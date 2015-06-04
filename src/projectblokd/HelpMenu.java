/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Aymren
 */
public class HelpMenu extends JPanel {
    
    private BufferedImage background;
    private Knop terugKnop;
    private KnopListener terugListener;
    
    private final int KNOP_WIDTH = 200;
    private final int KNOP_HEIGHT = (int) (KNOP_WIDTH * 0.3125);
    
    public HelpMenu () {
        setLayout(null);
        background = Spel.loadImage("menu_bg.png");
        maakTerugKnop();
    }
    
    public final void maakTerugKnop () {
        terugKnop = new Knop("exit-sign.png", Knop.TERUG);
        add(terugKnop);
        terugKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        terugKnop.setLocation(50, 10);
        terugListener = new KnopListener(this, terugKnop);
        terugKnop.addMouseListener(terugListener);
    }
    
    public void actie (Knop knop) {
        Spel spel = (Spel) getParent().getParent();
        if (knop.getActie() == Knop.TERUG) {
            spel.toonMenu();
        }
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(background, 0, 0, this);
    }
}
