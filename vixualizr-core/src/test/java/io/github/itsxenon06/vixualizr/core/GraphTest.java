package io.github.itsxenon06.vixualizr.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void newGraphHasNoEdges() {
        Graph graph = new Graph(3);

        assertEquals(3, graph.getNodeCount());
        for (int i = 0; i < 3; i++) {
            assertTrue(graph.getNeighbors(i).isEmpty());
        }
    }

    @Test
    void directedEdgeGoesOneWayOnly() {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1, 2.5);

        List<Edge> fromZero = graph.getNeighbors(0);
        assertEquals(1, fromZero.size());
        assertEquals(1, fromZero.get(0).to());
        assertEquals(2.5, fromZero.get(0).weight(), 1e-9);

        assertTrue(graph.getNeighbors(1).isEmpty());
    }

    @Test
    void undirectedEdgeGoesBothWays() {
        Graph graph = new Graph(2);
        graph.addUndirectedEdge(0, 1, 4.0);

        assertEquals(1, graph.getNeighbors(0).size());
        assertEquals(1, graph.getNeighbors(0).get(0).to());

        assertEquals(1, graph.getNeighbors(1).size());
        assertEquals(0, graph.getNeighbors(1).get(0).to());
    }

    @Test
    void multipleEdgesFromSameNodeAreKept() {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1, 1.0);
        graph.addEdge(0, 2, 2.0);
        graph.addEdge(0, 3, 3.0);

        assertEquals(3, graph.getNeighbors(0).size());
    }

    @Test
    void invalidNodesAreRejected() {
        Graph graph = new Graph(3);

        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 5, 1.0));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(-1, 0, 1.0));
        assertThrows(IllegalArgumentException.class, () -> graph.getNeighbors(3));
        assertThrows(IllegalArgumentException.class, () -> graph.getNeighbors(-1));
    }

    @Test
    void negativeNodeCountIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Graph(-1));
    }

    @Test
    void neighborListCannotBeModifiedFromOutside() {
        Graph graph = new Graph(2);
        graph.addEdge(0, 1, 1.0);

        List<Edge> neighbors = graph.getNeighbors(0);
        assertThrows(UnsupportedOperationException.class, neighbors::clear);
        assertEquals(1, graph.getNeighbors(0).size());
    }
}