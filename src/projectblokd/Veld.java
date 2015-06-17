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
    
    /*
     * Sla het gegeven veld op in de gegeven richting.
     */
    public void setNeighbour (Richtingen richting, Veld veld) {
        buren.put(richting, veld);
    }
    
    /*
     * Return het buurveld in de gegeven richting.
     */
    public Veld getNeighbour (Richtingen richting) {
        return buren.get(richting);
    }
    
    /*
     * Geeft een lijst met alle buren.
     */
    public ArrayList<Veld> getNeighbours () {
        ArrayList<Veld> burenList = new ArrayList<>();
        for (Richtingen richting : buren.keySet()) {
            burenList.add(buren.get(richting));
        }
        return burenList;
    }
    
    /*
     * Controleert of de held zich naar dit veld kan verplaatsen.
     * Als dit veld een object bevat waar de held zich niet naar toe kan verplaatsen
     * return false, anders return true.
     */
    public boolean kanVerplaatsen (Held held) {
        for (SpelItem item : spelItems) {
            if (!item.kanVerplaatsen(held))
                return false;
        }
        return true;
    }
    
    /*
     * Controleert of de kogel zich naar dit veld kan verplaatsen.
     * Als dit veld een object bevat waar de kogel zich niet naar toe kan verplaatsen
     * return false, anders return true.
     */
    public boolean kanVerplaatsen (Kogel kogel) {
        for (SpelItem item : spelItems) {
            if (!item.kanVerplaatsen(kogel))
                return false;
        }
        return true;
    }
    
    /*
     * Voegt het gegeven spelItem toe aan de lijst met spelItems
     */
    public void addSpelItem (SpelItem spelItem) {
        spelItems.add(spelItem);
        spelItem.setVeld(this);
    }
    
    /*
     * Verwijdert het gegeven spelItem uit de lijst met spelItems.
     */
    public void verwijderSpelItem (SpelItem item) {
        spelItems.remove(item);
    }
    
    /*
     * Doorloopt de lijst met spelItems en roept van elk item de methode destroy aan.
     */
    public void destroySpelItems () {
        Iterator<SpelItem> iter = spelItems.iterator();
        while (iter.hasNext()) {
            SpelItem item = iter.next();
            item.destroy(iter);
        }
    }
    
    /*
     * Doorloopt de lijst met spelItems en roept van elk item de methode actie aan.
     */
    public void powerUp (Held held) {
        Iterator<SpelItem> iter = spelItems.iterator();
        while (iter.hasNext()) {
            SpelItem item = iter.next();
            item.actie(held, iter);
        }
    }
    
    /*
     * Return true als dit veld een boot bevat.
     */
    public boolean hasBoot () {
        for (SpelItem item : spelItems) {
            if (item instanceof Boot) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return true als dit veld een bazooka bevat.
     */
    public boolean hasBazooka () {
        for (SpelItem item : spelItems) {
            if (item instanceof Bazooka) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return true als dit veld een held bevat.
     */
    public boolean hasHeld () {
        for (SpelItem item : spelItems) {
            if (item instanceof Held) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return true als dit veld een kogel bevat.
     */
    public boolean hasKogel () {
        for (SpelItem item : spelItems) {
            if (item instanceof Kogel) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return true als dit veld een ladder bevat.
     */
    public boolean hasLadder () {
        for (SpelItem item : spelItems) {
            if (item instanceof Ladder) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return de ladder die dit veld bevat.
     */
    public Ladder getLadder () {
        for (SpelItem item : spelItems) {
            if (item instanceof Ladder) {
                return (Ladder) item;
            }
        }
        return null;
    }
    
    /*
     * Return true als dit veld een muur bevat.
     */
    public boolean hasMuur () {
        for (SpelItem item : spelItems) {
            if (item instanceof Muur) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return true als dit veld een vriend bevat.
     */
    public boolean hasVriend () {
        for (SpelItem item : spelItems) {
            if (item instanceof Vriend) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Return true als dit veld water bevat.
     */
    public boolean hasWater () {
        for (SpelItem item : spelItems) {
            if (item instanceof Water) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * Als de gegeven afstand lager is dan de huidige afstand.
     * Verander afstand in de gegeven afstand.
     */
    public void setAfstand (int afstand) {
        if (afstand < afstandVanHelper)
            afstandVanHelper = afstand;
    }
    
    /*
     * return afstand.
     */
    public int getAfstand () {
        return afstandVanHelper;
    }
    
    /*
     * Zet onderdeelRoute op true of false.
     * Repaint het veld daarna.
     */
    public void isOnderdeelRoute (boolean bool) {
        onderdeelRoute = bool;
        repaint();
    }
    
    public boolean getOnderdeelRoute () {
        return onderdeelRoute;
    }
    
    /*
     * Tekent eerst de achtergrond.
     * Vervolgens wordt er een rood vierkant getekend als dit veld onderdeel is
     * van de route. Hierna worden alle spelItems getekend.
     */
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
