package com.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class FullHome extends GameObject {
    private static Image image;
    static {
        try {
            image = ImageIO.read(Model.class.getResourceAsStream("res/fullhome.jpg"));
        }catch (IOException e){
            System.out.print("blat");
        }
    }
    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.green);
//        graphics.drawRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
//        graphics.fillRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
        graphics.drawImage( image, getX()-getWidth()/2, getY()-getHeight()/2, null);

    }

    public FullHome(int x, int y) {
        super(x, y);
    }
}
