package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        File games = new File("D://Проекты//JavaFiz//Game", "Games");
        File src = new File("D://Проекты//JavaFiz//Game//Games", "src");
        File res = new File("D://Проекты//JavaFiz//Game//Games", "res");
        File savegames = new File("D://Проекты//JavaFiz//Game//Games", "savegames");
        File temp = new File("D://Проекты//JavaFiz//Game//Games", "temp");
        File tempTxt = new File(temp, "temp.txt");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File player1 = new File(savegames, "savePlayer1.txt");
        File player2 = new File(savegames, "savePlayer2.txt");
        File player3 = new File(savegames, "savePlayer3.txt");
        List<File> directory = Arrays.asList(games,src,res,savegames,temp,main,test,drawables,vectors,icons);
        for (File dir : directory){
            if (dir.mkdir()) {
                stringBuilder.append("Каталог " + dir.getName() + " создан\n");
            }
        }
        List<File> files = Arrays.asList(tempTxt,mainJava,utilsJava,player1,player2,player3);
        for (File file : files){
            try {
                if (file.createNewFile()) {
                    stringBuilder.append("Файл " + file.getName() + " создан\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

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
                    savePlayerRead.close();
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
}
