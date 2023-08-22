package org.academiadecodigo.spaceroom;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class Bullet {
    private static final int BULLET_SPEED = 10;
    public  Rectangle bullet;



    public Bullet() throws InterruptedException {
        bullet = new Rectangle(Player.player.getX(), Player.player.getY(), 10, 5);
        // bullet = new Rectangle(x, y, 5, 10);
        bullet.setColor(Color.RED);
        System.out.println("here");

    }

    public void fire() {
        while (bullet.getY() > 0) {
            bullet.fill();
            bullet.translate(0, -BULLET_SPEED);
            System.out.println(bullet.getY());
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        bullet.delete();
    }

    public Rectangle getBullet() {
        return bullet;
    }



}
