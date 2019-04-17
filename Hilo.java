import com.sun.istack.internal.logging.Logger;

public class Hilo extends Thread{
    TableroJuego tablero;
    public Hilo(TableroJuego tablero){
        this.tablero=tablero;
    }

    public void run(){
        while(true){
            try {
                Thread.sleep(6);
            } catch (Exception e) {
                //TODO: handle exception
            }
            
            tablero.repaint();
        }

    }
}