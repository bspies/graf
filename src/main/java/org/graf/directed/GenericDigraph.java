package org.graf.directed;

import org.graf.AbstractGraph;
import org.graf.Edge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericDigraph<V, E extends Edge<V>> extends AbstractGraph<V,E> implements DirectedGraph<V,E> {

    /**
     * Creates the graph with the initial nodes and edges.
     */
    public GenericDigraph() {
        super(new HashSet<>(), new HashSet<>());
    }

    @Override public Set<E> getOutgoingEdges(V node) {
        return getEdges().stream().filter(e -> node.equals(e.getSource())).collect(Collectors.toSet());
    }

    @Override public Set<E> getIncomingEdges(V node) {
        return getEdges().stream().filter(e -> node.equals(e.getTarget())).collect(Collectors.toSet());
    }

    @Override public boolean isAcyclic() {
        return false;
    }
}
