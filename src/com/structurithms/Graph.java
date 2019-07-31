package com.structurithms;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

public class Graph {

    public static int MINIMUM_SPANNING_TREE_ALGORITHM = 0;
    private HashSet<HashSet<String>> universalNodes = new HashSet<>();

    private HashSet<HashSet<String>> kUniversal = new HashSet<>();
    private ArrayList<Edge> kruskalEdges = new ArrayList<>();
    private HashSet<String> subSet1, subSet2;
    private Integer totalCost;

    private HashSet<HashSet<String>> pUniversal = new HashSet<>();
    private ArrayList<Edge> primEdges = new ArrayList<>();
    private ArrayList<Edge> tempEdges = new ArrayList<>();
    private ArrayList<Edge> operationalEdges;
    private String selectedNode = "";

    public void addEdge(GraphNode src, GraphNode dest, Integer cost) {
        universalNodes.add(Sets.newHashSet(src.alias));
        universalNodes.add(Sets.newHashSet(dest.alias));
        switch (MINIMUM_SPANNING_TREE_ALGORITHM) {
            case 0:
                kruskalEdges.add(new Edge(src, dest, cost));
                break;
            case 1:
                primEdges.add(new Edge(src, dest, cost));
                selectedNode = src.alias;
                break;
        }
    }

    public ArrayList<Edge> kruskalMST() {
        totalCost = 0;
        kUniversal = new HashSet<>(universalNodes);
        int edgesLimit = kUniversal.size() - 1;
        ArrayList<Edge> MSTEdges = new ArrayList<>();
        kruskalEdges.sort(Comparator.comparing(edge -> edge.cost));
        for (Edge edge : kruskalEdges) {
            if (MSTEdges.size() == edgesLimit) break;
            if (isAcyclic(edge.src.alias, edge.dest.alias, true)) {
                kUniversal.add(Sets.newHashSet(Sets.union(subSet1, subSet2)));
                kUniversal.remove(subSet1);
                kUniversal.remove(subSet2);
                MSTEdges.add(edge);
                totalCost += edge.cost;
            }
        }
        return MSTEdges;
    }

    public ArrayList<Edge> primMST() {
        totalCost = 0;
        pUniversal = new HashSet<>(universalNodes);
        operationalEdges = new ArrayList<>();
        ArrayList<Edge> MSTEdges = new ArrayList<>();
        int edgesLimit = pUniversal.size() - 1;
        tempEdges.addAll(primEdges);
        while (MSTEdges.size() != edgesLimit) {
            getSelectedEdges();
            for (int i = 0; i < operationalEdges.size(); i++) {
                Edge edge = operationalEdges.get(i);
                if (isAcyclic(edge.src.alias, edge.dest.alias, false)) {
                    pUniversal.add(Sets.newHashSet(Sets.union(subSet1, subSet2)));
                    pUniversal.remove(subSet1);
                    pUniversal.remove(subSet2);
                    MSTEdges.add(edge);
                    totalCost += edge.cost;
                    selectedNode = edge.dest.alias;
                    operationalEdges.remove(edge);
                    break;
                }
            }
        }
        return MSTEdges;
    }

    private void getSelectedEdges() {
        for (int i = 0; i < tempEdges.size(); i++) {
            Edge target = tempEdges.get(i);
            if (target.src.alias.equals(selectedNode)) {
                operationalEdges.add(target);
            } else if (target.dest.alias.equals(selectedNode)) {
                GraphNode dest = target.src;
                target.src = target.dest;
                target.dest = dest;
                operationalEdges.add(target);
            }
        }
        tempEdges.removeAll(operationalEdges);
        operationalEdges.sort(Comparator.comparing(edge -> edge.cost));
    }

    private boolean isAcyclic(String srcAlias, String destAlias, boolean mode) {
        subSet1 = new HashSet<>();
        subSet2 = new HashSet<>();
        HashSet<HashSet<String>> targetSet;
        targetSet = mode ? kUniversal : pUniversal;
        for (HashSet<String> subSet : targetSet) {
            if (subSet.contains(srcAlias)) subSet1 = subSet;
            if (subSet.contains(destAlias)) subSet2 = subSet;
            if (subSet1 == subSet2) return false;
        }
        return true;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

}

class Edge {

    GraphNode src;
    GraphNode dest;
    Integer cost;

    Edge(GraphNode src, GraphNode dest, Integer cost) {
        this.src = src;
        this.dest = dest;
        this.cost = cost;
    }
}

class GraphNode {

    String alias;
    Object data;

    GraphNode(String alias, Object data) {
        this.alias = alias;
        this.data = data;
    }
}
