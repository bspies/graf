package org.graf.print;

import org.graf.Edge;
import org.graf.Graph;
import org.graf.directed.DirectedGraph;

import java.io.PrintStream;

/**
 * Printer for outputting a graph to a DOT language format.
 */
public class DotPrinter {

    private static final String SPACE = " ", INDENT = "     ";
    private static final String END_LINE = System.getProperty("line.separator");

    enum GraphType {
        DIRECTED() {
            @Override String getName() { return "digraph"; }
            @Override String getEdgeSymbol() { return "->"; }
        },
        UNDIRECTED() {
            @Override String getName() { return "graph"; }
            @Override String getEdgeSymbol() { return "--"; }
        };

        abstract String getName();
        abstract String getEdgeSymbol();
    }

    /**
     * Prints (serializes) the graph to a DOT language formatted string.
     * @param graph The graph to serialize
     * @param graphName The name/identifier for the graph
     * @param formatter The DOT formatter
     * @param <V> The node type
     * @param <E> The edge type
     * @return The serialized string in DOT
     */
    public <V,E extends Edge<V>> String print(Graph<V,E> graph, String graphName, DotFormatter<V,E> formatter) {
        Printer printer = new StringPrinter();
        print(printer, graph, graphName, formatter);
        return printer.toString();
    }

    /**
     * Prints (serializes) the graph to a print stream in DOT language format.
     * @param stream The print stream
     * @param graph The graph to serialize
     * @param graphName The name/identifier for the graph
     * @param formatter The DOT formatter
     * @param <V> The node type
     * @param <E> The edge type
     */
    public <V,E extends Edge<V>> void print(PrintStream stream, Graph<V,E> graph, String graphName, DotFormatter<V,E> formatter) {
        Printer printer = new StreamPrinter(stream);
        print(printer, graph, graphName, formatter);
    }

    private GraphType graphType(Graph<?,?> graph) {
        return graph instanceof DirectedGraph ? GraphType.DIRECTED : GraphType.UNDIRECTED;
    }

    /***
     * Outputs the graph to the printer.
     * @param printer The printer destination
     * @param graph The graph to serialize
     * @param graphName The name/identifier for the graph
     * @param formatter The DOT formatter
     * @param <V> The node type
     * @param <E> The edge type
     */
    private <V,E extends Edge<V>> void print(
            Printer printer,
            Graph<V,E> graph,
            String graphName,
            DotFormatter<V,E> formatter) {

        GraphType type = graphType(graph);
        printer.append(type.getName())
               .append(SPACE).append(graphName)
               .append(SPACE).append("{").endLine();

        graph.getNodes().forEach(node -> printNode(printer, node, formatter).endLine());
        graph.getEdges().forEach(edge -> printEdge(printer, edge, type, formatter).endLine());
        printer.append("}");
    }

    private <V> Printer printNode(Printer printer, V node, DotFormatter<V,?> formatter) {
        printer.append(INDENT)
               .append(formatter.getNodeId(node))
               .append(formatter.getAttributes(node).map(this::printAttributes).orElse(""))
               .append(";");
        return printer;
    }

    private <V, E extends Edge<V>> Printer printEdge(Printer printer, E edge, GraphType type, DotFormatter<V,E> formatter) {
        printer.append(INDENT)
               .append(formatter.getNodeId(edge.getSource()))
               .append(SPACE)
               .append(type.getEdgeSymbol())
               .append(formatter.getNodeId(edge.getTarget()))
               .append(formatter.getAttributes(edge).map(this::printAttributes).orElse(""))
               .append(";");
        return printer;
    }

    private String printAttributes(DotAttributes attributes) {
        return null;
    }

    /**
     * Interface for outputting the graph.
     */
    private interface Printer {
        /**
         * Appends the object to the output.
         * @param obj The object to append
         * @return The 'this' for chaining
         */
        Printer append(Object obj);

        /**
         * Appends a new line to the output.
         * @return The 'this' for chaining
         */
        Printer endLine();
    }

    /**
     * Outputs graph to a string.
     */
    private class StringPrinter implements Printer {

        StringBuilder sb = new StringBuilder();

        @Override public Printer append(Object obj) {
            return this;
        }

        @Override public Printer endLine() {
            sb.append(END_LINE);
            return this;
        }

        @Override public String toString() {
            return sb.toString();
        }
    }

    /**
     * Outputs graph to a print stream.
     */
    private class StreamPrinter implements Printer {

        PrintStream out;

        StreamPrinter(PrintStream stream) {
            this.out = stream;
        }

        @Override public Printer append(Object obj) {
            out.print(obj);
            return this;
        }

        @Override public Printer endLine() {
            out.println();
            return this;
        }
    }
}
