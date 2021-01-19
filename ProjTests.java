import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProjTests extends JFrame implements ActionListener
{
    JFrame jf;
    JPanel p1,p2;
    JButton b1,b2;
    Container c;
    CardLayout card;
    ProjTests() 
    {
        c=getContentPane();
        card = new CardLayout();
        jf= new JFrame("Project Testspace");
        c.setLayout(card);
        jf.setSize(600,400);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p2=new JPanel();
        //p1.setBounds(200,200,100,100);
        //p2.setBounds(350,350,100,100);
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.GREEN);
        b1=new JButton("Button 1");
        b2=new JButton("Button 2");
        b1.addActionListener(this);
        b2.addActionListener(this);
        p1.add(b1);
        p2.add(b2);
        //b1.setBounds(300,100,60,60);
        //b2.setBounds(200,200,60,60);
        c.add(p1);
        c.add(p2);
        jf.add(c);
    }
    public void actionPerformed(ActionEvent e)
    {
        card.next(c);
    }
    public static void main(String args[]) 
    {
        new ProjTests();
        
    }
}
