import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class EditEmployee {
	JPanel panel = new JPanel();

	public EditEmployee(JFrame screen, JPanel mainMenu, MyHashTable emps){
		JPanel handler = new JPanel();
		handler.setLayout(new BoxLayout(handler, BoxLayout.Y_AXIS));
		handler.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Edit Employee");
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		titlePanel.add(title);
		handler.add(titlePanel);
		
		Component topSpacer = Box.createRigidArea(new Dimension(10, 40));
		handler.add(topSpacer);
		
		
		JPanel id = new JPanel(new FlowLayout());
		JLabel idLabel = new JLabel("Enter Employee ID Number: ");
		idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField empID = new JTextField();
		empID.setPreferredSize(new Dimension(100, 20));		
		

		id.add(idLabel);
		id.add(empID);
		handler.add(id);
		
		Component spacerI1 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacerI1);
		
		
		
		
		
		JPanel searchErrorMessagePanel = new JPanel();
		JLabel searchErrorMessage = new JLabel("Entered ID is invalid!"); // change text to match boxes in event handler
		searchErrorMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		searchErrorMessage.setForeground(Color.RED);
		searchErrorMessagePanel.add(searchErrorMessage);
		
		handler.add(searchErrorMessagePanel);
		searchErrorMessagePanel.setVisible(false);
		
		
		
		JPanel searchEmpPanel = new JPanel();
		JButton searchEmpButton = new JButton("Get Employee and Continue");
		searchEmpButton.setPreferredSize(new Dimension(200, 40));
		searchEmpPanel.add(searchEmpButton);
		handler.add(searchEmpPanel);
		
		Component spacerI2 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacerI2);
		
		
		
		
		
		
		
		
		// add the edit menus
		
		JPanel displayEmpIDPanel = new JPanel();
		JLabel displayEmpID = new JLabel();
		displayEmpID.setFont(new Font("Times New Roman", Font.BOLD, 24));
		displayEmpIDPanel.add(displayEmpID);
		handler.add(displayEmpIDPanel);
		displayEmpIDPanel.setVisible(false);

		
		
		String[] genderOptions = {"Male","Female","Other"};
		String[] locationOptions = {"Mississauga", "Toronto", "Waterloo"};
		String[] empTypes = {"PTE", "FTE"};
		
		JPanel empTypeOptionsPanel = new JPanel(new FlowLayout());
		JLabel empTypeLabel = new JLabel("Select Employee Type: ");  //(0 for Mississauaga, 1 for Toronto)
		empTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		JComboBox empTypeOptions = new JComboBox(empTypes);
		empTypeOptions.setPreferredSize(new Dimension(100, 20));
		empTypeOptionsPanel.add(empTypeLabel);
		empTypeOptionsPanel.add(empTypeOptions);
		handler.add(empTypeOptionsPanel);
		empTypeOptionsPanel.setVisible(false);
		
		
		
		Component spacer1 = Box.createRigidArea(new Dimension(10, 25));
		handler.add(spacer1);
		
		
		
		
		
		
		JPanel addPTEMenu = new JPanel();
		addPTEMenu.setLayout(new BoxLayout(addPTEMenu, BoxLayout.Y_AXIS));
		addPTEMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel pteFN = new JPanel(new FlowLayout());
		JLabel pteFNLabel = new JLabel("Enter Employee First Name: ");
		pteFNLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpFN = new JTextField();
		pteEmpFN.setPreferredSize(new Dimension(100, 20));
		pteFN.add(pteFNLabel);
		pteFN.add(pteEmpFN);
		addPTEMenu.add(pteFN);
		
		
		JPanel pteLN = new JPanel(new FlowLayout());
		JLabel pteLNLabel = new JLabel("Enter Employee Last Name: ");
		pteLNLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpLN = new JTextField();
		pteEmpLN.setPreferredSize(new Dimension(100, 20));
		pteLN.add(pteLNLabel);
		pteLN.add(pteEmpLN);
		addPTEMenu.add(pteLN);
		
		
		
		
		JPanel pteGender = new JPanel(new FlowLayout());
		JLabel pteGenderLabel = new JLabel("Select Employee Gender: "); // (0 for F, 1 for M, 2 for Other)
		pteGenderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		JTextField pteEmpGender = new JTextField();
//		pteEmpGender.setPreferredSize(new Dimension(100, 20));
		JComboBox pteSelectGender = new JComboBox(genderOptions);
		pteSelectGender.setPreferredSize(new Dimension(100, 20));
		pteGender.add(pteGenderLabel);
//		pteGender.add(pteEmpGender);
		pteGender.add(pteSelectGender);
		addPTEMenu.add(pteGender);
		
		
		JPanel pteWorkLoc = new JPanel(new FlowLayout());
		JLabel pteWorkLocLabel = new JLabel("Enter Employee Work Location: "); //(0 for Mississauaga, 1 for Toronto)
		pteWorkLocLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		JTextField pteEmpWorkLoc = new JTextField();
//		pteEmpWorkLoc.setPreferredSize(new Dimension(100, 20));
		JComboBox pteSelectLoc = new JComboBox(locationOptions);
		pteSelectLoc.setPreferredSize(new Dimension(100, 20));
		pteWorkLoc.add(pteWorkLocLabel);
//		pteWorkLoc.add(pteEmpWorkLoc);
		pteWorkLoc.add(pteSelectLoc);
		addPTEMenu.add(pteWorkLoc);
		
		JPanel pteDeducRate = new JPanel(new FlowLayout());
		JLabel pteDeducRateLabel = new JLabel("Enter Employee Deduction Rate: ");
		pteDeducRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpDeducRate = new JTextField();
		pteEmpDeducRate.setPreferredSize(new Dimension(100, 20));
		pteDeducRate.add(pteDeducRateLabel);
		pteDeducRate.add(pteEmpDeducRate);
		addPTEMenu.add(pteDeducRate);
		
		JPanel pteHourlyWage = new JPanel(new FlowLayout());
		JLabel pteHourlyWageLabel = new JLabel("Enter Employee Hourly Wage: ");
		pteHourlyWageLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpHourlyWage = new JTextField();
		pteEmpHourlyWage.setPreferredSize(new Dimension(100, 20));
		pteHourlyWage.add(pteHourlyWageLabel);
		pteHourlyWage.add(pteEmpHourlyWage);
		addPTEMenu.add(pteHourlyWage);
		
		JPanel pteHoursPerWeek = new JPanel(new FlowLayout());
		JLabel pteHoursPerWeekLabel = new JLabel("Enter Employee Hours Per Week: ");
		pteHoursPerWeekLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpHoursPerWeek = new JTextField();
		pteEmpHoursPerWeek.setPreferredSize(new Dimension(100, 20));
		pteHoursPerWeek.add(pteHoursPerWeekLabel);
		pteHoursPerWeek.add(pteEmpHoursPerWeek);
		addPTEMenu.add(pteHoursPerWeek);
		
		JPanel pteWeeksPerYear = new JPanel(new FlowLayout());
		JLabel pteWeeksPerYearLabel = new JLabel("Enter Employee Weeks Per Year: ");
		pteWeeksPerYearLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpWeeksPerYear = new JTextField();
		pteEmpWeeksPerYear.setPreferredSize(new Dimension(100, 20));
		pteWeeksPerYear.add(pteWeeksPerYearLabel);
		pteWeeksPerYear.add(pteEmpWeeksPerYear);
		addPTEMenu.add(pteWeeksPerYear);
		
		handler.add(addPTEMenu);
		addPTEMenu.setVisible(false); // auto toggles pte first for some reason
		
		
		
		
		
		
		
		
		JPanel addFTEMenu = new JPanel();
		addFTEMenu.setLayout(new BoxLayout(addFTEMenu, BoxLayout.Y_AXIS));
		addFTEMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel fteID = new JPanel(new FlowLayout());
		
		
		JPanel fteFN = new JPanel(new FlowLayout());
		JLabel fteFNLabel = new JLabel("Enter Employee First Name: ");
		fteFNLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField fteEmpFN = new JTextField();
		fteEmpFN.setPreferredSize(new Dimension(100, 20));
		fteFN.add(fteFNLabel);
		fteFN.add(fteEmpFN);
		addFTEMenu.add(fteFN);
		
		
		JPanel fteLN = new JPanel(new FlowLayout());
		JLabel fteLNLabel = new JLabel("Enter Employee Last Name: ");
		fteLNLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField fteEmpLN = new JTextField();
		fteEmpLN.setPreferredSize(new Dimension(100, 20));
		fteLN.add(fteLNLabel);
		fteLN.add(fteEmpLN);
		addFTEMenu.add(fteLN);
		
		
		JPanel fteGender = new JPanel(new FlowLayout());
		JLabel fteGenderLabel = new JLabel("Select Employee Gender: "); // (0 for F, 1 for M, 2 for Other): 
		fteGenderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		JTextField fteEmpGender = new JTextField();
//		fteEmpGender.setPreferredSize(new Dimension(100, 20));
		JComboBox fteSelectGender = new JComboBox(genderOptions);
		fteSelectGender.setPreferredSize(new Dimension(100, 20));
		fteGender.add(fteGenderLabel);
//		fteGender.add(fteEmpGender);
		fteGender.add(fteSelectGender);
		addFTEMenu.add(fteGender);
		
		
		JPanel fteWorkLoc = new JPanel(new FlowLayout());
		JLabel fteWorkLocLabel = new JLabel("Enter Employee Work Location: ");  //(0 for Mississauaga, 1 for Toronto)
		fteWorkLocLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
//		JTextField fteEmpWorkLoc = new JTextField();
//		fteEmpWorkLoc.setPreferredSize(new Dimension(100, 20));
		JComboBox fteSelectLoc = new JComboBox(locationOptions);
		fteSelectLoc.setPreferredSize(new Dimension(100, 20));
		fteWorkLoc.add(fteWorkLocLabel);
//		fteWorkLoc.add(fteEmpWorkLoc);
		fteWorkLoc.add(fteSelectLoc);
		addFTEMenu.add(fteWorkLoc);
		
		
		JPanel fteDeducRate = new JPanel(new FlowLayout());
		JLabel fteDeducRateLabel = new JLabel("Enter Employee Deduction Rate: ");
		fteDeducRateLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField fteEmpDeducRate = new JTextField();
		fteEmpDeducRate.setPreferredSize(new Dimension(100, 20));
		fteDeducRate.add(fteDeducRateLabel);
		fteDeducRate.add(fteEmpDeducRate);
		addFTEMenu.add(fteDeducRate);
		
		JPanel fteYearlySalary = new JPanel(new FlowLayout());
		JLabel fteYearlySalaryLabel = new JLabel("Enter Employee Yearly Salary: ");
		fteYearlySalaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField fteEmpYearlySalary = new JTextField();
		fteEmpYearlySalary.setPreferredSize(new Dimension(100, 20));
		fteYearlySalary.add(fteYearlySalaryLabel);
		fteYearlySalary.add(fteEmpYearlySalary);
		addFTEMenu.add(fteYearlySalary);
		
		handler.add(addFTEMenu);
		addFTEMenu.setVisible(false);
		
		
		
		
		
		
		
		Component spacer2 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer2);

		
		
		
		JPanel errorMessagePanel = new JPanel();
		JLabel errorMessage = new JLabel("A field has an invalid input"); // change text to match boxes in event handler
		errorMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		errorMessage.setForeground(Color.RED);
		errorMessagePanel.add(errorMessage);
		
		handler.add(errorMessagePanel);
		errorMessagePanel.setVisible(false);
		
		
		
		
		
		
		
		JPanel submitButtonPanel = new JPanel();
		JButton submitButton = new JButton("Edit Employee");
		submitButton.setPreferredSize(new Dimension(200, 40));
		submitButtonPanel.add(submitButton);
		handler.add(submitButtonPanel);
		submitButtonPanel.setVisible(false);
		
		
		
		Component spacer3 = Box.createRigidArea(new Dimension(10, 20));
		handler.add(spacer3);
		
		
		
		
		// main menu return
		
		JPanel exitButtonPanel = new JPanel();
		JButton exitButton = new JButton("Return To Main Menu");
		exitButton.setPreferredSize(new Dimension(200, 40));
		exitButtonPanel.add(exitButton);
		handler.add(exitButtonPanel);
		
		
		
		Component spacer4 = Box.createRigidArea(new Dimension(10, 20));
		handler.add(spacer4);
		
		
		
		JPanel confirmMessagePanel = new JPanel();
		JLabel confirmMessage = new JLabel("Employee Edited!"); // change text to match boxes in event handler
		confirmMessage.setFont(new Font("Times New Roman", Font.BOLD, 28));
		confirmMessagePanel.add(confirmMessage);
		
		handler.add(confirmMessagePanel);
		confirmMessagePanel.setVisible(false);
		
		
		panel.add(handler);
		panel.setVisible(false);
		
		
		
		
		
		
		searchEmpButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		searchErrorMessagePanel.setVisible(false);
        		int editEmpID;
            	try {
            		editEmpID = Integer.parseInt(empID.getText());
            		
            		if (emps.getFromTable(editEmpID) != null) {
            			id.setVisible(false);
            			searchEmpPanel.setVisible(false);
            			spacerI1.setVisible(false);
            			spacerI2.setVisible(false);
            			
            			displayEmpIDPanel.setVisible(true);
            			displayEmpID.setText("Editing Employee Number: " + Integer.toString(editEmpID));
            			submitButtonPanel.setVisible(true);
            			
            			// display the inital choose menus
            			if (emps.getFromTable(editEmpID) instanceof PTE) {
            				empTypeOptionsPanel.setVisible(true);
            				empTypeOptions.setSelectedIndex(0);
                    		addPTEMenu.setVisible(true);
                    		
                    		PTE tempPTE = (PTE) emps.getFromTable(editEmpID);
                    		
                    		pteEmpFN.setText(tempPTE.firstName);
                    		pteEmpLN.setText(tempPTE.lastName);
                  		
                    		if (tempPTE.gender.equals("Male")) {
                    			pteSelectGender.setSelectedIndex(0);
                    		}
                    		if (tempPTE.gender.equals("Female")) {
                    			pteSelectGender.setSelectedIndex(1);
                    		}
                    		if (tempPTE.gender.equals("Other")) {
                    			pteSelectGender.setSelectedIndex(2);
                    		}
                    		
                    		
                    		if (tempPTE.gender.equals("Mississauga")) {
                    			pteSelectLoc.setSelectedIndex(0);
                    		}
                    		if (tempPTE.gender.equals("Toronto")) {
                    			pteSelectLoc.setSelectedIndex(1);
                    		}
                    		if (tempPTE.gender.equals("Waterloo")) {
                    			pteSelectLoc.setSelectedIndex(2);
                    		}
                    		
                    		pteEmpDeducRate.setText(Double.toString(tempPTE.deductRate));
                    		


                    		
                    		fteEmpFN.setText(tempPTE.firstName);
                    		fteEmpLN.setText(tempPTE.lastName);
                    		
                    		if (tempPTE.gender.equals("Male")) {
                    			fteSelectGender.setSelectedIndex(0);
                    		}
                    		if (tempPTE.gender.equals("Female")) {
                    			fteSelectGender.setSelectedIndex(1);
                    		}
                    		if (tempPTE.gender.equals("Other")) {
                    			fteSelectGender.setSelectedIndex(2);
                    		}
                    		
                    		
                    		if (tempPTE.gender.equals("Mississauga")) {
                    			fteSelectLoc.setSelectedIndex(0);
                    		}
                    		if (tempPTE.gender.equals("Toronto")) {
                    			fteSelectLoc.setSelectedIndex(1);
                    		}
                    		if (tempPTE.gender.equals("Waterloo")) {
                    			fteSelectLoc.setSelectedIndex(2);
                    		}
                    		
                    		fteEmpDeducRate.setText(Double.toString(tempPTE.deductRate));
                    		
                    		
                    		
                    		
                    		pteEmpHourlyWage.setText(Double.toString(tempPTE.hourlyWage));
                    		pteEmpHoursPerWeek.setText(Double.toString(tempPTE.hoursPerWeek));
                    		pteEmpWeeksPerYear.setText(Double.toString(tempPTE.weeksPerYear));

            			}
            			else if (emps.getFromTable(editEmpID) instanceof FTE){
            				empTypeOptionsPanel.setVisible(true);
            				empTypeOptions.setSelectedIndex(1);
                    		addFTEMenu.setVisible(true);
                    		
                    		
                    		FTE tempFTE = (FTE) emps.getFromTable(editEmpID);

                    		
                    		fteEmpFN.setText(tempFTE.firstName);
                    		fteEmpLN.setText(tempFTE.lastName);
                    		
                    		if (tempFTE.gender.equals("Male")) {
                    			fteSelectGender.setSelectedIndex(0);
                    		}
                    		if (tempFTE.gender.equals("Female")) {
                    			fteSelectGender.setSelectedIndex(1);
                    		}
                    		if (tempFTE.gender.equals("Other")) {
                    			fteSelectGender.setSelectedIndex(2);
                    		}
                    		
                    		
                    		if (tempFTE.gender.equals("Mississauga")) {
                    			fteSelectLoc.setSelectedIndex(0);
                    		}
                    		if (tempFTE.gender.equals("Toronto")) {
                    			fteSelectLoc.setSelectedIndex(1);
                    		}
                    		if (tempFTE.gender.equals("Waterloo")) {
                    			fteSelectLoc.setSelectedIndex(2);
                    		}
                    		
                    		fteEmpDeducRate.setText(Double.toString(tempFTE.deductRate));
                    		
                    		
                    		
                    		
                    		pteEmpFN.setText(tempFTE.firstName);
                    		pteEmpLN.setText(tempFTE.lastName);
                  		
                    		if (tempFTE.gender.equals("Male")) {
                    			pteSelectGender.setSelectedIndex(0);
                    		}
                    		if (tempFTE.gender.equals("Female")) {
                    			pteSelectGender.setSelectedIndex(1);
                    		}
                    		if (tempFTE.gender.equals("Other")) {
                    			pteSelectGender.setSelectedIndex(2);
                    		}
                    		
                    		
                    		if (tempFTE.gender.equals("Mississauga")) {
                    			pteSelectLoc.setSelectedIndex(0);
                    		}
                    		if (tempFTE.gender.equals("Toronto")) {
                    			pteSelectLoc.setSelectedIndex(1);
                    		}
                    		if (tempFTE.gender.equals("Waterloo")) {
                    			pteSelectLoc.setSelectedIndex(2);
                    		}
                    		
                    		pteEmpDeducRate.setText(Double.toString(tempFTE.deductRate));
                    		
                    		
                    		fteEmpYearlySalary.setText(Double.toString(tempFTE.yearlySalary));
            			}
            			
            		}
            		
            		
            		else {
            			searchErrorMessagePanel.setVisible(true);
            		}
            	}
            	
            	catch (Exception e) {
            		searchErrorMessagePanel.setVisible(true);
            	}
            }
		});
		
		
		empTypeOptions.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if (empTypeOptions.getSelectedItem().toString().equals("PTE")) {
            		addPTEMenu.setVisible(true);
            		addFTEMenu.setVisible(false);
            	}
            	
            	else if (empTypeOptions.getSelectedItem().toString().equals("FTE")) {
            		addFTEMenu.setVisible(true);
            		addPTEMenu.setVisible(false);
            	}
            }
        });
		
		
		
		
		
		
		// submit --> remove emp and read the new version, 
		// also id.setVisible(true);	searchEmpPanel.setVisible(true);    stop displaying choose menus, go back to main menu
		
		submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boolean success = false;
            	try {
            		
            		// could update file each time this is called so even with multiple windows, it would update
            		
            		errorMessagePanel.setVisible(false);
            		
            		
	            	if(empTypeOptions.getSelectedItem().toString().equals("PTE")) {
	            		String pteFN = pteEmpFN.getText();
	            		String pteLN = pteEmpLN.getText();
	            		
	            		int pteEmpNum = Integer.parseInt(empID.getText());
            			boolean empExists = false;
            			
            			outerloop:
            			for (int i = 0; i < emps.buckets.length; i++) {
        					for (int j = 0; j < emps.buckets[i].size(); j++) {
        						if (pteEmpNum == emps.buckets[i].get(j).empNum) {
        							empExists = true;
        							break outerloop;
        						}
        					}
            			}
	            		
	            		if ((pteFN.equals("") || pteLN.equals("")) ){ 
	                		errorMessagePanel.setVisible(true);
	            		}
	            		
	            		else {	            			
	            			PTE newPTE = new PTE(pteEmpNum, pteFN, pteLN, pteSelectGender.getSelectedItem().toString(), 
	            							pteSelectLoc.getSelectedItem().toString(), Double.parseDouble(pteEmpDeducRate.getText()), 
	            							Double.parseDouble(pteEmpHourlyWage.getText()), Double.parseDouble(pteEmpHoursPerWeek.getText()), 
	            							Double.parseDouble(pteEmpWeeksPerYear.getText()));
	            			
	            			emps.removeFromTable(pteEmpNum);
	            			emps.addToTable(newPTE);
							success = true;
	            		}
	            	}
	            	
	            	else if(empTypeOptions.getSelectedItem().toString().equals("FTE")) {
	            		String fteFN = fteEmpFN.getText();
	            		String fteLN = fteEmpLN.getText();
	            		
	            		int fteEmpNum = Integer.parseInt(empID.getText());
            			boolean empExists = false;
            			
            			outerloop:
            			for (int i = 0; i < emps.buckets.length; i++) {
        					for (int j = 0; j < emps.buckets[i].size(); j++) {
        						if (fteEmpNum == emps.buckets[i].get(j).empNum) {
        							empExists = true;
        							break outerloop;
        						}
        					}
            			}
	            		
	            		if ((fteFN.equals("") || fteLN.equals("")) ){
	            			errorMessagePanel.setVisible(true);
	            		}
	            		
	            		else {
		            		FTE newFTE = new FTE(fteEmpNum, fteFN, fteLN, fteSelectGender.getSelectedItem().toString(), 
        							fteSelectLoc.getSelectedItem().toString(), Double.parseDouble(fteEmpDeducRate.getText()), 
        							Double.parseDouble(fteEmpYearlySalary.getText()));
		            		
		            		emps.removeFromTable(fteEmpNum);
							emps.addToTable(newFTE);
							success = true;
	            		}
	            	}
	            	
	            	
	            	
	            	if (success) {
		            	confirmMessagePanel.setVisible(true);
			
		            	Timer timer = new Timer(1000, new ActionListener() {
		            		public void actionPerformed(ActionEvent e) {
		            			confirmMessagePanel.setVisible(false);		            			

		            			id.setVisible(true);	
		                    	searchEmpPanel.setVisible(true);
		                    	spacerI1.setVisible(true);
		            			spacerI2.setVisible(true);
		                    	
		                    	
		                    	displayEmpIDPanel.setVisible(false);
		                    	submitButtonPanel.setVisible(false);
		                    	empTypeOptionsPanel.setVisible(false);
		                    	addFTEMenu.setVisible(false);
		                    	addPTEMenu.setVisible(false);
		                    	
		                    	pteEmpHourlyWage.setText("");
		                    	pteEmpHoursPerWeek.setText("");
		                    	pteEmpWeeksPerYear.setText("");
		                    	fteEmpYearlySalary.setText("");
		                    	
		                    	
		                    	panel.setVisible(false);
		                    	mainMenu.setVisible(true);
		                    }
		                });
		            	
		            	timer.setRepeats(false);
		            	timer.start();
	            	}
            	}
            	
            	catch (Exception e) {
            		errorMessagePanel.setVisible(true);
            	}
            }
        });
		
		
		
		
		
		
		
		
		

		
		exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	id.setVisible(true);	
            	searchEmpPanel.setVisible(true);
            	spacerI1.setVisible(true);
    			spacerI2.setVisible(true);
            	
            	
            	displayEmpIDPanel.setVisible(false);
            	submitButtonPanel.setVisible(false);
            	empTypeOptionsPanel.setVisible(false);
            	addFTEMenu.setVisible(false);
            	addPTEMenu.setVisible(false);
            	
            	pteEmpHourlyWage.setText("");
            	pteEmpHoursPerWeek.setText("");
            	pteEmpWeeksPerYear.setText("");
            	fteEmpYearlySalary.setText("");
            	
            	
            	panel.setVisible(false);
            	mainMenu.setVisible(true);
            }
        });
	}
}
