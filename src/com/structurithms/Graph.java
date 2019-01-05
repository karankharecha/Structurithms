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
    private HashSet<String> kSubSet1, kSubSet2;
    private Integer totalCost;

    private HashSet<HashSet<String>> pUniversal = new HashSet<>();
    private ArrayList<Edge> primEdges = new ArrayList<>();
    private ArrayList<Edge> pUniversalEdges = new ArrayList<>();
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
            if (isAcyclic(edge.src.alias, edge.dest.alias)) {
                kUniversal.add(Sets.newHashSet(Sets.union(kSubSet1, kSubSet2)));
                kUniversal.remove(kSubSet1);
                kUniversal.remove(kSubSet2);
                MSTEdges.add(edge);
                totalCost += edge.cost;
            }
        }
        return MSTEdges;
    }

    private boolean isAcyclic(String srcAlias, String destAlias) {
        kSubSet1 = new HashSet<>();
        kSubSet2 = new HashSet<>();
        for (HashSet<String> subSet : kUniversal) {
            if (subSet.contains(srcAlias)) kSubSet1 = subSet;
            if (subSet.contains(destAlias)) kSubSet2 = subSet;
            if (kSubSet1 == kSubSet2) return false;
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
