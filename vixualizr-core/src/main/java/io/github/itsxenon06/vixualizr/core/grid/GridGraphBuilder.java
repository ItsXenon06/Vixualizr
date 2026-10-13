package io.github.itsxenon06.vixualizr.core.grid;

import io.github.itsxenon06.vixualizr.core.Graph;

public class GridGraphBuilder {

    public static Graph toGraph(Grid grid) {
        Graph graph = new Graph(grid.getRows() * grid.getCols());
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                int node = grid.toNode(i, j);
                if (grid.inBounds(i + 1, j) && !grid.isWall(i + 1, j)) {
                    graph.addUndirectedEdge(node, grid.toNode(i + 1, j), 1.0);
                }
                if (grid.inBounds(i, j + 1) && !grid.isWall(i, j + 1)) {
                    graph.addUndirectedEdge(node, grid.toNode(i, j + 1), 1.0);
                }
                if(grid.inBounds(i, j)){
                    graph.addUndirectedEdge(node, grid.toNode(i, j), 1.0);
                }
            }
        }
        return graph;
    }
}
