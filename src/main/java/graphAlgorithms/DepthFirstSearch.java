package graphAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
    private final int numberOfVertex;
    private final LinkedList<Integer>[] listOfNeighbours;
    String nodes = "";

    /**
     * Creates the graph from the user's message. Starts the DFS algorithm.
     *
     * @param input The input from the user.
     */
    public DepthFirstSearch(String input) {
        this.numberOfVertex = Character.getNumericValue(input.charAt(0));

        listOfNeighbours = new LinkedList[numberOfVertex];
        for (int index = 0; index < numberOfVertex; ++index)
            listOfNeighbours[index] = new LinkedList();

        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(index) == '-') {
                this.addEdge(Character.getNumericValue(input.charAt(index - 1)),
                        Character.getNumericValue(input.charAt(index + 1)));
            }
        }
        this.DFS(Character.getNumericValue(input.charAt(2)));
    }

    /**
     * Adds in the list of neighbours.
     *
     * @param vertex1 The first vertex.
     * @param vertex2 The second vertex.
     */
    private void addEdge(int vertex1, int vertex2) {
        listOfNeighbours[vertex1].add(vertex2);
        listOfNeighbours[vertex2].add(vertex1);
    }

    /**
     * The Depth First Search Algorithm.
     */
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        String node = String.valueOf(vertex);
        nodes = nodes + node + " ";

        Iterator<Integer> iterator = listOfNeighbours[vertex].listIterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (!visited[next]) DFSUtil(next, visited);
        }
    }

    private void DFS(int vertex) {
        boolean[] visited = new boolean[numberOfVertex];
        DFSUtil(vertex, visited);
    }

    public String getNodes() {
        return nodes;
    }
}
