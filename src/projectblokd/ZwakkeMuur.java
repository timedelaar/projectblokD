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
        setImage("zwakke-muur.png");
    }
    
    /*
     * Verwijder de muur.
     */
    public void destroy (Iterator<SpelItem> iter) {
        iter.remove();
    }
}
