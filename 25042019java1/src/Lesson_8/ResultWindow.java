package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultWindow extends JDialog {

    public static String result;

    ResultWindow(JFrame parent) {
        super(parent, "Result", true);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 500, 30));
        repaint();
    }

    public void ResultWindowViewOn(String result) {
        this.result = result;
        JLabel label = new JLabel(result);

        add(label);
        JButton ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(75, 25));
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                remove(label);
                remove(ok);
            }
        });
        add(ok);
        setVisible(true);
    }
}