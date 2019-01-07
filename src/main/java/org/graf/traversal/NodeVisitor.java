package org.graf.traversal;

/**
 * A node visitor.
 * @param <V> The node type
 */
public interface NodeVisitor<V> {
    /**
     * Visits a graph node.
     * @param node The node being visited
     */
    void visit(V node);
}
