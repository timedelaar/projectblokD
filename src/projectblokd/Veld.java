/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    
    private boolean onderdeelRoute;
    private int afstandVanHelper = Integer.MAX_VALUE;
    
    public Veld () {
        buren = new HashMap<>();
        spelItems = new PriorityQueue<>();
        
        setImage("veld.png");
    }
    
    public final void setImage (String ref) {
        this.image = ImageStorage.get().getImage(ref);
    }
    
    public void setNeighbour (Richtingen richting, Veld veld) {
        buren.put(richting, veld);
    }
    
    public Veld getNeighbour (Richtingen richting) {
        return buren.get(richting);
    }
    
    public ArrayList<Veld> getNeighbours () {
        ArrayList<Veld> burenList = new ArrayList<>();
        for (Richtingen richting : buren.keySet()) {
            burenList.add(buren.get(richting));
        }
        return burenList;
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
        Iterator<SpelItem> iter = spelItems.iterator();
        while (iter.hasNext()) {
            SpelItem item = iter.next();
            item.destroy(iter);
        }
    }
    
    public void powerUp (Held held) {
        Iterator<SpelItem> iter = spelItems.iterator();
        while (iter.hasNext()) {
            SpelItem item = iter.next();
            item.actie(held, iter);
        }
    }
    
    public boolean hasBoot () {
        for (SpelItem item : spelItems) {
            if (item instanceof Boot) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasBazooka () {
        for (SpelItem item : spelItems) {
            if (item instanceof Bazooka) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasDestructable () {
        for (SpelItem item : spelItems) {
            if (item instanceof ZwakkeMuur) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasHeld () {
        for (SpelItem item : spelItems) {
            if (item instanceof Held) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasVriend () {
        for (SpelItem item : spelItems) {
            if (item instanceof Vriend) {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasWater () {
        for (SpelItem item : spelItems) {
            if (item instanceof Water) {
                return true;
            }
        }
        return false;
    }
    
    public void setAfstand (int afstand) {
        if (afstand < afstandVanHelper)
            afstandVanHelper = afstand;
    }
    
    public int getAfstand () {
        return afstandVanHelper;
    }
    
    public void isOnderdeelRoute (boolean bool) {
        onderdeelRoute = bool;
        repaint();
    }
    
    public boolean getOnderdeelRoute () {
        return onderdeelRoute;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        if (onderdeelRoute) {
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
