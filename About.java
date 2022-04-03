package org.text.wizard;
import java.awt.Image;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame implements ActionListener{

    JButton button;
    About(){
        setBounds(450, 100, 670, 580);
        setResizable(false);
        setTitle("About Text Wizard");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("src/main/resources/icons/textWizardIcon.png"));
        setIconImage(icon.getImage());
        setLayout(null);

        ImageIcon labelIcon = new ImageIcon(getClass().getResource("src/main/resources/icons/textWizardIcon.png"));
        JLabel label = new JLabel(labelIcon);
        label.setBounds(230, 40, 180, 180);
        add(label);


        JLabel textLabel = new JLabel("<html>WELCOME TO TEXT WIZARD<br> Text Wizard is a word processing program,<br> which allows changing of text in a computer file.<br> It is a text editor, a very simple word processor.<br> The program has options such as changing the font, the font size, and the font style.<br></html>");
        textLabel.setFont(new Font("MV Boli", Font.PLAIN, 18));
        textLabel.setBounds(130, 160, 440, 300);
        add(textLabel);

        button = new JButton("OK");
        button.setBounds(530, 480, 80, 25);
        button.setFocusable(false);
        setVisible(true);
        add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        dispose();
    }

    public static void main(String[] args) {
        new About().setVisible(true);
    }
}