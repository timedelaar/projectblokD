/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author Tim
 */
public class Helper extends PowerUp {

    private Held held;
    private ArrayList<Veld> onbezochteVelden;
    private ArrayList<Veld> bezochteVelden;
    
    private Veld einde;
    
    public Helper () {
        setImage(Spel.loadImage("helper.png"));
        onbezochteVelden = new ArrayList<>();
        bezochteVelden = new ArrayList<>();
    }
    
    @Override
    public void actie (Held held, Iterator iter) {
        this.held = held;
        Veld start = getVeld();
        start.setAfstand(0);
        vulOnbezochteVelden(start);
        if (vindRoute(start, einde)) {
            markeerRoute(einde);
        }
        iter.remove();
    }
    
    private void vulOnbezochteVelden (Veld huidigVeld) {
        Richtingen[] richtingen = {Richtingen.NORTH, Richtingen.EAST, Richtingen.SOUTH, Richtingen.WEST};
        for (Richtingen richting : richtingen) {
            Veld veld = huidigVeld.getNeighbour(richting);
            if (veld != null) {
                if (veld.kanVerplaatsen(held) && !onbezochteVelden.contains(veld)) {
                    onbezochteVelden.add(veld);
                    vulOnbezochteVelden(veld);
                    if (veld.hasVriend())
                        einde = veld;
                }
            }
        }
    }
    
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
    
    private void markeerRoute (Veld huidigVeld) {
            huidigVeld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            if (huidigVeld.getAfstand() != 0) {
                ArrayList<Veld> buren = huidigVeld.getNeighbours();
                Veld volgendVeld = vindLaagsteAfstand(buren);
                markeerRoute(volgendVeld);
            }
    }
}
