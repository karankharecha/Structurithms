package com.structurithms;

public class LinkedList<T> {
    private int listSize = 0;
    private Node<T> alpha;
    private Node<T> tail;

    public void insertNode(T element){
        Node<T> mNode = new Node<T>(element, null);
        if(alpha == null){
            alpha = mNode;
            tail = alpha;
        }
        else{
            tail.link = mNode;
            tail = mNode;
        }
        listSize++;
    }

    public void insertAlphaNode(T element){
        if(alpha == null) insertNode(element);
        else{
            alpha = new Node<>(element, alpha);
            listSize++;
        }
    }

    public void insertAt(int position, T element){
        if (position > listSize - 1){
            throw new IndexOutOfBoundsException();
        }
        if(position == 0){
            insertAlphaNode(element);
        }
        else if (position == listSize - 1){
            insertNode(element);
        }
        else {
            int count = 0;
            Node<T> beta = alpha;
            while(count != position - 1){
                beta = beta.link;
                count++;
            }
            beta.link = new Node<>(element, beta.link);
            listSize++;
        }
    }

//    public void removeNode(T element){
//        if(alpha == null){
//            System.out.println("List is empty !!");
//            return;
//        }
//        Node<T> omega;
//        beta = alpha;
//        if (alpha.data == element){
//            alpha = beta.link;
//        }
//        else {
//            omega = beta;
//            while (beta.data != element){
//                beta = beta.link;
//            }
//            while (omega.link != beta){
//                omega = omega.link;
//            }
//            omega.link = beta.link;
//            beta = null;
//        }
//        listSize--;
//        System.out.println("Node<T> Removed");
//    }

    public void listSummary(){
        Node<T> beta = alpha;
        while (beta != null){
            System.out.println(beta + "\n" + beta.data + "\n" + beta.link);
            System.out.println("-----------------------------------");
            beta = beta.link;
        }
        System.out.println("Size of list: " + listSize);
    }

    public int getSize() {
        return listSize;
    }

    private class Node<K>{
        K data;
        Node<K> link;

        Node(K data, Node<K> link) {
            this.data = data;
            this.link = link;
        }
    }
}