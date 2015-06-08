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
public class Water extends SpelItem {
    
    public Water () {
        setImage("water.png");
    }

    @Override
    public boolean kanVerplaatsen (Held held) {
        try {
            if (held.hasBoot()) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
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
