/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.*;
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
    private JPanel menus;
    
    public Spel (int width, int height) {
        this.width = width;
        this.height = height;
        setSize(width, height);
        init();
    }
    
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        createMenus();
        toonMenu();
    }
    
    public void createMenus () {
        menu = new Menu();
        menu.setPreferredSize(new Dimension(width, height));
        helpMenu = new HelpMenu();
        helpMenu.setPreferredSize(new Dimension(width, height));
        doolhofMenu = new DoolhofMenu();
        doolhofMenu.setPreferredSize(new Dimension(width, height));
        
        menus = new JPanel(new CardLayout());
        menus.add(menu, "hoofdmenu");
        menus.add(helpMenu, "helpmenu");
        menus.add(doolhofMenu, "doolhofmenu");
        add(menus);
    }
    
    public void toonMenu () {
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "hoofdmenu");
    }
    
    public void toonHelpMenu(){
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "helpmenu");
    }
    
    public void toonDoolhofMenu () {
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "doolhofmenu");
    }
    
    public void startSpel () {
        doolhof = new Doolhof(width, height, "maze1");
        menus.add(doolhof, "doolhof");
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "doolhof");
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
