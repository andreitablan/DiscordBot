package graphAlgorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {

    private final int numberOfVertex;
    private final LinkedList<Integer>[] listOfNeighbours;
    String nodes = "";

    /**
     * Creates the graph from the user's message. Starts the BFS algorithm.
     *
     * @param input The input from the user.
     */
    public BreadthFirstSearch(String input) {
        this.numberOfVertex = Character.getNumericValue(input.charAt(0));

        listOfNeighbours = new LinkedList[numberOfVertex];
        for (int index = 0; index < numberOfVertex; ++index)
            listOfNeighbours[index] = new LinkedList();

        for (int index = 1; index < input.length(); index++) {
            if (input.charAt(index) == '-') {
                this.addEdge(Character.getNumericValue(input.charAt(index - 1)), Character.getNumericValue(input.charAt(index + 1)));
            }
        }
        this.BFS(Character.getNumericValue(input.charAt(2)));
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
     * The Breadth First Search Algorithm.
     *
     * @param vertex The starting vertex.
     */
    void BFS(int vertex) {

        boolean[] visited = new boolean[numberOfVertex];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            vertex = queue.poll();
            String node = String.valueOf(vertex);
            nodes = nodes + node + " ";

            Iterator<Integer> iterator = listOfNeighbours[vertex].listIterator();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public String getNodes() {
        return nodes;
    }
}

