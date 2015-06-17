/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.Iterator;


/**
 *
 * @author Tim
 */
public class Held extends SpelItem {
    
    private Bazooka bazooka;
    private Boot boot;
    
    private BufferedImage lopend;
    private BufferedImage varend;
    
    private Richtingen laatsteRichting = Richtingen.NORTH;
    
    public Held () {
        lopend = ImageStorage.get().getImage("held.png");
        varend = ImageStorage.get().getImage("varende-held.png");
        setImage(lopend);
        setDrawPriority(15);
    }
    
    /*
     * Checkt of de held een bazooka heeft.
     * Zo ja, schiet de bazooka af in de laatst gelopen richting.
     */
    public void schiet (){
        if (bazooka != null) {
            bazooka.schiet(laatsteRichting);
            bazooka = null;
        }
    }
    
    /*
     * Verplaatst de held in de gegeven richting.
     * Controleert of er een veld is in de gegeven richting.
     * Zo ja, kijk of de held zich kan verplaatsen in die richting.
     * Kijkt of de held van land naar water gaat of andersom.
     * Zo ja, verandert het plaatje.
     * voegt held toe aan het nieuwe veld en verwijderd hem van het oude veld.
     * roept powerUp aan van het nieuwe veld.
     * verandert de laatst gelopen richting in de gegeven richting.
     */
    public void verplaats (Richtingen richting) {
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
                laatsteRichting = richting;
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

    @Override
    public void destroy () {
    }

    @Override
    public void destroy (Iterator<SpelItem> iter) {
    }
}
