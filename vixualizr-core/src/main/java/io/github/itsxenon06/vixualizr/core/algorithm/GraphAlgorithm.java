package io.github.itsxenon06.vixualizr.core.algorithm;

import io.github.itsxenon06.vixualizr.core.Graph;

public interface GraphAlgorithm<R>{
    AlgorithmRun<R> run(Graph graph);
}
