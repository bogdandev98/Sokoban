package com.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;


public class Box extends CollisionObject implements Movable {
    private static Image image;
    static {
        try {
            image = ImageIO.read(Model.class.getResourceAsStream("res/box.jpg"));
        }catch (IOException e){
            System.out.print("blat");
        }
    }
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.orange);
//        graphics.drawRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
//        graphics.fillRect(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
        graphics.drawImage( image, getX()-getWidth()/2, getY()-getHeight()/2, null);
    }

    @Override
    public void move(Direction direction) {
//        setX(getX()+x);
//        setY(getY()+y);
        if(direction.equals(Direction.DOWN)){
            setY(getY()+Model.FIELD_SELL_SIZE);
        }else if(direction.equals(Direction.UP)){
            setY(getY()-Model.FIELD_SELL_SIZE);
        }else if(direction.equals(Direction.LEFT)){
            setX(getX()-Model.FIELD_SELL_SIZE);
        }else if(direction.equals(Direction.RIGHT)){
            setX(getX()+Model.FIELD_SELL_SIZE);
        }
    }
}
