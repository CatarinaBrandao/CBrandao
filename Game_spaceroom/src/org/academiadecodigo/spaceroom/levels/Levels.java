package org.academiadecodigo.spaceroom.levels;

public enum Levels {

    LEVEL1(50),
    LEVEL2(100),
    LEVEL3(150);

    private final int speed;

    Levels(int speed) {
        this.speed = speed;
    }
}
