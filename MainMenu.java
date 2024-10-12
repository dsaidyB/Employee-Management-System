import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainMenu {

	public MainMenu(MyHashTable emps) {
		JFrame frame = new JFrame();
		frame.setTitle("Employee Management System");
		frame.setSize(800, 800); // initial window size
		frame.setResizable(false); // if i wanna stop resizing
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		
		
		JPanel mainMenu = new JPanel();
		AddEmployee addEmp = new AddEmployee(frame, mainMenu, emps);
		DisplayAllEmployees displayEmps = new DisplayAllEmployees(frame, mainMenu, emps);
		EditEmployee editEmp = new EditEmployee(frame, mainMenu, emps);
		DeleteEmployee deleteEmp = new DeleteEmployee(frame, mainMenu, emps);


		
		JPanel handler = new JPanel();
		handler.setLayout(new BoxLayout(handler, BoxLayout.Y_AXIS));
		handler.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel titlePanel = new JPanel();
		JLabel title = new JLabel("Employee Management System");
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		titlePanel.add(title);
		handler.add(titlePanel);

		Component spacer1 = Box.createRigidArea(new Dimension(10, 20));
		handler.add(spacer1);
		
		
		try {
			BufferedImage emsLogo = ImageIO.read(new File("src\\EMS_Logo.png"));
			Image editedLogo = emsLogo.getScaledInstance(446, 250, Image.SCALE_DEFAULT);
			JLabel picLabel = new JLabel(new ImageIcon(editedLogo));
			JPanel picPanel = new JPanel();
			picPanel.add(picLabel);
			handler.add(picPanel);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Component spacerException = Box.createRigidArea(new Dimension(10, 160));
			handler.add(spacerException);
		}
		
		Component spacer2 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer2);
		
		JPanel addEmpButtonPanel = new JPanel();
		JButton addEmpButton = new JButton("Add Employee");
		addEmpButton.setPreferredSize(new Dimension(200, 40));
		addEmpButtonPanel.add(addEmpButton);
		handler.add(addEmpButtonPanel);
		
		Component spacer3 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer3);
		
		JPanel displayEmpsButtonPanel = new JPanel();
		JButton displayEmpsButton = new JButton("Display All Employees");
		displayEmpsButton.setPreferredSize(new Dimension(200, 40));
		displayEmpsButtonPanel.add(displayEmpsButton);
		handler.add(displayEmpsButtonPanel);
		
		Component spacer4 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer4);
		
		JPanel editEmpButtonPanel = new JPanel();
		JButton editEmpButton = new JButton("Edit Employee");
		editEmpButton.setPreferredSize(new Dimension(200, 40));
		editEmpButtonPanel.add(editEmpButton);
		handler.add(editEmpButtonPanel);
		
		Component spacer5 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer5);
		
		JPanel deleteEmpButtonPanel = new JPanel();
		JButton deleteEmpButton = new JButton("Delete Employee");
		deleteEmpButton.setPreferredSize(new Dimension(200, 40));
		deleteEmpButtonPanel.add(deleteEmpButton);
		handler.add(deleteEmpButtonPanel);
		
		Component spacer6 = Box.createRigidArea(new Dimension(10, 40));
		handler.add(spacer6);
		
		mainMenu.add(handler);
		mainMenu.setVisible(true);

		mainMenu.addComponentListener(new ComponentAdapter() 
		{  
		        public void componentResized(ComponentEvent evt) {
		            Component c = (Component)evt.getSource();
		            
		            Rectangle r = frame.getBounds();
		            int h = r.height;
		            int w = r.width;
		            if (h > w) {
		            	title.setFont(new Font("Serif", Font.PLAIN, (w/16)));
		            }
		            else {
		            	title.setFont(new Font("Serif", Font.PLAIN, (h/16)));
		            }
		            
		            spacer1.setPreferredSize(new Dimension (10, h/40));
		            spacer2.setPreferredSize(new Dimension (10, h/20));
		    		addEmpButton.setPreferredSize(new Dimension((w/4), (h/20)));
		    		spacer3.setPreferredSize(new Dimension (10, h/20));
		    		displayEmpsButton.setPreferredSize(new Dimension((w/4), (h/20)));
		    		spacer4.setPreferredSize(new Dimension (10, h/20));
		    		editEmpButton.setPreferredSize(new Dimension((w/4), (h/20)));
		    		spacer5.setPreferredSize(new Dimension (10, h/20));
		    		deleteEmpButton.setPreferredSize(new Dimension((w/4), (h/20)));    	
		    		spacer6.setPreferredSize(new Dimension (10, h/20));
		        }
		});

		addEmpButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mainMenu.setVisible(false);
            	addEmp.panel.setVisible(true);
            }
        });
		
		displayEmpsButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	// update the allEmps JPanel each time it is accessed
            	displayEmps.updateEmps(emps);
            	
                mainMenu.setVisible(false);
            	displayEmps.panel.setVisible(true);
            }
        });
		
		editEmpButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mainMenu.setVisible(false);
            	editEmp.panel.setVisible(true);
            }
        });
		
		deleteEmpButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mainMenu.setVisible(false);
            	deleteEmp.panel.setVisible(true);
            }
        });
		
		
		
		
		frame.add(mainMenu);
		frame.add(addEmp.panel);
		frame.add(displayEmps.panel);
		frame.add(editEmp.panel);
		frame.add(deleteEmp.panel);
		
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
	           @Override
	           public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	               System.out.println("Frame closing");
	               
	               	File file = new File("src\\EmployeeInfoStorage.txt");
	               	
		       		String str = "";
		       		
		       		for (int i=0; i<emps.buckets.length; i++) {
		       			for (int j=0; j<emps.buckets[i].size(); j++) {
		       				if (emps.buckets[i].get(j) instanceof FTE) {
		       					FTE tempFTE = (FTE) emps.buckets[i].get(j);
		       					str += "FTE," + Integer.toString(tempFTE.empNum) + "," + tempFTE.firstName + "," + tempFTE.lastName +"," + tempFTE.gender 
		       							+ "," + tempFTE.workLoc + "," + Double.toString(tempFTE.deductRate) + "," + Double.toString(tempFTE.yearlySalary)
		       							+ "\n";
		       				}
		       				
		       				if (emps.buckets[i].get(j) instanceof PTE) {
		       					PTE tempPTE = (PTE) emps.buckets[i].get(j);
		       					str += "PTE," + Integer.toString(tempPTE.empNum) + "," + tempPTE.firstName + "," + tempPTE.lastName +"," + tempPTE.gender 
       									+ "," + tempPTE.workLoc + "," + Double.toString(tempPTE.deductRate) + "," + Double.toString(tempPTE.hourlyWage)
       									+ "," + Double.toString(tempPTE.hoursPerWeek) + "," + Double.toString(tempPTE.weeksPerYear)
       									+ "\n";
		       				}
		       			}
		       		}
		       		
		       	    BufferedWriter writer;
		       		try {
		       			writer = new BufferedWriter(new FileWriter(file));
		       			writer.write(str);
		       			writer.close();
		       			System.out.println("Employee Info Saved.");	
		       		} 
		       		catch (IOException e) {
		       			// TODO Auto-generated catch block
		       			System.out.println("Error writing to file.");
		       		}
		       		
		       		
		       		
		       		
		       		File editEMS = new File("src\\EMS_Open.txt");
		           	
		       		String update = "false";
		       		
		       	    BufferedWriter updateWriter;
		       		try {
		       			updateWriter = new BufferedWriter(new FileWriter(editEMS));
		       			updateWriter.write(update);
		       			updateWriter.close();
		       			System.out.println("EMS Status Updated.");	
		       		} 
		       		catch (IOException e) {
		       			// TODO Auto-generated catch block
		       			System.out.println("Error writing to EMS status file.");
		       		}
	               
		       		
	               System.exit(0);
	           }
	       });
	       
		frame.setVisible(true);
	}
}

//MainMenu menu = new MainMenu(frame);
//frame.add(menu.panel);
//	//System.out.println(frame.getComponents());
//	MainMenu m = new MainMenu(frame);
//	JScrollPane pane = new JScrollPane();
//	pane.setViewportView(m.panel);
//  frame.getContentPane().add(pane);
