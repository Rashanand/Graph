package com.test;

import com.ds.Graph;
import com.ds.MatrixGraph;

public class MatrixGraphTest {
    public static void main(String[] args) {
        Graph g = new MatrixGraph(5);
        testAddEdge(g);
        testRemoveEdge(g);
        testAddVertex(g);
        testRemoveVertex(g);
    }

    private static void testAddEdge(Graph g) {
        System.out.println(g);
        g.addEdge(5,5);
        System.out.println(g);
        g.addEdge(5,6);
        g.addEdge(0,0);
        g.addEdge(1,2);
        System.out.println(g);
    }

    private static void testRemoveEdge(Graph g) {
        System.out.println(g.removeEdge(5,6));
        System.out.println(g.removeEdge(1,2));
        System.out.println(g);
    }

    private static void testAddVertex(Graph g) {
        System.out.println(g.size());
        g.addVertex(4);
        g.addVertex(6);
        System.out.println(g);
        System.out.println(g.size());
    }

    private static void testRemoveVertex(Graph g) {
        System.out.println(g.size());
        g.reduceVertexTo(4);
        System.out.println(g.size());
        System.out.println(g);
    }
}
