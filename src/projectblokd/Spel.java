/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class Spel extends JPanel {
    
    
    private Doolhof doolhof;
    private Menu menu;
    private HelpMenu helpMenu;
    private DoolhofMenu doolhofMenu;
    private int width;
    private int height;
    private JPanel menus;
    private KeyBoardListener KBListener;
    
    public Spel (int width, int height) {
        this.width = width;
        this.height = height;
        setSize(width, height);
        init();
    }
    
    /*
     * Zet de layout, maakt de menu's en toon het hoofdmenu.
     */
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        createMenus();
        toonMenu();
    }
    
    /*
     * Maakt de menu's en voegt ze toe aan een card layout.
     */
    private void createMenus () {
        menu = new Menu();
        menu.setPreferredSize(new Dimension(width, height));
        helpMenu = new HelpMenu();
        helpMenu.setPreferredSize(new Dimension(width, height));
        doolhofMenu = new DoolhofMenu();
        doolhofMenu.setPreferredSize(new Dimension(width, height));
        
        menus = new JPanel(new CardLayout());
        menus.add(menu, "hoofdmenu");
        menus.add(helpMenu, "helpmenu");
        menus.add(doolhofMenu, "doolhofmenu");
        add(menus);
    }
    
    /*
     * Toont het hoofd menu
     */
    public void toonMenu () {
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "hoofdmenu");
    }
    
    /*
     * Toont het help menu
     */
    public void toonHelpMenu(){
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "helpmenu");
    }
    
    /*
     * Toon het doolhof selectie menu
     */
    public void toonDoolhofMenu () {
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "doolhofmenu");
    }
    
    /*
     * Maakt een nieuw doolhof object en voegt deze toe aan de card layout.
     */
    public void startSpel (String maze) {
        startKeyBoardListener();
        doolhof = new Doolhof(width, height, maze, KBListener);
        menus.add(doolhof, "doolhof");
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "doolhof");
    }
    
    /*
     * Stopt het spel en verwijderd het doolhof object van de card layout.
     */
    public void stopSpel (int score) {
        System.out.println("gewonnen");
        int minuten = score / 60;
        int secondes = score % 60;
        System.out.println("tijd: " + String.format("%02d", minuten) + ":" + String.format("%02d", secondes));
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "hoofdmenu");
        menus.remove(doolhof);
    }
    
    /*
     * verwijder het oude doolhof en maakt een nieuw doolhof object aan.
     */
    public void opnieuwStarten (String maze) {
        menus.remove(doolhof);
        startSpel(maze);
    }

    /*
     * Sluit het spel.
     */
    public void exit () {
        MainFrame frame = (MainFrame) getParent().getParent().getParent().getParent().getParent();
        frame.dispose();
    }
    
    /*
     * Start de keyboardlistener
     */
    private void startKeyBoardListener () {
        if (KBListener == null) {
            setFocusable(true);
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            KBListener = new KeyBoardListener();
            manager.addKeyEventDispatcher(KBListener);
        }
    }
}
