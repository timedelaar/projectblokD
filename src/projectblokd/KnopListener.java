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
    private HelpMenu helpMenu;
    private DoolhofMenu doolhofMenu;
    
    public KnopListener (Menu menu, Knop knop) {
        this.knop = knop;
        this.menu = menu;
    }
    
    public KnopListener (Doolhof doolhof, Knop knop) {
        this.knop = knop;
        this.doolhof = doolhof;
    }
    public KnopListener (HelpMenu helpmenu, Knop knop) {
        this.knop = knop;
        this.helpMenu = helpmenu;
    }
    public KnopListener (DoolhofMenu doolhofMenu, Knop knop) {
        this.knop = knop;
        this.doolhofMenu = doolhofMenu;
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        if (menu != null)
            menu.actie(knop);
        else if (doolhofMenu != null)
            doolhofMenu.actie(knop);
        else if (helpMenu != null)
            helpMenu.actie(knop);
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
