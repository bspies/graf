package org.graf.traversal;

import java.util.stream.Stream;

public class Visitors {
    /**
     * Composes the node visitors into a single visitor that runs the visitors sequentially.
     * @param <V> The node type
     * @return The composite node visitor
     */
    @SafeVarargs
    public static <V> NodeVisitor<V> compose(NodeVisitor<V>... visitors) {
        return node -> Stream.of(visitors).forEach(visitor -> visitor.visit(node));
    }
}
