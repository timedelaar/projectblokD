/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class Water extends SpelItem {
    
    public Water () {
        setImage(Spel.loadImage("water.png"));
    }

    @Override
    public boolean kanVerplaatsen (Held held) {
        if (held.hasBoot()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
    
}
