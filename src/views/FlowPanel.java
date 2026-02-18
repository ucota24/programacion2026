package views;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FlowPanel extends JPanel {
	
	public FlowPanel () {
		JButton buttons[] = new JButton[10];
		
		for(int i = 0; i < 10; i++) {
			buttons[i] = new JButton (i + "");
			add(buttons[i]);
		}
	}

}
