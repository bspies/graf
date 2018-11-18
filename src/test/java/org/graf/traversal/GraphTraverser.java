package org.graf.traversal;

import org.graf.Edge;

/**
 * A graph traverser.
 *
 * @param <V> The node type
 * @param <E> The edge type
 */
public interface GraphTraverser<V, E extends Edge<V>> {
    /**
     * Traverses the graph, beginning with the starting node.
     * @param startingNode The starting node
     * @param visitor The visitor
     */
    void traverse(V startingNode, NodeVisitor<V> visitor);
}
