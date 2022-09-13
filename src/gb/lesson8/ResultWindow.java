package gb.lesson8;

import javax.swing.*;
import java.awt.*;

public class ResultWindow extends JFrame {
    private static final int WINDOW_WIDTH = 250;
    private static final int WINDOW_HEIGHT = 100;
    private JTextField textResult = new JTextField();
    private JButton buttonOK = new JButton("OK");

    public ResultWindow() {
        setTitle("Result");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        add(textResult, BorderLayout.CENTER);
        textResult.setEditable(false);
        textResult.setHorizontalAlignment(JTextField.CENTER);
        add(buttonOK, BorderLayout.SOUTH);
        buttonOK.addActionListener(e->{
            setVisible(false);
        });

        setVisible(false);
    }

    public void setTextResult(String s){
        textResult.setText(s);
        setVisible(true);
    }
}
