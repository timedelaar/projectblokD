/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;

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
    
    /*
     * Controleert of de opgegeven referentie voorkomt in de opslag.
     * Zo ja, return het plaatje.
     * Zo nee, laad het plaatje en sla deze op in de opslag.
     * return vervolgens het plaatje.
     */
    public BufferedImage getImage (String ref) {
        BufferedImage image = storage.get(ref);
        if (image != null) {
            return image;
        }
        else {
            image = loadImage(ref);
            storage.put(ref, image);
            return image;
        }
    }
    
    /*
     * Slaat een plaatje op in de opslag onder de gegeven referentie.
     */
    public void addImage (String ref, BufferedImage image) {
        storage.put(ref, image);
    }
    
    /*
     * Laadt een plaatje doormiddel van de gegeven referentie.
     */
    public BufferedImage loadImage (String ref) {
        BufferedImage image = null;
        try {
            URL url = Spel.class.getClassLoader().getResource("images/" + ref);
            image = ImageIO.read(url);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return image;
    }
    
    /*
     * Resized een plaatje en slaat deze op in de opslag.
     */
    public BufferedImage resizeImage (String newRef, BufferedImage image, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
        storage.put(newRef, resizedImage);
        return resizedImage;
    }
}
