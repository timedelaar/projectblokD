/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JComponent;

/**
 *
 * @author Tim
 */
public class Veld extends JComponent {
    
    private HashMap<Richtingen, Veld> buren;
    private SpelItem spelItem;
    
    public Veld () {
        buren = new HashMap<>();
    }
    
    public void setNeighbour (Richtingen richting, Veld veld) {
        buren.put(richting, veld);
    }
    
    public Veld getNeighbour (Richtingen richting) {
        return buren.get(richting);
    }
    
    public void setSpelItem (SpelItem spelItem) {
        this.spelItem = spelItem;
    }
    
    public SpelItem getSpelItem () {
        return spelItem;
    }
    
    public void verwijderSpelItem () {
        spelItem = null;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.fillRect(0, 0, 30, 30);
    }
}
