package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_HEIGHT = 555;
    private static final int WIN_WIDTH = 505;

    private static StartNewGameWindow startNewGameWindow;
    private static Map field;

    public GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");

        JPanel jpanel = new JPanel(new GridLayout(1,2));

        JButton btnNewGame = new JButton("Start new game");
        JButton btnExit = new JButton("Exit game");
        jpanel.add(btnNewGame);
        jpanel.add(btnExit);

        startNewGameWindow = new StartNewGameWindow(this);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGameWindow.setVisible(true);
            }
        });

        add(jpanel, BorderLayout.SOUTH);

        field = new Map();
        add(field, BorderLayout.CENTER);

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        field.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);

    }

}
