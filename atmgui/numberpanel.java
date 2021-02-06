package atmgui;

import javax.swing.JButton;

public class numberpanel{

    
    JButton buttons[] = new JButton[50];

    public JButton[] createButtons(int n) {

        for (int i = 0; i < n; i++) {

            buttons[i] = new JButton(String.valueOf(i));
        }

        return buttons;
    }
}
