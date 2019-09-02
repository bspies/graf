package org.graf;

import java.util.Set;

/**
 * A graph, G=(V,E).
 * @param <V> The node (a.k.a. vertex) type
 * @param <E> The edge type
 */
public interface Graph<V, E extends Edge> {
    /**
     * Returns all the nodes of the graph. The returned
     * set should not be modifiable.
     * @return The graph nodes
     */
    Set<V> getNodes();

    /**
     * Returns all the edges of the graph. The returned
     * set should not be modifiable.
     * @return The graph edges
     */
    Set<E> getEdges();

    /**
     * Adds a node to the graph.
     * @param node The node to add
     * @return True if node was added (i.e. not a duplicate)
     */
    boolean addNode(V node);

    /**
     * Adds the nodes to the graph.
     * @param nodes The nodes to add
     * @return True if any of the nodes added to the graph
     */
    boolean addNodes(V... nodes);

    /**
     * Adds an edge to the graph.
     * @param edge The edge to add
     * @return True if edge was added (i.e. not a duplicate)
     */
    boolean addEdge(E edge);

    /**
     * Adds the edges to the graph.
     * @param edges The edges to add
     * @return True if any of the edges are added to the graph
     */
    boolean addEdges(E... edges);
}
