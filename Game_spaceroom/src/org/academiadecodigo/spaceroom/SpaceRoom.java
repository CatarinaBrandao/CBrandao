package org.academiadecodigo.spaceroom;

import Sound.Sound;
import org.academiadecodigo.spaceroom.menus.StartMenu;

/**
 * our main
 */

public class SpaceRoom {

    public static void main(String[] args) throws InterruptedException {

      Sound music = new Sound();
      music.setBackgroundSound();
      music.play();
      music.playBackgroundSound();
      music.stopBackground();
      StartMenu menuStart = new StartMenu();
      menuStart.show();

      menuStart.waitForEnterKey();

        if (menuStart.startGame()) {
            Game game = new Game();
            game.start();
        }
    }
}
