package gb.lesson7_2;

import javax.swing.*;
import java.awt.*;

public class CalcWindow extends JFrame {

    static double result = 0;

    public CalcWindow() {
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setLayout(new GridLayout(2, 1));

        addFields(this);

        setVisible(true);
    }

    public static void addFields(CalcWindow calcWindow) {

        JTextArea operationWindow = new JTextArea();
        operationWindow.setEditable(false);
        operationWindow.setFont(new Font("Dialog", Font.PLAIN, 40));
        operationWindow.setLineWrap(true);
        operationWindow.setText("0");
        calcWindow.add(operationWindow);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        JButton btnPercent = new JButton("%");
        buttonPanel.add(btnPercent);
        addListenerPercent(btnPercent, operationWindow);
        JButton btnCE = new JButton("CE");
        buttonPanel.add(btnCE);
        addListenerCE(btnCE, operationWindow);
        JButton btnBackspace = new JButton("<-");
        buttonPanel.add(btnBackspace);
        addListenerBack(btnBackspace, operationWindow);
        JButton btnDiv = new JButton("/");
        addListenerCommands(btnDiv, operationWindow, '/');
        buttonPanel.add(btnDiv);
        JButton btn7 = new JButton("7");
        buttonPanel.add(btn7);
        addListenerNumbers(btn7, operationWindow, 7);
        JButton btn8 = new JButton("8");
        buttonPanel.add(btn8);
        addListenerNumbers(btn8, operationWindow, 8);
        JButton btn9 = new JButton("9");
        buttonPanel.add(btn9);
        addListenerNumbers(btn9, operationWindow, 9);
        JButton btnMltpl = new JButton("*");
        buttonPanel.add(btnMltpl);
        addListenerCommands(btnMltpl, operationWindow, '*');
        JButton btn4 = new JButton("4");
        buttonPanel.add(btn4);
        addListenerNumbers(btn4, operationWindow, 4);
        JButton btn5 = new JButton("5");
        buttonPanel.add(btn5);
        addListenerNumbers(btn5, operationWindow, 5);
        JButton btn6 = new JButton("6");
        buttonPanel.add(btn6);
        addListenerNumbers(btn6, operationWindow, 6);
        JButton btnMinus = new JButton("-");
        buttonPanel.add(btnMinus);
        addListenerCommands(btnMinus, operationWindow, '-');
        JButton btn1 = new JButton("1");
        buttonPanel.add(btn1);
        addListenerNumbers(btn1, operationWindow, 1);
        JButton btn2 = new JButton("2");
        buttonPanel.add(btn2);
        addListenerNumbers(btn2, operationWindow, 2);
        JButton btn3 = new JButton("3");
        buttonPanel.add(btn3);
        addListenerNumbers(btn3, operationWindow, 3);
        JButton btnPlus = new JButton("+");
        buttonPanel.add(btnPlus);
        addListenerCommands(btnPlus, operationWindow, '+');
        JButton btnPlusMinus = new JButton("+/-");
        buttonPanel.add(btnPlusMinus);
        addListenerPlusMinus(btnPlusMinus, operationWindow);
        JButton btn0 = new JButton("0");
        buttonPanel.add(btn0);
        addListenerNumbers(btn0, operationWindow, 0);
        JButton btnMark = new JButton(".");
        buttonPanel.add(btnMark);
        addListenerMark(btnMark, operationWindow);
        JButton btnSum = new JButton("=");
        buttonPanel.add(btnSum);
        addListenerSum(btnSum, operationWindow);

        calcWindow.add(buttonPanel);
    }

    private static void addListenerNumbers(JButton jButton, JTextArea jTextArea, int i) {
        jButton.addActionListener((event) -> {
            if (!jTextArea.getText().equals("0")) {
                jTextArea.append("" + i);
            } else {
                jTextArea.setText("" + i);
            }
            if (!checkCommand(jTextArea.getText())) {
                String str = jTextArea.getText().substring(0, String.valueOf(result).length() - 1);
                String subStr = jTextArea.getText().substring(String.valueOf(result).length() - 1);
                if (subStr.startsWith("0") && subStr.length() > 1 && i == 0) {
                    jTextArea.setText(jTextArea.getText().substring(0, jTextArea.getText().length() - 1));
                } else if (subStr.startsWith("0") && i != 0) {
                    jTextArea.setText(str + i);
                }
            }
        });
    }

    private static void addListenerCE(JButton jButton, JTextArea jTextArea) {
        jButton.addActionListener((event) -> {
            jTextArea.setText("0");
            result = 0;
        });
    }

    private static void addListenerBack(JButton jButton, JTextArea jTextArea) {
        jButton.addActionListener((event) -> {
            String str = jTextArea.getText();
            if (str.length() == 1) {
                jTextArea.setText("0");
            } else if (str.contains("+") || str.contains("-") || str.contains("*") ||
                    str.contains("/") || str.contains(".") || Double.parseDouble(str) != 0) {
                jTextArea.setText(str.substring(0, str.length() - 1));
            }
        });
    }

    private static void addListenerMark(JButton jButton, JTextArea jTextArea) {
        jButton.addActionListener((event) -> {
            if (jTextArea.getText().indexOf('.') == -1) {
                jTextArea.append("" + '.');
            } else {
                if (!checkCommand(jTextArea.getText())) {
                    String subStr = "" + result;
                    String str = jTextArea.getText().substring(subStr.length(), jTextArea.getText().length());
                    if (str.length() == 1) {
                        jTextArea.append("0");
                    }
                    if (str.indexOf('.') == -1) {
                        jTextArea.append("" + '.');
                    }
                }
            }
        });
    }

    private static void addListenerCommands(JButton jButton, JTextArea jTextArea, char c) {
        jButton.addActionListener((event) -> {
            String str = jTextArea.getText();
            if (str.endsWith("+") || str.endsWith("-") || str.endsWith("*") || str.endsWith("/")) {
                jTextArea.setText(str.substring(0, str.length() - 1));
                str = jTextArea.getText();
            }
            if (checkCommand(str)) {
                result = Double.parseDouble(str);
                jTextArea.append("" + c);
            } else {
                if (!str.endsWith(".")) {
                    summarize(str);
                    output(jTextArea, "" + c);
                }
            }
        });
    }

    private static boolean checkCommand(String str) {
        return str.indexOf('+', 1) == -1 && str.indexOf('-', 1) == -1 && str.indexOf('*', 1) == -1 && str.indexOf('/', 1) == -1;
    }

    private static void addListenerSum(JButton jButton, JTextArea jTextArea) {
        jButton.addActionListener((event) -> {
            String str = jTextArea.getText();
            if (!str.endsWith("+") && !str.endsWith("-") && !str.endsWith("*") && !str.endsWith("/") && !str.endsWith(".")) {
                summarize(str);
                output(jTextArea, "");
            }
        });
    }

    private static void summarize(String str) {
        if (str.contains("+")) {
            result += Double.parseDouble(str.substring(str.indexOf('+') + 1, str.length()));
        } else if (str.indexOf('-', 1) != -1) {
            result -= Double.parseDouble(str.substring(str.indexOf('-', 1) + 1, str.length()));
        } else if (str.contains("*")) {
            result *= Double.parseDouble(str.substring(str.indexOf('*') + 1, str.length()));
        } else if (str.contains("/")) {
            result /= Double.parseDouble(str.substring(str.indexOf('/') + 1, str.length()));
        }
    }

    private static void output(JTextArea jTextArea, String str) {
        jTextArea.setText("" + rounded(result) + str);
    }

    private static String rounded(double d) {
        return (result - (int) result == 0) ? "" + (int) d : "" + d;
    }

    private static void addListenerPlusMinus(JButton jButton, JTextArea jTextArea) {
        jButton.addActionListener((event) -> {
            if (checkCommand(jTextArea.getText())) {
                result = (-1) * Double.parseDouble(jTextArea.getText());
                output(jTextArea, "");
            }
        });
    }

    private static void addListenerPercent(JButton jButton, JTextArea jTextArea) {
        jButton.addActionListener((event) -> {
            String str = jTextArea.getText();
            double sub = 0;
            if (!checkCommand(str)) {
                if (str.contains("+")) {
                    sub = result * Double.parseDouble(str.substring(str.indexOf('+') + 1, str.length())) / 100;
                } else if (str.indexOf('-', 1) != -1) {
                    sub = result * Double.parseDouble(str.substring(str.indexOf('-', 1) + 1, str.length())) / 100;
                } else if (str.contains("*")) {
                    sub = Double.parseDouble(str.substring(str.indexOf('*') + 1, str.length())) / 100;
                } else if (str.contains("/")) {
                    sub = Double.parseDouble(str.substring(str.indexOf('/') + 1, str.length())) / 100;
                }
            }
            if (sub > 0) {
                    output(jTextArea, str.substring(String.valueOf(result).length() - 2, String.valueOf(result).length() - 1) + rounded(sub));

            } else if (sub < 0) {
                    output(jTextArea, "" + rounded(sub));
            }
        });
    }
}
