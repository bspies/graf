package org.graf.traversal.events;

import org.graf.Edge;

/**
 * A listener for edge traversals.
 * @param <V> The node type
 * @param <E> The edge type
 */
public interface EdgeListener<V, E extends Edge<V>> {
    /**
     * A listener to an edge traversal. This method
     * is invoked before the target node is visited.
     * @param edge The edge being traversed
     */
    void onTraversal(E edge);
}
