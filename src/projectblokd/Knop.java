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
    
    private BufferedImage image;
    
    public Knop (String ref) {
        image = Spel.loadImage(ref);
    }
    
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
