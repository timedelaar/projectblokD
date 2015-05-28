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
 * @author Tim
 */
public class Menu extends JPanel {
    
    private BufferedImage background;
    private Knop startKnop;
    private KnopListener startListener;
    private Knop exitKnop;
    private KnopListener exitListener;
    
    private final int KNOP_WIDTH = 200;
    private final int KNOP_HEIGHT = (int) (KNOP_WIDTH * 0.3125);
    
    public Menu () {
        setLayout(null);
        background = Spel.loadImage("menu_bg.png");
        maakStartKnop();
        maakExitKnop();
    }
    
    public final void maakStartKnop () {
        startKnop = new Knop("start-sign.png", Knop.START);
        add(startKnop);
        startKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        startKnop.setLocation(200, 175);
        startListener = new KnopListener(this, startKnop);
        startKnop.addMouseListener(startListener);
    }
    
    public final void maakExitKnop () {
        exitKnop = new Knop("exit-sign.png", Knop.EXIT);
        add(exitKnop);
        exitKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        exitKnop.setLocation(200, 300);
        exitListener = new KnopListener(this, exitKnop);
        exitKnop.addMouseListener(exitListener);
    }
    
    public void actie (Knop knop) {
        Spel spel = (Spel) getParent();
        if (knop.getActie() == Knop.START) {
            deleteKnoppen();
            spel.startSpel();
        }
        else if (knop.getActie() == Knop.EXIT) {
            deleteKnoppen();
            spel.exit();
        }
    }
    
    private void deleteKnoppen () {
        startKnop.removeMouseListener(startListener);
        startListener = null;
        startKnop = null;
        exitKnop.removeMouseListener(exitListener);
        exitListener = null;
        exitKnop = null;
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(background, 0, 0, this);
    }
}
