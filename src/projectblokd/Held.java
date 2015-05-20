/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Tim
 */
public class Held extends SpelItem {
    
    private BufferedImage image;
    private Doolhof doolhof;
    
    public Held (Doolhof doolhof) {
        this.doolhof = doolhof;
        
        try {
            URL url = this.getClass().getClassLoader().getResource("images/rocket.png");
            image = ImageIO.read(url);
        }
        catch (Exception e) {
            image = null;
            System.out.println(e);
        }
    }
}
