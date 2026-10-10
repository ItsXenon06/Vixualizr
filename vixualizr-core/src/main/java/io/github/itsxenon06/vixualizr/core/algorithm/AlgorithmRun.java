package io.github.itsxenon06.vixualizr.core.algorithm;

import io.github.itsxenon06.vixualizr.core.event.Event;

import java.util.List;

public record AlgorithmRun<R>(R result, List<Event> events){

}

