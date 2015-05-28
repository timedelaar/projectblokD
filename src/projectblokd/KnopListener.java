/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Tim
 */
public class KnopListener implements MouseListener {
    
    private Knop knop;
    private Menu menu;
    private Doolhof doolhof;
    
    public KnopListener (Menu menu, Knop knop) {
        this.knop = knop;
        this.menu = menu;
    }
    
    public KnopListener (Doolhof doolhof, Knop knop) {
        this.knop = knop;
        this.doolhof = doolhof;
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        if (menu != null)
            menu.actie(knop);
        else if (doolhof != null)
            doolhof.opnieuwStarten();
    }

    @Override
    public void mousePressed (MouseEvent e) {
    }

    @Override
    public void mouseReleased (MouseEvent e) {
    }

    @Override
    public void mouseEntered (MouseEvent e) {
    }

    @Override
    public void mouseExited (MouseEvent e) {
    }
}
