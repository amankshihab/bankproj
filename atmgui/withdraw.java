package atmgui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withdraw implements ActionListener{
    
    JLabel withdrawlabel = new JLabel("~~ Enter the amount you want to withdraw ~~");
    JTextField jtf = new JTextField(10);
    JButton withdrawbutton = new JButton("Withdraw");
    JPanel jp = new JPanel();
    JLabel notthatrich = new JLabel("Sorry! You are not that rich!");

    int amount = 0;

    public withdraw(int amt){

        amount = amt;

        notthatrich.setVisible(false);
    }

    public void withdrawpanel(){

        jp.add(withdrawlabel);
        jp.add(jtf);
        jp.add(withdrawbutton);
        jp.add(notthatrich);

        withdrawbutton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        String s = jtf.getText();

        if(Integer.parseInt(s) > amount){
        
            notthatrich.setVisible(true);
        }

        else{

            //connect to db and update new value
        }
    }
}
