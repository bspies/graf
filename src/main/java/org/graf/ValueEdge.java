package org.graf;

/**
 * An edge that has a value associated with it.
 * @param <NV> The node value type
 * @param <EV> The edge value type
 */
public interface ValueEdge<NV,EV> extends Edge<NV> {
    /**
     * Returns the value of the edge.
     * @return The value
     */
    EV getValue();
}
