package org.graf.undirected;

import org.graf.AbstractPath;
import org.graf.Edge;

/**
 * A path consisting of undirected edges connected in a sequential fashion.
 *
 * @param <V> The node type
 * @param <E> The edge type
 */
public class UndirectedPath<V, E extends Edge<V>> extends AbstractPath<V, E> {

    @Override protected ValidationResult validate(E edge) {
        return null;
    }
}
