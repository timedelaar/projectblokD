/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class ZwakkeMuur extends Muur implements Destructable {
    
    public ZwakkeMuur () {
        setImage(Spel.loadImage("muur.png"));
    }
    
    public void destroy () {
        getVeld().verwijderSpelItem();
    }
}
