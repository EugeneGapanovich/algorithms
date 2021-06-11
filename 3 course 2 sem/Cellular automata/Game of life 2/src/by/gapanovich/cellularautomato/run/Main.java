package by.gapanovich.cellularautomato.run;

import by.gapanovich.cellularautomato.classes.Cells;
import by.gapanovich.cellularautomato.classes.Panel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {
    private static final int COUNT_CELLS = 50;
    private final int CELL_SIZE = 10;
    public boolean isActive;
    public by.gapanovich.cellularautomato.classes.Panel panel;

    public Main(by.gapanovich.cellularautomato.classes.Panel panel) {
        JFrame jframe = new JFrame("Graphics");
        isActive = false;
        this.panel = panel;

        jframe.setLocation(750, 150);
        jframe.setMinimumSize(new Dimension(panel.getCells().getN() * CELL_SIZE,
                panel.getCells().getN() * CELL_SIZE));
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.pack();
        jframe.setVisible(true);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(6, 1, 0, 0));

        JButton start = new JButton("Start");
        start.addActionListener(new Start());

        JButton pause = new JButton("Pause");
        pause.addActionListener(new Pause());

        JButton clear = new JButton("Clear");
        clear.addActionListener(new Clear());

        buttons.add(start);
        buttons.add(pause);
        buttons.add(clear);

        panel.addMouseListener(new MouseClick());

        jframe.getContentPane().add(panel, BorderLayout.CENTER);
        jframe.getContentPane().add(buttons, BorderLayout.EAST);
    }

    public static void main(String[] args) throws InterruptedException {
        Cells cells = new Cells(COUNT_CELLS);
        by.gapanovich.cellularautomato.classes.Panel panel = new Panel(cells);
        Main main = new Main(panel);

        while (true) {
            System.out.print("");
            panel.repaint();

            while (main.isActive) {
                Thread.sleep(500);

                cells.checkAllCells();
                panel.repaint();
            }
        }
    }

    public class Start implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isActive = true;
        }
    }

    public class Pause implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isActive = false;
        }
    }

    public class Clear implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.getCells().clearCells();
            isActive = false;
        }
    }

    public class MouseClick implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getX() < panel.getCells().getN() * CELL_SIZE && e.getY() < panel.getCells().getN() * CELL_SIZE) {
                int i = e.getX() / CELL_SIZE;
                int j = e.getY() / CELL_SIZE;

                if (panel.getCells().getElement(i, j) == 1) {
                    panel.getCells().setCell(i, j, 0);
                } else {
                    panel.getCells().setCell(i, j, 1);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
