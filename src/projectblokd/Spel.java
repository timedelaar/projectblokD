/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author Tim
 */
public class Spel extends JPanel {
    
    private Doolhof doolhof;
    
    public Spel () {
        init();
    }
    
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        setLayout(layout);
        doolhof = new Doolhof();
        doolhof.setPreferredSize(new Dimension(600, 600));
        add(doolhof);
    }
}
