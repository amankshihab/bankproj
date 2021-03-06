//Importing Required Packages
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import atmgui.numberpanel;

//End of imports
//start of program

@SuppressWarnings("serial")
class atmgui extends JFrame implements ActionListener {

    String custno = new String();
    String name = new String();

    Connection conn;

    int pinentered = 0;

    int i = 0;
    int attempts = 0;

    int pin = 0;
    Double balance = 0.0; // to retreive data from the db

    // color array
    Color color[] = { Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.ORANGE, Color.PINK};

    JFrame frame = new JFrame("Tightwad Bank ATM");

    public JLabel welcome = new JLabel("~$~ Welcome to Tightwad Bank! ~$~");
    JLabel slogan =  new JLabel("Where Our Interest Meets Your Needs");

    JLabel acc_no = new JLabel("~~ Enter Acc no. ~~");
    JLabel acc_doesnt_exist = new JLabel("Account does not exist!");
    JLabel img = new JLabel();
    JLabel img1 = new JLabel();
    JLabel imgpin = new JLabel();
    JLabel enterpinlabel = new JLabel("~~ Enter Pin: ~~");
    JLabel withlabel = new JLabel("~~ Enter the amount: ~~");
    JLabel thankyou = new JLabel("~~ Thank You! ~~");
    JLabel incorrect_pin = new JLabel("Incorrect pin!");
    JLabel hello = new JLabel("Hello");
    JLabel insuff_bal = new JLabel("Insufficient Balance!");
    JLabel remaininglabel = new JLabel("Remaining Balance:");
    JLabel balanceLabel = new JLabel("Balance:");

    JTextField acno = new JTextField(15);   //to enter account number in welcome page
    JTextField enterpin = new JTextField(15); //to enter pin number in pin page
    JTextField withamt = new JTextField(15);

    JPanel welcomepanel = new JPanel();
    JPanel welcomepanel2 = new JPanel();//first panel or welcome page
    JPanel pinpanel = new JPanel(); 
    JPanel pinpanel2 = new JPanel(); // second panel or page to enter pin
    JPanel atm = new JPanel();
    JPanel withpanel = new JPanel();
    JPanel thankyoupanel = new JPanel();

    JButton submit = new JButton("Submit"); //submit on welcome page
    JButton numbpan[];
    JButton continues = new JButton("Continue");
    JButton withdraw = new JButton("Withdraw");
    JButton deposit = new JButton("Deposit");
    JButton clear = new JButton("CLEAR");
    JButton zero = new JButton("0");
    JButton home = new JButton("GO BACK HOME");
    JButton cancel = new JButton("CANCEL");
    JButton cancel1 = new JButton("CANCEL");
    Container c;

    CardLayout card = new CardLayout();

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    Timer timer = new Timer(500, new ActionListener(){  // changes the color of welcome text

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

    Timer thanktime = new Timer(500, new ActionListener(){

        int i = 0;
        
        public void actionPerformed(ActionEvent e){

            if(i == 0){
                thankyou.setVisible(true);
                i = 1;
            }
            else{
                thankyou.setVisible(false);
                i = 0;
            }
        }
    });

    atmgui(){

//////////////////////////////////// Welcome Panel///////////////////////////////////////
        
        c = getContentPane();
        c.setLayout(card);
        
        welcome.setBounds(150, 10, 650, 100);    // welcome is a jlabel
        welcome.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 30));
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
        frame.getRootPane().setDefaultButton(submit);
        

        submit.setBounds(350, 390, 150, 25); // submit is a button
        submit.addActionListener(this);
        submit.setForeground(Color.MAGENTA);
        submit.setBackground(Color.GREEN);
        welcomepanel2.add(submit);

        acc_doesnt_exist.setBounds(330, 420, 230, 25);
        acc_doesnt_exist.setFont(new Font("Rockwell", Font.ITALIC, 18));
        acc_doesnt_exist.setForeground(Color.RED);
        acc_doesnt_exist.setVisible(false);
        welcomepanel2.add(acc_doesnt_exist);
        
        img.setIcon(new ImageIcon("resources\\Capture300.jpg"));
        img.setBounds(275,50,300,300);
        welcomepanel2.add(img);

        slogan.setBounds(225, 500, 650, 100);    
        slogan.setFont(new Font("Rockwell", Font.ITALIC ,24));
        slogan.setForeground(Color.PINK);
        welcomepanel2.add(slogan); 

        welcomepanel2.setBounds(-10, 0, 850, 700);
        welcomepanel2.setLayout(null);
        welcomepanel2.setBounds(-10, 0, 850, 700);
        welcomepanel2.setBackground(Color.DARK_GRAY);

        c.add(welcomepanel2);
//////////////////////////////// welcome panel ends ///////////////////////////////////////

/////////////////////////////////////pin panel/////////////////////////////////////////////////////////////
        
        // enterpinlabel is a jlabel
        pinpanel2.setLayout(null);
        
        hello.setForeground(Color.ORANGE);
        pinpanel2.add(hello);
        hello.setFont(new Font("MS PGothic", Font.BOLD, 30));
        hello.setBounds(320, 100, 450, 50);
        
        enterpinlabel.setFont(new Font("Impact", Font.BOLD, 20)); //setting font for enterpin
        enterpinlabel.setForeground(Color.GREEN); //setting its color to orange
        enterpinlabel.setBounds(345,200,200,40);
        
        enterpin.setBounds(355,250,120,40);
        enterpin.setText("");
        enterpin.setEditable(false);
        pinpanel2.add(enterpinlabel); //adding label enter pin to the panel
        pinpanel2.setBackground(Color.DARK_GRAY);   //setting the background of the panel
        c.add(pinpanel2);   //adding pinpanel to the cardlayout
        pinpanel2.add(enterpin); //enter pin is a text field
        
        numberpanel np = new numberpanel();
        numbpan = np.createButtons(10);
        for(int i = 0; i < 10; i++)
            numbpan[i].addActionListener(this);

        int r = 0;
        for(int i=0;i<7;i+=3)
        {
            for(int j=1;j<=3;j++)
            {
                numbpan[i+j].setBounds(325+((j-1)*60),300+(r*40),60,40);
            }
            r++;
        }
    
        for (int i = 0; i < 10; i++) {
    
            pinpanel2.add(numbpan[i]);
        }
        pinpanel2.add(zero);
        zero.addActionListener(this);
        zero.setBounds(385, 420, 60, 40);

        incorrect_pin.setBounds(360, 595, 180, 25);
        incorrect_pin.setVisible(false);
        incorrect_pin.setFont(new Font("IMPACT", Font.BOLD, 20));
        incorrect_pin.setForeground(Color.RED);
        pinpanel2.add(incorrect_pin);

        pinpanel2.add(continues);
        continues.setBounds(325, 480, 100, 40);
        continues.addActionListener(this);

        pinpanel2.add(clear);
        clear.addActionListener(this);
        clear.setBounds(430, 480, 80, 40);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.BLACK);

        pinpanel2.add(cancel);
        cancel.addActionListener(this);
        cancel.setBounds(370, 540, 100, 40);
        cancel.setBackground(Color.PINK);

//////////////////////////////////////pin panel ends///////////////////////////////////////
        
//////////////////////////////////////Withdraw Pages///////////////////////////////////

        c.add(withpanel);
        withpanel.setBackground(Color.DARK_GRAY);
        withpanel.setLayout(null);
        
        withpanel.add(withlabel);
        withlabel.setForeground(Color.CYAN);
        withlabel.setFont(new Font("Verdana", Font.BOLD, 20));
        withlabel.setBounds(280,200,450,50);

        withpanel.add(balanceLabel);
        balanceLabel.setBounds(350, 235, 450, 50);
        balanceLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        balanceLabel.setForeground(Color.GREEN);

        withpanel.add(withamt);
        withamt.setBounds(350,300,140,30);

        withpanel.add(withdraw);
        withdraw.addActionListener(this);
        withdraw.setBounds(370, 380, 100, 35);

        withpanel.add(deposit);
        deposit.addActionListener(this);
        deposit.setBounds(370, 420, 100, 35);

        withpanel.add(insuff_bal);
        insuff_bal.setBounds(335, 540, 250, 45);
        insuff_bal.setFont(new Font("Impact", Font.BOLD, 20));
        insuff_bal.setForeground(Color.RED);
        insuff_bal.setVisible(false);

        withpanel.add(cancel1);
        cancel1.addActionListener(this);
        cancel1.setBounds(370, 480, 100, 35);
        cancel1.setBackground(Color.PINK);

//////////////////////////////////////Withdraw page ends//////////////////////////////////////

//////////////////////////////////////Thank you page//////////////////////////////////////////

        thankyoupanel.add(thankyou);
        thankyoupanel.setBackground(Color.DARK_GRAY);
        thankyou.setForeground(Color.YELLOW);

        thankyou.setBounds(300, 25, 550, 100);    // welcome is a jlabel
        thankyou.setFont(new Font("Rockwell", Font.BOLD, 30));

        thankyoupanel.add(remaininglabel);
        thankyoupanel.setLayout(null);
        remaininglabel.setBounds(300, 300, 400, 100);
        remaininglabel.setFont(new Font("MS PGothic", Font.BOLD, 20));
        remaininglabel.setForeground(Color.MAGENTA);

        img1.setIcon(new ImageIcon("resources\\Capture300.jpg"));
        img1.setBounds(275,50,300,300);
        thankyoupanel.add(img1);

        thankyoupanel.add(home);
        home.setBounds(350,400,160,40);
        home.addActionListener(this);
        c.add(thankyoupanel);

//////////////////////////////////Thank you page ends/////////////////////////////////////////
        frame.setLayout(new CardLayout()); 
        frame.add(c);  
        c.setVisible(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.setSize(850,700); 
        timer.start(); 
        time.start();
        thanktime.start();
    }

    public void actionPerformed(ActionEvent e){
        
        for(int i = 0; i < 10; i++){

            if(e.getSource() == numbpan[i] && enterpin.getText().length() < 4){

                try{
                    enterpin.setText(enterpin.getText()+ "*");
                }
                catch(Exception ed){}
                pinentered = pinentered * 10 + i;
            }
        }
        
        if(e.getSource() == submit){
            try{
                Class.forName("org.postgresql.Driver");
            }
            catch(Exception except){
                System.out.println("No driver detected!");
                System.exit(1);
            }

            try{

                conn = DriverManager.getConnection("jdbc:postgresql://localhost/tightwad", "postgres", System.getenv("postgres_pass"));
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM atminfo where custno=\'" + acno.getText() + "\';");
                
                while(rs.next()){

                    try{
                        
                        if(custno == null){
                        acc_doesnt_exist.setVisible(true);
                        }
                        else{

                            custno = rs.getString("custno");
                            name = rs.getString("custname");
                            pin = rs.getInt("pin");
                            balance = rs.getDouble("balance");
                            hello.setText(hello.getText() + " " + name + "!");

                            balanceLabel.setText(balanceLabel.getText() + " " + balance);

                            card.next(c);
                        }
                    }
                    catch(Exception except){
                        acc_doesnt_exist.setVisible(true);
                    }
                }

                if(rs.next() == false){
                    welcomepanel2.add(acc_doesnt_exist);
                    acc_doesnt_exist.setVisible(true);
                }
            }
            catch(Exception except){
                System.out.println("hi");
                acc_doesnt_exist.setVisible(true);
            }
        }

        if(e.getSource() == continues){
            if(pinentered == pin)
            card.next(c);
            else{
                enterpin.setText("Incorrect, hit CLEAR");
                incorrect_pin.setVisible(true);
                enterpin.setForeground(Color.RED);
                attempts += 1;
        

                if(attempts == 4)
                    System.exit(1);
            }
        }

        if(e.getSource() == withdraw){

            if(Double.parseDouble(withamt.getText()) <= balance && Double.parseDouble(withamt.getText()) >= 100 && Double.parseDouble(withamt.getText()) % 100 == 0){

                double remaining = balance - Double.parseDouble(withamt.getText());
                
                try{
                    Statement withdrStatement = conn.createStatement();

                    String query = "UPDATE atminfo SET balance=" + remaining + " WHERE custno='" + custno + "';";
                    
                    withdrStatement.executeUpdate(query);

                    remaininglabel.setText(remaininglabel.getText() + " " + String.valueOf(remaining));
                    
                    card.next(c);
                }
                catch(Exception ed){

                }
            }
            else if(Double.parseDouble(withamt.getText()) % 100 != 0){

                withamt.setText("Has to be multiple of 100");
            }
            else{

                insuff_bal.setVisible(true);
            }
        }

        if(e.getSource() == clear){

            pinentered = 0;
            enterpin.setText("");
            enterpin.setForeground(Color.BLACK);
            incorrect_pin.setVisible(false);
        }

        if(e.getSource() == zero){

            if(enterpin.getText().length() < 4){
                enterpin.setText(enterpin.getText() + "*");
                pinentered *= 10;
            }
        }

        if(e.getSource() == deposit){

            if(Double.parseDouble(withamt.getText()) <= 100000 && Double.parseDouble(withamt.getText()) > 0){

                double updated = balance + Double.parseDouble(withamt.getText());
                
                try{
                    Statement withdrStatement = conn.createStatement();

                    String query = "UPDATE atminfo SET balance=" + updated + " WHERE custno='" + custno + "';";
                    
                    withdrStatement.executeUpdate(query);

                    remaininglabel.setText(remaininglabel.getText() + " " + String.valueOf(updated));
                    
                    card.next(c);
                }
                catch(Exception ed){

                }
            }
        
        }
        if(e.getSource() == home||e.getSource()== cancel||e.getSource()== cancel1){

            card.first(c);
            attempts=0;
            enterpin.setText(null);
            acno.setText(null);
            acc_doesnt_exist.setVisible(false);
            remaininglabel.setText("Remaining Balance: ");
            balanceLabel.setText("Balance: ");
            withamt.setText(null);
            hello.setText("Hello");
            pinentered = 0;

        }
    }

    public static void main(String[] args) {
        
        new atmgui();
    }   
}