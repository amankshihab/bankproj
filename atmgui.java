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
import java.awt.GridLayout;
import java.awt.GridBagLayout;

//End of imports

//start of program
public class atmgui {

    JFrame frame = new JFrame("Tightwad Bank ATM");
    
    JLabel welcome = new JLabel("Welome to Tightwad Bank!", JLabel.CENTER);
    
    JLabel acc_no = new JLabel("Enter Acc no.", JLabel.CENTER);

    JTextField acno = new JTextField(15);

    JPanel mainpanel = new JPanel();
    JPanel welcomepanel = new JPanel();
    JPanel pinpanel = new JPanel();
    JPanel atm = new JPanel();

    JButton submit = new JButton("Submit");

    CardLayout card = new CardLayout();
    BorderLayout border = new BorderLayout();
    //FlowLayout flow = new FlowLayout();
    GridLayout grid = new GridLayout(5,3);
    GridBagLayout gridbag = new GridBagLayout();

    atmgui(){

        /*Everything to do with the main panel*/
        frame.setVisible(true);
        frame.setLayout(card);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        /*Everything to do with the main panel ends*/

        /*Everything to do with the welcomepanel*/
        welcomepanel.setLayout(grid);
        welcomepanel.add(welcome);
        welcome.setFont(new Font("Algerian", Font.BOLD, 26));
        welcome.setForeground(Color.BLACK);    //CHANGE COLORRRRRR!!!
        acc_no.setFont(new Font("Algerian", Font.BOLD, 16));
        welcomepanel.add(acc_no);
        //acno.setSize(5, 5);
        welcomepanel.add(acno);
        welcomepanel.add(submit);
        //welcomepanel.setSize(400, 400);
        //welcomepanel.setBackground();
        frame.add(welcomepanel);
        /*Everything to do with the welcomepanel ends*/

        /*Everything to do with pin panel*/
        /*Everything to do with pin panel ends*/
    }

    public static void main(String[] args) {
        
        new atmgui();
    }
}