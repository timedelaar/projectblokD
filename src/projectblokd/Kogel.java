/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.Timer;

/**
 *
 * @author Tim
 */
public class Kogel extends SpelItem {
    
    private Timer timer;
    private Richtingen richting;

    public Kogel(Richtingen richting) {
        setImage("kogel.png");
        this.richting = richting;
        startTimer();
    }
    
    /*
     * Start de verplaats timer.
     */
    private void startTimer () {
        timer = new Timer(200, new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e) {
                verplaats();
            }
            
        });
        timer.start();
    }
    
    public void stopTimer () {
        timer.stop();
    }

    /*
     * Verplaatst de kogel.
     * Controleert of er een veld is in de gegeven richting.
     * Zo nee, verwijderd de kogel.
     * Zo ja, kijk of de kogel zich kan verplaatsen in die richting.
     * Zo ja, voegt kogel toe aan het nieuwe veld en verwijderd hem van het oude veld.
     * Zo nee, verwijderd de kogel en roept destroySpelItems aan van het nieuwe veld.
     */
    private void verplaats() {
        Veld huidigVeld = getVeld();
        Veld nieuwVeld = huidigVeld.getNeighbour(richting);
        if (nieuwVeld != null) {
            if (nieuwVeld.kanVerplaatsen(this)) {
                nieuwVeld = huidigVeld.getNeighbour(richting);
                nieuwVeld.addSpelItem(this);
                huidigVeld.verwijderSpelItem(this);
                nieuwVeld.repaint();
                huidigVeld.repaint();
                setVeld(nieuwVeld);
            }
            else {
                huidigVeld.verwijderSpelItem(this);
                nieuwVeld.destroySpelItems();
                nieuwVeld.repaint();
                huidigVeld.repaint();
                stopTimer();
            }
        }
        else {
            huidigVeld.verwijderSpelItem(this);
            huidigVeld.repaint();
            stopTimer();
        }
    }
    
    /*
     * Draait de richting van de kogel om.
     */
    public void omdraaien () {
        switch (richting) {
            case NORTH : 
                richting = Richtingen.SOUTH;
                break;
            case EAST :
                richting = Richtingen.WEST;
                break;
            case SOUTH :
                richting = Richtingen.NORTH;
                break;
            case WEST : 
                richting = Richtingen.EAST;
                break;
        }
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }

    @Override
    public void destroy () {
    }

    @Override
    public void destroy (Iterator<SpelItem> iter) {
    }
    
    public void forceVerplaats () {
        verplaats();
    }
    
    public Richtingen getRichting () {
        return richting;
    }
}
