import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Background {
    Rectangle background;
    Player player;
    private int xi;
    private int yi;
    private int xf;
    private int yf;

    public Background(int xi, int yi, int xf, int yf, Player player) {
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.player = player;

        background = new Rectangle(xi,yi,xf,yf);
        background.draw();

        int x = xi + 25;
        int y= yi + 25;

        for (int i = 0; (i < 20); i++) {

            Line linesx = new Line(x,10,x,510);
            Line linesy = new Line(10,y,510,y);
            linesx.draw();
            linesy.draw();

            x = x + 25;
            y = y + 25;

        }

    }


    public int getXf() {
        return xf;
    }

    public int getYf() {
        return yf;
    }

}
