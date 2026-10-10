package io.github.itsxenon06.vixualizr.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {
    @Test
    void remembersNodeCount() {
        Graph g = new Graph(5);
        assertEquals(5, g.getNodeCount());
    }
}