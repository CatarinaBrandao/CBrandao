package org.academiadecodigo.spaceroom;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    public static Picture background;

    public Background() {
        this.background = new Picture(10,0,"/background.640x480.png");
        this.background.draw();
    }

}
