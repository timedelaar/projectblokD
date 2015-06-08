/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.Iterator;

/**
 *
 * @author Tim
 */
public abstract class PowerUp extends SpelItem {
    
    public PowerUp () {
        setDrawPriority(19);
    }
    
    public abstract void actie (Held held, Iterator iter);
    
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
    public void destroy (Iterator<SpelItem> iter) {
        
    }
}
