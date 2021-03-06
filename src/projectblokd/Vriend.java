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
public class Vriend extends SpelItem {
    
    private Doolhof doolhof;
    
    public Vriend (Doolhof doolhof) {
        this.doolhof = doolhof;
        setImage("vriend.png");
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
    
    /*
     * Stopt het spel
     */
    @Override
    public void actie (Held held, Iterator<SpelItem> iter) {
        doolhof.stopSpel();
        iter.remove();
    }

    @Override
    public void destroy () {
    }

    @Override
    public void destroy (Iterator<SpelItem> iter) {
    }
}
