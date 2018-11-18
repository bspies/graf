package org.graf.traversal;

import org.graf.Edge;

/**
 * A listener for edge traversals.
 * @param <V> The node type
 * @param <E> The edge type
 */
public interface EdgeListener<V, E extends Edge<V>> {
    /**
     * A listener to an edge traversal.
     * @param edge The edge being traversed
     */
    void onTraversal(E edge);
}
