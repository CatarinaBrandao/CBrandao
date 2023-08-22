package org.academiadecodigo.spaceroom;

public class Game {
    private Background background;
    private Player player;



    public void start() throws InterruptedException {

        Background background1 = new Background();
        Player player1 = new Player();
        player1.player.draw();
        player1.playerMove();

        Obstacles obstacle = new Obstacles();
        obstacle.moveObstacle();


        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
