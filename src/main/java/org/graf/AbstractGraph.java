package org.graf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Abstract implementation of a {@link Graph}.
 * @param <V> The node value type
 * @param <E> The edge type
 */
public abstract class AbstractGraph<V, E extends Edge<V>> implements Graph<V,E> {

    private final Set<V> nodes;
    private final Set<E> edges;

    /**
     * Creates the graph with the initial nodes and edges.
     * @param initialNodes The initial nodes
     * @param initialEdges The initial edges
     */
    protected AbstractGraph(Set<V> initialNodes, Set<E> initialEdges) {
        this.nodes = initialNodes;
        this.edges = initialEdges;
    }

    /**
     * {@inheritDoc}
     */
    @Override public Set<V> getNodes() {
        return Collections.unmodifiableSet(nodes);
    }

    /**
     * {@inheritDoc}
     */
    @Override public Set<E> getEdges() {
        return Collections.unmodifiableSet(edges);
    }

    /**
     * {@inheritDoc}
     */
    @Override public boolean addNode(V node) {
        return nodes.add(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override public boolean addNodes(V... nodes) {
        return Collections.addAll(this.nodes, nodes);
    }

    /**
     * {@inheritDoc}
     */
    @Override public boolean addEdge(E edge) {
        addIfAbsent(edge.getSource(), edge.getTarget());
        return edges.add(edge);
    }

    @Override public boolean addEdges(E... edges) {
        boolean changed = false;
        for (E e : edges) {
            changed |= addEdge(e);
        }
        return changed;
    }

    private void addIfAbsent(V... nodesToAdd) {
        nodes.addAll(Arrays.asList(nodesToAdd));
    }
}
