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
    private Kogel kogel;
    private RouteState onderdeelRoute;
    
    public Veld () {
        buren = new HashMap<>();
        setImage(Spel.loadImage("veld.png"));
        onderdeelRoute = RouteState.NIETGEWEEST;
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
    public void verwijderKogel(){
        kogel = null;
    }
    public void setKogel(Kogel kogel)
    {
        this.kogel = kogel;
    }
    
    public void isOnderdeelRoute (RouteState state) {
        onderdeelRoute = state;
        repaint();
    }
    
    public RouteState getOnderdeelRoute () {
        return onderdeelRoute;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        if (onderdeelRoute == RouteState.WELONDERDEEL) {
            Color color = new Color(255, 0, 0, 100);
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        if (spelItem != null) {
            if (spelItem.getImage() != null) {
                g.drawImage(spelItem.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        }
        if (kogel != null) {
            if (kogel.getImage() != null) {
                g.drawImage(kogel.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
