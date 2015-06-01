/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;

/**
 *
 * @author Tim
 */
public class Dak extends SpelItem {
    
    public Dak() {
        setImage(Spel.loadImage("muur.png"));
        BufferedImage newImage = Spel.addTransparency(getImage(), 0.55f);
        setImage(newImage);
        setDrawPriority(14);
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
}
