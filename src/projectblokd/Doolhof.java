/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Color;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

/**
 *
 * @author Tim
 */
public class Doolhof extends JPanel {
    
    private int width;
    private int height;
    private int VELD_SIZE;
    
    private Knop resetKnop;
    
    Timer timer;
    JLabel scoreLabel;
    private int score;
    
    /* 1 = muur
     * 2 = held
     * 3 = vriend
     * 4 = cheater
     * 5 = helper
     * 6 = bazooka
     */
    private int[][] doolhofLayout = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 2, 1, 0, 5, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 0, 1, 0, 1, 6, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                     {1, 0, 4, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1},
                                     {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    
    private final int CHEATER_WAARDE = 10;
    
    public Doolhof (int width, int height) {
        this.width = width;
        this.height = height;
        init();
        maakScoreBoard();
        addResetKnop();
        maakDoolhof();
        startScoreTimer();
    }
    
    private void init () {
        setLayout(null);
        VELD_SIZE = width / doolhofLayout.length;
    }
    
    private void maakScoreBoard () {
        BufferedImage image = Spel.loadImage("sign.png");
        image = Spel.resizeImage(image, 100, 25);
        scoreLabel = new JLabel("tijd: 00:00", new ImageIcon(image), SwingConstants.LEFT);
        scoreLabel.setHorizontalTextPosition(JLabel.CENTER);
        scoreLabel.setVerticalTextPosition(JLabel.CENTER);
        scoreLabel.setForeground(Color.white);
        add(scoreLabel);
        scoreLabel.setLocation(30, 2);
        scoreLabel.setSize(100, 25);
        Font scoreFont = scoreLabel.getFont();
        scoreLabel.setFont(new Font(scoreFont.getFontName(), Font.PLAIN, 16));
    }
    
    private void addResetKnop () {
        resetKnop = new Knop("reset-sign.png", Knop.RESET);
        add(resetKnop);
        resetKnop.setSize(70, 25);
        resetKnop.setLocation(500, 2);
        resetKnop.addMouseListener(new KnopListener(this, resetKnop));
    }
    
    public void opnieuwStarten () {
        System.out.println("reset");
    }
    
    private void startScoreTimer () {
        timer = new Timer(1000, new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e) {
                verhoogScore();
                updateScore();
            }
            
            private void verhoogScore () {
                score ++;
            }
            
            private void updateScore () {
                int minuten = score / 60;
                int secondes = score % 60;
                scoreLabel.setText("tijd: " + String.format("%02d", minuten) + ":" + String.format("%02d", secondes));
            }
            
        });
        timer.start();
    }
    
    public void verlaagScore (int waarde) {
        if (score >= waarde) {
            score -= waarde;
        }
        else {
            score = 0;
        }
    }
    
    private void startKeyBoardListener (Held held) {
        setFocusable(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        KeyBoardListener KBListener = new KeyBoardListener(held);
        manager.addKeyEventDispatcher(KBListener);
    }
    
    private void maakDoolhof () {
        Veld[][] velden = new Veld[doolhofLayout.length][doolhofLayout.length];
        for (int y = 0; y < doolhofLayout.length; y++) {
            for (int x = 0; x < doolhofLayout[y].length; x++) {
                Veld veld = addVeld(x, y);
                addSpelItem(veld, doolhofLayout[y][x]);
                velden[y][x] = veld;
            }
        }
        voegBurenToe(velden);
    }
    
    private Veld addVeld (int x, int y) {
        int xCord = x * VELD_SIZE;
        int yCord = y * VELD_SIZE;
        Veld veld = new Veld();
        add(veld);
        veld.setSize(VELD_SIZE, VELD_SIZE);
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
            Cheater cheater = new Cheater(CHEATER_WAARDE, this);
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
    
    public void stopSpel () {
        Spel spel = (Spel) getParent();
        spel.stopSpel();
        timer.stop();
    }
}
