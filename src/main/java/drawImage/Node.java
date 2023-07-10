package drawImage;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int number;
    private List<Node> neighbours = new ArrayList<>();

    public Node(int number) {
        this.number = number;
    }

    public void addNeighbour(Node node) {
        neighbours.add(node);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

}
