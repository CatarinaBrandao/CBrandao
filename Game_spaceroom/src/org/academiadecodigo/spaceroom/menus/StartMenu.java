package org.academiadecodigo.spaceroom.menus;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu implements KeyboardHandler {


        private boolean startGame;
        private boolean keyPressed;
        private Picture menuBackground;
        private Picture menuWelcome;
        private Picture startButton;
        private Picture menuInstructions;


    public StartMenu(){
            startGame=false;
            keyPressed=false;

            menuBackground = new Picture(10, 10,"/menuBackground.png");

            menuWelcome = new Picture(menuBackground.getWidth() / 2 - (200) + 10, 200, "/welcome.400.png");

            startButton = new Picture(menuBackground.getWidth() / 2 - (140) + 10, menuBackground.getHeight() / 2, "/start-button280x104.png");

            menuInstructions = new Picture(menuBackground.getWidth() / 2 - (150) + 10, 500,"/menuInstructions.300x35.png");


            Keyboard keyboard= new Keyboard(this);
            spaceKey(keyboard);

        }

        public void show(){
            menuBackground.draw();
            menuWelcome.draw();
            startButton.draw();
            menuInstructions.draw();

        }
        public boolean startGame(){
            return startGame;
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
                startGame=true;
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


