package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListGraph implements Graph {
    private Node[] adjList;
    private int noOfVertices;

    public ListGraph(int noOfVertices) {
        if(noOfVertices > 0) {
            adjList = new Node[noOfVertices];
        } else {
            throw new IllegalArgumentException("Invalid parameter passed!!");
        }
        this.noOfVertices = noOfVertices;
    }

    @Override
    public void addVertex(int vertex) {

    }

    @Override
    public void reduceVertexTo(int vertex) {

    }

    @Override
    public void addEdge(int start, int end) {
        if (start > 0 && start <= noOfVertices && end > 0 && end <= noOfVertices) {
            Node node = new Node(end - 1);
            if (adjList[start - 1] == null) {
                adjList[start - 1] = node;
            } else {
                Node pointer = adjList[start - 1];
                while (pointer.next != null) {
                    pointer = pointer.next;
                }
                pointer.next = node;
            }
        } else {
            System.out.println("Invalid parameter passed!!");
        }
    }

    @Override
    public boolean removeEdge(int start, int end) {
        boolean isRemoved = false;
        if (start > 0 && start <= noOfVertices && end > 0 && end <= noOfVertices) {
            if (adjList[start - 1] != null) {
                Node pointer = adjList[start - 1];
                Node before = pointer;
                while (pointer != null) {
                    if(pointer.vertex == end - 1) {
                        if (pointer == adjList[start - 1]) {
                            adjList[start - 1] = pointer.next;
                        } else {
                            before.next = pointer.next;
                        }

                        isRemoved = true;
                    }
                    before = pointer;
                    pointer = pointer.next;
                }
            }
        } else {
            System.out.println("Invalid parameter passed!!");
        }
        return isRemoved;
    }

    @Override
    public int[] traversalDFS() {
        int[] paths = new int[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++){
            DFS(i, visited, true);
        }

        return paths;
    }

    @Override
    public int[] traversalBFS() {
        boolean[] visited = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            BFS(i, visited);
        }

        return new int[0];
    }

    private int[] BFS(int vertex, boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(vertex);
        q.add(null);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if(current == null && q.size() > 1) {
                q.add(null);
                System.out.println();
            } else {
                System.out.print((current + 1) + ", ");
                visited[current] = true;
                Node node = adjList[current];
                while (node != null) {
                    if(!visited[node.vertex]) {
                        q.add(node.vertex);
                    }
                    node = node.next;
                }
            }
        }

        return null;
    }

    private void DFS(int vertex, boolean[] visited, boolean checkVertex) {
        if(!checkVertex || !visited[vertex]) {
            visited[vertex] = true;
            System.out.print((vertex+1) + ", ");
            Node node = adjList[vertex];
            while (node != null) {
                if(!visited[node.vertex]) {
                    DFS(node.vertex, visited, false);
                }
                node = node.next;
            }
            if(checkVertex) {
                System.out.println();
            }
        }
    }

    @Override
    public int size() {
        return noOfVertices;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ListGraph [");
        for (int i = 0; i < noOfVertices; i++) {
            if (adjList[i] != null) {
                StringBuffer sb = new StringBuffer((i + 1) + " -> (");
                Node pointer = adjList[i];
                while (pointer.next != null) {
                    sb.append((pointer.vertex + 1) + ", ");
                    pointer = pointer.next;
                }
                sb.append((pointer.vertex + 1) + "),");
                stringBuffer.append(sb);
            } else {
                stringBuffer.append((i + 1) + ",");
            }
        }
        return stringBuffer.append("]").toString();
    }

    private class Node {
        int vertex;
        Node next;

        public Node(int vertex) {
            this.vertex = vertex;
        }
    }
}
