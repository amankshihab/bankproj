//Importing Required Packages
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

//End of imports
//Have to add gridbag
//start of program
public class atmgui {

    JFrame frame = new JFrame("Tightwad Bank ATM");
    
    JLabel welcome = new JLabel("Welome to Tightwad Bank!");
    
    JLabel acc_no = new JLabel("Enter Acc no.");

    JTextField acno = new JTextField(15);

    JPanel mainpanel = new JPanel();
    JPanel welcomepanel = new JPanel();
    JPanel pinpanel = new JPanel();
    JPanel atm = new JPanel();

    JButton submit = new JButton("Submit");

    CardLayout card = new CardLayout();
    BorderLayout border = new BorderLayout();
    //FlowLayout flow = new FlowLayout();
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    atmgui(){

        //Everything to do with the main panel
        frame.setVisible(true);
        frame.setLayout(card);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        //Everything to do with the main panel ends

        //Everything to do with the welcomepanel
        welcomepanel.setLayout(gridbag);
        //gbc.gridx = 0;
        //gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        welcome.setFont(new Font("Verdana", Font.BOLD, 20));
        welcomepanel.add(welcome, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        acc_no.setFont(new Font("Verdana", Font.BOLD, 16));
        welcomepanel.add(acc_no, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        welcomepanel.add(acno, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        welcomepanel.add(submit, gbc);
        //welcomepanel.setSize(400, 400);
        //welcomepanel.setBackground();
        frame.add(welcomepanel);
        //Everything to do with the welcomepanel ends

        //Everything to do with pin panel
        //Everything to do with pin panel ends
    }

    public static void main(String[] args) {
        
        new atmgui();
    }
}