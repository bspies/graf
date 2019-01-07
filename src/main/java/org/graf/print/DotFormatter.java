package org.graf.print;

import org.graf.Edge;

import java.util.Optional;

/**
 * An interface for formatting elements of a DOT graph.
 * @param <V> The node type
 * @param <E> The edge type
 */
public interface DotFormatter<V, E extends Edge<V>> {
    /**
     * Returns the identifier for the given node.
     * @param node The node for which to get the id
     * @return The node identifier
     */
    String getNodeId(V node);

    /**
     * Gets the attributes for a node.
     * @param node The node
     * @return The attributes, if present
     */
    Optional<DotAttributes> getAttributes(V node);

    /**
     * Gets the attributes for an edge, if present.
     * @param edge The edge
     * @return The attributes, if present
     */
    Optional<DotAttributes> getAttributes(E edge);
}
