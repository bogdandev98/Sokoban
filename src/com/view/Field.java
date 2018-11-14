package com.view;

import com.controller.EventListener;
import com.model.Direction;
import com.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel {
    private View view;
    private Direction direction;
    private EventListener eventListener;
    public Field(View view){
        this.view=view;
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        setFocusable(true);
    }

    public void paint(Graphics g){
        g.setColor(new Color(0x194894));
        g.fillRect(0,0,500,500);
      for (GameObject gameObject: view.getGameObjects().getAll()){
            gameObject.draw(g);
        }
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
    public class KeyHandler extends KeyAdapter{
        private RestartFrame restartFrame;
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getExtendedKeyCode()==KeyEvent.VK_LEFT){
                eventListener.move(Direction.LEFT);
                direction=Direction.LEFT;
            }
            if(e.getExtendedKeyCode()==KeyEvent.VK_RIGHT){
                eventListener.move(Direction.RIGHT);
                direction=Direction.RIGHT;
            }
            if(e.getExtendedKeyCode()==KeyEvent.VK_DOWN){
                eventListener.move(Direction.DOWN);
                direction=Direction.DOWN;
            }
            if(e.getExtendedKeyCode()==KeyEvent.VK_UP){
                eventListener.move(Direction.UP);
                direction=Direction.UP;
            }
            if(e.getExtendedKeyCode()==KeyEvent.VK_R){
                eventListener.restart();
            }
//            if(e.getExtendedKeyCode()==KeyEvent.VK_C){
//                view.completed(0);
//            }
        }
    }
}
