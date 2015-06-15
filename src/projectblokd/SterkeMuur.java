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
public class SterkeMuur extends Muur {
    
    private int sterkte = 2;
    
    public SterkeMuur () {
        setImage("muur.png");
    }
    
    public void destroy (Iterator<SpelItem> iter) {
        sterkte --;
        if (sterkte == 1) {
            setImage("zwakke-muur.png");
        }
        else if (sterkte == 0) {
            iter.remove();
        }
    }
}
