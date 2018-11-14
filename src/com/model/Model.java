package com.model;

import com.controller.EventListener;

import java.nio.file.Paths;

public class Model {
    private EventListener eventListener;
    private GameObjects gameObjects;
    private LevelLoader levelLoader = new LevelLoader("res/levels.txt");
    private int currentLevel;

    public Model(int level) {
        currentLevel = level;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public static final int FIELD_SELL_SIZE=20;

    public GameObjects getGameObjects(){
        return gameObjects;
    }

    public void move(Direction direction){
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollision(direction))
            return;
        player.move(direction);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction){
        for (GameObject gameObject1 : gameObjects.getWalls()) {
            if (gameObject.isCollision(gameObject1, direction))
                return true;
        }
        return false;
    }
    public boolean checkBoxCollision(Direction direction){
        for (Box box: gameObjects.getBoxes()){
            if (gameObjects.getPlayer().isCollision(box, direction)){
                if(checkWallCollision(box, direction))
                    return true;
                for (Box box1: gameObjects.getBoxes()){
                    if (box.isCollision(box1, direction))
                        return true;
                }
                box.move(direction);
            }
        }
        return false;
    }

    public void checkCompletion(){
        boolean flag1;
        boolean flag2=true;
        gameObjects.getFullHomes().removeAll(gameObjects.getFullHomes());
        for (Box box : gameObjects.getBoxes()){
            flag1=false;
            for (Home home : gameObjects.getHomes()) {
                if (box.getX()==home.getX() && box.getY()==home.getY()) {
                    FullHome fullHome= new FullHome(home.getX(), home.getY());
                    gameObjects.addFullHomes(fullHome);
                    flag1 = true;
                    break;
                }
            }
            if (!flag1){
                flag2=false;
            }
        }
        if (flag2) {
            eventListener.levelCompleted(currentLevel);
        }
    }

    private void restartLevel(int level){
        gameObjects= levelLoader.getLevel(level);
    }
    public void restart(){
        restartLevel(currentLevel);
    }
    public void startNextLevel(){
        currentLevel+=1;
        restartLevel(currentLevel);
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }
}
