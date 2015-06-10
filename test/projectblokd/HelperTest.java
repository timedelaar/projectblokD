/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectblokd;

import java.util.Iterator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Tim
 */
public class HelperTest {
    
    public HelperTest () {
    }

    @BeforeClass
    public static void setUpClass () throws Exception {
    }

    @AfterClass
    public static void tearDownClass () throws Exception {
    }
    
    @Before
    public void setUp () {
    }
    
    @After
    public void tearDown () {
    }

    /**
     * Test of actie method, of class Helper.
     */
    @Test
    public void testActie () {
        System.out.println("actie");
        Held held = null;
        Iterator iter = null;
        Helper instance = new Helper();
        instance.actie(held, iter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
