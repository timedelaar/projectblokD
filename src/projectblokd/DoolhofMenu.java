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
    private Knop terugKnop;
    private KnopListener terugListener;
    
    private final int KNOP_WIDTH = 200;
    private final int KNOP_HEIGHT = (int) (KNOP_WIDTH * 0.3125);

    public DoolhofMenu() {
        setLayout(null);
        background = ImageStorage.get().getImage("menu_bg.png");
        maakMaze1Knop();
        maakMaze2Knop();
        maakMaze3Knop();
        maakTerugKnop();
    }

    public final void maakMaze1Knop() {
        maze1Knop = new Knop("maze1-sign.png", Knop.MAZE1);
        add(maze1Knop);
        maze1Knop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        maze1Knop.setLocation(200, 75);
        maze1Listener = new KnopListener(this, maze1Knop);
        maze1Knop.addMouseListener(maze1Listener);
    }

    public final void maakMaze2Knop() {
        maze3Knop = new Knop("maze2-sign.png", Knop.MAZE2);
        add(maze3Knop);
        maze3Knop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        maze3Knop.setLocation(200, 250);
        maze3Listener = new KnopListener(this, maze3Knop);
        maze3Knop.addMouseListener(maze3Listener);
    }

    public final void maakMaze3Knop() {
        maze2Knop = new Knop("maze3-sign.png", Knop.MAZE3);
        add(maze2Knop);
        maze2Knop.setSize(new Dimension(KNOP_WIDTH, KNOP_HEIGHT));
        maze2Knop.setLocation(200, 425);
        maze2Listener = new KnopListener(this, maze2Knop);
        maze2Knop.addMouseListener(maze2Listener);
    }
    
    public final void maakTerugKnop () {
        terugKnop = new Knop("back-sign.png", Knop.TERUG);
        add(terugKnop);
        terugKnop.setSize(new Dimension(150, 47));
        terugKnop.setLocation(420, 530);
        terugListener = new KnopListener(this, terugKnop);
        terugKnop.addMouseListener(terugListener);
    }

    public void actie(Knop knop) {
        Spel spel = (Spel) getParent().getParent();
        if (knop.getActie() == Knop.MAZE1) {
            spel.startSpel("maze1");
        } else if (knop.getActie() == Knop.MAZE2) {
            spel.startSpel("maze2");
        } else if (knop.getActie() == Knop.MAZE3) {
            spel.startSpel("maze3");
        }
        else if (knop.getActie() == Knop.TERUG) {
            spel.toonMenu();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }
}
