import java.util.*;


public class MyHashTable {
	
	// ATTRIBUTES
	// buckets is an array of ArrayList.  Each item in an ArrayList is an EmployeeInfo
	// object holding a reference value pointing to a student.
	// the [] is what indicates that it is an array of ArrayLists
	// technically you could do double arraylist: ArrayList<ArrayList<TYPE>> lol = new ArrayList<ArrayList<TYPE>>;
	// technically you don't need the <EmployeeInfo>, that is to prevent raw type warning, where you might accidentally put different types in arraylist
	// arraylist is just a array but what happens is that it like copies the thing and makes bigger array if it overflows
	// the left side is kinda like, get ready to deal with this type in the array, points to like the start
	// "x marks the spot to a treasure chest"
	public ArrayList<EmployeeInfo>[] buckets;
	public int size;
	
	// CONSTRUCTOR
	public MyHashTable(int howManyBuckets) {
		
		size = 0;
		
		// Construct the hash table (open hashing/closed addressing) as an array of howManyBuckets ArrayLists.

		// Instantiate buckets as an array to have an ArrayList as each element of the array.
		// the arraylist is generic or something, and gives yellow underline warning here cuz array is type dependent or like more strict
		// generic don't track type or something so when I say <EmployeeInfo> it may not be possible
		// array is covariant --> super class can compile ex. you can put strings in an object array cuz like object is super of string
		// generics have stronger type check, so like u use the <>. this means that during execution after compiling, it returns to arraylist,
		// but all the things inside are type cast to string, so like inside the arraylist there is no mention of type, it is just cast
		// so there is no actual thing such as ArrayList<EmployeeInfo>, so the array cannot make it a thing
		// the right is the actual location of the interconnected set of data, "specify how big the treasure chest is"
		buckets = new ArrayList[howManyBuckets];

		// For each element in the array, instantiate its ArrayList.
		for (int i = 0; i < howManyBuckets; i++) {
			buckets[i] = new ArrayList<EmployeeInfo>();  // Instantiate the ArrayList for bucket i. If I put number in (), it will premake that size
		}
	}


	// METHODS
	public int calcBucket(int id) {
		return(id % buckets.length);  // employee number modulo number of buckets
	}


	public void addToTable(EmployeeInfo theEmp) {
		// Add the employee referenced by theEmp to the hash table.
		size += 1;
		
		if (theEmp == null) {
			return; // Nothing to do!
		}
		else {
			buckets[calcBucket(theEmp.empNum)].add(theEmp);
		}
	}


	public EmployeeInfo removeFromTable(int empNum) {
		// Remove that employee from the hash table and return the reference value for that employee.
		// Return null if that employee isn't in the table.
		
		EmployeeInfo temp;
		
		for (int i=0; i < buckets[calcBucket(empNum)].size(); i++) {
			if (buckets[calcBucket(empNum)].get(i).empNum == empNum) {
				temp = buckets[calcBucket(empNum)].get(i);
				buckets[calcBucket(empNum)].remove(i);
				size -= 1;
				return temp;
			}
		}
		
		// if not in hashtable
		return(null);
	}

	
	public EmployeeInfo getFromTable(int empNum) {
		// Return the reference value for that employee, return null if employee isn't in the table.

		for (int i=0; i < buckets[calcBucket(empNum)].size(); i++) {
			if (buckets[calcBucket(empNum)].get(i).empNum == empNum) {
				return buckets[calcBucket(empNum)].get(i);
			}
		}
		
		// if not in hashtable
		return(null);
	}


	public void displayTable() {
		// Walk through the buckets and display the items in each bucket's ArrayList.
		
		System.out.println("\n\nHERE ARE THE CONTENTS OF THE TABLE:\n");
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i].isEmpty()) {
				System.out.println("BUCKET " + i + " has an empty ArrayList!\n");
			}
			else {
				System.out.println("BUCKET " + i + " has an ArrayList holding the following employees:");
				// Print out the first name of each employee in the ArrayList for the current bucket.
				for (int j = 0; j < buckets[i].size(); j++) {
					System.out.println("  " + buckets[i].get(j).firstName);
				}
			}
		}
		
	}

}
