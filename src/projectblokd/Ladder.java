/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Tim
 */
public class Ladder extends PowerUp {
    
    private ArrayList<Veld> exits;

    public Ladder () {
        setImage("ladder.png");
        exits = new ArrayList<>();
    }
    
    @Override
    public void actie (Held held, Iterator iter) {
        Veld exit = getVeld();
        while (exit == getVeld() && exits.size() > 1) {
            int exitNumber = (int) (Math.random() * exits.size());
            exit = exits.get(exitNumber);
        }
        verplaatsHeld(held, exit);
    }
    
    private void verplaatsHeld (Held held, Veld exit) {
        exit.addSpelItem(held);
        getVeld().verwijderSpelItem(held);
        held.setVeld(exit);
        exit.repaint();
        getVeld().repaint();
    }
    
    public void setExits (ArrayList<Veld> exits) {
        this.exits = exits;
    }
}
