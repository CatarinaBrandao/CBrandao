import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Background background = new Background(10,10,500,500, player);
        player.setBackground(background);

    }
}
