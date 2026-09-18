import java.util.*;

class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, List<Node>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            graph.get(a).add(new Node(b, value));
            graph.get(b).add(new Node(a, 1.0 / value));
        }

        double[] answer = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {

                answer[i] = -1.0;
            }
            else if (start.equals(end)) {

                answer[i] = 1.0;
            }
            else {

                Set<String> visited = new HashSet<>();

                answer[i] = dfs(graph, start, end, 1.0, visited);
            }
        }

        return answer;
    }

    private double dfs(
            Map<String, List<Node>> graph,
            String current,
            String target,
            double value,
            Set<String> visited) {

        if (current.equals(target)) {
            return value;
        }

        visited.add(current);

        for (Node node : graph.get(current)) {

            if (!visited.contains(node.name)) {

                double result = dfs(
                        graph,
                        node.name,
                        target,
                        value * node.value,
                        visited
                );

                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }

    class Node {
        String name;
        double value;

        Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }
}