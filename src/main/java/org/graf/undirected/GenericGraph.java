package org.graf.undirected;

import org.graf.AbstractGraph;
import org.graf.Edge;

import java.util.Collection;

public class GenericGraph<V, E extends Edge<V>> extends AbstractGraph<V,E> implements UndirectedGraph<V,E> {

    @Override public Collection<E> getEdgesOf(V node) {
        return null;
    }
}
