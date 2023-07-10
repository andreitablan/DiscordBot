package graphAlgorithms;

public class ConnectedGraph {

    public ConnectedGraph() {

    }

    public String checkConnected(String input) {
        int numberOfVertex = Character.getNumericValue(input.charAt(0));
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(input);
        String listOfNodes = depthFirstSearch.getNodes();
        String[] parts = listOfNodes.split(" ");
        if (parts.length == numberOfVertex) return "The graph is connected.";
        else return "The graph is not connected.";
    }
}
