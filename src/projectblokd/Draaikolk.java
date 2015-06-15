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
    
    @Override
    public void destroy (Iterator<SpelItem> iter) {
        kanVerplaatsen = true;
        setImage("water.png");
        kolkTimer.start();
    }
}
