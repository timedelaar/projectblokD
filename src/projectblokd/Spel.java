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
    private int width;
    private int height;
    
    public Spel (int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }
    
    private void init () {
        FlowLayout layout = (FlowLayout) getLayout();
        layout.setVgap(0);
        layout.setHgap(0);
        setLayout(layout);
        doolhof = new Doolhof(width, height);
        System.out.println(getWidth());
        doolhof.setPreferredSize(new Dimension(width, height));
        add(doolhof);
    }
}
