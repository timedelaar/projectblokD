/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.Iterator;

/**
 *
 * @author Aymren
 */
public class Muur extends SpelItem {
    
    private int sterkte = Integer.MAX_VALUE;

    public Muur() {
        setImage(Spel.loadImage("muur-rand.png"));
    }
    
    public boolean kanVerplaatsen (Held held) {
        return false;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return false;
    }

    @Override
    public void destroy () {
        sterkte --;
    }

    @Override
    public void destroy (Iterator iter) {
        sterkte --;
        if (sterkte == 0) {
            iter.remove();
        }
    }
}
