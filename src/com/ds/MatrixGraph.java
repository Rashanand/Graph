package com.ds;

import java.util.ArrayList;
import java.util.List;

public class MatrixGraph implements Graph{
    private int [][] graph;
    private int noOfVertices;

    public MatrixGraph(int noOfVertices) {
        if(noOfVertices > 0) {
            this.graph = new int[noOfVertices][noOfVertices];
        } else {
            throw new IllegalArgumentException("Invalid parameter passed!!");
        }
        this.noOfVertices = noOfVertices;
    }

    @Override
    public void addVertex(int vertex) {
        if (vertex <= noOfVertices) {
            System.out.println("Invalid parameter passed!!");
        } else {
            int[][] oldG = graph;
            graph = new int[vertex][vertex];

            for (int i = 0; i < noOfVertices; i++)
                for (int j = 0; j < noOfVertices; j++)
                    if (oldG[i][j] > 0)
                        graph[i][j] = oldG[i][j];
            noOfVertices = vertex;
        }
    }

    @Override
    public void reduceVertexTo(int vertex) {
        if (vertex > noOfVertices || vertex < 1) {
            System.out.println("Invalid parameter passed!!");
        } else {
            int[][] oldG = graph;
            graph = new int[vertex][vertex];

            for (int i = 0; i < vertex; i++)
                for (int j = 0; j < vertex; j++)
                    if (oldG[i][j] > 0)
                        graph[i][j] = oldG[i][j];
            noOfVertices = vertex;
        }
    }

    @Override
    public void addEdge(int start, int end) {
        if(start > 0 && start <= noOfVertices && end > 0 && end <= noOfVertices) {
            graph[start - 1][end - 1] = 1;
        } else {
            System.out.println("Invalid parameters passed!!");
        }
    }

    @Override
    public boolean removeEdge(int start, int end) {
        if(start > 0 && start <= noOfVertices && end > 0 && end <= noOfVertices ) {
            if(graph[start - 1][end - 1] == 1) {
                graph[start - 1][end - 1] = 0;
                return true;
            }
        } else {
            System.out.println("Invalid parameters passed!!");
        }
        return false;
    }

    @Override
    public int size() {
        return noOfVertices;
    }

    @Override
    public String toString() {
        List<String> gs = null;
        if (noOfVertices > 0) {
            gs = new ArrayList<String>();

            for (int i = 0; i < noOfVertices; i++)
                for (int j = 0; j < noOfVertices; j++)
                    if (graph[i][j] > 0)
                        gs.add("("+i+","+j+")");
        }
        return "MatrixGraph : "+gs;
    }
}
