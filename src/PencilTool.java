/*
 * TCSS305 - Spring 2013
 * Assignment 5 - PowerPaint
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 * The Pencil tool for PowerPaint.
 * 
 * @author Crystal Miraflor
 * @version 1.2
 *
 */
public class PencilTool extends AbstractTool {  

  /**
   * The path of the pencil drawing.
   */
  private GeneralPath my_drawing;
  
  /**
   * Constructs a default pencil tool.
   */
  public PencilTool() {
    super();
    
  }
  
  /**
   * Creates a new pencil tool to start drawing at
   * the specified point.
   * 
   * @param the_start_x The starting x-coordinate.
   * @param the_start_y The starting y-coordinate.
   * @param the_end_x The ending x-coordinate.
   * @param the_end_y The ending y-coordinate.
   * @param the_color The color.
   */
  public PencilTool(final int the_start_x, final int the_start_y, final int the_end_x,
                  final int the_end_y, final Color the_color) {
    super(the_start_x, the_start_y, the_end_x, the_end_y, the_color);
    my_drawing = new GeneralPath();
  }
  

  /**
   * A method for the pencil to draw. 
   * 
   * @param the_graphic The graphic.
   */
  @Override
  public void draw(final Graphics the_graphic) {
    final Graphics2D graphic = (Graphics2D) the_graphic;
    graphic.setColor(getColor());
    if (my_drawing.getCurrentPoint() == null) {
      my_drawing.moveTo(getEndX(), getEndY());
    } else {
      my_drawing.lineTo(getEndX(), getEndY());
      my_drawing.moveTo(getEndX(), getEndY());
    }
    
    graphic.draw(my_drawing);
  }

  
}
