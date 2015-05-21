/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Tim
 */
public abstract class SpelItem {
    
    private BufferedImage image;
    private Veld veld;
    
    public void setImage (BufferedImage image) {
        this.image = image;
    }
    
    public BufferedImage getImage () {
        return image;
    }
    
    public void setVeld (Veld veld) {
        this.veld = veld;
    }
    
    public Veld getVeld () {
        return veld;
    }
}
