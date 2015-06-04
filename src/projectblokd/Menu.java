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
    private Knop helpKnop;
    private KnopListener helpListener;
    
    private final int KNOP_WIDTH = 200;
    private final int KNOP_HEIGHT = (int) (KNOP_WIDTH * 0.3125);
    
    public Menu () {
        setLayout(null);
        background = Spel.loadImage("menu_bg.png");
        maakStartKnop();
        maakHelpKnop();
        maakExitKnop();
    }
    
    public final void maakStartKnop () {
        startKnop = new Knop("start-sign.png", Knop.START);
        add(startKnop);
        startKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        startKnop.setLocation(200, 75);
        startListener = new KnopListener(this, startKnop);
        startKnop.addMouseListener(startListener);
    }
    public final void maakHelpKnop(){
        helpKnop = new Knop ("start-sign.png", Knop.HELP);
        add(helpKnop);
        helpKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        helpKnop.setLocation(200, 250);
        helpListener = new KnopListener(this, helpKnop);
        helpKnop.addMouseListener(helpListener);
    }
    public final void maakExitKnop () {
        exitKnop = new Knop("exit-sign.png", Knop.EXIT);
        add(exitKnop);
        exitKnop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        exitKnop.setLocation(200, 425);
        exitListener = new KnopListener(this, exitKnop);
        exitKnop.addMouseListener(exitListener);
    }
    
    public void actie (Knop knop) {
        Spel spel = (Spel) getParent().getParent();
        if (knop.getActie() == Knop.START) {
            spel.toonDoolhofMenu();
        }
        else if (knop.getActie() == Knop.HELP){
            spel.toonHelpMenu();
        }
        else if (knop.getActie() == Knop.EXIT) {
            spel.exit();
        }
    }
    
    @Override
    public void paintComponent (Graphics g) {
        g.drawImage(background, 0, 0, this);
    }
}
