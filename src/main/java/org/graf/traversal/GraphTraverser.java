package org.graf.traversal;

import org.graf.Edge;
import org.graf.traversal.events.EdgeListener;

/**
 * A graph traverser.
 *
 * @param <V> The node type
 * @param <E> The edge type
 */
public interface GraphTraverser<V, E extends Edge<V>> {
    /**
     * Traverses the graph, beginning with the starting node.
     *
     * @param startingNode The starting node
     * @param visitor      The node visitor
     * @param listeners    The edge traversal listeners
     */
    void traverse(V startingNode, NodeVisitor<V> visitor, EdgeListener... listeners);
}