package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '.';

    static char[][] field;
    int mode;
    static int fieldSizeX;
    static int fieldSizeY;
    static int winLength;

    static int cellX = 0;
    static int cellY = 0;
    int cellHeight;
    int cellWidth;

    boolean isInit = false;

    public Map() {
        setBackground(Color.CYAN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                update(e);
            }
        });

    }

    public void update(MouseEvent e) {
        this.cellX = e.getX() / cellWidth;
        this.cellY = e.getY() / cellHeight;
        System.out.println(cellX + " " + cellY);
        repaint();
        if (mode == MODE_H_V_A) {
            if (H_V_A.isCellValid(cellX, cellY)) {
                H_V_A.humVsAi();
            }
        }else if(mode == MODE_H_V_H){
            if (H_V_H.isCellValid(cellX, cellY)){
                H_V_H.humVsHum();
            }
        }
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {

        this.mode = mode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }

        isInit = true;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke((new BasicStroke(4)));
                g2.setColor(Color.RED);
                if (field[i][j] == DOT_X) {
                    g.drawLine((j * cellWidth) + 8, (i * cellHeight) + 8, ((j + 1) * cellWidth) - 8, ((i + 1) * cellHeight) - 8);
                    g.drawLine(((j + 1) * cellWidth) - 8, (i * cellHeight) + 8, (j * cellWidth) + 8, ((i + 1) * cellHeight) - 8);
                } else if (field[i][j] == DOT_O) {
                    g.drawOval((j * cellWidth) + 8, (i * cellHeight) + 8, cellWidth - 16, cellHeight - 16);
                }
            }
        }
    }
}
