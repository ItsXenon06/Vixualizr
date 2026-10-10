package io.github.itsxenon06.vixualizr.core.event;
public record Event(EventType type, int a, int b, double value) {

    private static final int NONE = -1;

    public static Event visit(int node) {
        return new Event(EventType.VISIT, node, NONE, 0.0);
    }
    public static Event discover(int node, int from) {
        return new Event(EventType.DISCOVER, node, from, 0.0);
    }
    public static Event update(int node, int from, double distance) {
        return new Event(EventType.UPDATE, node, from, distance);
    }
    public static Event examineEdge(int from, int to, double weight) {
        return new Event(EventType.EXAMINE_EDGE, from, to, weight);
    }
    public static Event selectEdge(int from, int to, double weight) {
        return new Event(EventType.SELECT_EDGE, from, to, weight);
    }
}