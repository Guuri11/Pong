import javax.swing.JOptionPane;

public class Score {

    /**********************************
     * ATRIBUTOS
     **********************************/
    private static int anotacionJugador1 = 0;
    private static int anotacionJugador2 = 0;

    /**********************************
     * FUNCIONES
     **********************************/
    public static void goalJugador1() {
        anotacionJugador1++;
        comprobarVictoria();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("x");
        }
    }

    public static void goalJugador2() {
        anotacionJugador2++;
        comprobarVictoria();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("x");
        }
    }

    public static void comprobarVictoria() {
        if (anotacionJugador1 == 10) {
            int a = JOptionPane.showConfirmDialog(null, "Revancha?", "Ha ganado el jugador 1!", JOptionPane.YES_NO_OPTION);
            if(a==JOptionPane.NO_OPTION){  
                System.exit(0);
            }else{
                anotacionJugador1 = 0;
            }
            
        }

        if (anotacionJugador2 == 10) {
            int a = JOptionPane.showConfirmDialog(null, "Revancha?", "Ha ganado el jugador 2!", JOptionPane.YES_NO_OPTION);
            if(a==JOptionPane.NO_OPTION){  
                System.exit(0);
            }else{
                anotacionJugador2 = 0;
            }
        }
        
    }

}