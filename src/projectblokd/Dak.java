/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.Iterator;

/**
 *
 * @author Tim
 */
public class Dak extends SpelItem {
    
    public Dak() {
        BufferedImage newImage = Spel.addTransparency(ImageStorage.get().getImage("muur.png"), 0.55f);
        setImage(newImage);
        setDrawPriority(14);
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }

    @Override
    public void destroy () {
    }

    @Override
    public void destroy (Iterator iter) {
    }
}
