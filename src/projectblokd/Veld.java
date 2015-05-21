/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import javax.swing.JComponent;

/**
 *
 * @author Tim
 */
public class Veld extends JComponent {
    
    private HashMap<Richtingen, Veld> buren;
    private SpelItem spelItem;
    private BufferedImage image;
    
    public Veld () {
        buren = new HashMap<>();
        setImage(Spel.loadImage("veld.png"));
    }
    
    public final void setImage (BufferedImage image) {
        this.image = image;
    }
    
    public void setNeighbour (Richtingen richting, Veld veld) {
        buren.put(richting, veld);
    }
    
    public Veld getNeighbour (Richtingen richting) {
        return buren.get(richting);
    }
    
    public void setSpelItem (SpelItem spelItem) {
        this.spelItem = spelItem;
        spelItem.setVeld(this);
    }
    
    public SpelItem getSpelItem () {
        return spelItem;
    }
    
    public void verwijderSpelItem () {
        spelItem = null;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        if (spelItem != null) {
            if (spelItem.getImage() != null) {
                g.drawImage(spelItem.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
