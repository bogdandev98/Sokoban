package com.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Home extends GameObject {
    private static Image image;
    static {
        try {
            image = ImageIO.read(Model.class.getResourceAsStream("res/home.jpg"));
        }catch (IOException e){
            System.out.print("blat");
        }
    }
    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.blue);
//        graphics.drawRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
//        graphics.fillRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
        graphics.drawImage( image, getX()-getWidth()/2, getY()-getHeight()/2, null);

    }


    public Home(int x, int y) {
        super(x, y);

    }
}
