import javax.swing.JFrame;

public class Ventana extends JFrame{
    private static final long serialVersionUID = 1L;

     /*********************************
                CONSTANTES            
     *********************************/
    private static final int ANCHO = 800;
    private static final int ALTO = 500;        //La barra de arriba del todo mide 30.5px;
    /**********************************
                ATRIBUTOS
    **********************************/

    private Campo campo;
    /**********************************
                CONSTRUCTOR
    **********************************/
    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Pong by Guri");
        setSize(ANCHO, ALTO);
        campo = new Campo();
        add(campo);
    }
    /**********************************
                FUNCIONES
    **********************************/
    public static int getAncho(){
        int ancho = ANCHO;
            return ancho;
    }

    public static int getAlto(){
        int alto = ALTO;
            return alto;
    }
}