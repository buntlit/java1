package gb.lesson8;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_WIDTH = 405;
    private static final int WINDOW_HEIGHT = 400;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final int MODE_H_V_A = 0;
    private static final int MODE_H_V_H = 1;

    private GameWindow gameWindow;

    private JRadioButton radioHvH = new JRadioButton("Human VS Human");
    private JRadioButton radioHvA = new JRadioButton("Human VS AI", true);
    private ButtonGroup gameMode = new ButtonGroup();
    private JSlider sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
    private JSlider sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
    private JButton buttonStart = new JButton("Start");


    public SettingsWindow(GameWindow gameWindow) {

        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Settings");

        setLayout(new GridLayout(8, 1));

        add(new JLabel("Select game mode:"));
        add(radioHvA);
        add(radioHvH);
        gameMode.add(radioHvA);
        gameMode.add(radioHvH);

        add(new JLabel("Select field size:"));
        jSliderSettings(sliderFieldSize);
        add(sliderFieldSize);

        add(new JLabel("Select dots to win:"));
        jSliderSettings(sliderDotsToWin);
        add(sliderDotsToWin);

        sliderFieldSize.addChangeListener(e->{
            sliderDotsToWin.setMaximum(sliderFieldSize.getValue());
        });

        add(buttonStart);
        buttonStart.addActionListener(e->{
            setVisible(false);

            int mode;

            if (radioHvA.isSelected()){
                mode = MODE_H_V_A;
            }else {
                mode = MODE_H_V_H;
            }

            int size = sliderFieldSize.getValue();
            int dotToWin = sliderDotsToWin.getValue();

            gameWindow.startNewGame(mode, size, dotToWin);
        });


        setVisible(false);

    }

    private static void jSliderSettings(JSlider jSlider){
        jSlider.setMajorTickSpacing(1);
        jSlider.setPaintLabels(true);
        jSlider.setPaintTicks(true);
    }
}
