/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;

/**
 *
 * @author Aymren
 */
public class MuurRand extends Muur {

    private BufferedImage image;

    public MuurRand() {
        image = Spel.loadImage("muur-rand.png");
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
