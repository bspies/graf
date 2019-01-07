package org.graf.directed;

import org.graf.Edge;
import org.graf.Graph;

import java.util.Collection;

/**
 * A directional graph, i.e. a graph in which all edges are directed
 * from one node to another.
 * @param <V> The node (a.k.a. vertex) type
 * @param <E> The edge type
 */
public interface DirectedGraph<V, E extends Edge<V>> extends Graph<V,E> {
    /**
     * Returns all the outgoing edges from a given node.
     * @param node The source node
     * @return The outgoing edges
     */
    Collection<E> getOutgoingEdges(V node);

    /**
     * Returns all the incoming edges to a given node.
     * @param node The target node
     * @return The incoming edges
     */
    Collection<E> getIncomingEdges(V node);

    /**
     * Does this graph allow cycles?
     * @return True if this graph is a DAG, false if cycles allowed
     */
    boolean isAcyclic();
}
