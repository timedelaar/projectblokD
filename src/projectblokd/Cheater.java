/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

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
    }

    @Override
    public void actie () {
        doolhof.verlaagScore(waarde);
    }
    
}
