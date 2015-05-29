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
    
    private Doolhof doolhof;
    
    private Bazooka bazooka;
    
    private Richtingen laatsteRichting;
    
    public Held (Doolhof doolhof) {
        this.doolhof = doolhof;
        
        setImage(Spel.loadImage("held.png"));
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
            if (checkVeld(nieuwVeld)) {
                nieuwVeld.setSpelItem(this);
                huidigVeld.verwijderSpelItem();
                nieuwVeld.repaint();
                huidigVeld.repaint();
                if (bazooka != null) {
                    bazooka.setVeld(nieuwVeld);
                }
            }
        }
    }
    
    public boolean checkVeld (Veld veld) {
        SpelItem item = veld.getSpelItem();
        if (item == null) {
            return true;
        }
        else if (item instanceof Muur) {
            return false;
        }
        else if (item instanceof PowerUp) {
            PowerUp powerUp = (PowerUp) item;
            if (powerUp instanceof Bazooka) {
                Bazooka b = (Bazooka) powerUp;
                b.setHeld(this);
            }
            powerUp.actie();
        }
        else if (item instanceof Vriend) {
            doolhof.stopSpel();
        }
        return true;
    }
    
    public void addBazooka (Bazooka bazooka) {
        this.bazooka = bazooka;
    }
}
