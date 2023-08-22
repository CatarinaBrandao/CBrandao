package org.academiadecodigo.spaceroom;

import Sound.Sound;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.spaceroom.menus.GameOverMenu;
import org.academiadecodigo.spaceroom.menus.StartMenu;


public class Obstacles {


    public Picture[] obstacles = new Picture[12];
    Bullet bullet = new Bullet();
    public Picture test ;


    public Obstacles() throws InterruptedException {

        for (int i = 0; i < obstacles.length; i++) {
            //the position needs to be random on the x-axis so the asteroid is first created outside the grid

            obstacles[i] = new Picture((10 + (int)(Math.random() * (Background.background.getWidth()-45))), -Math.ceil(Math.random() * 1500), "/asteroid.45x45.png");
            obstacles[i].draw();
            System.out.println("An asteroid is comming...");
            System.out.println(obstacles[i].getX());
            System.out.println(obstacles[i].getY());

        }
        moveObstacle();



}
        public void moveObstacle() throws InterruptedException {

            for (int i = 0; i < obstacles.length; i++) {

               if (iscrashed(obstacles[i])){
                    gameOver();
                    break;
                }

                obstacles[i].translate(0, 30);
                System.out.println("Position "+ obstacles[i].getY());
                verifyPosition(obstacles[i]);
                if (iscrashed(obstacles[i])){
                    Thread.sleep(1350);
                    gameOver();
                    break;
                }

                //isShooted(obstacles[i]);
            }

            Thread.sleep(100);
            moveObstacle();

        }
        //}

        public void gameOver() throws InterruptedException {

            Background.background.delete();
            Player.player.delete();
            GameOverMenu menuGameOver = new GameOverMenu();
            menuGameOver.show();

            menuGameOver.waitForEnterKey();

            if (menuGameOver.gameOver()) {

                StartMenu menuStart = new StartMenu();
                menuStart.show();
                menuStart.waitForEnterKey();

                if (menuStart.startGame()) {
                    Player.player.load("/player.50x50.png");
                    Game game = new Game();
                    game.start();

                }

            }
        }

        public boolean verifyPosition(Picture obstacles) {
            if (obstacles.getY() >= Player.player.getY()){

                obstacles.translate(0,-680);
            }
            return true;
        }

        public boolean iscrashed(Picture obstacle){
            System.out.println("Posição do Player no X "+Player.player.getY()+"Posição do Player no X + Heigth "+Player.player.getY()+Player.player.getHeight());
            System.out.println("Posição do Obstaculo no X "+obstacle.getY()+"Posição do Obstaculo no X + Heigth "+obstacle.getY()+obstacle.getHeight());
            //if (obstacle.getMaxX() >= Player.player.getX() && obstacle.getMaxY() >= Player.player.getY()){
            if ((Player.player.getX() >= obstacle.getX()-30) && (Player.player.getX() <= obstacle.getX()+30)){
                if(Player.player.getY() <= obstacle.getY() + obstacle.getHeight()) {
                    Sound music = new Sound();
                    music.setCrashSound();
                    music.playCrashSound();
                    music.stopCrashSound();
                    Player.player.load("/collision.100x86.png");
                    return true;
                }
            }
            return false;
        }
       public boolean isShooted(Picture obstacle){

           System.out.println("==================================");
            if (bullet.getBullet().getX() >= obstacle.getX() && bullet.getBullet().getX() <= obstacle.getX() + obstacle.getWidth()){
                System.out.println("THERE");
                if(bullet.getBullet().getY() <= obstacle.getY()+ obstacle.getHeight()) {
                    System.out.println("HERE");
                    obstacle.translate(-1000, -900000);

                    return true;
                }
            }
            return false;
        }

}
