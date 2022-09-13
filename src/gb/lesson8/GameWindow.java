package gb.lesson8;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static final int WINDOW_WIDTH = 505;
    private static final int WINDOW_HEIGHT = 555;
    private SettingsWindow settingsWindow;
    private Map map;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");

        settingsWindow = new SettingsWindow(this);
        map = new Map(this);
        add(map, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton buttonStart = new JButton("Start new game");
        panel.add(buttonStart);
        JButton buttonExit = new JButton("Exit");
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        buttonExit.addActionListener(e->{
            System.exit(0);
        });

        buttonStart.addActionListener(e->{
            settingsWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int gameMode, int size, int dotsToWin){
        map.startNewGame(gameMode, size, dotsToWin);
    }
}
