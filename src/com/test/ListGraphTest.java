package com.test;

import com.ds.Graph;
import com.ds.ListGraph;

public class ListGraphTest {
    public static void main(String[] args) {
        Graph g = new ListGraph(6);
        testAddEdge(g);
        testTraverseDFS(g);
        testTraverseBFS(g);
        testRemoveEdge(g);
    }

    private static void testAddEdge(Graph g) {
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(3, 5);
        g.addEdge(5, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 2);
        System.out.println(g);
    }

    private static void testRemoveEdge(Graph g) {
        g.removeEdge(1, 3);
        System.out.println(g);
        g.removeEdge(1, 2);

        System.out.println(g);
    }

    private static void testTraverseDFS(Graph g) {
        System.out.println("Traversal DFS::");
        g.traversalDFS();
    }

    private static void testTraverseBFS(Graph g) {
        System.out.println("Traversal BFS::");
        g.traversalBFS();
    }
}
