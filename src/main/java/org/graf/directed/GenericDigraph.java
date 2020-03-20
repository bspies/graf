package org.graf.directed;

import org.graf.AbstractGraph;
import org.graf.Edge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericDigraph<V, E extends Edge<V>> extends AbstractGraph<V,E> implements DirectedGraph<V,E> {

    /**
     * Creates the directed graph with the initial nodes and edges.
     */
    public GenericDigraph() {
        super(new HashSet<>(), new HashSet<>());
    }

    /**
     * Creates the directed graph with the initial nodes and edges.
     * @param initialNodes The initial nodes
     * @param initialEdges The initial edges
     */
    public GenericDigraph(Set<V> initialNodes, Set<E> initialEdges) {
        super(new HashSet<>(initialNodes), new HashSet<>(initialEdges));
    }

    /**
     * {@inheritDoc}
     */
    @Override public Set<E> getOutgoingEdges(V node) {
        return getEdges().stream().filter(e -> node.equals(e.getSource())).collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override public Set<E> getIncomingEdges(V node) {
        return getEdges().stream().filter(e -> node.equals(e.getTarget())).collect(Collectors.toSet());
    }

    /**
     * {@inheritDoc}
     */
    @Override public boolean isAcyclic() {
        return false;
    }
}
