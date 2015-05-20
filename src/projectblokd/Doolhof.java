/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Dimension;
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
    private int[][] doolhof = {{1, 1, 1, 1},
                               {1, 0, 0, 1},
                               {1, 0, 0, 1},
                               {1, 1, 0, 1}};
    
    public Doolhof () {
        init();
        startScoreTimer();
        startKeyBoardListener();
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
    
    private void startKeyBoardListener () {
        setFocusable(true);
        KeyBoardListener KBListener = new KeyBoardListener(new Held());
        addKeyListener(KBListener);
    }
    
    private void maakDoolhof () {
        Veld[][] velden = new Veld[doolhof.length][doolhof.length];
        for (int y = 0; y < doolhof.length; y++) {
            for (int x = 0; x < doolhof[y].length; x++) {
                int xCord = x * 30 + 100;
                int yCord = y * 30 + 100;
                Veld veld = new Veld();
                add(veld);
                veld.setSize(new Dimension(30, 30));
                veld.setLocation(xCord, yCord);
                velden[y][x] = veld;
            }
        }
        
        voegBurenToe(velden);
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
