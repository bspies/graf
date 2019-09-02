package org.graf.undirected;

import org.graf.AbstractGraph;
import org.graf.Edge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericGraph<V, E extends Edge<V>> extends AbstractGraph<V,E> implements UndirectedGraph<V,E> {

    /**
     * Creates the graph.
     */
    public GenericGraph() {
        super(new HashSet<>(), new HashSet<>());
    }

    @Override public Set<E> getEdgesOf(V node) {
        return getEdges().stream()
                .filter(e -> node.equals(e.getSource()) || node.equals(e.getTarget()))
                .collect(Collectors.toSet());
    }
}
