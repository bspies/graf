package org.graf;

import java.util.Objects;

/**
 * An edge that has a value associated with it that cannot be changed to another value. To
 * be truly immutable, the edge value type should also be immutable.
 * @param <NV> The node value type
 * @param <EV> The edge value type
 */
public class ConstantEdge<NV,EV> extends BasicEdge<NV> implements ValueEdge<NV,EV> {

    private final EV value;

    /**
     * Creates the constant edge.
     * @param source The source node
     * @param target The target node
     * @param value The edge value
     */
    public ConstantEdge(NV source, NV target, EV value) {
        super(source, target);
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override public EV getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConstantEdge)) return false;
        if (!super.equals(o)) return false;
        ConstantEdge<?, ?> valueEdge = (ConstantEdge<?, ?>) o;
        return value.equals(valueEdge.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
