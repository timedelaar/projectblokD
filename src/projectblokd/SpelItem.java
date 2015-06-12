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
public abstract class SpelItem implements Comparable {
    
    private BufferedImage image;
    private Veld veld;
    private int drawPriority = 20;
    
    public void setDrawPriority (int priority) {
        drawPriority = priority;
    }
    
    public int getDrawPriority () {
        return drawPriority;
    }
    
    public void setImage (String ref) {
        this.image = ImageStorage.get().getImage(ref);
    }
    
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
    
    public abstract boolean kanVerplaatsen (Held held);
    
    public abstract boolean kanVerplaatsen (Kogel kogel);
    
    public abstract void destroy ();
    
    public abstract void destroy (Iterator iter);
    
    public void actie (Held held, Iterator<SpelItem> iter){}
    
    @Override
    public int compareTo (Object o) {
        SpelItem item = (SpelItem) o;
        if (drawPriority < item.getDrawPriority()) {
            return 1;
        }
        else if (drawPriority > item.getDrawPriority()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
