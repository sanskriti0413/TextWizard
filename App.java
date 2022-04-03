package org.text.wizard;

/**
 * Hello world!
 *
 */
// public class App 
// {
//     public static void main( String[] args )
//     {
//         System.out.println( "Hello World!" );
//     }
// }


	
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.event.*;


public class App extends JFrame implements ActionListener{

    JTextArea area; // globally declare text area
    JScrollPane pane; // for scrolling

    App(){
        setBounds(100, 100, 800, 600);  // set size of window
        setTitle("Text Wizard");
        ImageIcon icon = new ImageIcon(getClass().getResource("src/main/resources/icons/textWizardIcon.png"));
        setIconImage(icon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JMenuBar menuBar = new JMenuBar();   // create main menu bar

        // file menu and menu item start
        JMenu file = new JMenu("File");  // create menu on main menu bar

        JMenuItem newdoc = new JMenuItem("New");  // create menu item for file
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // for shortcut key
        newdoc.addActionListener(this); // for event happening on click

        JMenuItem open = new JMenuItem("Open");  // create menu item for file
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));  // for shortcut key
        open.addActionListener(this);  // for event happening on click

        JMenuItem save = new JMenuItem("Save");  // create menu item for file
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));  // for shortcut key
        save.addActionListener(this);  // for event happening on click

        JMenuItem print = new JMenuItem("Print");  // create menu item for file
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));  // for shortcut key
        print.addActionListener(this);  // for event happening on click

        JMenuItem exit = new JMenuItem("Exit");  // create menu item for file
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));  // for shortcut key
        exit.addActionListener(this);  // for event happening on click

        file.add(newdoc); // add menu item on menu(file)
        file.add(open);  // add menu item on menu(file)
        file.add(save);  // add menu item on menu(file)
        file.add(print);  // add menu item on menu(file)
        file.add(exit);  // add menu item on menu(file)

        // file menu and menu item end

        // edit menu and menu start

        JMenu edit = new JMenu("Edit");  // create menu on main menu bar

        JMenuItem copy = new JMenuItem("Copy");  // create menu item for edit
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));  // for shortcut key
        copy.addActionListener(this);  // for event happening on click

        JMenuItem paste = new JMenuItem("Paste");  // create menu item for edit
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));  // for shortcut key
        paste.addActionListener(this);  // for event happening on click

        JMenuItem cut = new JMenuItem("Cut"); // create menu item for edit
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));  // for shortcut key
        cut.addActionListener(this);  // for event happening on click

        JMenuItem selectall = new JMenuItem("Select All");  // create menu item for edit
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));  // for shortcut key
        selectall.addActionListener(this);  // for event happening on click

        edit.add(copy);  // add menu item on munu(edit)
        edit.add(paste);  // add menu item on munu(edit)
        edit.add(cut);  // add menu item on munu(edit)
        edit.add(selectall);  // add menu item on munu(edit)

        // edit menu and menu item end


        // Theme menu and menu item start

        JMenu theme = new JMenu("Theme");  // create menu on main menu bar  

        JMenuItem darkTheme = new JMenuItem("Dark Theme");  // create menu item for file
        darkTheme.addActionListener(this);  // for event happening on click

        JMenuItem moonLightTheme = new JMenuItem("Moon Light Theme");  // create menu item for file
        moonLightTheme.addActionListener(this);  // for event happening on click
        
        theme.add(darkTheme);   // add menu item on munu(theme)
        theme.add(moonLightTheme);  // add menu item on munu(theme)

        // Theme menu and menu item end


        // View menu and menu item start
        JMenu view = new JMenu("View");  // create menu on main menu bar

        JMenuItem word = new JMenuItem("Word Count");  // create menu item for view
        word.addActionListener(this);

        JMenuItem character = new JMenuItem("Character Count");  // create menu item for view
        character.addActionListener(this);

        view.add(word);
        view.add(character);

        // view menu and menu item end


        // help menu and menu item start
        JMenu help = new JMenu("Help");  // create menu on main menu bar

        JMenuItem about = new JMenuItem("About");  // create menu item for help
        about.addActionListener(this);  // for event happening on click

        help.add(about); // add menu item on menu(help)

        // help menu and menu item end


        menuBar.add(file); // add on menuBar
        menuBar.add(edit); // add on menuBar
        menuBar.add(theme); // add on menuBar
        menuBar.add(view); // add on menuBar
        menuBar.add(help); // add on menuBar

        setJMenuBar(menuBar); // add on frame

        area = new JTextArea();
        area.setFont(new Font("MV Boli", Font.PLAIN, 20)); // set font type and size
        area.setLineWrap(true);  // wrap for line
        area.setWrapStyleWord(true); // wrap for word

        pane = new JScrollPane(area); 
        pane.setBorder(BorderFactory.createEmptyBorder()); // for remove border
        add(pane, BorderLayout.CENTER);  // add scrollpane on layout
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(pane);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("New")){
            area.setText("");
        }

        else if(ae.getActionCommand().equals("Open")){
            JFileChooser chooser = new JFileChooser("E:/");  // default open location
            chooser.setAcceptAllFileFilterUsed(false);  // for not opening all extension files
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only.txt files", "txt"); // for opening only txt file
            chooser.addChoosableFileFilter(restrict);

            int action = chooser.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }
            
            File file = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader, null);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        else if(ae.getActionCommand().equals("Save")){
            JFileChooser saveas = new JFileChooser();
    //         saveas.setApproveButtonText("Save");

            int action = saveas.showOpenDialog(this);
            if(action != JFileChooser.APPROVE_OPTION){
                return;
            }

            File filename = new File(saveas.getSelectedFile() + "txt");
            BufferedWriter outfile = null;
            try {
                outfile = new BufferedWriter(new FileWriter(filename));
                area.write(outfile);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        else if(ae.getActionCommand().equals("Print")){
            try {
                area.print();
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

        else if(ae.getActionCommand().equals("Exit")){
            System.exit(0);
        }

        else if(ae.getActionCommand().equals("Copy")){
            // text = area.getSelectedText();
            area.copy();
        }
        else if(ae.getActionCommand().equals("Paste")){
            // area.insert(text, area.getCaretPosition());
            area.paste();
        }

        else if(ae.getActionCommand().equals("Cut")){
    //         text = area.getSelectedText();
    //         area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
            area.cut();
        }

        else if(ae.getActionCommand().equals("Select All")){
            area.selectAll();
        }

        else if(ae.getActionCommand().equals("Dark Theme")){
            area.setBackground(Color.DARK_GRAY);
            area.setForeground(Color.WHITE);
        }

        else if(ae.getActionCommand().equals("Moon Light Theme")){
            area.setBackground(new Color(107, 169, 255));
            area.setForeground(Color.BLACK);        
        }

        else if(ae.getActionCommand().equals("Word Count")){
            String text = area.getText();
            if(text.length() == 0){
                JOptionPane.showMessageDialog(null, "Word : 0 ", "Word Count", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                String words[] = text.split("\\s");
                JOptionPane.showMessageDialog(null, "Words : " + words.length, "Word Count", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        else if(ae.getActionCommand().equals("Character Count")){
            String text = area.getText();
            String textWithoutSpace = text.replaceAll("\\s+", "");

            JOptionPane.showMessageDialog(null, "Characters (including spaces) : " + text.length() + ",  " + "Characters (without spaces) : " + textWithoutSpace.length(), "Character Count", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(ae.getActionCommand().equals("About")){
            new About().setVisible(true);
        }
    }
    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());    // for new window look
        } catch (Exception e) {
            //TODO: handle exception
        }
        new App().setVisible(true);
    }    
}
