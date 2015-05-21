/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class MainFrame extends JFrame {
    
    private final int FRAME_WIDTH = 606;
    private final int FRAME_HEIGHT = 629;
    
    private final int SPEL_WIDTH = 600;
    private final int SPEL_HEIGHT = 600;
    
    public MainFrame () {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("(A)Mazing");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        addSpel();
    }
    
    private void addSpel () {
        Spel spel = new Spel(SPEL_WIDTH, SPEL_HEIGHT);
        spel.setSize(SPEL_WIDTH, SPEL_HEIGHT);
        
        JPanel panel = new JPanel();
        FlowLayout layout = (FlowLayout) panel.getLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        panel.add(spel);
        
        add(panel);
    }
    
}
