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
public class Kogel {
    
    private Veld huidigVeld;
    private Timer timer;
    private BufferedImage image;
    private Richtingen richting;

    public Kogel(Veld veld, Richtingen richting) {
        image = Spel.loadImage("cheater.png");
        this.richting = richting;
        huidigVeld = veld;
        veld.setKogel(this);
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
        Veld nieuwVeld = huidigVeld.getNeighbour(richting);
        if (nieuwVeld != null) {
            if (checkHit(nieuwVeld) == false) {
                nieuwVeld.setKogel(this);
                huidigVeld.verwijderKogel();
                nieuwVeld.repaint();
                huidigVeld.repaint();
                huidigVeld = nieuwVeld;
            }
            else {
                huidigVeld.verwijderKogel();
                nieuwVeld.repaint();
                huidigVeld.repaint();
                timer.stop();
            }
        }
        else {
            huidigVeld.verwijderKogel();
            huidigVeld.repaint();
            timer.stop();
        }
    }

    private boolean checkHit(Veld veld) {
        SpelItem item = veld.getSpelItem();
        if (item instanceof SpelItem && item instanceof Destructable){
            Destructable d = (Destructable) item;
            d.destroy();
            return true;
        }
        else if (item instanceof PowerUp) {
            return false;
        }
        else if (item instanceof SpelItem && !(item instanceof Destructable)) {
            return true;
        }
        else
            return false;
    }
    
    public BufferedImage getImage () {
        return image;
    }
}
