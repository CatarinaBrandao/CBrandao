package org.academiadecodigo.spaceroom.menus;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOverMenu implements KeyboardHandler {

    private boolean gameOver;
    private boolean keyPressed;
    private Picture menuBackground;
    private Picture restartButton;
    private Picture exitButton;
    private Picture restartInstructions;
    private static final int PADDING = 10;


    public GameOverMenu(){
        gameOver=false;
        keyPressed=false;

        menuBackground = new Picture(10, 0,"/menuBackground.png");
        restartButton = new Picture(menuBackground.getWidth() / 2 - (175) + PADDING, 200, "/restart.350x98.png");
        exitButton = new Picture(menuBackground.getWidth() / 2 - (140) + PADDING, menuBackground.getHeight() / 2,"/exitbutton.280x104.png");
        restartInstructions = new Picture(menuBackground.getWidth() / 2 - (150) + PADDING, 550,"/restartInstructions.300.png");

        Keyboard keyboard= new Keyboard((KeyboardHandler) this);
        spaceKey(keyboard);

    }

    public void show(){
        menuBackground.draw();
        restartButton.draw();
        exitButton.draw();
        restartInstructions.draw();


    }
    public boolean gameOver(){
        return gameOver;
    }

    private void spaceKey(Keyboard keyboard){
        KeyboardEvent event= new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_ENTER);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyCode = keyboardEvent.getKey();
        if(keyCode==KeyboardEvent.KEY_ENTER){
            gameOver=true;
            keyPressed=true;
            menuBackground.delete();

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void waitForEnterKey(){

        while(!keyPressed){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
