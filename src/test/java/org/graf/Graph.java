package org.graf;

import java.util.Collection;

/**
 * A graph, G=(V,E).
 * @param <V> The node (a.k.a. vertex) type
 * @param <E> The edge type
 */
public interface Graph<V, E extends Edge> {
    /**
     * Returns all the nodes of the graph.
     * @return The graph nodes
     */
    Collection<V> getNodes();

    /**
     * Returns all the edges of the graph.
     * @return The graph edges
     */
    Collection<E> getEdges();

    /**
     * Adds a node to the graph.
     * @param node The node to add
     */
    void addNode(V node);

    /**
     * Adds an edge to the graph.
     * @param edge The edge to add
     */
    void addEdge(E edge);
}
