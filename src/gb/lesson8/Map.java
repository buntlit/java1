package gb.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {
    private GameWindow gameWindow;
    private boolean isInit = false;
    private int gameMode;
    private int size;
    private int dotsToWin;
    private int cellWidth;
    private int cellHeight;

    private double errorRate;

    public Map(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.LIGHT_GRAY);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                if (isInit) {
                    mouseReleasedUpdate(mouseEvent);
                }
            }
        });
    }

    private void mouseReleasedUpdate(MouseEvent mouseEvent) {
        int cellX = mouseEvent.getX() / cellWidth;
        int cellY = mouseEvent.getY() / cellHeight;

        if (!Logic.gameFinished) {
            Logic.setHumanCoordinates(cellX, cellY, gameMode);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        render(graphics);
    }

    public void startNewGame(int gameMode, int size, int dotsToWin) {
        this.gameMode = gameMode;
        this.size = size;
        this.dotsToWin = dotsToWin;

        Logic.size = size;
        Logic.dotToWin = dotsToWin;
        Logic.initMap();
        Logic.gameFinished = false;
        isInit = true;
        repaint();
    }

    private void render(Graphics graphics) {
        if (!isInit) {
            return;
        }

        cellWidth = getWidth() / size;
        cellHeight = getHeight() / size;
        errorRate = cellWidth / 10;

        for (int i = 0; i < size; i++) {
            int y = i * cellWidth;
            graphics.drawLine(0, y, getWidth(), y);
        }

        for (int i = 0; i < size; i++) {
            int x = i * cellHeight;
            graphics.drawLine(x, 0, x, getHeight());
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Logic.map[j][i] == Logic.DOT_X) {
                    drawX(graphics, i, j, Color.BLACK, errorRate);
                }
                if (Logic.map[j][i] == Logic.DOT_WIN_X) {
                    drawX(graphics, i, j, Color.GREEN, errorRate);
                }
                if (Logic.map[j][i] == Logic.DOT_O) {
                    drawO(graphics, i, j, Color.BLACK, errorRate);
                }
                if (Logic.map[j][i] == Logic.DOT_WIN_O) {
                    drawO(graphics, i, j, Color.RED, errorRate);
                }
            }

        }
    }

    private void drawO(Graphics graphics, int cellX, int cellY, Color color, Double error) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(color);
        graphics2D.drawOval((int) (cellX * cellWidth + error), (int) (cellY * cellWidth + error), (int) (cellWidth - 2 * error), (int) (cellHeight - 2 * error));
    }

    private void drawX(Graphics graphics, int cellX, int cellY, Color color, Double error) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.setColor(color);
        graphics2D.drawLine((int) (cellX * cellWidth + error), (int) (cellY * cellHeight + error), (int) ((cellX + 1) * cellWidth - error), (int) ((cellY + 1) * cellHeight - error));
        graphics2D.drawLine((int) (cellX * cellWidth + error), (int) ((cellY + 1) * cellHeight - error), (int) ((cellX + 1) * cellWidth - error), (int) (cellY * cellHeight + error));
    }


}
