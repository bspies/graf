package org.graf;

import org.graf.directed.DirectedGraph;
import org.graf.directed.GenericDigraph;
import org.graf.undirected.GenericGraph;
import org.graf.undirected.UndirectedGraph;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphTests {
    @Test
    public void populateDiGraphWithNodesAndEdges() {
        TestNode[] nodes = {new TestNode("one"), new TestNode("two"), new TestNode("three")};
        TestEdge[] edges = {new TestEdge(nodes[0], nodes[1]), new TestEdge(nodes[1], nodes[2])};
        DirectedGraph<TestNode,TestEdge> digraph = createDiGraph(nodes, edges);
        Set<TestNode> graphNodes = digraph.getNodes();
        Set<TestEdge> graphEdges = digraph.getEdges();
        assertEquals("Expected getNodes() to equal node set", toSet(nodes), graphNodes);
        assertEquals("Expected getEdges() to equal edge set", toSet(edges), graphEdges);
    }

    @Test
    public void populateUndirectedGraphWithNodesAndEdges() {
        TestNode[] nodes = {new TestNode("one"), new TestNode("two"), new TestNode("three")};
        TestEdge[] edges = {new TestEdge(nodes[0], nodes[1]), new TestEdge(nodes[1], nodes[2])};
        UndirectedGraph<TestNode,TestEdge> undirectedGraph = createUndirectedGraph(nodes, edges);
        Set<TestNode> graphNodes = undirectedGraph.getNodes();
        Set<TestEdge> graphEdges = undirectedGraph.getEdges();
        assertEquals("Expected getNodes() to equal node set", toSet(nodes), graphNodes);
        assertEquals("Expected getEdges() to equal edge set", toSet(edges), graphEdges);
    }

    @Test
    public void getIncomingEdgesFromDiGraph() {
        TestNode[] nodes = {new TestNode("one"), new TestNode("two"), new TestNode("three")};
        TestEdge[] edges = {
                new TestEdge(nodes[0], nodes[1]),
                new TestEdge(nodes[1], nodes[2]),
                new TestEdge(nodes[0], nodes[2])
        };
        DirectedGraph<TestNode,TestEdge> digraph = createDiGraph(nodes, edges);
        assertEquals(
                "Incoming edges should be one->three, two->three",
                toSet(edges[1], edges[2]),
                digraph.getIncomingEdges(nodes[2])
        );
        assertEquals(
                "Incoming edges should be one->two",
                toSet(edges[0]),
                digraph.getIncomingEdges(nodes[1])
        );
    }

    @Test
    public void getConnectedEdgesInUndirectedGraph() {
        TestNode[] nodes = {new TestNode("one"), new TestNode("two"), new TestNode("three")};
        TestEdge[] edges = {
                new TestEdge(nodes[0], nodes[1]),
                new TestEdge(nodes[1], nodes[2]),
                new TestEdge(nodes[0], nodes[2])
        };
        UndirectedGraph<TestNode,TestEdge> undirectedGraph = createUndirectedGraph(nodes, edges);
        Set<TestEdge> connectedEdges = undirectedGraph.getEdgesOf(nodes[2]);
        assertEquals(
                "Connected edges should be one-three, two-three",
                toSet(edges[1], edges[2]),
                connectedEdges
        );
    }

    ///////////////////////////////////////////////////////////////////////////////

    @SafeVarargs
    private <T> Set<T> toSet(T... elements) {
        Set<T> set = new HashSet<>();
        Collections.addAll(set, elements);
        return set;
    }

    private DirectedGraph<TestNode,TestEdge> createDiGraph(TestNode[] nodes, TestEdge[] edges) {
        DirectedGraph<TestNode,TestEdge> digraph = new GenericDigraph<>();
        digraph.addNodes(nodes);
        digraph.addEdges(edges);
        return digraph;
    }

    private UndirectedGraph<TestNode,TestEdge> createUndirectedGraph(TestNode[] nodes, TestEdge[] edges) {
        UndirectedGraph<TestNode,TestEdge> undirectedGraph = new GenericGraph<>();
        undirectedGraph.addNodes(nodes);
        undirectedGraph.addEdges(edges);
        return undirectedGraph;
    }

    private class TestNode {
        String message;
        TestNode(String message) { this.message = message; }
        String getMessage() { return message; }
        @Override public String toString() { return getMessage(); }
    }

    private class TestEdge extends BasicEdge<TestNode> {
        TestEdge(TestNode source, TestNode target) {
            super(source, target);
        }
    }
}
