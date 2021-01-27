package atmgui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class numberpanel implements ActionListener{

    
    JButton buttons[] = new JButton[50];
    JButton continues = new JButton("Continue");

    JTextField jtf;
    JPanel jp;

    int pin = 0;

    Container c;

    CardLayout card = new CardLayout();

    public numberpanel(JPanel jp, JTextField jtf, Container c, CardLayout card){

        this.jtf = jtf;
        this.jp = jp;
        this.c = c;
        this.card = card;
    }
    
    public void addNumberPanel() {

        JButton pinnumbers[] = createButtons(10);
        
        
        //positioning pinnumbers[]
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

            if(e.getSource() == buttons[i] && jtf.getText().length() < 4){

                jtf.setText(jtf.getText()+ "*");
            }

            if(jtf.getText().length() == 4){
                pin = pin * 10 + i;
            }
        }

        if(e.getSource() == continues){

            card.next(c);
        }
    }

    public int get_pin(){

        return pin;
    }
}
