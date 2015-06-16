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
    
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        createMenus();
        toonMenu();
    }
    
    public void createMenus () {
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
    
    public void toonMenu () {
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "hoofdmenu");
    }
    
    public void toonHelpMenu(){
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "helpmenu");
    }
    
    public void toonDoolhofMenu () {
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "doolhofmenu");
    }
    
    public void startSpel (String maze) {
        startKeyBoardListener();
        doolhof = new Doolhof(width, height, maze, KBListener);
        menus.add(doolhof, "doolhof");
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "doolhof");
    }
    
    public void stopSpel (int score) {
        System.out.println("gewonnen");
        int minuten = score / 60;
        int secondes = score % 60;
        System.out.println("tijd: " + String.format("%02d", minuten) + ":" + String.format("%02d", secondes));
        CardLayout cl = (CardLayout) menus.getLayout();
        cl.show(menus, "hoofdmenu");
        menus.remove(doolhof);
    }
    
    public void opnieuwStarten (String maze) {
        menus.remove(doolhof);
        startSpel(maze);
    }

    public void exit () {
        MainFrame frame = (MainFrame) getParent().getParent().getParent().getParent().getParent();
        frame.dispose();
    }
    
    private void startKeyBoardListener () {
        if (KBListener == null) {
            setFocusable(true);
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            KBListener = new KeyBoardListener();
            manager.addKeyEventDispatcher(KBListener);
        }
    }
}
