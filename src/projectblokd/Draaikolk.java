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
public class Draaikolk extends Water {
    
    private boolean kanVerplaatsen = false;
    Timer kolkTimer;
    
    public Draaikolk () {
        setImage("draaikolk.png");
        maakTimer();
    }
    
    /*
     * Maakt een timer die gestart wordt als de draaikolk geraakt wordt.
     * De timer reset de draaikolk na 1,5 seconde.
     */
    private void maakTimer () {
        kolkTimer = new Timer(1500, new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e) {
                kanVerplaatsen = false;
                setImage("draaikolk.png");
                kolkTimer.stop();
                getVeld().repaint();
            }
        });
    }
    
    @Override
    public boolean kanVerplaatsen (Held held) {
        return kanVerplaatsen;
    }
    
    @Override
    public boolean kanVerplaatsen (Kogel kogel) {
        return kanVerplaatsen;
    }
    
    /*
     * Als de draaikolk geraakt wordt door een kogel verdwijnt deze tijdelijk.
     */
    @Override
    public void destroy (Iterator<SpelItem> iter) {
        kanVerplaatsen = true;
        setImage("water.png");
        kolkTimer.start();
    }
}
