/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

/**
 *
 * @author Tim
 */
public class Knop extends JComponent {
    
    public static final int RESET = 0;
    public static final int START = 1;
    public static final int EXIT = 2;
    
    private BufferedImage image;
    private int actie;
    
    public Knop (String ref, int actie) {
        image = Spel.loadImage(ref);
        this.actie = actie;
    }
    
    public int getActie () {
        return actie;
    }
    
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
