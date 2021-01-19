//Importing Required Packages
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;

//End of imports

//start of program
public class atmgui {

    JFrame frame = new JFrame("Tightwad Bank ATM");
    
    JLabel welcome = new JLabel("Welome to Tightwad Bank!");
    
    JLabel acc_no = new JLabel("Acc no.");

    JTextField acno = new JTextField(15);

    JPanel mainpanel = new JPanel();
    JPanel welcomepanel = new JPanel();
    JPanel pinpanel = new JPanel();
    JPanel atm = new JPanel();

    JButton submit = new JButton("Submit");

    CardLayout card = new CardLayout();
    BorderLayout border = new BorderLayout();

    atmgui(){

        //Everything to do with the main panel
        frame.setVisible(true);
        frame.setLayout(card);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        //Everything to do with the main panel ends

        //Everything to do with the welcomepanel
        welcomepanel.setLayout(border);
        welcomepanel.add(welcome, BorderLayout.CENTER);
        welcomepanel.add(acc_no, BorderLayout.CENTER);
        welcomepanel.add(submit, BorderLayout.CENTER);
        welcomepanel.setSize(400, 400);
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