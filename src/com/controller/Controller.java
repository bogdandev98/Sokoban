package com.controller;

import com.model.Direction;
import com.model.GameObjects;
import com.model.Model;
import com.view.RestartFrame;
import com.view.View;

import java.io.*;
import java.net.URLDecoder;


public class Controller implements EventListener {
    private View view;
    private Model model;
    public Controller() {
        model= new Model(loadNumberLevel());
        model.restart();
        model.setEventListener(this);
        view= new View(this);
        view.init();
        view.setEventListener(this);
    }

    public static void main(String[] args) {

        Controller controller=new Controller();

    }

    public GameObjects getGameObjects(){
        return model.getGameObjects();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }


    public void restartLevel() {
        model.restart();
        view.update();
    }


    public void restartGame() {
        model.setCurrentLevel(1);
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    //@Override
    public void save() throws IOException{

//        String[] strings = Controller.class.getPackage().toString().split(" ");
//        String path = strings[1].replace(".","/");
//        System.out.print(URLDecoder.decode(Controller.class
//                .getProtectionDomain()
//                .getCodeSource()
//                .getLocation()
//                .toString()));
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("/save.txt"))));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(URLDecoder.decode(Controller.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"save.txt", "UTF-8")))));
        writer.write("Level: "+(model.getCurrentLevel()+1));
        writer.close();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);

    }

    public int loadNumberLevel(){
        try {
            //BufferedReader reader = new BufferedReader(new InputStreamReader(Controller.class.getResourceAsStream("save.txt")));
            BufferedReader reader = new BufferedReader(new InputStreamReader( new FileInputStream(URLDecoder.decode(Controller.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"save.txt","UTF-8"))));
            String[] strings = reader.readLine().split(" ");
            return Integer.parseInt(strings[1]);
        }catch (Exception e){
            return 1;
        }
    }

    public void restart(){
        RestartFrame restartFrame = new RestartFrame(this);
        restartFrame.init();
    }

}
