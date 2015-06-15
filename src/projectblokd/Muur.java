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

    public Muur() {
        setImage("muur-rand.png");
    }
    
    public boolean kanVerplaatsen (Held held) {
        return false;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return false;
    }

    @Override
    public void destroy () {
    }

    @Override
    public void destroy (Iterator<SpelItem> iter) {
    }
}
