/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Tim
 */
public class Helper extends PowerUp {

    private ArrayList<Veld> onbezochteVelden;
    private ArrayList<Veld> bezochteVelden;
    
    private Veld einde;
    
    public Helper () {
        setImage("helper.png");
    }
    
    /*
     * Methode wordt aangeroepen door veld.
     * Vindt de korste route naar het einde en tekent deze.
     * Gebaseerd op Dijkstra's algoritme.
     */
    @Override
    public void actie (Held held, Iterator iter) {
        onbezochteVelden = new ArrayList<>();
        bezochteVelden = new ArrayList<>();
        Veld start = getVeld();
        start.setAfstand(0);
        vulOnbezochteVelden(start, held);
        if (vindRoute(start, einde)) {
            markeerRoute(einde);
        }
        iter.remove();
    }
    
    /*
     * Vult een arrayList met alle velden waar de held kan komen.
     * Als het veld de vriend bevat wordt deze opgeslagen als einde.
     */
    private void vulOnbezochteVelden (Veld huidigVeld, Held held) {
        Richtingen[] richtingen = {Richtingen.NORTH, Richtingen.EAST, Richtingen.SOUTH, Richtingen.WEST};
        for (Richtingen richting : richtingen) {
            Veld veld = huidigVeld.getNeighbour(richting);
            if (veld != null) {
                if (veld.kanVerplaatsen(held) && !onbezochteVelden.contains(veld)) {
                    veld.isOnderdeelRoute(false);
                    if (veld.hasVriend())
                        einde = veld;
                    onbezochteVelden.add(veld);
                    vulOnbezochteVelden(veld, held);
                }
            }
        }
    }
    
    /*
     * Vindt in de array met onbezochte velden het veld met de laagste afstand
     * van het beginpunt.
     */
    private Veld vindLaagsteAfstand (ArrayList<Veld> velden) {
        Veld laagsteVeld = null;
        if (velden.size() > 0) {
            laagsteVeld = velden.get(0);
            for (Veld veld : velden) {
                if (veld.getAfstand() < laagsteVeld.getAfstand()) {
                    laagsteVeld = veld;
                }
            }
        }
        return laagsteVeld;
    }
    
    /*
     * Begint bij het beginpunt en gaat elk veld af totdat het einde is gevonden
     * of er geen velden meer onbezocht zijn. Geeft elk veld een afstand van het beginpunt.
     * Als alle buren van het veld een afstand hebben wordt het veld verwijderd
     * uit de arrayList met onbezochte velden. Pakt vervolgens uit de overgebleven
     * onbezochte velden degene met de laagste afstand en begint opnieuw.
     */
    private boolean vindRoute (Veld start, Veld einde) {
        Veld huidigVeld = start;
        boolean gevonden = false;
        while (!gevonden) {
            if (bezochteVelden.contains(einde)) {
                gevonden = true;
            }
            else if (onbezochteVelden.isEmpty()) {
                return false;
            }
            else {
                ArrayList<Veld> buren = huidigVeld.getNeighbours();
                for (Veld veld : buren) {
                    if (veld != null) {
                        if (onbezochteVelden.contains(veld)) {
                            veld.setAfstand(huidigVeld.getAfstand() + 1);
                        }
                    }
                }
                bezochteVelden.add(huidigVeld);
                onbezochteVelden.remove(huidigVeld);
                if (!onbezochteVelden.isEmpty()) {
                    huidigVeld = vindLaagsteAfstand(onbezochteVelden);
                }
            }
        }
        return gevonden;
    }
    
    /*
     * Haalt de kortste route op en markeert dat deze onderdeel is van de route.
     */
    private void markeerRoute (Veld huidigVeld) {
            huidigVeld.isOnderdeelRoute(true);
            if (huidigVeld.getAfstand() != 0) {
                ArrayList<Veld> buren = huidigVeld.getNeighbours();
                Veld volgendVeld = vindLaagsteAfstand(buren);
                markeerRoute(volgendVeld);
            }
    }
}
