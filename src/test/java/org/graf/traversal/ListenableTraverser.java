package org.graf.traversal;

import org.graf.Edge;
import org.graf.traversal.events.EdgeListener;

/**
 * Sub-interface that adds the ability to listen to traversal events.
 */
public interface ListenableTraverser<V, E extends Edge<V>> extends GraphTraverser<V,E> {
    /**
     * Adds a listner for edge traversal events.
     * @param listener The edge listener
     */
    void addListener(EdgeListener<V,E> listener);
}
