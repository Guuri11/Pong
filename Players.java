import java.awt.geom.Rectangle2D;

public class Players{

    /**********************************
                 ATRIBUTOS
    **********************************/
    private int x, y;
    private static final int ANCHO = 10;
    private static final int ALTO = 60;

    /**********************************
                CONSTRUCTOR
    **********************************/
    public Players(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**********************************
                FUNCIONES
    **********************************/
    public Rectangle2D dibujarJugadores(){
        return new Rectangle2D.Double(x,y,ANCHO,ALTO);
    }

    public int getX(){
        int x = this.x;
        return x;
    }

    public int getY(){
        int y = this.y;
        return y;
    }

    public void setY(int y){
        this.y += y;
    }

}