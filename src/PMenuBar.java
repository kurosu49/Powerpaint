/*
 * TCSS305 - Spring 2013
 * Assignment 5 - PowerPaint
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;


/**
 * Menu Bar class.
 * 
 * @author Crystal Miraflor
 * @version 1.00
 *
 */
@SuppressWarnings("serial")
public class PMenuBar extends JMenuBar {
  
  /**
   * Default thickness to be set.
   */
  private static final String MY_DEFAULT_THICKNESS = "1";
  
  /**
   * The main menus for PowerPaint.
   */
  private final JMenu[] my_main_menus = new JMenu[] {new JMenu("File") , new JMenu("Options"), 
                                                     new JMenu("Tools")};
  /**
   * The help menu.
   */
  private final JMenu my_help_menu;
  
  /**
   * The thickness menu.
   */
  private final JMenu my_thickness_menu;
  
  /**
   * A Button group to hold all tool buttons.
   */
  private final ButtonGroup my_tool_buttons;
 
  /**
   * A Button group to hold all file menu items.
   */
  private final ButtonGroup my_file_items;
  
  /**
   * A Button group to hold all thickness buttons.
   */
  private final ButtonGroup my_thickness_buttons;
  
  /**
   * Constructor. Creates new MenuBar for PowerPaint.
   * 
   */
  public PMenuBar() {
    super();
    my_help_menu = new JMenu("Help");
    my_tool_buttons = new ButtonGroup();
    my_thickness_menu = new JMenu("Thickness");
    my_file_items = new ButtonGroup();
    my_thickness_buttons = new ButtonGroup();
    addButtons();
  }
  
  /**
   * Adds buttons onto the menu bar.
   */
  private void addButtons() {
    my_main_menus[0].setMnemonic(KeyEvent.VK_F);
    my_main_menus[1].setMnemonic(KeyEvent.VK_O);
    my_main_menus[2].setMnemonic(KeyEvent.VK_T);
    my_help_menu.setMnemonic(KeyEvent.VK_H);
    my_thickness_menu.setMnemonic(KeyEvent.VK_T);
    for (JMenu m: my_main_menus) {
      add(m);
    }
    
    add(my_help_menu);
  }
  
  /**
   * Creates the file items (not including tools
   * and thickness).
   * 
   * @param the_panel The drawing panel.
   */
  public void createFileButtons(final DrawingPanel the_panel) {
    final JMenuItem item = new JMenuItem("Clear");
    item.setMnemonic(KeyEvent.VK_C);
    item.setSelected(false);
    item.addActionListener(new ActionListener() {
      /**
       * The action of the clear button. Clears the drawing
       * panel.
       * 
       * @param the_action The action.
       */
      @Override
      public void actionPerformed(final ActionEvent the_action) {
        the_panel.clearDrawing();
      }
      
    });
    my_file_items.add(item);
    my_main_menus[0].add(item);
    my_main_menus[0].addSeparator();
    final JMenuItem item2 = new JMenuItem("Exit");
    item2.addActionListener(new ActionListener() {
      /**
       * The action of the exit button. Closes the program.
       * 
       * @param the_action The action.
       */
      @Override
      public void actionPerformed(final ActionEvent the_action) {
        System.exit(0);
      }
      
    });
    item2.setMnemonic(KeyEvent.VK_X);
    item2.setSelected(false);
    my_file_items.add(item);
    my_main_menus[0].add(item2);

  }
  
  /**
   * Setups the option menu.
   * 
   * @param the_panel The panel.
   * 
   */
  public void setupOptionButtons(final DrawingPanel the_panel) {
    final JCheckBox grid = new JCheckBox("Grid");
    grid.setMnemonic(KeyEvent.VK_G);
    grid.setSelected(false);
    grid.addActionListener(new ActionListener() {
      /**
       * Adds the grid function, to set it on or not.
       * 
       * @param the_action The action.
       */
      @Override
      public void actionPerformed(final ActionEvent the_action) {
        if (grid.isSelected()) {
          the_panel.setGrid(true);
          the_panel.repaint();
        } else {
          the_panel.setGrid(false);
          the_panel.repaint();
        }
      }
      
    });
    my_main_menus[1].add(grid);
    my_main_menus[1].add(my_thickness_menu);
    
  }
  
  /**
   * Creates radio buttons of a tool.
   * 
   * @param the_action The action of the button
   * being made.
   */
  public void createToolButtons(final Action the_action) {
    final JRadioButtonMenuItem tool = new JRadioButtonMenuItem(the_action);
    tool.setSelected(false);
    my_tool_buttons.add(tool);
    my_main_menus[2].add(tool);
  }
  
  /**
   * Creates radio buttons for thickness and
   * implements their actions to change thickness.
   * 
   * @param the_name The name.
   * @param the_mnemonic The mnemonic.
   * @param the_panel The panel.
   * @param the_thickness The thickness.
   */
  public void createThicknessButtons(final String the_name, final int the_mnemonic, 
                                     final DrawingPanel the_panel, final int the_thickness) {
    final JRadioButtonMenuItem thickness = new JRadioButtonMenuItem(the_name);
    thickness.setMnemonic(the_mnemonic);
    thickness.addActionListener(new ActionListener() {

      /**
       * Sets the current thickness to be this thickness.
       * 
       * @param the_action The action.
       * 
       */
      @Override
      public void actionPerformed(final ActionEvent the_action) {
        the_panel.setThickness(the_thickness);
        
      }
      
    });
    if (the_name.equals(MY_DEFAULT_THICKNESS)) {
      thickness.setSelected(true);
    } else {
      thickness.setSelected(false);
    }
    my_thickness_buttons.add(thickness);
    my_thickness_menu.add(thickness);
  }
  
  /**
   * Creates the help button and
   * the action which displays a small
   * message. 
   */
  public void createHelpButton() {
    final JMenuItem item = new JMenuItem("About");
    item.setMnemonic(KeyEvent.VK_A);
    item.setSelected(false);
    item.addActionListener(new ActionListener() {
      
      /**
       * Implements the action for about to display 
       * a message.
       * 
       * @param the_action The action.
       * 
       */
      @Override
      public void actionPerformed(final ActionEvent the_action) {
        JOptionPane.showMessageDialog(item, "Insert interesting message here.");
      }
      
    });
    my_help_menu.add(item);
    
  }

  
  /**
   * Adds the color button to the PowerPaint
   * menu bar.
   * 
   * @param the_item  The menu item.
   */
  public void addColorMenu(final JMenuItem the_item) {
    the_item.setSelected(false);
    my_main_menus[2].add(the_item);
    my_main_menus[2].addSeparator();
  }
  

  
}