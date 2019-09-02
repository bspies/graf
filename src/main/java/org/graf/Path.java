package org.graf;

import java.util.Set;

public interface Path<V, E extends Edge<V>> {
    /**
     * Returns all edges that are a part of this
     * path.
     * @return The path edges
     */
    Set<E> getEdges();

    /**
     * Returns all nodes that connected by this path.
     * @return The path nodes
     */
    Set<V> getNodes();

    /**
     * Adds an edge to the path. The edge added must maintain the sequential
     * nature of the path, i.e. must be connected to a node from the last edge
     * in the sequence.
     * @param edge The edge to add
     * @throws IllegalArgumentException If the edge is not sequential
     * @throws UnsupportedOperationException If the path is immutable
     */
    void addEdge(E edge);
}
