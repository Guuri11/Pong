import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Campo extends JPanel implements ActionListener, KeyListener {

    private static final long serialVersionUID = 1L;
    /**********************************
     * ATRIBUTOS
     **********************************/
    private static Graphics halfCourt; // Linea de medio campo
    private Timer t = new Timer(5, this);

    // Instanciar Pelota
    private static Pelota pelota = new Pelota(391, 228);

    // Atributos jugador 1
    public static Players jugador1 = new Players(10, 220);
    private static int play1X = 10;
    private static int play1Y = 220;
    private static boolean w = false; // estado de la tecla W (false = no pulsada)
    private static boolean s = false; // estado de la tecla S (false = no pulsada)

    // Atributos jugador 2
    public static Players jugador2 = new Players(775, 220);
    private static int play2X = 775;
    private static int play2Y = 220;
    private static boolean up = false; // estado de la tecla VK_UP (false = no pulsada)
    private static boolean down = false; // estado de la tecla VK_DOWN (false = no pulsada)

    /**********************************
     * CONSTRUCTOR
     **********************************/
    public Campo() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setBackground(Color.BLACK);
    }

    /**********************************
     * FUNCIONES
     **********************************/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // CREAR LINEA MEDIO CAMPO//
        halfCourt = g;
        halfCourt.setColor(Color.WHITE);
        halfCourt.fillRect(400, 0, 3, 471);

        // CREAR PELOTA//
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fill(pelota.dibujarPelota());

        // CREAR JUGADORES//
        g2.setColor(Color.WHITE);
        g2.fill(jugador1.dibujarJugadores());
        repaint();

        g2.setColor(Color.WHITE);
        g2.fill(jugador2.dibujarJugadores());
        repaint();

    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        // FISICAS DE LA PELOTA
        Pelota.actualizar(play1X, play2X, play1Y, play2Y);

        if (pelota.getX() <= jugador1.getX() + 10) {
            if (pelota.getY() >= jugador1.getY() && pelota.getY() <= jugador1.getY() + 60) {
                pelota.setX(25);
                pelota.setBallVelX(pelota.getBallVelX());
                pelota.controlarVelocidad(0.05);
            }
        }

        if (pelota.getX() >= jugador2.getX() - 20) {
            if (pelota.getY() >= jugador2.getY() && pelota.getY() <= jugador2.getY() + 60) {
                pelota.setX(750);
                pelota.setBallVelX(pelota.getBallVelX());
                pelota.controlarVelocidad(0.01);
            }
        }

        // Estado jugador 1
        if (w == true && jugador1.getY() >= 1)
            jugador1.setY(-3);
        if (s == true && jugador1.getY() <= 410)
            jugador1.setY(3);

        // Estado jugador 2
        if (up == true && jugador2.getY() >= 1)
            jugador2.setY(-3);
        if (down == true && jugador2.getY() <= 410)
            jugador2.setY(3);

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            w = true;
        }
        if (code == KeyEvent.VK_S) {
            s = true;
        }

        if (code == KeyEvent.VK_UP) {
            up = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            down = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            w = false;
        }
        if (code == KeyEvent.VK_S) {
            s = false;
        }

        if (code == KeyEvent.VK_UP) {
            up = false;
        }
        if (code == KeyEvent.VK_DOWN) {
            down = false;
        }
    }

}