package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        File games = new File("D://Проекты//JavaFiz//Game", "Games");
        createDirectory(games, stringBuilder);
        File src = new File("D://Проекты//JavaFiz//Game//Games", "src");
        createDirectory(src, stringBuilder);
        File res = new File("D://Проекты//JavaFiz//Game//Games", "res");
        createDirectory(res, stringBuilder);
        File savegames = new File("D://Проекты//JavaFiz//Game//Games", "savegames");
        createDirectory(savegames, stringBuilder);
        File temp = new File("D://Проекты//JavaFiz//Game//Games", "temp");
        createDirectory(temp, stringBuilder);
        File tempTxt = new File(temp, "temp.txt");
        createFile(tempTxt, stringBuilder);
        File main = new File(src, "main");
        createDirectory(main, stringBuilder);
        File test = new File(src, "test");
        createDirectory(test, stringBuilder);
        File mainJava = new File(main, "Main.java");
        createFile(mainJava, stringBuilder);
        File utilsJava = new File(main, "Utils.java");
        createFile(utilsJava, stringBuilder);
        File drawables = new File(res, "drawables");
        createDirectory(drawables, stringBuilder);
        File vectors = new File(res, "vectors");
        createDirectory(vectors, stringBuilder);
        File icons = new File(res, "icons");
        createDirectory(icons, stringBuilder);
        File player1 = new File(savegames, "savePlayer1.txt");
        createFile(player1, stringBuilder);
        File player2 = new File(savegames, "savePlayer2.txt");
        createFile(player2, stringBuilder);
        File player3 = new File(savegames, "savePlayer3.txt");
        createFile(player3, stringBuilder);
        try (FileWriter tempTxtWriter = new FileWriter(tempTxt)) {
            tempTxtWriter.write(stringBuilder.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        GameProgress gameProgressPlayer1 = new GameProgress(24, 2, 7, 2.35);
        GameProgress gameProgressPlayer2 = new GameProgress(72, 1, 5, 3.5);
        GameProgress gameProgressPlayer3 = new GameProgress(1, 1, 89, 7.4);
        gameProgressPlayer1.saveGame(player1, gameProgressPlayer1);
        gameProgressPlayer2.saveGame(player2, gameProgressPlayer2);
        gameProgressPlayer3.saveGame(player3, gameProgressPlayer3);
        File zipSave = new File(savegames,"zip_save.zip");
        try (ZipOutputStream zSave = new ZipOutputStream(new FileOutputStream(zipSave))){
            for (File saves : savegames.listFiles()) {
                if (saves.getName().contains(".txt")) {
                    FileInputStream savePlayerRead = new FileInputStream(saves);
                    zSave.putNextEntry(new ZipEntry(saves.getName()));
                    byte[] buffer = new byte[savePlayerRead.available()];
                    savePlayerRead.read(buffer);
                    zSave.write(buffer);
                    zSave.closeEntry();
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        for (File item : savegames.listFiles()) {
            if (item.getName().contains(".txt")) {
                item.delete();
            }
        }
    }

    public static void createDirectory(File need, StringBuilder stringBuilder) {
        if (need.mkdir()) {
            stringBuilder.append("Каталог " + need.getName() + " создан\n");
        }
    }

    public static void createFile(File need, StringBuilder stringBuilder) {
        try {
            if (need.createNewFile()) {
                stringBuilder.append("Файл " + need.getName() + " создан\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
