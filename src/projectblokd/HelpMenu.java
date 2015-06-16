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
    
    private final int KNOP_WIDTH = 150;
    private final int KNOP_HEIGHT = (int) (KNOP_WIDTH * 0.3125);
    
    public HelpMenu () {
        setLayout(null);
        background = ImageStorage.get().getImage("helpmenu_bg.png");
        maakTerugKnop();
    }
    
    public final void maakTerugKnop () {
        terugKnop = new Knop("back-sign.png", Knop.TERUG);
        add(terugKnop);
        terugKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        terugKnop.setLocation(420, 530);
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
