package com.structurithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class BinaryTree {

    private Node alpha;
    private int treeSize = 0;
    private boolean isUpperLevel = true;

    public void insert(int data){
        alpha = insertData(alpha, data);
    }

    public void preOrder(){
        traversePreOrder(alpha);
    }

    public void postOrder(){
        traversePostOrder(alpha);
    }

    public void inOrder(){
        traverseInOrder(alpha);
    }

    public HashMap<Integer, ArrayList<Node>> breadthFirstTraversal(){
        return getLevels(alpha);
    }

    public int getSize() {
        return treeSize;
    }

    private Node insertData(Node kNode, int data){
        if (kNode == null){
            treeSize++;
            return new Node(data, null, null);
        }
        if (kNode.value > data){
            kNode.leftLink = insertData(kNode.leftLink, data);
        } else {
            kNode.rightLink = insertData(kNode.rightLink, data);
        }
        return kNode;
    }

    private void traversePreOrder(Node kNode) {
        if (kNode != null) {
            System.out.print(kNode.value + " ");
            traversePreOrder(kNode.leftLink);
            traversePreOrder(kNode.rightLink);
        }
    }

    private void traversePostOrder(Node kNode){
        if (kNode != null){
            traversePostOrder(kNode.leftLink);
            traversePostOrder(kNode.rightLink);
            System.out.print(kNode.value + " ");
        }
    }

    private void traverseInOrder(Node kNode){
        if (kNode != null){
            traverseInOrder(kNode.leftLink);
            System.out.print(kNode.value + " ");
            traverseInOrder(kNode.rightLink);
        }
    }

    private HashMap<Integer, ArrayList<Node>> getLevels(Node kNode) {
        isUpperLevel = true;
        HashMap<Integer, ArrayList<Node>> levelsMap = new HashMap<>();
        int level = 0;
        if (kNode != null){
            ArrayList<Node> parentList = new ArrayList<Node>(){{add(alpha);}};
            ArrayList<Node> childList = new ArrayList<>();
            while(isUpperLevel){
                ArrayList<Node> elements = getChildNodes(parentList, childList);
                if (!elements.isEmpty()){
                    levelsMap.put(level++, elements);
                    parentList = new ArrayList<>(childList);
                    childList.clear();
                }
            }
        }
        return levelsMap;
    }

    private ArrayList<Node> getChildNodes(ArrayList<Node> parentList, ArrayList<Node> childList){
        ArrayList<Node> nodes = new ArrayList<>();
        for (Node parentNode: parentList){
            nodes.add(parentNode);
            if (parentNode.leftLink != null) childList.add(parentNode.leftLink);
            if (parentNode.rightLink != null) childList.add(parentNode.rightLink);
        }
        if (nodes.isEmpty()) isUpperLevel = false;
        return nodes;
    }

    public class Node{
        int value;
        Node leftLink;
        Node rightLink;

        Node(int value, Node leftLink, Node rightLink) {
            this.value = value;
            this.leftLink = leftLink;
            this.rightLink = rightLink;
        }
    }
}
