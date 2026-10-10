package io.github.itsxenon06.vixualizr.core.algorithm;

import java.util.List;

public record PathResult(boolean found, List<Integer> path, double cost, int visitedCount) {
    public static PathResult notFound(int visitedCount) {
        return new PathResult(false, List.of(), Double.POSITIVE_INFINITY, visitedCount);
    }
}
