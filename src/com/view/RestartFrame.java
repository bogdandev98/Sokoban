package com.view;

import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RestartFrame extends JFrame{
    private Controller controller;
    private JButton gameButton;
    private JButton levelButton;


    public RestartFrame(Controller controller){
        this.controller = controller;
        gameButton = new JButton("GAME");
        gameButton.setSize(new Dimension(50,20));
        levelButton = new JButton("LEVEL");
        gameButton.setSize(new Dimension(50,20));
    }
    public void init(){

        setDefaultCloseOperation(1);
        setSize(210, 100);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        panel2.add(Box.createRigidArea(new Dimension(20,20)));
        panel2.add(levelButton);
        panel2.add(Box.createRigidArea(new Dimension(20,20)));
        panel2.add(gameButton);
        panel2.add(Box.createRigidArea(new Dimension(20,20)));


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        Label label = new Label("              RESTART:");
        label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel.add(label);
        panel.add(panel2);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        add(panel);

        levelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.restartLevel();
                dispose();
            }
        });

        gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.restartGame();
                dispose();

            }
        });

    }
}
