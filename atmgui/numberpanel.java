package atmgui;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class numberpanel implements ActionListener{

    
    JButton buttons[];
    
    public void addNumberPanel(JPanel jp) {

        JButton pinnumbers[] = createButtons(10);

        // pinnumbers[0].setBounds(x, y, width, height);

        for (int i = 0; i < 10; i++) {

            jp.add(pinnumbers[i]);
        }
    }

    public JButton[] createButtons(int n) {

        JButton buttons[] = new JButton[n];

        for (int i = 0; i < n; i++) {

            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(null);
        }

        return buttons;
    }

    public void actionPerformed(ActionEvent e){

        for(int i = 0; i < 10; i++){

            if(e.getSource() == buttons[i]){

                System.out.println(i);
            }
        }
    }
}
