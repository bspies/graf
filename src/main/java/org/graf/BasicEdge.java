package org.graf;

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
}
