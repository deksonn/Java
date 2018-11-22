
package Igra;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Deksonn
 */
public class Main {

    public static void main(String[] args) throws IOException {

        JFrame obj = new JFrame();
        Igra igra = new Igra();
        obj.setBounds(330, 100, 700, 600);
        obj.setTitle("Igra");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(igra);

    }

}
