package atmgui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transanctionpages implements ActionListener{
    
    JButton withdrawbutton;
    JButton depositbutton;

    JLabel choose = new JLabel("Choose your option:");
    
    public void transanctionpanel(JPanel jp){

        withdrawbutton = new JButton("Withdraw");
        withdrawbutton.addActionListener(this);
        depositbutton = new JButton("Deposit");
        depositbutton.addActionListener(this);

        withdrawbutton.setForeground(Color.ORANGE);
        withdrawbutton.setBackground(Color.GREEN);

        depositbutton.setForeground(Color.ORANGE);
        depositbutton.setBackground(Color.GREEN);

        jp.add(withdrawbutton);
        jp.add(depositbutton);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == withdrawbutton){

            // withdraw enn paranje page indakkanam and cardlayout should take it there
        }

        if(e.getSource() == depositbutton){

            //deposit page indakkanam, and cardlayout  next varanam
        }
    }
}
