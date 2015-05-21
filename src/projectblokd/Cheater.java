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
    
    public Cheater (int waarde) {
        this.waarde = waarde;
    }

    @Override
    public void actie () {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
