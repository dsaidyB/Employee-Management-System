import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class DisplayAllEmployees {
	JPanel panel = new JPanel();
	JPanel allEmpsPanel = new JPanel();
	
	
	public void updateEmps(MyHashTable currEmps) {    	
    	// add to some string 
    	int paramsToDisplay = 10;
    	String[][] allEmps = new String[currEmps.size][paramsToDisplay]; 
    	// i can have paramsToDisplay be blank as it turns out java doesnt support 2d array, it just links the array to another one
    	
    	int traverse = 0;
    	for (int i = 0; i < currEmps.buckets.length; i++) {
			if (currEmps.buckets[i].isEmpty()) {
			}
			else {
				for (int j = 0; j < currEmps.buckets[i].size(); j++) {
					
					// both: empNum, firstName, lastName, gender, workLoc, deductRate
					
					if (currEmps.buckets[i].get(j) instanceof PTE) {
						// hourlyWage, hoursPerWeek, weeksPerYear;   there is a calcNetAnnualIncome thing
						PTE tempPTE = (PTE) currEmps.buckets[i].get(j);
						String[] tempData = {"PTE", 
											Integer.toString(tempPTE.empNum), 
											tempPTE.firstName, 
											tempPTE.lastName, 
											tempPTE.gender, 
											tempPTE.workLoc, 
											Double.toString(tempPTE.deductRate), 
											Double.toString(tempPTE.hourlyWage), 
											Double.toString(tempPTE.hoursPerWeek), 
											Double.toString(tempPTE.weeksPerYear), 
											"N/A"}; 
						
						allEmps[traverse] = tempData;
					}
					
					if (currEmps.buckets[i].get(j) instanceof FTE) {
						//yearlySalary
						FTE tempFTE = (FTE) currEmps.buckets[i].get(j);
								
						String[] tempData = {"FTE", 
											Integer.toString(tempFTE.empNum), 
											tempFTE.firstName, 
											tempFTE.lastName, 
											tempFTE.gender, 
											tempFTE.workLoc, 
											Double.toString(tempFTE.deductRate), 
											"N/A", 
											"N/A", 
											"N/A", 
											Double.toString(tempFTE.yearlySalary)};
						
						allEmps[traverse] = tempData;

					}
					
//					System.out.println("  " + currEmps.buckets[i].get(j).firstName);
					traverse += 1;
				}
			}
		}
    	
    	
        // Column Names
        String[] columnNames = {"Type of Emp.", "ID", "First Name", "Last Name", "Gender", "Work Location", "Deduct Rate", "Hourly Wage", "Hours Per Week", "Weeks Per Year", "Yearly Salary"};
 
        
        // Initializing the JTable
        JTable empInfo = new JTable(allEmps, columnNames);
        empInfo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        empInfo.setPreferredScrollableViewportSize(new Dimension(700, 500));

       // empInfo.setBounds(20, 40, 500, 600);
        
        empInfo.getColumnModel().getColumn(0).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(1).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(2).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(3).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(4).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(5).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(6).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(7).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(8).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(9).setPreferredWidth(100);
        empInfo.getColumnModel().getColumn(10).setPreferredWidth(100);

        // adding it to JScrollPane
        JScrollPane scrollEmps = new JScrollPane(empInfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        
        // updating allEmps
        allEmpsPanel.removeAll();
        allEmpsPanel.add(scrollEmps);
        allEmpsPanel.revalidate();
        allEmpsPanel.repaint();
	}
	
	
	
	
	public DisplayAllEmployees(JFrame screen, JPanel mainMenu, MyHashTable emps){
		JPanel handler = new JPanel();
		handler.setLayout(new BoxLayout(handler, BoxLayout.Y_AXIS));
		handler.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Displaying All Employees");
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		titlePanel.add(title);
		handler.add(titlePanel);
		
		Component spacer1 = Box.createRigidArea(new Dimension(10, 20));
		handler.add(spacer1);

		handler.add(allEmpsPanel);
		
		Component spacer2 = Box.createRigidArea(new Dimension(10, 20));
		handler.add(spacer2);
		
		
		JPanel exitButtonPanel = new JPanel();
		JButton exitButton = new JButton("Return To Main Menu");
		exitButton.setPreferredSize(new Dimension(200, 40));
		exitButtonPanel.add(exitButton);
		handler.add(exitButtonPanel);
		
		
		panel.add(handler);
		panel.setVisible(false);
		
		exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	panel.setVisible(false);
            	mainMenu.setVisible(true);
            }
        });
	}
}
