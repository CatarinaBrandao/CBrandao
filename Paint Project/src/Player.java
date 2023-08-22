import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import java.io.*;
import java.util.ArrayList;

public class Player implements KeyboardHandler {

    private Rectangle player;

    private Background background;

    private ArrayList<Rectangle> list = new ArrayList<>();

    public Player()  {
        player = new Rectangle(10,10,25,25);
        player.setColor(Color.PINK);
        player.fill();
        keyboardInit();
    }

   public void print(){

        Rectangle rectanglep = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getWidth());
        rectanglep.setColor(Color.BLACK);
        rectanglep.draw();
        rectanglep.fill();

        list.add(rectanglep);
        System.out.println("add" + list);

        player.delete();
        player.fill();

   }

   public void clean (){

        for (int i = 0; i < list.size(); i++) {

           if (player.getX() == list.get(i).getX() && player.getY() == list.get(i).getY()) {

               list.get(i).delete();
               list.remove(list.get(i));
           }
       }
       System.out.println("remove" + list);
   }

   public void save(){

       String string = "";

       for (int i = 0; i < list.size(); i++){
           string += list.get(i).getX() + ":" + list.get(i).getY() + " ";

       }
       try {

           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("resources/catarina.txt"));
           bufferedWriter.write(string);

           //ensure all data in bufferedWriter is saved immediately
           //wild coment apears
           bufferedWriter.flush();
           bufferedWriter.close();

       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }

   public void load(){

     for (int i = 0; i < list.size(); i++) {
           list.get(i).delete();
       }

       list.clear();
       try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/catarina.txt"));
           String line;

           while ((line = bufferedReader.readLine()) != null) {
               String[] positions = line.split(" ");
               for (String position : positions) {
                   String[] coordinates = position.split(":");

                   //convert string into int
                   //another one
                   int x = Integer.parseInt(coordinates[0]);
                   int y = Integer.parseInt(coordinates[1]);

                   Rectangle rectanglep = new Rectangle(x, y, player.getWidth(), player.getHeight());
                   rectanglep.setColor(Color.BLACK);
                   rectanglep.fill();

                   list.add(rectanglep);
                   System.out.println(list);

               }
           }

           bufferedReader.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }


   }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void keyboardInit(){

        Keyboard keyboard = new Keyboard(this);

        // move right
        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        // move left
        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        // move up
        KeyboardEvent upPress = new KeyboardEvent();
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPress.setKey(KeyboardEvent.KEY_UP);

        // move down
        KeyboardEvent downPress = new KeyboardEvent();
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPress.setKey(KeyboardEvent.KEY_DOWN);

        //print
        KeyboardEvent paintPress = new KeyboardEvent();
        paintPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paintPress.setKey(KeyboardEvent.KEY_P);

        //clean
        KeyboardEvent clearPress = new KeyboardEvent();
        clearPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clearPress.setKey(KeyboardEvent.KEY_C);

        //save art
        KeyboardEvent savePress = new KeyboardEvent();
        savePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        savePress.setKey(KeyboardEvent.KEY_S);

        //load art saved
        KeyboardEvent loadPress = new KeyboardEvent();
        loadPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        loadPress.setKey(KeyboardEvent.KEY_L);


        keyboard.addEventListener(rightPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(upPress);
        keyboard.addEventListener(downPress);
        keyboard.addEventListener(paintPress);
        keyboard.addEventListener(clearPress);
        keyboard.addEventListener(savePress);
        keyboard.addEventListener(loadPress);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:

                if ((player.getX() + player.getWidth()) < background.getXf()) {
                    player.translate(25, 0);
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (player.getX() > 10) {
                    player.translate(-25, 0);
                }
                break;

            case KeyboardEvent.KEY_UP:
                if (player.getY() > 10) {
                    player.translate(0, -25);
                }
                break;

            case KeyboardEvent.KEY_DOWN:

                if ((player.getY() + player.getHeight()) < background.getYf()) {
                    player.translate(0, 25);
                }
                break;

            case KeyboardEvent.KEY_P:

                print();

                break;


            case KeyboardEvent.KEY_C:

                clean();

                break;


            case KeyboardEvent.KEY_S:

                save();

                break;


            case KeyboardEvent.KEY_L:

                load();

                break;


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        }


}
