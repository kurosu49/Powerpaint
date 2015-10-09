/*
 * TCSS305 - Spring 2013
 * Assignment 5 - PowerPaint
 */

/**
 * Runs PowerPaint.
 * 
 * @author Crystal Miraflor
 * @version 1.00
 *
 */
public final class PowerPaintMain2 {

  /**
   * Constructor to override the default constructor.
   */
  private PowerPaintMain2() {
    //does nothing
  }
  
  /**
   * Main method that executes the GUI.
   * 
   * @param the_args Command line arguments.
   */
  public static void main(final String[] the_args) {
    final PowerPaintGUI2 gui = new PowerPaintGUI2();
    gui.start();
  }
  
}
