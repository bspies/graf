package org.graf;

/**
 * An edge between two nodes. In an undirected graph,
 * the terms "source" and "target" are arbitrary, and simply
 * refer to one of the nodes connected by the edge.
 * @param <V> The node (a.k.a. vertex) type
 */
public interface Edge<V> {
    /**
     * Returns the source of a directed edge, or simply one
     * of the nodes of an undirected edge.
     * @return The source node
     */
    V getSource();

    /**
     * Returns the target of a directed edge, or simply one
     * of the nodes of an undirected edge.
     * @return The target node
     */
    V getTarget();
}
