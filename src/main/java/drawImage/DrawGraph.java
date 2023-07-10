package drawImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DrawGraph extends JPanel {

    private final HashMap<Node, Integer> hashMapX = new HashMap<>();
    private final HashMap<Node, Integer> hashMapY = new HashMap<>();
    int xMiddle = 700;
    int yMiddle = 300;
    int math = Math.min(xMiddle, yMiddle);
    int radius = 4 * math / 5;
    int radius1 = Math.abs(math - radius) / 2;
    private List<Node> nodeList = new ArrayList<Node>();

    /**
     * Creates a Graphics2D object in order draw the graph.
     *
     * @param nodeList The given nodes list.
     * @throws IOException
     */
    public DrawGraph(List<Node> nodeList) throws IOException {

        this.nodeList = nodeList;
        BufferedImage bufferedImage = new BufferedImage(1400, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D imageGraphics = bufferedImage.createGraphics();
        imageGraphics.setPaint(Color.darkGray);
        imageGraphics.fillRect(0, 0, 1400, 600);

        this.paintNodes(imageGraphics);
        this.paintEdges(imageGraphics);
        this.paintNumbers(imageGraphics);

        ImageIO.write(bufferedImage, "PNG", new File("C:\\Users\\andre\\Desktop\\graph.png"));

    }

    /**
     * Paints the nodes of the graph.
     *
     * @param graphics2D The Graphics2D object.
     */
    public void paintNodes(Graphics2D graphics2D) {
        for (int index = 0; index < this.nodeList.size(); index++) {
            double tangent = 2 * Math.PI * index / this.nodeList.size();
            int xCoordonate = (int) Math.round(xMiddle + radius * Math.cos(tangent));
            int yCoordonate = (int) Math.round(yMiddle + radius * Math.sin(tangent));

            graphics2D.setPaint(Color.yellow);
            graphics2D.fillOval(xCoordonate - radius1, yCoordonate - radius1, 2 * radius1, 2 * radius1);
            hashMapX.put(this.nodeList.get(index), xCoordonate - radius1 + 10);
            hashMapY.put(this.nodeList.get(index), yCoordonate - radius1 + 25);
        }
    }

    /**
     * Prints the edges of the graph.
     *
     * @param graphics2D The Graphics2D object.
     */
    public void paintEdges(Graphics2D graphics2D) {
        graphics2D.setPaint(Color.yellow);
        graphics2D.setStroke(new BasicStroke(4));
        for (Node node : nodeList) {
            node.getNeighbours().stream().forEach(neighbour -> graphics2D.drawLine(hashMapX.get(node),
                    hashMapY.get(node), hashMapX.get(neighbour), hashMapY.get(neighbour)));
        }
    }

    /**
     * Paints the number of the nodes.
     *
     * @param graphics2D The Graphics2D object.
     */
    public void paintNumbers(Graphics2D graphics2D) {
        for (int index = 0; index < this.nodeList.size(); index++) {
            double tangent = 2 * Math.PI * index / this.nodeList.size();
            int xCoordonate = (int) Math.round(xMiddle + radius * Math.cos(tangent));
            int yCoordonate = (int) Math.round(yMiddle + radius * Math.sin(tangent));

            graphics2D.setFont(graphics2D.getFont().deriveFont(20f));
            graphics2D.setPaint(Color.blue);
            graphics2D.drawString(String.valueOf(this.nodeList.get(index).getNumber()),
                    xCoordonate - radius1 + 20, yCoordonate - radius1 + 35);
        }
    }
}