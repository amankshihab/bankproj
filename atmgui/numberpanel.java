package atmgui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class numberpanel {
    
    public static void addNumberPanel(JPanel jp){

        JButton pinnumbers[] = createButtons(10);

        pinnumbers[0].setBounds(x, y, width, height);
        
        for(int i = 0; i < 10; i++){

            jp.add(pinnumbers[i]);
        }
    }

    static JButton[] createButtons(int n) {
        
        JButton buttons[] = new JButton[n];

        for(int i = 0; i < n; i++){

            buttons[i] = new JButton(String.valueOf(i));
        }

        return buttons;
    }
}
