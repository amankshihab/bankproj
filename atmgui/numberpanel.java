package atmgui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class numberpanel implements ActionListener{

    
    JButton buttons[] = new JButton[50];
    JButton continues = new JButton("Continue");

    JTextField jtf;
    
    JPanel jp;

    JLabel incorrect_pin = new JLabel("Incorrect Pin!");

    int pin = 0;
    int pincorrect = 0;

    Container c;

    CardLayout card = new CardLayout();
    
    public void addNumberPanel() {

        JButton pinnumbers[] = createButtons(10);
        
        int r=0;
        for(int i=0;i<7;i+=3)
        {
            for(int j=1;j<=3;j++)
            {
                pinnumbers[i+j].setBounds(250+((j-1)*60),300+(r*40),60,40);
            }
            r++;
        }

        for (int i = 0; i < 10; i++) {

            jp.add(pinnumbers[i]);
        }

        continues.setBounds(370, 580, 60, 40);
        jp.add(continues);
        continues.addActionListener(this);

        jp.add(incorrect_pin);
        incorrect_pin.setVisible(false);
        incorrect_pin.setBounds(350, 480, 60, 60);
    }

    public JButton[] createButtons(int n) {

        // buttons[] = new JButton[n];

        for (int i = 0; i < n; i++) {

            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
        }

        return buttons;
    }

    public void actionPerformed(ActionEvent e){

        for(int i = 0; i < 10; i++){

            if(e.getSource() == buttons[i]){

                jtf.setText(jtf.getText()+ "*");
                pin = pin * 10 + i;
            }
        }

        if(e.getSource() == continues){

            if(pincorrect == pin)
                card.next(c);
            else{
                incorrect_pin.setVisible(true);
                System.out.println(pincorrect);
                System.out.println(pin);
            }
        }
    }

    public int get_pin(){

        return pin;
    }
}
