/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class Spel extends JPanel {
    
    
    private Doolhof doolhof;
    private int width;
    private int height;
    
    public Spel (int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }
    
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        setLayout(layout);
        doolhof = new Doolhof(width, height);
        doolhof.setPreferredSize(new Dimension(width, height));
        add(doolhof);
    }
    
    public void stopSpel () {
        System.out.println("gewonnen");
    }
    
    public static BufferedImage loadImage (String ref) {
        BufferedImage image = null;
        try {
            URL url = Spel.class.getClassLoader().getResource("images/" + ref);
            image = ImageIO.read(url);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return image;
    }
}
