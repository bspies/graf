package org.graf;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class AbstractPath<V, E extends Edge<V>> implements Path<V,E> {

    private final Set<E> edges = new LinkedHashSet<>();

    /**
     * {@inheritDoc}
     */
    @Override public Collection<E> getEdges() {
        return edges;
    }

    /**
     * {@inheritDoc}
     */
    @Override public Collection<V> getNodes() {
        Set<V> nodes = new HashSet<>();
        getEdges().forEach(e -> {
            nodes.add(e.getSource());
            nodes.add(e.getTarget());
        });
        return nodes;
    }

    /**
     * {@inheritDoc}
     */
    @Override public void addEdge(E edge) {
        ValidationResult result = validate(edge);
        if (result != ValidationResult.VALID) {
            throw new IllegalArgumentException(
                    String.format("Edge '%s' cannot be added to the path. %s", edge, result)
            );
        }
        edges.add(edge);
    }

    /**
     * Test the validity of the given edge (before addition to path).
     *
     * @param edge The edge to test
     * @return True if edge is not duplicate and is sequential
     */
    protected abstract ValidationResult validate(E edge);

    /**
     * The enumeration of validation results when adding a new
     * edge to the path.
     */
    protected enum ValidationResult {
        DUPLICATE("Edge is a duplicate of one already present in the path."),
        NON_SEQUENTIAL("Edge is not sequential."),
        VALID("Edge is valid.");

        private String message;
        private ValidationResult(String message) {
            this.message = message;
        }

        public String toString() {
            return message;
        }
    }
}
