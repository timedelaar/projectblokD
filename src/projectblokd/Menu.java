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
    
    public Menu () {
        setLayout(null);
        background = Spel.loadImage("menu_bg.png");
        maakStartKnop();
        maakExitKnop();
    }
    
    public final void maakStartKnop () {
        startKnop = new Knop("held.png");
        add(startKnop);
        startKnop.setSize(new Dimension(100, 40));
        startKnop.setLocation(100, 100);
        startListener = new KnopListener(this, startKnop);
        startKnop.addMouseListener(startListener);
    }
    
    public final void maakExitKnop () {
        exitKnop = new Knop("vriend.png");
        add(exitKnop);
        exitKnop.setSize(new Dimension(100, 40));
        exitKnop.setLocation(100, 200);
        exitListener = new KnopListener(this, exitKnop);
        exitKnop.addMouseListener(exitListener);
    }
    
    public void actie (Knop knop) {
        Spel spel = (Spel) getParent();
        if (knop.equals(startKnop)) {
            deleteKnoppen();
            spel.startSpel();
        }
        else if (knop.equals(exitKnop)) {
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
