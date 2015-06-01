/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

/**
 *
 * @author Tim
 */
public class Kogel extends SpelItem {
    
    private Timer timer;
    private BufferedImage image;
    private Richtingen richting;

    public Kogel(Richtingen richting) {
        image = Spel.loadImage("cheater.png");
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
            if (!checkHit(nieuwVeld)) {
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
    
    private boolean checkHit (Veld veld) {
        if (veld.kanVerplaatsen(this))
            return false;
        else
            return true;
    }
    
    public BufferedImage getImage () {
        return image;
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
}
