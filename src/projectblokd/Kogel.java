/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import javax.swing.Timer;

/**
 *
 * @author Tim
 */
public class Kogel {
    
    private Veld huidigVeld;
    //private Timer timer;

    public Kogel(Veld veld) {
        //setImage(Spel.loadImage("cheater.png"));                    
    }

    public void verplaats(Richtingen richting) {              
        Veld nieuwVeld = huidigVeld.getNeighbour(richting);
        if (checkHit(nieuwVeld) == false) {
            nieuwVeld.setKogel(this);
            huidigVeld.verwijderKogel();
            nieuwVeld.repaint();
            huidigVeld.repaint();
        }
    }

    public boolean checkHit(Veld veld) {
        SpelItem item = veld.getSpelItem();
        if (item instanceof Muur) {
            return true;
        }
        else
            return false;
    }
}
