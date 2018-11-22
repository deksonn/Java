
package Igra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Deksonn
 */
public class Igra extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int rezultat = 0;
    private int ukupnoCigli = 20;
    private Timer timer;
    private int brzina = 2;
    private int igrac = 250;
    private int lopticaX = 200; 
    private int lopticaY = 300; 
    private int lopticaXsmer = 1;
    private int lopticaYsmer = -2;
    private Cigle zid;

    public Igra() {
        zid = new Cigle(4, 5);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(brzina, this);
        timer.start();

    }

    public void paint(Graphics g) {
        //pozadina
        g.setColor(Color.DARK_GRAY);
        g.fillRect(1, 1, 692, 592);

        //crtanje zida(cigli)
        zid.draw((Graphics2D) g);

        //borderi
       g.setColor(Color.white);
       g.fillRect(0, 0, 3, 592);
       g.fillRect(0, 0, 692, 3);
       g.fillRect(692, 0, 3, 592);
       
        //rezultat
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("Score:" + rezultat, 550, 30);

        //podloga
        g.setColor(Color.white);
        g.fillRect(igrac, 550, 100, 10);

        //loptica
        g.setColor(Color.white);
        g.fillOval(lopticaX, lopticaY, 20, 20);

        //kraj igre - pobeda
        if (ukupnoCigli == 0) {
            play = false;
            lopticaXsmer = 0;
            lopticaYsmer = 0;
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Pobedili ste! Čestitamo! Vaš rezultat je:" + rezultat, 110, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Pritisnite Enter da biste započeli novu igru ", 230, 350);

        }
        //kraj igre - poraz
        if (lopticaY > 570) {
            play = false;
            lopticaXsmer = 0;
            lopticaYsmer = 0;
            g.setColor(Color.white);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Kraj igre! Vaš rezultat je: " + rezultat, 190, 300);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("Kliknite Enter za novu igru ", 190, 350);

        }

        g.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    //pomeranje u desnu i levu stranu i restart na Enter dugme
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            if (igrac >= 600) {
                igrac = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (igrac < 10) {
                igrac = 10;
            } else {
                moveLeft();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                play = true;
                lopticaX = 120;
                lopticaY = 350;
                lopticaXsmer = -1;
                lopticaYsmer = -2;
                igrac = 310;
                rezultat = 0;
                ukupnoCigli = 20;
                zid = new Cigle(4, 5);
                repaint();

            }
        }
    }

    public void moveRight() {
        play = true;
        igrac += 10;
    }

    public void moveLeft() {
        play = true;
        igrac -= 10;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (play) {
            //kada loptica dodirne podlogu...
            if (new Rectangle(lopticaX, lopticaY, 20, 20).intersects(new Rectangle(igrac, 550, 100, 10))) {
                //loptica menja smer
                lopticaYsmer = -lopticaYsmer;
            }
            
            for (int i = 0; i < zid.getZid().length; i++) {
                for (int j = 0; j < zid.getZid()[0].length; j++) {
                    if (zid.getZid()[i][j] > 0) {
                        int ciglaX = j * zid.getCigleSirina() + 70;
                        int ciglaY = i * zid.getCigleVisina() + 55;
                        int cigleSirina = zid.getCigleSirina();
                        int cigleVisina = zid.getCigleVisina();
                        Rectangle ballRect = new Rectangle(lopticaX, lopticaY, 20, 20);
                        Rectangle ciglaPravougaonik = new Rectangle(ciglaX, ciglaY, cigleSirina, cigleVisina);
                        //kada loptica dodirne ciglu
                        if (ballRect.intersects(ciglaPravougaonik)) {
                            zid.setBrickValue(0, i, j);
                            ukupnoCigli--;
                            rezultat += 5;

                            if (lopticaX +10<= ciglaPravougaonik.x || lopticaX +1>= ciglaPravougaonik.x + ciglaPravougaonik.width) {
                                lopticaXsmer = -lopticaXsmer;
                            } else {
                                lopticaYsmer = -lopticaYsmer;
                            }
                            break;
                        }
                    }

                }
            }
            
            lopticaX += lopticaXsmer;
            lopticaY += lopticaYsmer;
            //kad udari o okvir
            if (lopticaX < 0) {
                lopticaXsmer = -lopticaXsmer;
            }
            if (lopticaY < 0) {
                lopticaYsmer = -lopticaYsmer;
            }
            if (lopticaX > 670) {
                lopticaXsmer = -lopticaXsmer;
            }

        }
        repaint();

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//get, set metode i toString metoda
    public boolean isPlay() {
        return play;
    }

    public void setPlay(boolean play) {
        this.play = play;
    }

    public int getRezultat() {
        return rezultat;
    }

    public void setRezultat(int rezultat) {
        this.rezultat = rezultat;
    }

    public int getUkupnoCigli() {
        return ukupnoCigli;
    }

    public void setUkupnoCigli(int ukupnoCigli) {
        this.ukupnoCigli = ukupnoCigli;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getBrzina() {
        return brzina;
    }

    public void setBrzina(int brzina) {
        this.brzina = brzina;
    }

    public int getIgrac() {
        return igrac;
    }

    public void setIgrac(int igrac) {
        this.igrac = igrac;
    }

    public int getLopticaX() {
        return lopticaX;
    }

    public void setLopticaX(int lopticaX) {
        this.lopticaX = lopticaX;
    }

    public int getLopticaY() {
        return lopticaY;
    }

    public void setLopticaY(int lopticaY) {
        this.lopticaY = lopticaY;
    }

    public int getLopticaXsmer() {
        return lopticaXsmer;
    }

    public void setLopticaXsmer(int lopticaXsmer) {
        this.lopticaXsmer = lopticaXsmer;
    }

    public int getLopticaYsmer() {
        return lopticaYsmer;
    }

    public void setLopticaYsmer(int lopticaYsmer) {
        this.lopticaYsmer = lopticaYsmer;
    }

    public Cigle getZid() {
        return zid;
    }

    public void setZid(Cigle zid) {
        this.zid = zid;
    }

    public Igra(Timer timer, Cigle zid) {
        this.timer = timer;
        this.zid = zid;
    }

    @Override
    public String toString() {
        return "Igra{" + "play=" + play + ", rezultat=" + rezultat + ", ukupnoCigli=" + ukupnoCigli + ", timer=" + timer + ", brzina=" + brzina + ", igrac=" + igrac + ", lopticaX=" + lopticaX + ", lopticaY=" + lopticaY + ", lopticaXsmer=" + lopticaXsmer + ", lopticaYsmer=" + lopticaYsmer + ", zid=" + zid + '}';
    }

}
