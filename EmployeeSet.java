//Benjamin Longwell
//CS272, LAB2
//A class representing an Employee; contains employee name, state, number, age, zip, and advisors

public class EmployeeSet extends Employee{
      //instance variables
      private int count = 0;
      public Employee[] employees;
      
      //EmployeeSet no parameter constructor
      public EmployeeSet(){
         employees = new Employee[10];
      }//end constructor for EmployeeSet
      
      //EmployeeSet copy constuctor
      public EmployeeSet(Object obj) {
		if(obj == null) return;
		if(obj instanceof EmployeeSet) {
			Employee[] tempArray = new Employee[count];
         for(int i = 0; i < count; i++){
            tempArray[i] = new Employee(employees[i]);
         }//end for
		}//end if
		else return;
	}//end copy constructor for EmployeeSet
      
      
      
      
      
      
      
      
      
      
      //MAIN
		public static void main(String[] args) {
         //employee 1
		   Employee emp1 = new Employee();
 		   emp1.setEmployeeNo(10000);
         //employee 2
         Employee emp2 = new Employee();
 		   emp2.setEmployeeNo(20000);
         //employee 3
         Employee emp3 = new Employee();
 		   emp3.setEmployeeNo(30000);
         //employee 4
         Employee emp4 = new Employee();
 		   emp4.setEmployeeNo(40000);
         //employee 5
         Employee emp5 = new Employee();
 		   emp5.setEmployeeNo(50000);
         //employee 6
         Employee emp6 = new Employee();
 		   emp6.setEmployeeNo(60000);
         //employee 7
         Employee emp7 = new Employee();
 		   emp7.setEmployeeNo(70000);
         //employee 8
         Employee emp8 = new Employee();
 		   emp8.setEmployeeNo(80000);
         //employee 9
         Employee emp9 = new Employee();
 		   emp9.setEmployeeNo(90000);
         //employee 10
         Employee emp10 = new Employee();
 		   emp10.setEmployeeNo(10000);
         //employee 11
         Employee emp11 = new Employee();
 		   emp11.setEmployeeNo(11000);
         //employee 12
         Employee emp12 = new Employee();
 		   emp12.setEmployeeNo(12000);
         //employee 13
         Employee emp13 = new Employee();
 		   emp13.setEmployeeNo(13000);
         //employee 14
         Employee emp14 = new Employee();
 		   emp14.setEmployeeNo(14000);
         //employee 15
         Employee emp15 = new Employee();
 		   emp15.setEmployeeNo(15000);
         //employee 16
         Employee emp16 = new Employee();
 		   emp16.setEmployeeNo(16000);
         //employee 17
         Employee emp17 = new Employee();
 		   emp17.setEmployeeNo(17000);
         //employee 18
         Employee emp18 = new Employee();
 		   emp18.setEmployeeNo(18000);
         //employee 19
         Employee emp19 = new Employee();
 		   emp19.setEmployeeNo(19000);
         //employee 20
         Employee emp20 = new Employee();
 		   emp20.setEmployeeNo(20000);
         //employee 21
         Employee emp21 = new Employee();
 		   emp21.setEmployeeNo(21000);
         //employee 22
         Employee emp22 = new Employee();
 		   emp22.setEmployeeNo(22000);
         //employee 23
         Employee emp23 = new Employee();
 		   emp23.setEmployeeNo(23000);
         //employee 24
         Employee emp24 = new Employee();
 		   emp24.setEmployeeNo(24000);
         //employee 25
         Employee emp25 = new Employee();
 		   emp25.setEmployeeNo(25000);
         
 		   
		
	}//end main

}
