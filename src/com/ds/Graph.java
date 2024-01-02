package com.ds;

public interface Graph {
    void addVertex(int vertex);
    void reduceVertexTo(int vertex);
    void addEdge(int start, int end);
    boolean removeEdge(int start, int end);
    int[] traversalDFS();
    int[] traversalBFS();
    int size();
}
