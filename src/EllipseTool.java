/*
 * TCSS305 - Spring 2013
 * Assignment 5 - PowerPaint
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


/**
 * The Ellipse Tool for PowerPaint.
 * 
 * @author Crystal Miraflor
 * @version 1.2
 *
 */
public class EllipseTool extends AbstractTool {
  
  /**
   * Default Ellipse Constructor.
   */
  public EllipseTool() {
    super();

  }

  /**
   * Constructs new Ellipse.
   *  
   * @param the_start_x The start x.
   * @param the_start_y The start y.
   * @param the_end_x The end x.
   * @param the_end_y The end y.
   * @param the_color The color.
   */
  public EllipseTool(final int the_start_x, final int the_start_y, final int the_end_x,
                  final int the_end_y, final Color the_color) {
    super(the_start_x, the_start_y, the_end_x, the_end_y, the_color);
  }
  
  /**
   * The drawing method of the ellipse.
   * 
   * @param the_graphic The graphic.
   */
  @Override
  public void draw(final Graphics the_graphic) {
    final Graphics2D graphic = (Graphics2D) the_graphic;
    graphic.setColor(getColor());

    calculate();
    final Shape ellipse = new Ellipse2D.Double(getRotatedX(), getRotatedY(),
                                               getWidth(), getHeight());
    graphic.draw(ellipse);
    
  }
 


}
