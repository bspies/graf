package org.graf.directed;

import org.graf.AbstractGraph;
import org.graf.Edge;

import java.util.Collection;

public class GenericDigraph<V, E extends Edge<V>> extends AbstractGraph<V,E> implements DirectedGraph<V,E> {

    @Override public Collection<E> getOutgoingEdges(V node) {
        return null;
    }

    @Override public Collection<E> getIncomingEdges(V node) {
        return null;
    }

    @Override public boolean isAcyclic() {
        return false;
    }
}
