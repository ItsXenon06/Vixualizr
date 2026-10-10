package io.github.itsxenon06.vixualizr.core;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Graph {
    private final int nodeCount;
    private final List<List<Edge>> adjacency;


    public Graph(int nodeCount) {
        if (nodeCount < 0) {
            throw new IllegalArgumentException("nodeCount must be non-negative, got " + nodeCount);
        }
        this.nodeCount = nodeCount;
        this.adjacency = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            adjacency.add(new ArrayList<>());
        }

    }
    public List<Edge> getNeighbors(int node) {
        checkNode(node);
        return Collections.unmodifiableList(adjacency.get(node));
    }
    private void checkNode(int node) {
        if (node < 0 || node >= nodeCount) {
            throw new IllegalArgumentException("Node " + node + " is out of bounds");
        }
    }
    public void addEdge(int from, int to, double weight) {
        checkNode(from);
        checkNode(to);
        adjacency.get(from).add(new Edge(to, weight));
    }
    public void addUndirectedEdge(int from, int to, double weight) {
        addEdge(from, to, weight);
        addEdge(to, from, weight);
    }
    public int getNodeCount() {
        return nodeCount;
    }
}
