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
        setImage("bazooka.png");
    }

   /* Methode schiet wordt door held aangeroepen.
    * In de methode wordt er een nieuwe kogel gemaakt met de richting waar de held naartoe is gericht
    * De kogel wordt vervolgens toegevoegd op de veld
    */
    public void schiet (Richtingen richting) {
        Kogel kogel = new Kogel(richting);
        held.getVeld().addSpelItem(kogel);
        kogel.setVeld(held.getVeld());
    }   
    
    /* Methode actie wordt door veld aangeroepen.
     * voegt de bazooka toe aan de held en verwijdert de power-up
     */
    @Override
    public void actie (Held held, Iterator iter) {
        this.held = held;
        held.addBazooka(this);
        iter.remove();
    }
}
