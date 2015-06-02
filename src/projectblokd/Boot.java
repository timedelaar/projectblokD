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
public class Boot extends PowerUp {
    
    public Boot () {
        setImage(Spel.loadImage("boot.png"));
    }

    @Override
    public void actie (Held held, Iterator iter) {
        held.addBoot(this);
        iter.remove();
    }
    
}
