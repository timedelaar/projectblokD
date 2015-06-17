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
        setImage("boot.png");
    }

    /* De methode wordt aangeroepen door veld
     * Voegt de boot toe aan de held en verwijderd de power-up
     */
    @Override
    public void actie (Held held, Iterator iter) {
        held.addBoot(this);
        iter.remove();
    }
    
}
