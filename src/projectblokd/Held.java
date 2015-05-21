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
        
        loadImage("rocket.png");
    }
    
    public void verplaats (Richtingen richting) {
        Veld veld = getVeld();
        Veld nieuwVeld = veld.getNeighbour(richting);
        if (checkVeld(nieuwVeld)) {
            nieuwVeld.setSpelItem(this);
            veld.verwijderSpelItem();
            nieuwVeld.repaint();
            veld.repaint();
        }
    }
    
    public boolean checkVeld (Veld veld) {
        SpelItem item = veld.getSpelItem();
        if (item instanceof Muur) {
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
        return true;
    }
    
    public void addBazooka (Bazooka bazooka) {
        this.bazooka = bazooka;
    }
}
