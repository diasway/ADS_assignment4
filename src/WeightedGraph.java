import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        vertices = new HashMap<>();
    }

    public Vertex<V> addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
        return vertices.get(data);
    }

    public void addEdge(V sourceData, V destData, double weight) {
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);

        if (source == null) {
            source = addVertex(sourceData);
        }
        if (dest == null) {
            dest = addVertex(destData);
        }

        source.addAdjacentVertex(dest, weight);
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
}
