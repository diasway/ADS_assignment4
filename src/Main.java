import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "B", 2);
        graph.addEdge("B", "D", 1);
        graph.addEdge("C", "D", 5);

        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph);
        List<Vertex<String>> bfsResult = bfs.bfs("A");
        System.out.println("BFS order:");
        bfsResult.forEach(v -> System.out.print(v + " "));
        System.out.println();

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph);
        Map<Vertex<String>, Double> distances = dijkstra.dijkstra("A");
        System.out.println("Dijkstra distances from A:");
        for (Map.Entry<Vertex<String>, Double> entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}