package org.academiadecodigo.spaceroom;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements KeyboardHandler {

    public static Picture player = new Picture(200, 540, "/player.50x50.png");
    public static Rectangle shoot = new Rectangle(player.getY(), player.getY(),10,5);

    public Player() {
        player.draw();

    }

    public void playerMove() throws InterruptedException {
        keyboardInit();

    }

    public void keyboardInit() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent enterPress = new KeyboardEvent();
        enterPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        enterPress.setKey(KeyboardEvent.KEY_SPACE);

        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(enterPress);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (player.getMaxX() < (Background.background.getMaxX()) - 10) {
                    System.out.println("moving right");
                    player.translate(15, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (player.getX() > 20) {
                    System.out.println("moving left");
                    player.translate(-15, 0);
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                try {
                    shootBullet();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void shootBullet() throws InterruptedException {
        Bullet bullet = new Bullet();
        new Thread(bullet::fire).start();
        System.out.println("PEW PEW");
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}



}