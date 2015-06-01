/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Aymren
 */
public class Muur extends SpelItem {

    public Muur() {
        setImage(Spel.loadImage("muur-rand.png"));
    }
    
    public boolean kanVerplaatsen (Held held) {
        return false;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return false;
    }
}
