/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class Bazooka extends PowerUp {
    
    private Held held;

    public void schiet (Richtingen richting) {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    @Override
    public void actie () {
        held.addBazooka(this);
    }
    
    public void setHeld (Held held) {
        this.held = held;
    }
}
