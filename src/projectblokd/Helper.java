/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.Iterator;

/**
 *
 * @author Tim
 */
public class Helper extends PowerUp {

    private Held held;
    
    public Helper () {
        setImage(Spel.loadImage("helper.png"));
    }
    
    @Override
    public void actie (Held held, Iterator iter) {
        this.held = held;
        Veld veld = getVeld();
        vindRoute(veld);
        iter.remove();
    }
    
    private boolean vindRoute(Veld veld) {
        if (veld.hasVriend()) {
            veld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            return true;
        }
        if (!veld.kanVerplaatsen(held) || veld.getOnderdeelRoute() == RouteState.GEWEEST) {
            return false;
        }
        veld.isOnderdeelRoute(RouteState.GEWEEST);
        Veld volgendVeld = veld.getNeighbour(Richtingen.NORTH);
        if (vindRoute(volgendVeld)) {
            veld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            return true;
        }
        volgendVeld = veld.getNeighbour(Richtingen.EAST);
        if (vindRoute(volgendVeld)) {
            veld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            return true;
        }
        volgendVeld = veld.getNeighbour(Richtingen.SOUTH);
        if (vindRoute(volgendVeld)) {
            veld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            return true;
        }
        volgendVeld = veld.getNeighbour(Richtingen.WEST);
        if (vindRoute(volgendVeld)) {
            veld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            return true;
        }
        veld.isOnderdeelRoute(RouteState.GEENONDERDEEL);
        return false;
    }
}
