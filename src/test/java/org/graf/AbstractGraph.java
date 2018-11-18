package org.graf;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public abstract class AbstractGraph<V, E extends Edge<V>> implements Graph<V,E> {

    private Set<V> nodes;
    private Set<E> edges;

    @Override public Collection<V> getNodes() {
        return nodes;
    }

    @Override public Collection<E> getEdges() {
        return edges;
    }

    @Override
    public void addNode(V node) {
        nodes.add(node);
    }

    @Override
    public void addEdge(E edge) {
        addIfAbsent(edge.getSource(), edge.getTarget());
        edges.add(edge);
    }

    private void addIfAbsent(V... nodesToAdd) {
        nodes.addAll(Arrays.asList(nodesToAdd));
    }
}
