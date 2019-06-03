/**
 * @author Jerome, Adrien, Raphaël, Joachim
 * @version 1.0
 */
package main;

import java.io.IOException;

import controller.Run;

/**
 * The Class Main.
 *
 * @author Jerome, Adrien, Raphaël, Joachim
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException 
     */
    public static void main(final String[] args) throws IOException {
    	new Run();
        }
}
