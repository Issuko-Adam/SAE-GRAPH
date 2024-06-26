package main.java.graphe;

public class Arc {
    private final String source;
    private final String destination;
    private final int valuation;

    public Arc(String source, String destination, int valuation) {
        assert valuation >= 0;
        this.source = source;
        this.destination = destination;
        this.valuation = valuation;
    }
    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getValuation() {
        return valuation;
    }
}
