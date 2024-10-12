import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class DeleteEmployee {
	JPanel panel = new JPanel();

	public DeleteEmployee(JFrame screen, JPanel mainMenu, MyHashTable emps){
		JPanel handler = new JPanel();
		handler.setLayout(new BoxLayout(handler, BoxLayout.Y_AXIS));
		handler.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Delete Employee");
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		titlePanel.add(title);
		handler.add(titlePanel);
		
		
		Component spacer1 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer1);
		
		
		JPanel id = new JPanel(new FlowLayout());
		JLabel idLabel = new JLabel("Enter Employee ID Number: ");
		idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField empID = new JTextField();
		empID.setPreferredSize(new Dimension(100, 20));
		id.add(idLabel);
		id.add(empID);
		handler.add(id);
		
		
		Component spacer2 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer2);
		
		
		
		JPanel errorMessagePanel = new JPanel();
		JLabel errorMessage = new JLabel("Entered ID is invalid!"); // change text to match boxes in event handler
		errorMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		errorMessage.setForeground(Color.RED);
		errorMessagePanel.add(errorMessage);
		
		handler.add(errorMessagePanel);
		errorMessagePanel.setVisible(false);
		
		
		
		JPanel submitButtonPanel = new JPanel();
		JButton submitButton = new JButton("Delete Employee");
		submitButton.setPreferredSize(new Dimension(200, 40));
		submitButtonPanel.add(submitButton);
		handler.add(submitButtonPanel);
		
		
		Component spacer3 = Box.createRigidArea(new Dimension(10, 20));
		handler.add(spacer3);
		
		
		
		JPanel exitButtonPanel = new JPanel();
		JButton exitButton = new JButton("Return To Main Menu");
		exitButton.setPreferredSize(new Dimension(200, 40));
		exitButtonPanel.add(exitButton);
		handler.add(exitButtonPanel);
		
		
		Component spacer4 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer4);
		
		
		JPanel confirmMessagePanel = new JPanel();
		JLabel confirmMessage = new JLabel("Employee Deleted!"); // change text to match boxes in event handler
		confirmMessage.setFont(new Font("Times New Roman", Font.BOLD, 28));
		confirmMessagePanel.add(confirmMessage);
		
		handler.add(confirmMessagePanel);
		confirmMessagePanel.setVisible(false);
		
		
		
		panel.add(handler);
		panel.setVisible(false);
		
				
		submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		errorMessagePanel.setVisible(false);

            	int removeEmpID;
            	
            	try {
            		removeEmpID = Integer.parseInt(empID.getText());
            	
            		if (emps.removeFromTable(removeEmpID) == null) {
            			errorMessagePanel.setVisible(true);
            		}
            		
            		else {
            			confirmMessagePanel.setVisible(true);
            			
            			
		            	Timer timer = new Timer(1000, new ActionListener() {
		            		public void actionPerformed(ActionEvent e) {
		            			confirmMessagePanel.setVisible(false);		            			
		                    	panel.setVisible(false);
		                    	mainMenu.setVisible(true);
		                    }
		                });
		            	
		            	timer.setRepeats(false);
		            	timer.start();
		            	
		            	// potentially could directly edit file as well, so that if multiple windows open, then it would keep update
            		}
            	}
            	
            	catch (Exception e) {
            		errorMessagePanel.setVisible(true);
            	}
            }
		});
		
		
		exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	panel.setVisible(false);
            	mainMenu.setVisible(true);
            }
        });
	}
}
