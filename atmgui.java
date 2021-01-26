
//Importing Required Packages
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Timer;
import java.awt.Container;
import java.awt.CardLayout;
import java.awt.GridLayout;

//End of imports
//start of program

class atmgui extends JFrame implements ActionListener {

    String custno = new String();
    String name = new String();

    int i = 0;

    int pin = 0;
    Double balance = 0.0; // to retreive data from the db

    // color array
    Color color[] = { Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE, Color.PINK};

    JFrame frame = new JFrame("Tightwad Bank ATM");

    public JLabel welcome = new JLabel("~$~ Welcome to Tightwad Bank! ~$~");

    JLabel acc_no = new JLabel("~~ Enter Acc no. ~~");
    JLabel acc_doesnt_exist = new JLabel("Account does not exist!");
    JLabel img = new JLabel();
    JLabel imgpin = new JLabel();
    JLabel enterpinlabel = new JLabel("~~ Enter Pin: ~~");

    JTextField acno = new JTextField(15);   //to enter account number in welcome page
    JTextField enterpin = new JTextField(15); //to enter pin number in pin page

    JPanel welcomepanel = new JPanel();
    JPanel welcomepanel2 = new JPanel();//first panel or welcome page
    JPanel pinpanel = new JPanel(); 
    JPanel pinpanel2 = new JPanel(); // second panel or page to enter pin
    JPanel atm = new JPanel();

    JButton submit = new JButton("Submit"); //submit on welcome page

    Container c;

    CardLayout card = new CardLayout();

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    Timer timer = new Timer(500, new ActionListener(){  // changes the color of welcome text

        @Override
        public void actionPerformed(ActionEvent e){
            int i = getRandomNumber(0, 6);
            welcome.setForeground(color[i]);
        }
    });

    Timer time = new Timer(500, new ActionListener(){

        public void actionPerformed(ActionEvent e){

            if(i == 0){
                acc_no.setVisible(true);
                i = 1;
            }
            else{
                acc_no.setVisible(false);
                i = 0;
            }
        }
    });

    atmgui(){

        // Welcome Panel
        c = getContentPane();
        c.setLayout(card);
        
        welcome.setBounds(95, 10, 650, 100);    // welcome is a jlabel
        welcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcomepanel2.add(welcome); 

        //welcomepanel2 has all the elements
        //welcomepanel has the image, and welcomepanel2 is added to welcompanel
        
        acc_no.setBounds(310, 200, 300, 250); // acc_no is a jlabel
        acc_no.setFont(new Font("Verdana", Font.BOLD, 20));
        acc_no.setForeground(Color.ORANGE);
        welcomepanel2.add(acc_no);
        
        acno.setBounds(310, 350, 240, 25); // acno is textfield
        welcomepanel2.add(acno);
        acno.setForeground(Color.BLUE);
        acno.setBackground(Color.LIGHT_GRAY);

        submit.setBounds(350, 390, 150, 25); // submit is a button
        submit.addActionListener(this);
        submit.setForeground(Color.MAGENTA);
        submit.setBackground(Color.GREEN);
        welcomepanel2.add(submit);

        acc_doesnt_exist.setBounds(350, 420, 150, 25);
        acc_doesnt_exist.setFont(new Font("Verdana", Font.ITALIC, 18));
        acc_doesnt_exist.setForeground(Color.RED);
        acc_doesnt_exist.setVisible(false);
        welcomepanel2.add(acc_doesnt_exist);
        
        welcomepanel2.setLayout(null);
        img.setIcon(new ImageIcon("download.jpeg"));
        img.setBounds(0,0,850,700);
        welcomepanel2.setBounds(-10, 0, 850, 700);
        welcomepanel2.setBackground(Color.DARK_GRAY);

        c.add(welcomepanel2);
        // welcome panel ends

        //pin panel
        // enterpinlabel.setBounds(310, 0, 300, 250); // enterpin is a jlabel
        enterpinlabel.setFont(new Font("Verdana", Font.BOLD, 20)); //setting font for enterpin
        enterpinlabel.setForeground(Color.ORANGE); //setting its color to orange
        pinpanel2.add(enterpinlabel); //adding label enter pin to the panel
        pinpanel2.setBackground(Color.DARK_GRAY);   //setting the background of the panel
        c.add(pinpanel2);   //adding pinpanel to the cardlayout
        pinpanel2.add(enterpin); //enter pin is a text field
        // enterpin.setBounds(310, 20, 300, 250);
        pinpanel2.setLayout(new GridLayout(3,1));

        // pin panel ends
        
        
        frame.setLayout(new CardLayout()); 
        // frame.add(welcomepanel);
        frame.add(c);  
        c.setVisible(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setSize(850,700); 
        timer.start(); 
        time.start();
    }

    public void changevisible(){

        acc_doesnt_exist.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch(Exception except){
            System.out.println("No driver detected!");
            System.exit(1);
        }

        // String query = "SELECT * FROM atminfo where custno=\'" + acno.getText() + "\'";

        try{

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/tightwad", "postgres", "amankshihab");
            Statement st = conn.createStatement();
            // System.out.println(query);
            ResultSet rs = st.executeQuery("SELECT * FROM atminfo where custno=\'" + acno.getText() + "\';");

            while(rs.next()){

                try{
                    custno = rs.getString("custno");
                    name = rs.getString("custname");
                    pin = rs.getInt("pin");
                    balance = rs.getDouble("balance");
                    System.out.println(custno);
                    System.out.println(name);
                    System.out.println(pin);
                    System.out.println(balance);

                    card.next(c);
                }
                catch(Exception except){
                    // acc_doesnt_exist.setVisible(true);
                    changevisible();
                }
            }
        }
        catch(Exception except){
            // System.out.println("Could not connect to database!");
            changevisible();
            // System.exit(1);
        }
    }

    public static void main(String[] args) {
        
        new atmgui();
    }   
}
