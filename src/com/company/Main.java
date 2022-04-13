package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder stringBuilder = new StringBuilder();
        File games = new File("Games");
        File src = new File("D://Проекты//JavaFiz//Game//Games", "src");
        File res = new File("D://Проекты//JavaFiz//Game//Games", "res");
        File savegames = new File("D://Проекты//JavaFiz//Game//Games", "savegames");
        File temp = new File("D://Проекты//JavaFiz//Game//Games", "temp");
        File tempTxt = new File(temp,"temp.txt");
        File main = new File(src,"main");
        File test = new File(src,"test");
        File mainJava = new File(main,"Main.java");
        File utilsJava = new File(main,"Utils.java");
        File drawables = new File(res,"drawables");
        File vectors = new File(res,"vectors");
        File icons = new File(res,"icons");
        if (src.mkdir()){
            stringBuilder.append("Каталог "+ src.getName() +" создан\n");
        }
        if (res.mkdir()){
            stringBuilder.append("Каталог "+ res.getName() +" создан\n");
        }
        if (savegames.mkdir()){
            stringBuilder.append("Каталог "+ savegames.getName() +" создан\n");
        }
        if (temp.mkdir()){
            stringBuilder.append("Каталог "+ temp.getName() +" создан\n");
        }
        if (main.mkdir()){
            stringBuilder.append("Каталог "+ main.getName() +" создан\n");
        }
        if (test.mkdir()){
            stringBuilder.append("Каталог "+ test.getName() +" создан\n");
        }
        if (drawables.mkdir()){
            stringBuilder.append("Каталог "+ drawables.getName() +" создан\n");
        }
        if (vectors.mkdir()){
            stringBuilder.append("Каталог "+ vectors.getName() +" создан\n");
        }
        if (icons.mkdir()){
            stringBuilder.append("Каталог "+ icons.getName() +" создан\n");
        }
        try {
            if (mainJava.createNewFile()){
                stringBuilder.append("Файл "+ mainJava.getName() +" создан\n");
            }
            if (utilsJava.createNewFile()){
                stringBuilder.append("Файл "+utilsJava.getName() +" создан\n");
            }
            if (tempTxt.createNewFile()){
                stringBuilder.append("Файл "+ tempTxt.getName() +" создан\n");
            }
		} catch (IOException ex){
			System.out.println(ex.getMessage());
		}
        String sb = stringBuilder.toString();
        try (FileOutputStream tempTxtWriter = new FileOutputStream(tempTxt)){
            byte[] bytes = sb.getBytes();
                tempTxtWriter.write(bytes,0, bytes.length);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    }
