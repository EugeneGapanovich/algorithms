package by.gapanovich.cellularautomato.classes;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private final Cells cells;

    public Panel(Cells cells) {
        this.cells = cells;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cell_size = 10;
        for (int i = 1; i < cells.getN() + 1; i++) {
            g.drawLine(0, cell_size * i, cells.getN() * cell_size, cell_size * i);
            g.drawLine(cell_size * i, 0, cell_size * i, cells.getN() * cell_size);
        }

        for (int i = 0; i < cells.getN(); i++) {
            for (int j = 0; j < cells.getN(); j++) {
                if (cells.getElement(i, j) == 1) {
                    g.fillRect(i * cell_size, j * cell_size, cell_size, cell_size);
                }
            }
        }
    }

    public Cells getCells() {
        return cells;
    }
}
