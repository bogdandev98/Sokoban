package com.controller;

import com.model.Direction;
import java.io.IOException;

public interface EventListener  {
    void move(Direction direction);
    void restart();
    void startNextLevel();
    void levelCompleted(int level);
    //void save() throws  IOException;
    //void restartGame();


}
