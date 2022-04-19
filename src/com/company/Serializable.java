package com.company;

import java.io.File;

public interface Serializable {
    String toString();

    void saveGame(File savePlayer, GameProgress player);
}