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
public class ZwakkeMuur extends Muur {
    
    public ZwakkeMuur () {
        setImage("muur.png");
    }
    
    public void destroy (Iterator iter) {
        iter.remove();
    }
}
