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
public class Cheater extends PowerUp {
    
    private int waarde;
    private Doolhof doolhof;
    
    public Cheater (int waarde, Doolhof doolhof) {
        this.waarde = waarde;
        this.doolhof = doolhof;
        setImage(Spel.loadImage("cheater.png"));
    }

    @Override
    public void actie (Held held, Iterator iter) {
        doolhof.verlaagScore(waarde);
        iter.remove();
    }
    
}
