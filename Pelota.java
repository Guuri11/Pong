import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Pelota{
    /**********************************
                ATRIBUTOS
    **********************************/
    private static int x,y;
    private static final int ANCHO = 20;
    private static final int ALTO = 20;
    private static double BallVelX = (double) direccionInicioX();//velocidad X a la que se movera la pelota
    private static double BallVelY = (double) direccionInicioX(); //velocidad Y a la que se movera la pelota
    private static int incrementarCadaTresGolpes;

    /**********************************
                CONSTRUCTOR
    **********************************/
    public Pelota(int x, int y){
        this.x=x;
        this.y=y;
    }

    /**********************************
                FUNCIONES
    **********************************/
    public Ellipse2D dibujarPelota(){
        return new Ellipse2D.Double(x,y,ANCHO,ALTO);
    }

    public int getX(){
        int x = this.x;
        return x;
    }

    public int getY(){
        int y = this.y;
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }

    public double getBallVelX(){
        double BallVelX  = this.BallVelX;
        return BallVelX;
    }

    public double getBallVelY(){
        double BallVelY  = this.BallVelY;
        return BallVelY;
    }

    public void setBallVelX(double vel){
        BallVelX = -vel;
    }

    public static int direccionInicioX(){
        Random ran = new Random(System.currentTimeMillis());
        int x = ran.nextInt(2)+1;
        if(x==1)
            x=-2;
        return x;
    }

    public void controlarVelocidad(double incremento){
        this.incrementarCadaTresGolpes++;
        if(incrementarCadaTresGolpes == 3){
            if(BallVelX < 0)
                BallVelX -= incremento;
                    else
                        BallVelX += incremento;

            if(BallVelY<0)
                BallVelY -= incremento;
                    else   
                        BallVelY += incremento;
            incrementarCadaTresGolpes = 0;
        }
        System.out.println("Velocidad x:"+BallVelX+"\nVelocidad y: "+BallVelY+"\nGolpes "+incrementarCadaTresGolpes);
    }

    public static int direccionInicioY(){
        Random ran = new Random(System.currentTimeMillis());
        int y = ran.nextInt(2)+1;
        if(y==1)
            y=-2;
        return y;
    }

    public static void actualizar(int play1X, int play2X, int play1Y, int play2Y){
        if(x<=0){
            x = 391;
            y= 228;
            BallVelX = 2;
            BallVelY = -2;
            Score.goalJugador2();
        }
            else if(x>=780){
                x = 391;
                y = 228;
                BallVelX = -2;
                BallVelY = 2;
                Score.goalJugador1();
                
            }

        if(y <0 || y >450){     //si la pelota toca el techo o el suelo que rebote
            BallVelY = -BallVelY;
        }
        x += BallVelX;          //Actualizar la posicion de la pelota
        y += BallVelY;
    }

}