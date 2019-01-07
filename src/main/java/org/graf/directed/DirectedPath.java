package org.graf.directed;

import org.graf.AbstractPath;
import org.graf.Edge;

/**
 * A set of directed edges that connect nodes in a sequential
 * fashion.
 */
public class DirectedPath<V, E extends Edge<V>> extends AbstractPath<V,E> {

    private E head;

    /**
     * Creates a path with an initial edge.
     * @param startingEdge The initial edge
     */
    public DirectedPath(E startingEdge) {
        this.addEdge(startingEdge);
        this.head = startingEdge;
    }

    @Override protected ValidationResult validate(E edge) {
        return null;
    }
}
