package com.model;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LevelLoader {
    String levels;
    public LevelLoader(String levels) {
        this.levels=levels;
    }

    public GameObjects getLevel(int level) {
//        try {
//            File file= new File(levels.toString());
//            InputStreamReader input = new InputStreamReader(new FileInputStream(file));
//        }catch (FileNotFoundException e){
//
//        }
        int currentLevel = (level % 60 == 0) ? 60 : level % 60;
        String stringLevel = "Maze: " + currentLevel;
        List<String> levelInfo = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(Model.class.getResourceAsStream(levels)))) {
            String line = "";
            while (!line.equals(stringLevel)) { line = reader.readLine(); }
            for (int i = 0; i < 7; i++) { line = reader.readLine(); }
            while (!"".equals(line)) {
                levelInfo.add(line);
                line = reader.readLine();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("blat");
        }
        Set<Box> boxes = new HashSet<>();
        Set<Wall> walls = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;
        for (int i = 0; i < levelInfo.size(); i++) {
            String wight = levelInfo.get(i);
            for (int j = 0; j < wight.length(); j++) {
                int x = (j == 0) ? Model.FIELD_SELL_SIZE / 2 : (Model.FIELD_SELL_SIZE / 2) + j * Model.FIELD_SELL_SIZE;
                int y = (i == 0) ? Model.FIELD_SELL_SIZE / 2 : (Model.FIELD_SELL_SIZE / 2) + i * Model.FIELD_SELL_SIZE;
                char symbol = wight.charAt(j);
                switch (symbol) {
                    case 'X' :
                        walls.add(new Wall(x, y));
                        break;
                    case '*' :
                        boxes.add(new Box(x, y));
                        break;
                    case '.' :
                        homes.add(new Home(x, y));
                        break;
                    case '&' :
                        boxes.add(new Box(x, y));
                        homes.add(new Home(x, y));
                        break;
                    case '@' :
                        player = new Player(x, y);
                        break;
                }
            }
        }
        return new GameObjects( walls, boxes, homes, player);
    }

}

