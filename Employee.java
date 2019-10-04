//Benjamin Longwell
//CS272, LAB2
//A class representing an Employee; contains employee name, state, number, age, zip, and advisors

public class Employee {
	//Instance Variables
	String employeeName, employeeState;
	int employeeNo, employeeAge, employeeZip;
	int[] advisors;
	
	//Employee Constructor
	public Employee() {
		employeeName = null;
		employeeState = null;
		employeeNo = 0;
		employeeAge = 0;
		employeeZip = 0;
		advisors = new int[]{0, 0, 0};
	}//end Employee constructor
	
	public Employee(Object obj) {
		if(obj == null) return;
		if(obj instanceof Employee) {
			int[] temp = {0, 0, 0};
			int[] temp1 = ((Employee) obj).getAdvisors();
			this.employeeName = ((Employee) obj).getEmployeeName();
			this.employeeState = ((Employee) obj).getEmployeeState();
			this.employeeNo = ((Employee) obj).getEmployeeNo();
			this.employeeAge = ((Employee) obj).getEmployeeAge();
			this.employeeZip = ((Employee) obj).getEmployeeZip();
			for(int i = 0; i < 3; i++) temp[i] = temp1[i];			
			this.advisors = temp;			
		}//end if
		else return;
	}//end copy constructor for Employee
	
	//Employee Copy Constructor
	
	//accessors
	//each get their respective value and return them according to the return type
	public String getEmployeeName() {return employeeName;}
	public String getEmployeeState() {return employeeState;}
	public int getEmployeeNo() {return employeeNo;}
	public int getEmployeeAge() {return employeeAge;}
	public int getEmployeeZip() {return employeeZip;}
	public int[] getAdvisors() {return advisors;}
	
	//mutators
	//each set their respective value according to a parameter matching the proper variable type
	public void setEmployeeName(String eName) { employeeName = new String(eName);}
	public void setEmployeeState(String eState) { employeeState = new String(eState);}
	public void setEmployeeNo(int eNo) { employeeNo = eNo;}
	public void setEmployeeAge(int eAge) {employeeAge = eAge;}
	public void setEmployeeZip(int eZip) {employeeZip = eZip;}
	public void setAdvisors(int a1, int a2, int a3) {
		advisors[0] = a1;
		advisors[1] = a2;
		advisors[2] = a3;		
	}//end setEmployeeAdvisors()
	
	//toString method to more easily print out the object of the class
	public String toString() {
		String a = String.format("Name: %-20s \t State: %5s, Number: %-10d Age: %5d Zip: %-8d Advisors: ", employeeName, employeeState, employeeNo, employeeAge, employeeZip);
		String b = "";
		for(int i = 0; i < 3; i++) {
			b = b + " ";
			b = b + advisors[i];
		}//end for
		return a + b;
	}//end toString
	
	//tests equality of 2 Employee objects for the employeeNo variable
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj instanceof Employee) {
			return(this.employeeNo == ((Employee) obj).getEmployeeNo());
		}//end if
		return false;
	}//end equals method
	
	//getAllAdvisors method checks for unique advisors given 2 employee objects
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		//there can be at most 6 unique advisors
		int[] uniqueAdvisors = {0, 0, 0, 0, 0, 0};
		int[] e1Advisors = e1.getAdvisors();
		//for(int i = 0; i < 3; i++) System.out.print("E1s advisor " + (i+1) + ": " + e1Advisors[i] + " ");
		int[] e2Advisors = e2.getAdvisors();
		//for(int i = 0; i < 3; i++) System.out.print("E2s advisor " + (i+1) + ": " + e2Advisors[i] + " ");
		int count = 0;
		
		//compare e1's advisors to e2's and e2's to e1's
		for(int i = 0; i < 3; i++) {
			if((e1Advisors[i] != e2Advisors[0])&&(e1Advisors[i] != e2Advisors[1])&&(e1Advisors[i] != e2Advisors[2])) {
				uniqueAdvisors[count] = e1Advisors[i];
				count++;
			}//close if
			
		}//end for
		return uniqueAdvisors;
	}//end getAllAdvisors method
	
	// public static void main(String[] args) {
// 		Employee[] employees = new Employee[10];
// 		Employee ben = new Employee();
// 		employees[0] = ben;
// 		
// 		New Employee Ben with initialized values
// 		ben.setEmployeeName("Benjamin Longwell");
// 		ben.setEmployeeState("NM");
// 		ben.setEmployeeNo(15024);
// 		ben.setEmployeeAge(18);
// 		ben.setEmployeeZip(88007);
// 		ben.setAdvisors(1, 2, 3);
// 		
// 		Print out Employee object for Ben
// 		System.out.println(ben);
// 		
// 		Create new employee, Jake, from Ben
// 		Employee jake = new Employee(ben);
// 		employees[1] = jake;
// 		
// 		Initialize Jake
// 		System.out.println(jake);
// 		jake.setEmployeeName("Jake Ballinger");
// 		jake.setEmployeeState("NY");
// 		jake.setEmployeeNo(208564);
// 		jake.setEmployeeAge(21);
// 		jake.setEmployeeZip(50518);
// 		jake.setAdvisors(2,  3,  4);
// 		
// 		Print out Employee object for Jake
// 		System.out.println(jake);
// 		System.out.println(ben);
// 		
// 		Create new Employee, Bailey, from jake
// 		Employee bailey = new Employee(jake);
// 		employees[2] = bailey;
// 		bailey.setEmployeeName("Bailey Ballinger");
// 		System.out.println(bailey);
// 		
// 		testing equals() method
// 		System.out.println(bailey.equals(jake));
// 		
// 		System.out.println(bailey.equals(ben));
// 		
// 		testing getAllAdvisors
// 		int[] benJakeAdvisors = getAllAdvisors(ben, jake);
// 		int[] jakeBaileyAdvisors = getAllAdvisors(jake, bailey);
// 		
// 		for(int i = 0; i < 6; i++) System.out.println(benJakeAdvisors[i]);
// 		
// 		System.out.println("Printing Ben and Jake's unique advisors:");
// 		
// 		for(int i = 0; i < 6; i++) {
// 			System.out.print(benJakeAdvisors[i] + ", ");
// 		}//end for
// 		System.out.println();
// 		
// 		System.out.println("Printing Jake and Bailey's unique advisors:(this is blank because there are no unique advisors between jake and bailey.)"); 
// 		for(int i= 0; jakeBaileyAdvisors[i] != 0; i++) { 
// 			System.out.print(benJakeAdvisors[i]);
// 		  }//end for
// 		
// 		for(int i = 0; i < 3; i++) System.out.println(employees[i]);
// 	}//end main

}
