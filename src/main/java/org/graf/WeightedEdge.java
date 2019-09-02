package org.graf;

/**
 * A weighted edge, i.e. an edge that has a weight (number) associated with it.
 * @param <NV> The node value type
 */
public class WeightedEdge<NV> extends BasicEdge<NV> implements ValueEdge<NV,Number> {

    private Number weight;

    /**
     * Creates a weighted edge.
     * @param source The source node
     * @param target The target node
     * @param weight The edge weight
     */
    public WeightedEdge(NV source, NV target, Number weight) {
        super(source, target);
        setValue(weight);
    }

    /**
     * Gets the weight of this edge.
     * @return The edge weight
     */
    @Override public Number getValue() {
        return weight;
    }

    /**
     * Set the weight of this edge.
     * @param weight The edge weight
     */
    public void setValue(Number weight) {
        this.weight = weight;
    }
}
