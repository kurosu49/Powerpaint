/*
 * TCS305 - Spring 2013
 * Assignment 5 - PowerPaint
 * 
 */


import java.awt.Color;
import java.awt.Graphics;

/**
 * The Line Tool for PowerPaint.
 * 
 * @author Crystal Miraflor
 * @version 1.00
 */
public class LineTool extends AbstractTool {
  
  /**
   * Constructs new Line tool.
   */
  public LineTool() {
    super();
  }
  
  /**
   * A constructor which gives the line tool a starting point
   * and an ending point.
   * 
   * @param the_start_x The starting x-coordinate.
   * @param the_start_y The starting y-coordinate.
   * @param the_end_x The ending x-coordinate.
   * @param the_end_y The ending y-coordinate.
   * @param the_color The color.
   */
  public LineTool(final int the_start_x, final int the_start_y, final int the_end_x,
                  final int the_end_y, final Color the_color) {
    super(the_start_x, the_start_y, the_end_x, the_end_y, the_color);
  }

  /**
   * Draws a line using this tool.
   * 
   * @param the_graphic The graphic.
   */
  @Override
  public void draw(final Graphics the_graphic) {
    the_graphic.setColor(getColor());
    the_graphic.drawLine(getStartX(), getStartY(), getEndX(), getEndY());

    
  }

 
  
  
}
