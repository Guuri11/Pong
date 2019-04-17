import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class TableroJuego extends JPanel{
    Pelota pelota = new Pelota(0, 0);
    Raqueta r1 = new Raqueta(10,200);
    Raqueta r2 = new Raqueta(774,200);

    public TableroJuego(){
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            dibujar(g2);
            actualizar();
    }

    public void dibujar(Graphics2D g){
        g.fill(pelota.getPelota());
    }

    public void actualizar(){
        pelota.mover(getBounds());
    }

    public void iterarJuego(){
        while(true){
            repaint();
            try {
                Thread.sleep(6);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}