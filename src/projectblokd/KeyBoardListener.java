/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

/**
 *
 * @author Tim
 */
public class KeyBoardListener implements KeyEventDispatcher {
    
    Held held;
    
    public KeyBoardListener () {
        
    }
    
    public KeyBoardListener (Held held) {
        this.held = held;
    }
    
    public void setHeld (Held held) {
        this.held = held;
    }

    @Override
    public boolean dispatchKeyEvent (KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                held.verplaats(Richtingen.WEST);
            }
            else if (e.getKeyCode() == 38) {
                held.verplaats(Richtingen.NORTH);
            }
            else if (e.getKeyCode() == 39) {
                held.verplaats(Richtingen.EAST);
            }
            else if (e.getKeyCode() == 40) {
                held.verplaats(Richtingen.SOUTH);
            }
            else if (e.getKeyCode() == 32) {
                held.schiet();
            }
        }
        return true;
    }
    
}
