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
            System.out.println("links");
        }
        else if (code == 38) {
            System.out.println("boven");
        }
        else if (code == 39) {
            System.out.println("rechts");
        }
        else if (code == 40) {
            System.out.println("onder");
        }
        else if (code == 32) {
            System.out.println("spatie");
        }
    }

    @Override
    public void keyReleased (KeyEvent e) {
    }
    
}
