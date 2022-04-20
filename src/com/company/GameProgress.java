package com.company;

import java.io.*;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(File savePlayer, GameProgress player) {
        try (FileOutputStream savePlayerWrite = new FileOutputStream(savePlayer)) {
            byte[] bytes = player.toString().getBytes();
            savePlayerWrite.write(bytes, 0, bytes.length);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}