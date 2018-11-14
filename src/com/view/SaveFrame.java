package com.view;

import com.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveFrame extends JFrame{
    private Controller controller;
    private JButton saveButton;
    private JButton exitButton;
    private JButton nextLevelButton;

    public SaveFrame(Controller controller){
        this.controller = controller;
        saveButton = new JButton("SAVE");
        exitButton = new JButton("EXIT");
        nextLevelButton = new JButton("NEXT LEVEL");
    }
    public void init(int level){

        setDefaultCloseOperation(1);
        setSize(310, 100);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.LINE_AXIS));
        panel2.add(Box.createRigidArea(new Dimension(20,20)));
        panel2.add(saveButton);
        panel2.add(Box.createRigidArea(new Dimension(20,20)));
        panel2.add(nextLevelButton);
        panel2.add(Box.createRigidArea(new Dimension(20,20)));
        panel2.add(exitButton);
        panel2.add(Box.createRigidArea(new Dimension(20,20)));


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        Label label = new Label("                 Level <<" + level + ">> completed");
        label.setFont(new Font("Times New Roman", Font.BOLD, 16));
        panel.add(label);
        panel.add(panel2);
        panel.add(Box.createRigidArea(new Dimension(0,10)));

        add(panel);

        nextLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startNextLevel();
                dispose();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.save();
                }catch (IOException ex){
                    JOptionPane.showMessageDialog(null,"Game no save!!!");
                }
            }
        });

    }

    public JButton getExitButton() {
        return exitButton;
    }
}