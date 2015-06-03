/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class Spel extends JPanel {
    
    
    private Doolhof doolhof;
    private Menu menu;
    private HelpMenu helpMenu;
    private DoolhofMenu doolhofMenu;
    private int width;
    private int height;
    
    public Spel (int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }
    
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        setLayout(layout);
        toonMenu();
    }
    
    public void toonMenu () {
        menu = new Menu();
        add(menu);
        menu.setPreferredSize(new Dimension(width, height));
    }
    public void toonHelpMenu(){
        remove(menu);
        menu = null;
        
        helpMenu = new HelpMenu();
        add(helpMenu);
        helpMenu.setPreferredSize(new Dimension(width, height));
        repaint();
    }
    
    public void toonDoolhofMenu () {
        remove(menu);
        menu = null;

        doolhofMenu = new DoolhofMenu();
        add(doolhofMenu);
        doolhofMenu.setPreferredSize(new Dimension(width, height));
        repaint();
    }
    
    public void startSpel () {
        remove(menu);
        menu = null;
        startDoolhof();
        repaint();
    }
    
    private void startDoolhof () {
        doolhof = new Doolhof(width, height);
        doolhof.setPreferredSize(new Dimension(width, height));
        add(doolhof);
    }
    
    public void stopSpel () {
        System.out.println("gewonnen");
    }
    
    public void opnieuwStarten () {
        System.out.println("reset doolhof");
    }

    public void exit () {
        
    }
    
    public static BufferedImage loadImage (String ref) {
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
    
    public static BufferedImage resizeImage (BufferedImage image, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
        return resizedImage;
    }
    
    public static BufferedImage addTransparency (BufferedImage image, float t) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = newImage.createGraphics();
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, t);
        g2.setComposite(ac);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return newImage;
    }
}
