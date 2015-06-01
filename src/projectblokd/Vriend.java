/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class Vriend extends SpelItem {
    
    private Doolhof doolhof;
    
    public Vriend (Doolhof doolhof) {
        this.doolhof = doolhof;
        setImage(Spel.loadImage("vriend.png"));
    }
    
    public void stopSpel () {
        doolhof.stopSpel();
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
}
