import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EMS_Open {
		public EMS_Open() {
			JFrame frame = new JFrame();
			frame.setTitle("Employee Management System Already Open");
			frame.setSize(800,100); // initial window size
			frame.setResizable(false); // if i wanna stop resizing
			frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
			
			JPanel titlePanel = new JPanel();
			JLabel title = new JLabel("Employee Management System Already Open!");
			title.setFont(new Font("Serif", Font.PLAIN, 28));
			titlePanel.add(title);
			
			frame.add(titlePanel);
			
			frame.setVisible(true);
//			frame.addWindowListener(new java.awt.event.WindowAdapter() {
//		           @Override
//		           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//		        	   
//		           }
//			});
		}
}
