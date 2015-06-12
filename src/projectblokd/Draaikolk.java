/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

/**
 *
 * @author Tim
 */
public class Draaikolk extends Water {
    
    public Draaikolk () {
        setImage("draaikolk.png");
    }
    
    @Override
    public boolean kanVerplaatsen (Held held) {
        return false;
    }
}
