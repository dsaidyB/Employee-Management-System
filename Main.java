import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		MyHashTable emps = new MyHashTable(20);
		 
		
		// to run multiple instances of EMS at the same time and have no issues with information loss and live updates and work with them both:
		// simply run this file reading code each time a feature is opened, so they all share same emps hashtable
		// and also run the file writing code each a feature is finished (except DisplayAllEmployees), so that the current version of emps is always saved to file
		
		
		// futhermore, for more clean code, the function to read and write to the ems file could be made to a function
		
		// alternatively, I could prevent multiple instances of EMS from running at the same time by creating a dummy file
		// and use that as a conditional to be able to an instance of EMS
		
		
		File file = new File("src\\EmployeeInfoStorage.txt"); // ask why it accesses outside of src when i try to access the text file in folder
		 // Note:  Double backquote is to avoid compiler interpret words like \test as \t (ie. as a escape sequence)
		
	    BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));

	        String st;
	        String[] empInfo = new String[10];
	        // PTE or FTE, 
			try {
				st = br.readLine();
				while (st != null) {
					//System.out.println(st);
					
					empInfo = st.split(",");
					
					// if i do == to a String object, it compares if the reference value is the same
					// if i do "text" == "text" then it does compare values because for literals, java compiler interns them meaning that
					// objects of equal values are reused 
					if (empInfo[0].equals("PTE")) {
						PTE emp = new PTE(Integer.parseInt(empInfo[1]), empInfo[2], empInfo[3], empInfo[4], empInfo[5], 
									Double.parseDouble(empInfo[6]), Double.parseDouble(empInfo[7]), Double.parseDouble(empInfo[8]), Double.parseDouble(empInfo[9]));
						
						emps.addToTable(emp);
					}
					
					if (empInfo[0].equals("FTE")) {
						FTE emp = new FTE(Integer.parseInt(empInfo[1]), empInfo[2], empInfo[3], empInfo[4], empInfo[5], 
									Double.parseDouble(empInfo[6]), Double.parseDouble(empInfo[7]));
						
						emps.addToTable(emp);
					}
					
					st = br.readLine();
				}
				
				br.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error while reading file.");
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found.");
		}
	    
		//emps.displayTable();
		
		
		
		
		
		File testFile = new File("src\\EMS_Open.txt"); // ask why it accesses outside of src when i try to access the text file in folder
	    BufferedReader test;
	    boolean emsOpen = false;
	    
		try {
			test = new BufferedReader(new FileReader(testFile));

	        String st = "";
	        // PTE or FTE, 
			try {
				st += test.readLine();
				
				if (st.equals("true")) {
					emsOpen = true;
				}
				
				test.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error while reading file.");
			}
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found.");
		}
		
		
		
		
		
		
		
		if (!emsOpen) {
			File editEMS = new File("src\\EMS_Open.txt");
           	
       		String str = "true";
       		
       	    BufferedWriter writer;
       		try {
       			writer = new BufferedWriter(new FileWriter(editEMS));
       			writer.write(str);
       			writer.close();
       			System.out.println("EMS Status Updated.");	
       		} 
       		catch (IOException e) {
       			// TODO Auto-generated catch block
       			System.out.println("Error writing to EMS status file.");
       		}
       		
       		new MainMenu(emps);
			
		}
		else {
			System.out.println("Session of EMS already open!");
			new EMS_Open();
		}
	}
}



//PARAMS

//pteEmpFN
//pteEmpLN
//pteSelectGender - combobox
//pteSelectLoc - combobox
//pteEmpDeducRate
//pteEmpHourlyWage
//pteEmpHoursPerWeek
//pteEmpWeeksPerYear
//
//
//fteEmpFN
//fteEmpLN
//fteSelectGender - combobox
//fteSelectLoc - combobox
//fteEmpDeducRate
//fteEmpYearlySalary
//
//String[] genderOptions = {"Male","Female","Other"};
//String[] locationOptions = {"Mississauga", "Toronto", "Waterloo"};
//String[] empTypes = {"PTE", "FTE"};