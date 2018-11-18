package org.graf.undirected;

import org.graf.Edge;

import java.util.Collection;

/**
 * A graph where nodes are connected by undirected edges.
 * @param <V> The node type
 * @param <E> The edge type
 */
public interface UndirectedGraph<V, E extends Edge<V>> {
    /**
     * Returns all edges connected to the given node.
     * @param node The node from which to get connected edges
     * @return The edges connected to the node
     */
    Collection<E> getEdgesOf(V node);
}
