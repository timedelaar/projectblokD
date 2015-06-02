/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;


/**
 *
 * @author Tim
 */
public class Held extends SpelItem {
    
    private Bazooka bazooka;
    private Boot boot;
    
    private BufferedImage lopend;
    private BufferedImage varend;
    
    private Richtingen laatsteRichting;
    
    public Held () {
        lopend = Spel.loadImage("held.png");
        varend = Spel.loadImage("varende-held.png");
        setImage(lopend);
        setDrawPriority(15);
    }
    
    public void schiet (){
        if (bazooka != null) {
            bazooka.schiet(laatsteRichting);
            bazooka = null;
        }
    }
    
    public void verplaats (Richtingen richting) {
        laatsteRichting = richting;
        Veld huidigVeld = getVeld();
        Veld nieuwVeld = huidigVeld.getNeighbour(richting);
        if (nieuwVeld != null) {
            if (nieuwVeld.kanVerplaatsen(this)) {
                if (nieuwVeld.hasWater() && !huidigVeld.hasWater()) {
                    setImage(varend);
                }
                else if (!nieuwVeld.hasWater() && huidigVeld.hasWater()) {
                    setImage(lopend);
                }
                nieuwVeld.addSpelItem(this);
                huidigVeld.verwijderSpelItem(this);
                nieuwVeld.powerUp(this);
                nieuwVeld.repaint();
                huidigVeld.repaint();
            }
        }
    }
    
    public void addBazooka (Bazooka bazooka) {
        this.bazooka = bazooka;
    }
    
    public boolean hasBazooka () {
        if (bazooka != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void addBoot (Boot boot) {
        this.boot = boot;
    }
    
    public boolean hasBoot () {
        if (boot != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
}
