package com.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Wall extends GameObject {
    private static Image image;
    static {
        try {
            image = ImageIO.read(Model.class.getResourceAsStream("res/wall.jpg"));
        }catch (IOException e){
            System.out.print("blat");
        }
    }
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.black);
//        graphics.drawOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
//        graphics.fillOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
          graphics.drawImage( image, getX()-getWidth()/2, getY()-getHeight()/2, null);

    }


}
