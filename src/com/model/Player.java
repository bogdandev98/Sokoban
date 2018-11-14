package com.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Player extends CollisionObject implements Movable  {
    private static Image imDown;
    private static Image imUp;
    private static Image imRight;
    private static Image imLeft;
    static {
        try {
            imDown = ImageIO.read(Model.class.getResourceAsStream("res/down.jpg"));
            imUp = ImageIO.read(Model.class.getResourceAsStream("res/up.jpg"));
            imLeft = ImageIO.read(Model.class.getResourceAsStream("res/left.jpg"));
            imRight = ImageIO.read(Model.class.getResourceAsStream("res/right.jpg"));
        }catch (IOException e){
            System.out.print("blat");
        }
    }
    public Player(int x, int y) {
        super(x, y);
        image=imDown;
    }
    private Image image;

    @Override
    public void move(Direction direction) {
//        setX(getX()+x);
//        setY(getY()+y);
        if(direction.equals(Direction.DOWN)){
            setY(getY()+Model.FIELD_SELL_SIZE);
            image = imDown;
        }else if(direction.equals(Direction.UP)){
            setY(getY()-Model.FIELD_SELL_SIZE);
            image = imUp;
        }else if(direction.equals(Direction.LEFT)){
            setX(getX()-Model.FIELD_SELL_SIZE);
            image = imLeft;
        }else if(direction.equals(Direction.RIGHT)){
            setX(getX()+Model.FIELD_SELL_SIZE);
            image = imRight;
        }
    }

    @Override
    public void draw(Graphics graphics) {
//        graphics.setColor(Color.red);
//        graphics.drawOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
//        graphics.fillOval(getX()-getWidth()/2, getY()-getHeight()/2, getWidth(), getHeight());
//
            graphics.drawImage( image, getX()-getWidth()/2, getY()-getHeight()/2, null);

    }
}
