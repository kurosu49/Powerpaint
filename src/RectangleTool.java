/*
 * TCSS305 - Spring 2013
 * Assignment 5 - PowerPaint
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * The Rectangle tool for PowerPaint.
 * 
 * @author Crystal Miraflor
 * @version 1.2
 *
 */
public class RectangleTool extends AbstractTool {
  
  /**
   * The Rectangle tool.
   */
  public RectangleTool() {
    super();
  }

  /**
   * Creates a new rectangle tool and starts
   * drawing from these points.
   * 
   * @param the_start_x The starting x-coordinate.
   * @param the_start_y The starting y-coordinate.
   * @param the_end_x The ending x-coordinate.
   * @param the_end_y The ending y-coordinate.
   * @param the_color The color.
   */
  public RectangleTool(final int the_start_x, final int the_start_y, final int the_end_x,
                       final int the_end_y, final Color the_color) {
    super(the_start_x, the_start_y, the_end_x, the_end_y, the_color);
  }
  
  /**
   * Draws the rectangle.
   * 
   * @param the_graphic The graphic.
   * 
   */
  @Override
  public void draw(final Graphics the_graphic) {
    final Graphics2D graphic = (Graphics2D) the_graphic;
    graphic.setColor(getColor());
    
    calculate();

    final Shape rect = new Rectangle2D.Double(getRotatedX(), getRotatedY(), 
                                              getWidth(), getHeight());
    graphic.draw(rect);
    

  }

  

  
}
