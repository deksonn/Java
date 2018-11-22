
package Igra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Deksonn
 */
public class Cigle {
//deklarisanje zida kao matrica  i  visine i sirine svake cigle
    private int zid[][];
    private int cigleSirina;
    private int cigleVisina;

    public Cigle(int red, int kol) {
        
        zid = new int[red][kol];
        for (int i = 0; i < zid.length; i++) {
            for (int j = 0; j < zid[i].length; j++) {
                zid[i][j] = 1;
           }

        }
        //visina i sirina pojedinacne cigle
        cigleSirina = 570 / kol; 
        cigleVisina = 200 / red;

    }

    public void draw(Graphics2D g) {
        //iscrtavaju se popunjene bele cigle a zatim okviri plave boje tj nepopunjeni plavi pravougaonici
        for (int i = 0; i < zid.length; i++) {
            for (int j = 0; j < zid[0].length; j++) {
                if (zid[i][j] >0) {
                    g.setColor(Color.gray);
                    
                    g.fillRect(j * cigleSirina + 70, i * cigleVisina + 55, cigleSirina, cigleVisina);
                    g.setStroke(new BasicStroke(4));
                    g.setColor(Color.white);
                    g.drawRect(j * cigleSirina + 70, i * cigleVisina + 55, cigleSirina, cigleVisina);

                }
            }
        }
    }
//get, set metode i toString metoda
    public void setBrickValue(int value, int red, int kol) {
        zid[red][kol] = value;
    }

    public int[][] getZid() {
        return zid;
    }

    public void setZid(int[][] zid) {
        this.zid = zid;
    }

    public int getCigleSirina() {
        return cigleSirina;
    }

    public void setCigleSirina(int cigleSirina) {
        this.cigleSirina = cigleSirina;
    }

    public int getCigleVisina() {
        return cigleVisina;
    }

    public void setCigleVisina(int cigleVisina) {
        this.cigleVisina = cigleVisina;
    }

    @Override
    public String toString() {
        return "Cigle{" + "zid=" + zid + ", cigleSirina=" + cigleSirina + ", cigleVisinat=" + cigleVisina + '}';
    }

}
