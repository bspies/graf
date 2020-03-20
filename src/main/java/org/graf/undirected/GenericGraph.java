package org.graf.undirected;

import org.graf.AbstractGraph;
import org.graf.Edge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * An implementation of an undirected graph.
 * @param <V> The node value type
 * @param <E> The edge type
 */
public class GenericGraph<V, E extends Edge<V>> extends AbstractGraph<V,E> implements UndirectedGraph<V,E> {

    /**
     * Creates the undirected graph.
     */
    public GenericGraph() {
        super(new HashSet<>(), new HashSet<>());
    }

    /**
     * Creates a the undirected graph with initial nodes and edges.
     * @param initialNodes The initial nodes
     * @param initialEdges The initial edges
     */
    public GenericGraph(Set<V> initialNodes, Set<E> initialEdges) {
        super(new HashSet<>(initialNodes), new HashSet<>(initialEdges));
    }

    /**
     * {@inheritDoc}
     */
    @Override public Set<E> getEdgesOf(V node) {
        return getEdges().stream()
                .filter(e -> node.equals(e.getSource()) || node.equals(e.getTarget()))
                .collect(Collectors.toSet());
    }
}
