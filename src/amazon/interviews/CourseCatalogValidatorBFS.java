package amazon.interviews;

import java.util.*;
public class CourseCatalogValidatorBFS {

    public boolean isValidCatalog(Map<String, List<String>> catalog) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();

        // Initialize inDegree and graph
        for (String course : catalog.keySet()) {
            graph.putIfAbsent(course, new ArrayList<>());
            inDegree.putIfAbsent(course, 0);

            for (String dep : catalog.get(course)) {
                graph.putIfAbsent(dep, new ArrayList<>());
                inDegree.put(dep, inDegree.getOrDefault(dep, 0) + 1);
            }
        }

        // Queue for nodes with zero in-degree
        Queue<String> queue = new LinkedList<>();
        for (String course : inDegree.keySet()) {
            if (inDegree.get(course) == 0) {
                queue.offer(course);
            }
        }

        int processedCount = 0;

        // Process BFS
        while (!queue.isEmpty()) {
            String current = queue.poll();
            processedCount++;

            for (String neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all courses processed, graph is acyclic
        return processedCount == inDegree.size();
    }

    // For testing
    public static void main(String[] args) {
        Map<String, List<String>> catalog = new HashMap<>();
        catalog.put("chemistry", Arrays.asList("physics", "math"));
        catalog.put("math", Arrays.asList("hindi"));
        catalog.put("hindi", Collections.emptyList());
        catalog.put("physics", Collections.emptyList());

        CourseCatalogValidatorBFS validator = new CourseCatalogValidatorBFS();
        System.out.println("Is valid catalog? " + validator.isValidCatalog(catalog)); // true
    }
}
