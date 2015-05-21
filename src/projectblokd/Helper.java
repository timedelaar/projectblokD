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
        System.out.println("Toon snelste route");
    }
    
}
