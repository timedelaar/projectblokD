/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Tim
 */
public class Doolhof extends JPanel {
    
    private int width;
    private int height;
    private int veldSize;
    private String currentMaze;
    
    private Knop resetKnop;
    
    Timer timer;
    JLabel scoreLabel;
    private int score;
    
    /* Dit is de 2D array om alle objecten een nummer/waarde toe te kennen
     * De daadwerkelijke doolhof wordt in de methode maakDoolhof gemaakt.
     * 1 = zwakke muur
     * 2 = held
     * 3 = vriend
     * 4 = cheater
     * 5 = helper
     * 6 = bazooka
     * 7 = muurrand
     * 8 = dak
     * 9 = water
     * 10 = boot
     * 11 = sterke muur
     * 12 = draaikolk
     * 13 = kaats muur
     * 14 = ladder
     */
    private int[][] defaultLayout = {{ 7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7},
                                     { 7, 11, 11, 11, 11, 11, 11, 11, 11, 11,  3,  0,  0,  0,  0,  0,  0,  0, 11,  7},
                                     { 7,  2,  0,  0,  0,  0, 11, 11, 14, 11, 11, 11, 11, 11, 11, 11, 11,  0, 11,  7},
                                     { 7, 11,  0, 11, 11,  0,  0,  0,  0, 11,  0,  0,  0,  0,  0,  0, 12,  1, 11,  7},
                                     { 7, 11,  0, 11, 11, 11, 11, 11,  0, 11,  0, 11, 11,  6, 11,  0, 12,  0, 11,  7},
                                     { 7, 11,  0, 11, 11, 11,  4,  0,  0, 11,  0, 11, 11,  6,  0,  0, 12,  0, 11,  7},
                                     { 7, 10,  0,  9, 11, 11, 11, 11,  0, 11,  0, 11, 11, 11, 11,  0, 12,  0, 11,  7},
                                     { 7, 11,  9,  9,  9,  9, 11,  6,  0,  1,  0,  0,  0,  0,  0,  0, 12,  0, 11,  7},
                                     { 7, 12,  9,  9,  9,  9, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,  1, 11,  7},
                                     { 7, 12,  9,  9,  9,  9,  0,  0,  0, 11,  4,  0,  5, 11, 11,  0, 11,  0,  8,  7},
                                     { 7, 12,  9, 12,  9,  9,  9, 11,  5, 11,  0,  0, 11, 11, 11,  0, 11,  9,  8,  7},
                                     { 7, 12,  9, 12,  9,  9,  9, 11, 11, 11, 11,  0, 11,  4, 11,  9,  9,  9,  8,  7},
                                     { 7, 12,  9,  9,  9,  9,  9, 11,  4, 11, 11,  0, 11,  0,  0,  9, 11, 11,  8,  7},
                                     { 7, 12,  9,  9,  9,  9, 11, 11,  9, 11, 11,  0, 11,  0,  0,  9, 11, 11,  4,  7},
                                     { 7, 12,  9,  9,  9,  9,  9,  9,  9, 11, 11,  0, 11,  0, 11,  9, 11,  4, 11,  7},
                                     { 7,  9,  9,  9,  9,  9, 11, 11,  1, 11,  0,  0, 11,  0, 11,  9, 11,  9, 11,  7},
                                     { 7,  9,  9,  9,  9,  9,  9, 11,  0, 11, 11,  0,  0,  0, 11,  9,  9,  9, 11,  7},
                                     { 7,  9, 14, 11, 11, 11, 11, 11,  0, 11, 11, 11, 11, 11, 11,  9, 11,  9, 11,  7},
                                     { 7,  9,  0,  6, 11,  6,  9,  9,  0,  0,  0,  0,  0,  0,  0,  0, 13, 11, 11,  7},
                                     { 7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7,  7}};
    
    private int[][] doolhofLayout;
    
    private final int CHEATER_WAARDE = 10;
    
    public Doolhof (int width, int height, String maze, KeyBoardListener KBListener) {
        this.width = width;
        this.height = height;
        currentMaze = maze;
        init();
        maakScoreBoard();
        addResetKnop();
        maakDoolhof(KBListener);
        startScoreTimer();
    }
    
    private void init () {
        setLayout(null);
        try {
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(currentMaze + ".txt"));
            doolhofLayout = (int[][]) inStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
            doolhofLayout = defaultLayout;
        }
        if (width <= height) {
            veldSize = width / doolhofLayout.length;
        }
        else {
            veldSize = height / doolhofLayout.length;
        }
    }
    
   /* De methode maakScoreboard wordt er een image gemaakt met timer bovenop getekend
    * Hierbij is een JLabel gebruikt en is er wat positionering toegepast
    */
    private void maakScoreBoard () {
        BufferedImage image = ImageStorage.get().getImage("sign.png");
        image = ImageStorage.get().resizeImage("score-sign", image, 100, 25);
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
    
   /* De methode opnieuwstarten roept de class Spel (door twee niveaus omhoog te gaan)
    * In spel wordt weer de methode opnieuwStarten aangeroepen
    */
    public void opnieuwStarten () {
        Spel spel = (Spel) getParent().getParent();
        spel.opnieuwStarten(currentMaze);
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
    
    /* Leest de tweedimensionale array en maakt de velden aan.
     * Roept vervolgens addSpelItem aan voor elk veld om de spelItems toe te voegen.
     * Slaat de velden tijdelijk op in een tweedimensionale array om de buren
     * aan elk veld toe te kennen. En roept daarna voegExitsToe aan om alle exits
     * toe te kennen aan de ladders.
     */
    private void maakDoolhof (KeyBoardListener KBListener) {
        Veld[][] velden = new Veld[doolhofLayout.length][doolhofLayout.length];
        for (int y = 0; y < doolhofLayout.length; y++) {
            for (int x = 0; x < doolhofLayout[y].length; x++) {
                Veld veld = addVeld(x, y);
                addSpelItem(veld, doolhofLayout[y][x], KBListener);
                velden[y][x] = veld;
            }
        }
        voegBurenToe(velden);
        voegExitsToe(velden);
    }
    
    /* Tekent het veld op de juiste plaats.
     * return - het zojuist aangemaakte veld.
     */
    private Veld addVeld (int x, int y) {
        int xCord = x * veldSize;
        int yCord = y * veldSize;
        Veld veld = new Veld();
        add(veld);
        veld.setSize(veldSize, veldSize);
        veld.setLocation(xCord, yCord);
        return veld;
    }
    
    /*
     * Checkt of een spelItem toegevoegd moet worden aan het veld.
     * Zo ja, voegt het spelItem toe. Als het spelItem de held is, linkt de 
     * keyboardlistener aan de held.
     */
    private void addSpelItem (Veld veld, int item, KeyBoardListener KBListener) {
        if (item == 1) {
            ZwakkeMuur muur = new ZwakkeMuur();
            veld.addSpelItem(muur);
        }
        else if (item == 2) {
            Held held = new Held();
            KBListener.setHeld(held);
            veld.addSpelItem(held);
        }
        else if (item == 3) {
            Vriend vriend = new Vriend(this);
            veld.addSpelItem(vriend);
        }
        else if (item == 4) {
            Cheater cheater = new Cheater(CHEATER_WAARDE, this);
            veld.addSpelItem(cheater);
        }
        else if (item == 5) {
            Helper helper = new Helper();
            veld.addSpelItem(helper);
        }
        else if (item == 6) {
            Bazooka bazooka = new Bazooka();
            veld.addSpelItem(bazooka);
        }
        else if (item == 7) {
            Muur muur = new Muur();
            veld.addSpelItem(muur);
        }
        else if (item == 8) {
            Dak dak = new Dak();
            veld.addSpelItem(dak);
        }
        else if (item == 9) {
            Water water = new Water();
            veld.addSpelItem(water);
        }
        else if (item == 10) {
            Boot boot = new Boot();
            veld.addSpelItem(boot);
        }
        else if (item == 11) {
            SterkeMuur sterkeMuur = new SterkeMuur();
            veld.addSpelItem(sterkeMuur);
        }
        else if (item == 12) {
            Water water = new Water();
            veld.addSpelItem(water);
            Draaikolk draaikolk = new Draaikolk();
            veld.addSpelItem(draaikolk);
        }
        else if (item == 13) {
            KaatsMuur kaatsMuur = new KaatsMuur();
            veld.addSpelItem(kaatsMuur);
        }
        else if (item == 14) {
            Ladder ladder = new Ladder();
            veld.addSpelItem(ladder);
        }
    }
    
    /* Voegt de buren toe aan alle velden.
     * Elk veld weet welke velden er aangrenzend liggen.
     */
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
    
    /* Voegt de exits toe aan de ladders.
     * Maakt eerst een arrayList met alle velden die een ladder bevatten.
     * Vervolgens wordt die array in elke ladder opgeslagen.
     */
    private void voegExitsToe (Veld[][] velden) {
        ArrayList<Veld> exits = new ArrayList<>();
        for (int y = 0; y < velden.length; y++) {
            for (int x = 0; x < velden[y].length; x++) {
                if (velden[y][x].hasLadder()) {
                    exits.add(velden[y][x]);
                }
            }
        }
        for (Veld exit : exits) {
            Ladder ladder = exit.getLadder();
            if (ladder != null) {
                ladder.setExits(exits);
            }
        }
    }
    /*
     * Roept stopSpel aan in de klasse Spel.
     */
    public void stopSpel () {
        Spel spel = (Spel) getParent().getParent();
        spel.stopSpel(score);
        timer.stop();
    }
}
