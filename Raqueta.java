import java.awt.geom.Rectangle2D;

public class Raqueta{
    private static int x, y;
    private static final int ANCHO = 10;
    private static final int ALTO = 40;

    public Raqueta(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getRaqueta(){
        return new Rectangle2D.Double(x,y,ANCHO,ALTO);
    }
}