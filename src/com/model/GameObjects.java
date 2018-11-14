package com.model;

import java.util.*;

public class GameObjects {
        private Set<Wall> walls;
    private Set<Box> boxes;
    private Set<Home> homes;
    private Set<FullHome> fullHomes;
        private Player player;

    public GameObjects( Set<Wall> walls, Set<Box> boxes, Set<Home> homes, Player player) {
        this.walls = walls;
        this.boxes = boxes;
        this.homes = homes;
        this.player = player;
        fullHomes = new HashSet<FullHome>();
    }

    public Set<FullHome> getFullHomes() {
        return fullHomes;
    }

    public void addFullHomes(FullHome fullHome) {
        fullHomes.add(fullHome);
    }

    public List<GameObject> getAll(){
        List<GameObject> gameObjectSet= new ArrayList<GameObject>();
        gameObjectSet.addAll(walls);
        gameObjectSet.addAll(boxes);
        gameObjectSet.addAll(homes);
        gameObjectSet.add(player);
        if(!fullHomes.isEmpty())
            gameObjectSet.addAll(fullHomes);
        return gameObjectSet;
    }
    public Set<Wall> getWalls() {
        return walls;
    }

    public void setWalls(Set<Wall> walls) {
        this.walls = walls;
    }

    public Set<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(Set<Box> boxes) {
        this.boxes = boxes;
    }

    public Set<Home> getHomes() {
        return homes;
    }

    public void setHomes(Set<Home> homes) {
        this.homes = homes;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
