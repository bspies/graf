package org.graf;

import java.util.Objects;

/**
 * A simple edge between two nodes.
 * @param <V> The node type
 */
public class BasicEdge<V> implements Edge<V> {

    private final V source, target;

    public BasicEdge(V source, V target) {
        this.source = source;
        this.target = target;
    }

    /**
     * {@inheritDoc}
     */
    @Override public V getSource() {
        return source;
    }

    /**
     * {@inheritDoc}
     */
    @Override public V getTarget() {
        return target;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BasicEdge)) return false;
        BasicEdge<?> basicEdge = (BasicEdge<?>) o;
        return source.equals(basicEdge.source) &&
                target.equals(basicEdge.target);
    }

    @Override public int hashCode() {
        return Objects.hash(source, target);
    }

    /**
     * Override toString() for debugging purposes.
     * @return The string representation of the edge
     */
    @Override public String toString() {
        return this.source + "--" + this.target;
    }
}
