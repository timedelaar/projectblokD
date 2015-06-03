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
public class DoolhofMenu extends JPanel {

    private BufferedImage background;
    private Knop maze1Knop;
    private KnopListener maze1Listener;
    private Knop maze2Knop;
    private KnopListener maze2Listener;
    private Knop maze3Knop;
    private KnopListener maze3Listener;
    
    private final int KNOP_WIDTH = 200;
    private final int KNOP_HEIGHT = (int) (KNOP_WIDTH * 0.3125);

    public DoolhofMenu() {
        setLayout(null);
        background = Spel.loadImage("menu_bg.png");
        maakMaze1Knop();
        maakMaze2Knop();
        maakMaze3Knop();
    }

    public final void maakMaze1Knop() {
        maze1Knop = new Knop("maze1-sign.png", Knop.START);
        add(maze1Knop);
        maze1Knop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        maze1Knop.setLocation(200, 75);
        maze1Listener = new KnopListener(this, maze1Knop);
        maze1Knop.addMouseListener(maze1Listener);
    }

    public final void maakMaze2Knop() {
        maze3Knop = new Knop("maze2-sign.png", Knop.HELP);
        add(maze3Knop);
        maze3Knop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        maze3Knop.setLocation(200, 250);
        maze3Listener = new KnopListener(this, maze3Knop);
        maze3Knop.addMouseListener(maze3Listener);
    }

    public final void maakMaze3Knop() {
        maze2Knop = new Knop("maze3-sign.png", Knop.EXIT);
        add(maze2Knop);
        maze2Knop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        maze2Knop.setLocation(200, 425);
        maze2Listener = new KnopListener(this, maze2Knop);
        maze2Knop.addMouseListener(maze2Listener);
    }

    public void actie(Knop knop) {
        Spel spel = (Spel) getParent();
        if (knop.getActie() == Knop.MAZE1) {
            deleteKnoppen();
            spel.startSpel();
        } else if (knop.getActie() == Knop.MAZE2) {
            deleteKnoppen();
            //start doolhof2
        } else if (knop.getActie() == Knop.MAZE3) {
            deleteKnoppen();
            //start doolhof3
        }
    }

    private void deleteKnoppen() {
        maze1Knop.removeMouseListener(maze1Listener);
        maze1Listener = null;
        maze1Knop = null;
        maze2Knop.removeMouseListener(maze2Listener);
        maze2Listener = null;
        maze2Knop = null;
        maze3Knop.removeMouseListener(maze3Listener);
        maze3Listener = null;
        maze3Knop = null;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }
}
