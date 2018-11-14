package com.view;

import com.controller.Controller;
import com.controller.EventListener;
import com.model.GameObjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private Controller controller;
    private Field field;
    private SaveFrame saveFrame;
        public View(Controller controller) {
        this.controller=controller;

    }
    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Socoban 2.0");
        setVisible(true);
        setResizable(false);

        field.paint(getGraphics());
    }

    public GameObjects getGameObjects() {
        return controller.getGameObjects();
    }

    public void setEventListener(EventListener eventListener) {
        field.setEventListener(eventListener);
    }
    public void update(){
        field.repaint();
    }
    public void  completed(int level){
        update();
        JOptionPane.showMessageDialog(null, "Рівень <<" + level + ">> пройдений");
        SaveFrame saveFrame = new SaveFrame(controller);
        saveFrame.init(level);
        saveFrame.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                saveFrame.dispose();
            }
        });

    }

}
