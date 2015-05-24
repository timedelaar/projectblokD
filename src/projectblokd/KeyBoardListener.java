/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Tim
 */
public class KeyBoardListener implements KeyListener {
    
    Held held;
    
    public KeyBoardListener (Held held) {
        this.held = held;
    }

    @Override
    public void keyTyped (KeyEvent e) {
    }

    @Override
    public void keyPressed (KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 37) {
            held.verplaats(Richtingen.WEST);
        }
        else if (code == 38) {
            held.verplaats(Richtingen.NORTH);
        }
        else if (code == 39) {
            held.verplaats(Richtingen.EAST);
        }
        else if (code == 40) {
            held.verplaats(Richtingen.SOUTH);
        }
        else if (code == 32) {
            held.schiet();
        }
    }

    @Override
    public void keyReleased (KeyEvent e) {
    }
    
}
