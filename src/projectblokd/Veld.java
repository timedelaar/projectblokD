/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import javax.swing.JComponent;

/**
 *
 * @author Tim
 */
public class Veld extends JComponent {
    
    private HashMap<Richtingen, Veld> buren;
    private PriorityQueue<SpelItem> spelItems;
    private BufferedImage image;
    private RouteState onderdeelRoute;
    
    public Veld () {
        buren = new HashMap<>();
        spelItems = new PriorityQueue<>();
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
    
    public boolean kanVerplaatsen (Held held) {
        for (SpelItem item : spelItems) {
            if (!item.kanVerplaatsen(held))
                return false;
        }
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        for (SpelItem item : spelItems) {
            if (!item.kanVerplaatsen(kogel))
                return false;
        }
        return true;
    }
    
    public void addSpelItem (SpelItem spelItem) {
        spelItems.add(spelItem);
        spelItem.setVeld(this);
    }
    
    public void verwijderSpelItem (SpelItem item) {
        spelItems.remove(item);
    }
    
    public void destroySpelItems () {
        Iterator iter = spelItems.iterator();
        while (iter.hasNext()) {
            SpelItem item = (SpelItem) iter.next();
            if (item instanceof Destructable) {
                Destructable d = (Destructable) item;
                d.destroy(iter);
            }
        }
    }
    
    public void powerUp (Held held) {
        Iterator iter = spelItems.iterator();
        while (iter.hasNext()) {
            SpelItem item = (SpelItem) iter.next();
            item.actie(held, iter);
        }
    }
    
    public boolean hasVriend () {
        for (SpelItem item : spelItems) {
            if (item instanceof Vriend) {
                return true;
            }
        }
        return false;
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
        if (spelItems.size() > 0) {
            for (SpelItem item : spelItems) {
                if (item.getImage() != null) {
                    g.drawImage(item.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        }
    }
}
