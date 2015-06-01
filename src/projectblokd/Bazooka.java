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
public class Bazooka extends PowerUp {
    
    private Held held;
    
    public Bazooka () {
        setImage(Spel.loadImage("bazooka.png"));
    }

    public void schiet (Richtingen richting) {
        Kogel kogel = new Kogel(richting);
        held.getVeld().addSpelItem(kogel);
        kogel.setVeld(held.getVeld());
    }   
    
    @Override
    public void actie (Held held, Iterator iter) {
        this.held = held;
        held.addBazooka(this);
        iter.remove();
    }
}
