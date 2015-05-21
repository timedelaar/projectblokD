/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class Doolhof extends JPanel {
    
    Timer timer;
    private int minuten;
    private int secondes;
    private int[][] doolhof = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                               {1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                               {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    public Doolhof () {
        init();
        startScoreTimer();
        maakDoolhof();
    }
    
    private void init () {
        setLayout(null);
    }
    
    private void startScoreTimer () {
        timer = new Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e) {
                verhoogScore();
            }
            
            private void verhoogScore () {
                secondes ++;
                if (secondes == 60) {
                    minuten ++;
                    secondes = 0;
                }
            }
            
        });
        timer.start();
    }
    
    private void startKeyBoardListener (Held held) {
        setFocusable(true);
        KeyBoardListener KBListener = new KeyBoardListener(held);
        addKeyListener(KBListener);
    }
    
    private void maakDoolhof () {
        Veld[][] velden = new Veld[doolhof.length][doolhof.length];
        for (int y = 0; y < doolhof.length; y++) {
            for (int x = 0; x < doolhof[y].length; x++) {
                Veld veld = addVeld(x, y);
                addSpelItem(veld, doolhof[y][x]);
                velden[y][x] = veld;
            }
        }
        voegBurenToe(velden);
    }
    
    private Veld addVeld (int x, int y) {
        int xCord = x * 30 + 100;
        int yCord = y * 30 + 100;
        Veld veld = new Veld();
        add(veld);
        veld.setSize(30, 30);
        veld.setLocation(xCord, yCord);
        return veld;
    }
    
    private void addSpelItem (Veld veld, int item) {
        if (item == 1) {
            Muur muur = new Muur();
            veld.setSpelItem(muur);
        }
        else if (item == 2) {
            Held held = new Held(this);
            veld.setSpelItem(held);
            startKeyBoardListener(held);
        }
        else if (item == 3) {
            Vriend vriend = new Vriend();
            veld.setSpelItem(vriend);
        }
        else if (item == 4) {
            Cheater cheater = new Cheater();
            veld.setSpelItem(cheater);
        }
        else if (item == 5) {
            Helper helper = new Helper();
            veld.setSpelItem(helper);
        }
        else if (item == 6) {
            Bazooka bazooka = new Bazooka();
            veld.setSpelItem(bazooka);
        }
    }
    
    private void voegBurenToe (Veld[][] velden) {
        for (int y = 0; y < velden.length; y++) {
            for (int x = 0; x < velden[y].length; x++) {
                if (y > 0) {
                    velden[y][x].setNeighbour(Richtingen.NORTH, velden[y-1][x]);
                }
                if (y < velden.length-1) {
                    velden[y][x].setNeighbour(Richtingen.SOUTH, velden[y+1][x]);
                }
                if (x > 0) {
                    velden[y][x].setNeighbour(Richtingen.WEST, velden[y][x-1]);
                }
                if (x < velden.length-1) {
                    velden[y][x].setNeighbour(Richtingen.EAST, velden[y][x+1]);
                }
            }
        }
    }
}
