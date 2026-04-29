import java.util.*;
public class UnweightedShortestPath {
    public static List<Integer> shortestPath(int[][] graph, int start, int target) {
        int nodes = graph.length;
        boolean[] visited = new boolean[nodes];
        int[] parent = new int[nodes];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current == target) {
                break;
            }
            for (int neighbor = 0; neighbor < nodes; neighbor++) {
                if (graph[current][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        if (!visited[target]) {
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        int node = target;

        while (node != -1) {
            path.add(node);
            node = parent[node];
        }

        Collections.reverse(path);
        return path;
        }

    public static void main(String[] args) {
        int[][] graph = {
                    {0, 1, 1, 0},
                    {1, 0, 0, 1},
                    {1, 0, 0, 1},
                    {0, 1, 1, 0}
        };

        int start = 0;
        int target = 3;

        List<Integer> path = shortestPath(graph, start, target);

        if (path.isEmpty()) {
            System.out.println("No path found");
        }
        else {
            System.out.println("Shortest path: " + path);
        }
    }

}
