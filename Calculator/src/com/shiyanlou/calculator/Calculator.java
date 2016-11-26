package com.shiyanlou.calculator;

/**
 * Created by chaowan on 11/22/16.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class Calculator {

    String str1 = "0";
    String str2 = "0";
    String signal = "+";
    String result = "";

    int k1 = 1;
    int k2 = 1;
    int k3 = 1;
    int k4 = 1;
    int k5 = 1;
    JButton store;

    @SuppressWarnings("rawtypes")
    Vector vt = new Vector(20,10);

    JFrame frame = new JFrame("Calculator");
    JTextField result_TextField = new JTextField(result, 20);
    JButton clear_Button = new JButton("Clear");
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button_point = new JButton(".");
    JButton button_plus = new JButton("+");
    JButton button_minus = new JButton("-");
    JButton button_prod = new JButton("*");
    JButton button_divide = new JButton("/");
    JButton button_equal = new JButton("=");

    public Calculator() {

        button0.setMnemonic(KeyEvent.VK_0);

        result_TextField.setHorizontalAlignment(JTextField.RIGHT);


        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(4, 4, 5, 5));
        pan.add(button0);
        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button4);
        pan.add(button5);
        pan.add(button6);
        pan.add(button7);
        pan.add(button8);
        pan.add(button9);
        pan.add(button_plus);
        pan.add(button_minus);
        pan.add(button_prod);
        pan.add(button_divide);
        pan.add(button_point);
        pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(result_TextField, BorderLayout.WEST);
        pan2.add(clear_Button, BorderLayout.EAST);

        frame.setLocation(300, 200);

        frame.setResizable(false);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);

        class Listener implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);
                if (k1 == 1) {
                    if (k3 == 1) {
                        str1 = "";

                        k5 = 1;
                    }
                    str1 = str1 + ss;

                    k3 = k3 + 1;

                    result_TextField.setText(str1);

                } else if (k1 == 2) {
                    if (k4 == 1) {
                        str2 = "";

                        k5 = 1;
                    }
                    str2 = str2 + ss;
                    k4 = k4 + 1;
                    result_TextField.setText(str2);
                }
            }
        }

        class Listener_signal implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);

                if (k2 == 1) {
                    k1 = 2;
                    k5 = 1;
                    signal = ss2;
                    k2 = k2 + 1;
                } else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a - 2);

                    if (!(c.getText().equals("+"))
                            && !(c.getText().equals("-"))
                            && !(c.getText().equals("*"))
                            && !(c.getText().equals("/"))) {
                        cal();
                        str1 = result;

                        k1 = 2;
                        k5 = 1;
                        k4 = 1;
                        signal = ss2;
                    }
                    k2 = k2 + 1;
                }
            }
        }

        class Listener_clear implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                k5 = 1;
                k2 = 1;
                k1 = 1;
                k3 = 1;
                k4 = 1;
                str1 = "0";
                str2 = "0";
                signal = "";
                result = "";
                result_TextField.setText(result);
                vt.clear();
            }
        }

        class Listener_equal implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {

                store = (JButton) e.getSource();
                vt.add(store);
                cal();

                k1 = 1;
                k2 = 1;
                k3 = 1;
                k4 = 1;

                str1 = result;
            }
        }

        class Listener_point implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                if (k5 == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();
                    if (k1 == 1) {
                        if (k3 == 1) {
                            str1 = "";

                            k5 = 1;
                        }
                        str1 = str1 + ss2;

                        k3 = k3 + 1;

                        result_TextField.setText(str1);
                    } else if (k1 == 2) {
                        if (k4 == 1) {
                            str2 = "";
                            k5 = 1;
                        }
                        str2 = str2 + ss2;

                        k4 = k4 + 1;

                        result_TextField.setText(str2);
                    }
                }

                k5 = k5 + 1;
            }

        }

        Listener_equal jt_equal = new Listener_equal();

        Listener jt = new Listener();
        Listener_signal jt_signal = new Listener_signal();
        Listener_clear jt_c = new Listener_clear();
        Listener_point jt_point = new Listener_point();

        button0.addActionListener(jt);
        button1.addActionListener(jt);
        button2.addActionListener(jt);
        button3.addActionListener(jt);
        button4.addActionListener(jt);
        button5.addActionListener(jt);
        button6.addActionListener(jt);
        button7.addActionListener(jt);
        button8.addActionListener(jt);
        button9.addActionListener(jt);
        button_divide.addActionListener(jt_signal);
        button_equal.addActionListener(jt_equal);
        button_minus.addActionListener(jt_signal);
        button_plus.addActionListener(jt_signal);
        button_prod.addActionListener(jt_signal);
        button_point.addActionListener(jt_point);
        clear_Button.addActionListener(jt_c);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void cal(){
        double a2;
        double b2;
        String c = signal;
        double result2 = 0;

        if(c.equals("")){
            result_TextField.setText("please input operator");
        }
        else {
            if (str1.equals("."))
                str1 = "0.0";
            if (str2.equals("."))
                str2 = "0.0";
            a2 = Double.valueOf(str1).doubleValue();
            b2 = Double.valueOf(str2).doubleValue();

            if(c.equals("+")){
                result2 = a2 + b2;
            }
            if(c.equals("-")){
                result2 = a2 - b2;
            }
            if(c.equals("*")){
                result2 = a2 * b2;
            }
            if(c.equals("/")){
                if(b2 == 0){
                    result2 = 0;
                }
                else {
                result2 = a2 / b2;
            }
        }
        result = ((new Double(result2)).toString());
        result_TextField.setText(result);

    }

}

@SuppressWarnings("unused")
public static void main(String[] args){
    try {
        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }                                                                       catch (Exception e){
        e.printStackTrace();
    }
    Calculator cal = new Calculator();
    }
}
