package com.fju;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class WasherDemo extends JFrame{
    public JButton button2;
    public JButton button3;
    public JPanel panel1;

    public WasherDemo() {
        panel1.addComponentListener(new ComponentAdapter() {
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showConfirmDialog(null,"謝謝您的惠顧與支持!");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showConfirmDialog(null,"謝謝您的回饋，我們會做得更好!");
            }
        });
    }

    public static void main(String[] args){
        WasherDemo gui = new WasherDemo();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("Satisfaction survey");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new WasherDemo().panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JButton button2 = new JButton("我很滿意(Like ! )");
        JButton button3 = new JButton("有待加強ㄟ !");
        frame.add(panel);
        panel.add(button2);
        panel.add(button3);
        frame.setVisible(true);



    }

}


