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
    
    /*
     * Verlaagt de sterkte van de muur met 1.
     * Als de muur bijna kapot is, verander het plaatje.
     * Als de muur kapot is, verwijder de muur.
     */
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
