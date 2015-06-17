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

    /*
     * Luistert welke toets wordt ingedrukt en handelt daar naar.
     */
    @Override
    public boolean dispatchKeyEvent (KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                held.verplaats(Richtingen.WEST);
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP) {
                held.verplaats(Richtingen.NORTH);
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                held.verplaats(Richtingen.EAST);
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                held.verplaats(Richtingen.SOUTH);
            }
            else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                held.schiet();
            }
        }
        return true;
    }
    
}
