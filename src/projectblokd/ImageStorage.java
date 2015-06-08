/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Tim
 */
public class ImageStorage {
    
    private static ImageStorage single = new ImageStorage();
    
    private HashMap<String, BufferedImage> storage = new HashMap<>();
    
    public static ImageStorage get () {
        return single;
    }
    
    public BufferedImage getImage (String ref) {
        BufferedImage image = storage.get(ref);
        if (image != null) {
            return image;
        }
        else {
            image = Spel.loadImage(ref);
            storage.put(ref, image);
            return image;
        }
    }
    
    public void addImage (String ref, BufferedImage image) {
        storage.put(ref, image);
    }
}
