/*
 * TCSS305 - Spring 2013
 * Assignment 5 - PowerPaint
 * 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;


/**
 * The GUI for PowerPaint.
 * 
 * @author Crystal Miraflor
 * @version 1.00
 *
 */
public class PowerPaintGUI2 {
  
  /**
   * Default ToolKit.
   */
  private static final Toolkit KIT = Toolkit.getDefaultToolkit();
  
  /**
   * Screen size of the computer.
   */
  private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
  
  /**
   * New width of the GUI.
   */
  private static final int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();
  
  /**
   * New height of the GUI.
   */
  private static final int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();
  
  /**
   * A constant for the highest tool index.
   */
  private static final int MAX_TOOL_INDEX = 3;
  
  /**
   * A constant for the max thickness.
   */
  private static final int MAX_THICKNESS = 4;
  
  /**
   * Main frame of the GUI.
   */
  private final JFrame my_frame;
  
  /**
   * Main panel of the GUI.
   */
  private final DrawingPanel my_panel;
  
  /**
   * Contains the actions of all tool buttons.
   */
  private List<ToolButtonAction> my_tool_action;
  
  /**
   * The menu bar.
   */
  private final PMenuBar my_menubar;
  
  /**
   * The tool bar.
   */
  private final PToolBar my_toolbar;
  
  /**
   * The color button for the tool bar.
   */
  private JButton my_color_button;
  
  /**
   * The color menu item for the menu bar.
   */
  private JMenuItem my_color_item;
  
  /**
   * Constructs new PowerPaintGUI object.
   * Initializes all instance fields.
   */
  public PowerPaintGUI2() {
    my_frame = new JFrame("TCSS 305 PowerPaint, Spring 2013");
    my_panel = new DrawingPanel();
    my_menubar = new PMenuBar();
    my_toolbar = new PToolBar();
  }
  
  /**
   * 
   */
  public void createToolActions() {
    my_tool_action = new ArrayList<ToolButtonAction>();
    my_tool_action.add(new ToolButtonAction("Pencil", KeyEvent.VK_P, 0));
    my_tool_action.add(new ToolButtonAction("Line", KeyEvent.VK_L, 1));
    my_tool_action.add(new ToolButtonAction("Rectangle", KeyEvent.VK_R, 2));
    my_tool_action.add(new ToolButtonAction("Ellipse", KeyEvent.VK_E, MAX_TOOL_INDEX));
  }

  /**
   * Creates and sets up the buttons and components
   * by adding them onto the frame. 
   */
  private void initialSetup() {

    my_frame.add(my_panel);
    final ColorButtonAction coloraction = new ColorButtonAction("Color...");
    my_color_button = new JButton(coloraction);
    my_color_item = new JMenuItem(coloraction);
    my_menubar.createFileButtons(my_panel);

    createToolActions();
    
    my_menubar.addColorMenu(my_color_item);
    my_toolbar.addColorButton(my_color_button);
    
    my_color_button.setBackground(Color.BLACK);
    my_color_item.setBackground(Color.BLACK);
    my_color_button.setForeground(Color.WHITE);
    my_color_item.setForeground(Color.WHITE);
    
    for (ToolButtonAction t : my_tool_action) {
      my_menubar.createToolButtons(t);
      my_toolbar.createToolToggleButton(t);
    }
    
    my_menubar.createThicknessButtons("1", KeyEvent.VK_1, my_panel, 1);
    my_menubar.createThicknessButtons("2", KeyEvent.VK_2, my_panel, 2);
    my_menubar.createThicknessButtons("4", KeyEvent.VK_4, my_panel, MAX_THICKNESS);
    my_menubar.setupOptionButtons(my_panel);
    my_menubar.createHelpButton();
    
    my_frame.setJMenuBar(my_menubar);
    my_frame.add(my_toolbar, BorderLayout.SOUTH);
    
  }
  
  /**
   * Basically creates the entire GUI.
   */
  public void start() {
    
    initialSetup();
    
    my_frame.pack();
    my_frame.setVisible(true);
    
    my_frame.setLocation(SCREEN_WIDTH / 2 - my_frame.getWidth() / 2, 
                         SCREEN_HEIGHT / 2 - my_frame.getHeight() / 2);
    
    my_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
  }
  
  /**
   * A class to create Actions for the tools
   * of PowerPaint.
   * 
   * @author Crystal Miraflor
   * @version 1.2
   *
   */
  @SuppressWarnings("serial")
  class ToolButtonAction extends AbstractAction {
    
    /**
     * The tool index.
     */
    private final int my_tool;
    
    /**
     * Constructs a new ToolButtonAction.
     * Basically creates an action of a tool that
     * can be assigned to a button. Sets the name
     * and mnemonic keys.
     * 
     * @param the_name The name.
     * @param the_mnemonic  The mnemonic.
     * @param the_index The index.
     */
    public ToolButtonAction(final String the_name, final int the_mnemonic, 
                            final int the_index) {
      super(the_name);
      my_tool = the_index;
      this.putValue(Action.NAME, the_name);
      this.putValue(Action.MNEMONIC_KEY, the_mnemonic);
      this.putValue(Action.SELECTED_KEY, true);
    }
    
    /**
     * Implements the action of the button.
     * 
     * @param the_action The action.
     */
    @Override
    public void actionPerformed(final ActionEvent the_action) {
      my_panel.setTool(my_tool);
      
    }
  }
  
  
  /**
   * A class to create the action for the 
   * color button.
   * 
   * @author Crystal Miraflor
   * @version 1.00
   *
   */
  @SuppressWarnings("serial")
  class ColorButtonAction extends AbstractAction {

    
    /**
     * Constructor for the ColorButtonAction.
     * Sets the name and mnemonic keys.
     * 
     * @param the_name The name.
     */
    public ColorButtonAction(final String the_name) {
      super(the_name);
      this.putValue(Action.NAME, the_name);
      this.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
      this.putValue(Action.SELECTED_KEY, true);
    }
    
    /**
     * The action of the color button. User selects a color
     * and that color is now set to the current color.
     * 
     * @param the_action The action. 
     */
    @Override
    public void actionPerformed(final ActionEvent the_action) {
      final Color result = JColorChooser.showDialog(my_panel, 
                                                    "Choose a Color.", my_panel.getColor());
      my_panel.setColor(result);
      if (result.equals(Color.BLACK)) {
        my_color_button.setForeground(Color.WHITE);
        my_color_item.setForeground(Color.WHITE);
      } else {
        my_color_button.setForeground(Color.BLACK);
        my_color_item.setForeground(Color.BLACK);
      }
      my_color_button.setBackground(result);
      my_color_item.setBackground(result); 
    }
  }
  
}
