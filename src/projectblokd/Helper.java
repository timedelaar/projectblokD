/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class Helper extends PowerUp {

    public Helper () {
        setImage(Spel.loadImage("helper.png"));
    }
    
    @Override
    public void actie () {
        Veld veld = getVeld();
        System.out.println(vindRoute(veld));
    }
    
    private boolean vindRoute(Veld veld) {
        SpelItem item = veld.getSpelItem();
        if (item instanceof Vriend) {
            veld.isOnderdeelRoute(RouteState.WELONDERDEEL);
            return true;
        }
        if (item instanceof Muur || veld.getOnderdeelRoute() == RouteState.GEWEEST) {
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
