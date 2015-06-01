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
public class ZwakkeMuur extends Muur implements Destructable {
    
    public ZwakkeMuur () {
        setImage(Spel.loadImage("muur.png"));
    }
    
    public void destroy (Iterator iter) {
        iter.remove();
    }
}
