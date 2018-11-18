package org.graf.undirected;

import org.graf.Edge;
import org.graf.Path;

import java.util.Collection;

/**
 * A path consisting of undirected edges connected in a sequential fashion.
 *
 * @param <V> The node type
 * @param <E> The edge type
 */
public class UndirectedPath<V, E extends Edge<V>> implements Path<V, E> {
    /**
     * {@inheritDoc}
     */
    public Collection<E> getEdges() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public Collection<V> getNodes() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void addEdge(E edge) {

    }
}
