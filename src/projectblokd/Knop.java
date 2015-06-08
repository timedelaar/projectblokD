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
    public static final int HELP = 3;
    public static final int TERUG = 4;
    public static final int MAZE1 = 5;
    public static final int MAZE2 = 6;
    public static final int MAZE3 = 7;
    
    private BufferedImage image;
    private int actie;
    
    public Knop (String ref, int actie) {
        image = ImageStorage.get().getImage(ref);
        this.actie = actie;
    }
    
    public int getActie () {
        return actie;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
