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
    private Kogel kogel;
    
    public Bazooka () {
        setImage(Spel.loadImage("bazooka.png"));
    }

    public void schiet (Richtingen richting) {
        kogel.verplaats(richting);
    }    
    @Override
    public void actie () {
        held.addBazooka(this);
    }
    
    public void setHeld (Held held) {
        this.held = held;
    }
}
