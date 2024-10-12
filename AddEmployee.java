import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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


public class AddEmployee {
	JPanel panel = new JPanel();

	public AddEmployee(JFrame screen, JPanel mainMenu, MyHashTable emps){
		JPanel handler = new JPanel();
		handler.setLayout(new BoxLayout(handler, BoxLayout.Y_AXIS));
		handler.setAlignmentX(Component.CENTER_ALIGNMENT);

		
		
		
		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Add Employee");
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		titlePanel.add(title);
		handler.add(titlePanel);
		
		
		
		String[] genderOptions = {"Male","Female","Other"};
		String[] locationOptions = {"Mississauga", "Toronto", "Waterloo"};
		
		JPanel empTypeOptions = new JPanel(new FlowLayout());
		JRadioButton optionPTE = new JRadioButton("Add a Part Time Employee");
		optionPTE.setSelected(true);
		Component optionsSpacer = Box.createRigidArea(new Dimension(60, 40));
		JRadioButton optionFTE = new JRadioButton("Add a Full Time Employee");
		
		ButtonGroup empOptionsButtons = new ButtonGroup();
		empOptionsButtons.add(optionPTE);
		empOptionsButtons.add(optionFTE);
		
		empTypeOptions.add(optionPTE);
		empTypeOptions.add(optionsSpacer);
		empTypeOptions.add(optionFTE);
		handler.add(empTypeOptions);
		
		
		
		
		
		
		Component spacer1 = Box.createRigidArea(new Dimension(10, 25));
		handler.add(spacer1);
		
		
		
		
		
		
		JPanel addPTEMenu = new JPanel();
		addPTEMenu.setLayout(new BoxLayout(addPTEMenu, BoxLayout.Y_AXIS));
		addPTEMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel pteID = new JPanel(new FlowLayout());
		JLabel pteIDLabel = new JLabel("Enter Employee ID Number: ");
		pteIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField pteEmpID = new JTextField();
		pteEmpID.setPreferredSize(new Dimension(100, 20));
		pteID.add(pteIDLabel);
		pteID.add(pteEmpID);
		addPTEMenu.add(pteID);
		
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
		addPTEMenu.setVisible(true); // auto toggles pte first for some reason
		
		
		
		
		
		
		
		
		JPanel addFTEMenu = new JPanel();
		addFTEMenu.setLayout(new BoxLayout(addFTEMenu, BoxLayout.Y_AXIS));
		addFTEMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JPanel fteID = new JPanel(new FlowLayout());
		JLabel fteIDLabel = new JLabel("Enter Employee ID Number: ");
		fteIDLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		JTextField fteEmpID = new JTextField();
		fteEmpID.setPreferredSize(new Dimension(100, 20));
		fteID.add(fteIDLabel);
		fteID.add(fteEmpID);
		addFTEMenu.add(fteID);
		
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
		
		
		
		
		
		
		JPanel doubleEmpErrorMessagePanel = new JPanel();
		JLabel doubleEmpErrorMessage = new JLabel("An employee with that ID number already exists!"); // change text to match boxes in event handler
		doubleEmpErrorMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		doubleEmpErrorMessage.setForeground(Color.RED);
		doubleEmpErrorMessagePanel.add(doubleEmpErrorMessage);
		
		handler.add(doubleEmpErrorMessagePanel);
		doubleEmpErrorMessagePanel.setVisible(false);
		
		
		
		
		
		
		
		JPanel errorMessagePanel = new JPanel();
		JLabel errorMessage = new JLabel("A field has an invalid input"); // change text to match boxes in event handler
		errorMessage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		errorMessage.setForeground(Color.RED);
		errorMessagePanel.add(errorMessage);
		
		handler.add(errorMessagePanel);
		errorMessagePanel.setVisible(false);
		
		
		
		
		
		JPanel submitButtonPanel = new JPanel();
		JButton submitButton = new JButton("Add Employee");
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
		JLabel confirmMessage = new JLabel("Employee Added!"); // change text to match boxes in event handler
		confirmMessage.setFont(new Font("Times New Roman", Font.BOLD, 28));
		confirmMessagePanel.add(confirmMessage);
		
		handler.add(confirmMessagePanel);
		confirmMessagePanel.setVisible(false);
		
		
		panel.add(handler);
		panel.setVisible(false);
		
		
		
		optionPTE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(optionPTE.isSelected()) {
					//System.out.println("add pte");
//					PTE somePTE = new PTE(123456, "Bugs", "Bunny", 0, 1, 0.1, 0.2, 0.15, 85000.50);
//					emps.addToTable(somePTE);
					addPTEMenu.setVisible(true);
					addFTEMenu.setVisible(false);
				}
				else {
					//System.out.println("bye pte");
					addPTEMenu.setVisible(false);
				}
			}  
		});
		
		optionFTE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(optionFTE.isSelected()) {
					//System.out.println("add fte");
					addFTEMenu.setVisible(true);
					addPTEMenu.setVisible(false);
				}
				else {
					//System.out.println("bye fte");
					addFTEMenu.setVisible(false);
				}
			}  
		});
		
		
		submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	boolean success = false;
            	try {
            		
            		// could update file each time this is called so even with multiple windows, it would update
            		
            		errorMessagePanel.setVisible(false);
            		doubleEmpErrorMessagePanel.setVisible(false);
            		
	            	if(optionPTE.isSelected()) {
	            		String pteFN = pteEmpFN.getText();
	            		String pteLN = pteEmpLN.getText();
	            		
	            		int pteEmpNum = Integer.parseInt(pteEmpID.getText());
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
	            		
	            		if (empExists || (pteFN.equals("") || pteLN.equals("")) ){ 
	            			//||(Integer.parseInt(pteEmpGender.getText()) > 2 || Integer.parseInt(pteEmpGender.getText()) < 0)
	            			//|| (Integer.parseInt(pteEmpWorkLoc.getText()) > 1 || Integer.parseInt(pteEmpWorkLoc.getText()) < 0)
	                		errorMessagePanel.setVisible(true);
	                		
	                		if (empExists) {
	                    		doubleEmpErrorMessagePanel.setVisible(true);
	                		}
	            		}
	            		
	            		else {	            			
	            			PTE newPTE = new PTE(pteEmpNum, pteFN, pteLN, pteSelectGender.getSelectedItem().toString(), 
	            							pteSelectLoc.getSelectedItem().toString(), Double.parseDouble(pteEmpDeducRate.getText()), 
	            							Double.parseDouble(pteEmpHourlyWage.getText()), Double.parseDouble(pteEmpHoursPerWeek.getText()), 
	            							Double.parseDouble(pteEmpWeeksPerYear.getText()));
	            		
	            			emps.addToTable(newPTE);
							success = true;
	            		}
	            	}
	            	
	            	else if(optionFTE.isSelected()) {
	            		String fteFN = fteEmpFN.getText();
	            		String fteLN = fteEmpLN.getText();
	            		
	            		int fteEmpNum = Integer.parseInt(fteEmpID.getText());
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
	            		
	            		if (empExists || (fteFN.equals("") || fteLN.equals("")) ){
	            			// || (Integer.parseInt(fteEmpGender.getText()) > 2 || Integer.parseInt(fteEmpGender.getText()) < 0)
	            			// || (Integer.parseInt(fteEmpWorkLoc.getText()) > 1 || Integer.parseInt(fteEmpWorkLoc.getText()) < 0)
	            			
	                		errorMessagePanel.setVisible(true);
	                		
	                		if (empExists) {
	                    		doubleEmpErrorMessagePanel.setVisible(true);
	                		}
	            		}
	            		
	            		else {
		            		FTE newFTE = new FTE(Integer.parseInt(fteEmpID.getText()), fteFN, fteLN, fteSelectGender.getSelectedItem().toString(), 
        							fteSelectLoc.getSelectedItem().toString(), Double.parseDouble(fteEmpDeducRate.getText()), 
        							Double.parseDouble(fteEmpYearlySalary.getText()));
		            		
							emps.addToTable(newFTE);
							success = true;
	            		}
	            	}
	            	
	            	
	            	
	            	if (success) {
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
	
		
		
//		panel.addComponentListener(new ComponentAdapter() 
//		{  
//		        public void componentResized(ComponentEvent evt) {
//		            Component c = (Component)evt.getSource();
//		            
//		            Rectangle r = screen.getBounds();
//		            int h = r.height;
//		            int w = r.width;
//		            if (h > w) {
//		            	title.setFont(new Font("Serif", Font.PLAIN, (w/16)));
//		            }
//		            else {
//		            	title.setFont(new Font("Serif", Font.PLAIN, (h/16)));
//		            }
//		            
//		            spacer1.setPreferredSize(new Dimension (10, h/5));
//		    		addEmpButton.setPreferredSize(new Dimension((w/4), (h/20)));
//		    		spacer2.setPreferredSize(new Dimension (10, h/16));
//		    		displayEmpsButton.setPreferredSize(new Dimension((w/4), (h/20)));
//		    		spacer3.setPreferredSize(new Dimension (10, h/16));
//		    		editEmpButton.setPreferredSize(new Dimension((w/4), (h/20)));
//		    		spacer4.setPreferredSize(new Dimension (10, h/16));
//		    		deleteEmpButton.setPreferredSize(new Dimension((w/4), (h/20)));    	
//		    		spacer5.setPreferredSize(new Dimension (10, h/16));
//		        }
//		});
		
		
		
	}
}
