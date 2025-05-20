import java.util.*;

public class DijkstraSearch<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }

    public Map<Vertex<V>, Double> dijkstra(V startData) {
        Vertex<V> start = graph.getVertex(startData);
        if (start == null) return Collections.emptyMap();

        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>(Comparator.comparingDouble(vd -> vd.distance));
        Set<Vertex<V>> visited = new HashSet<>();

        for (Vertex<V> v : graph.getAllVertices()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        distances.put(start, 0.0);
        pq.add(new VertexDistance<>(start, 0.0));

        while (!pq.isEmpty()) {
            VertexDistance<V> currentVD = pq.poll();
            Vertex<V> current = currentVD.vertex;

            if (visited.contains(current)) continue;
            visited.add(current);

            for (Map.Entry<Vertex<V>, Double> neighborEntry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                if (!visited.contains(neighbor)) {
                    double newDist = distances.get(current) + weight;
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        pq.add(new VertexDistance<>(neighbor, newDist));
                    }
                }
            }
        }

        return distances;
    }

    private static class VertexDistance<V> {
        Vertex<V> vertex;
        double distance;

        public VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
