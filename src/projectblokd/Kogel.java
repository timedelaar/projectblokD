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
    
    private void startTimer () {
        timer = new Timer(200, new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e) {
                verplaats();
            }
            
        });
        timer.start();
    }

    private void verplaats() {
        Veld huidigVeld = getVeld();
        Veld nieuwVeld = huidigVeld.getNeighbour(richting);
        if (nieuwVeld != null) {
            if (nieuwVeld.kanVerplaatsen(this)) {
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
                timer.stop();
            }
        }
        else {
            huidigVeld.verwijderSpelItem(this);
            huidigVeld.repaint();
            timer.stop();
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
}
