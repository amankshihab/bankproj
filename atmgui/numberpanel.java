package atmgui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class numberpanel implements ActionListener{

    
    JButton buttons[] = new JButton[50];

    JTextField jtf;
    JPanel jp;


    public numberpanel(JPanel jp, JTextField jtf){

        this.jtf = jtf;
        this.jp = jp;
    }
    
    public void addNumberPanel() {

        JButton pinnumbers[] = createButtons(10);

        // pinnumbers[0].setBounds(x, y, width, height);

        for (int i = 0; i < 10; i++) {

            jp.add(pinnumbers[i]);
        }
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

                jtf.setText(String.valueOf(i));
            }
        }
    }
}
