package by.gapanovich.algorithms.Main;

/*
    Task:

    Разработать класс «Граф», для работы с графом, представленным
        •	матрицей смежности,
        •	матрицей инцидентности,
        •	списками смежности,
        •	списками дуг.
    Класс «Граф» должен содержать следующие методы:
        - конструктор/ деструктор;
        - конструктор копирования;
        - добавление/удаление вершины;
        - добавление/удаление дуги;
        -  печать;
*/

import by.gapanovich.algorithms.Classes.Edge;
import by.gapanovich.algorithms.Classes.Graph;
import by.gapanovich.algorithms.Classes.Vertex;
import by.gapanovich.algorithms.Printer.MatrixPrinter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
    public static Graph graph;
    public static int[][] matrix = new int[0][0];

    public Main() {
        JFrame jFrame = new JFrame("Graphics");

        jFrame.setLocation(750, 150);
        jFrame.setMinimumSize(new Dimension(600, 600));
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.getContentPane().add(this);

        jFrame.pack();
        jFrame.setVisible(true);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[] coordsX = new int[matrix.length];
        int[] coordsY = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            coordsX[i] = new Random().nextInt(300);
            coordsY[i] = new Random().nextInt(300);
        }

        for (int i = 0; i < matrix.length; i++) {
            g.setColor(Color.BLACK);
            g.drawString(Character.toString(graph.getVertices()[i].getName()),coordsX[i]+20,coordsY[i]+20);
            g.fillOval(coordsX[i], coordsY[i], 10, 10);
        }

        g.setColor(Color.RED);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    g.drawLine(coordsX[i] + 5, coordsY[i] + 5, coordsX[j] + 5, coordsY[j] + 5);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Main htd = new Main();

        int[][] adj = {
                {0,1,0,0,1,0},
                {1,0,1,0,1,0},
                {0,1,0,1,0,0},
                {0,0,1,0,1,1},
                {1,1,0,1,0,0},
                {0,0,0,1,0,0}
        };


        Graph firstGraph = new Graph(adj, adj.length);
        firstGraph.printGraph();
        MatrixPrinter.printMatrix(firstGraph.writeIncidenceMatrix());



        Main.graph = firstGraph;
        Main.matrix = firstGraph.writeAdjacencyMatrix();

        htd.repaint();

        Thread.sleep(1500);

        Vertex vertex = new Vertex('X');
        firstGraph.addVertex(vertex);
        Edge edge = new Edge(graph.getVertices()[0], graph.getVertices()[graph.getVertices().length-1]);
        firstGraph.addEdge(edge);
        firstGraph.printGraph();
        MatrixPrinter.printMatrix(firstGraph.writeIncidenceMatrix());
        Main.graph = firstGraph;
        Main.matrix = firstGraph.writeAdjacencyMatrix();

        htd.repaint();
    }
}
