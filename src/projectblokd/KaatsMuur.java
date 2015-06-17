/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class KaatsMuur extends Muur {
    
    public KaatsMuur () {
        setImage("kaats-muur.png");
    }
    
    /*
     * Draait de kogel om.
     */
    @Override
    public boolean kanVerplaatsen (Kogel kogel) {
        kogel.omdraaien();
        return true;
    }
}
