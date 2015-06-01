/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;


/**
 *
 * @author Tim
 */
public class Held extends SpelItem {
    
    private Bazooka bazooka;
    
    private Richtingen laatsteRichting;
    
    public Held () {
        setImage(Spel.loadImage("held.png"));
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
    
    public boolean kanVerplaatsen (Held held) {
        return true;
    }
    
    public boolean kanVerplaatsen (Kogel kogel) {
        return true;
    }
}
