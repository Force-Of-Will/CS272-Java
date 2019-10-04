//README: This class runs Employee.java at the same time as this file (EmployeeSet.java) in order to work:
//             I have included my Employee.java file as part of the submission of this lab.
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
            Employee[] tempArray = new Employee[((EmployeeSet)obj).capacity()];
            this.count = ((EmployeeSet)obj).size();
            for(int i = 0; i < count; i++){
               tempArray[i] = new Employee(((EmployeeSet)obj).getEmployee(i));
         }//end for
         this.employees = tempArray;            	
		}//end if
		else return;
	}//end copy constructor for EmployeeSet
   
   //toString() method
   public String toString(){
      String a = String.format("EmployeeNum:\t");
      String b;
      for(int i = 0; i < count; i++){
         b = String.format("%10d,",employees[i].getEmployeeNo());
         a = a+b;
      }//end for
      a = a +"\n";
      return a;
   }//end toString() method
   //size() method
   public int size(){
      return count;
   }//end size() method
   
   //capacity() method
   public int capacity(){
      return employees.length;
   }//end capacity method
   
   //add() method
   public void add(Employee a){
      if(count == employees.length){
         Employee[] employees2 = new Employee[employees.length *2];
         for(int i = 0; i < count; i++) employees2[i] = employees[i];//end for
         employees = employees2;         
      }//end if
      
      employees[count] = a;
      
      count++;
   }//end add() method
   
  
   
   //Contains() method
   public boolean contains(Employee a){
      if(a == null) return false;
      for(int i = 0; i < count; i++){
         if(employees[i].equals(a)){
            return true;
         }//end if
      }//end for
      return false;
   }//end contains method
   
   //TODO Check in class if this is supposed to take an Employee object parameter or 
   //if its not supposed to return anything, or correct return values
   
   public void remove(int eno){
      for(int i = 0; i < count; i++){
         if(employees[i].getEmployeeNo() == eno){
            System.out.println("Removing Employee with Employee Number: " + eno);
            for(int j = i; j < count-1; j++){
               employees[j] = employees[j+1];
            }//end for (j)
            count--;
         }//end if
      }//end for outer
      //return true;
   }//end remove() method
   
   //my own method used for purpose of the copy constructor
   public Employee getEmployee(int a){
      return employees[a];
   }//end getEmployee
      
   private void ensureCapacity(int minimumCapacity){
      if((this.capacity()) < minimumCapacity){
         Employee[] employees2 = new Employee[minimumCapacity];
         for(int i = 0; i < count; i++) employees2[i] = employees[i];//end for
         employees = employees2;           
      }//end if
   }//end ensureCapacity() method

   public void addOrdered(Employee a){
      if(this.size() == 0){
         employees[0] = new Employee(a);
         count++;
      }//end if // checks if the array is empty
      
      //compare input parameter to each element before it, if 
      //    it is larger than the element before it and smaller the element after, it goes in the next spot
      //    move the rest of the array up one element to make room for new element
      for(int i = 1; i < count; i++){
       
         if(a.getEmployeeNo() > (employees[i-1]).getEmployeeNo() &&(a.getEmployeeNo() < (employees[i+1]).getEmployeeNo())){
            //a eNo > the previous element's eno
            //System.out.println("Found a space where" + a.getEmployeeNo() +" is greater than " + ((employees[i-1]).getEmployeeNo()));

            if(count < this.capacity()){//if there is room for 1 element
               //move elements to the right by 1
               //shove in the new element (element goes at employees[i])
               
               for(int j = count + 1; j >= i; j--){
                  employees[j] = new Employee(employees[j-1]);
               }//end for j
               
               employees[i] = new Employee(a);
               
               count++;
               break;
            }//end if (room for 1)
            else if(count >= this.capacity()){ //there is NOT room for 1 element
                this.ensureCapacity(this.capacity() * 2);
                
                //move elements to the right by 1
                //shove in the new element
                for(int j = count + 1; j >= i; j--){
                  employees[j] = new Employee(employees[j-1]);
               }//end for j
               
               employees[i] = new Employee(a);
                
                
                
                count++;
                break;
             }//end if (no room for 1)      
         }//end if (found a spot to put the employee obj)
      }//end for look through array
   }//end addOrdered() method
      
      
      
      
      
      
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
         
         //create EmployeeSet instance
         EmployeeSet myEmployees = new EmployeeSet();
         
         //create test employees
         myEmployees.add(emp1);
         myEmployees.add(emp2);
         myEmployees.add(emp3);
         myEmployees.add(emp4);
         myEmployees.add(emp5);
         myEmployees.add(emp6);
         System.out.println("The capacity is now: " + myEmployees.capacity());
         System.out.println("Number of employees here: " + myEmployees.size());
         myEmployees.add(emp7);
         myEmployees.add(emp8);
         myEmployees.add(emp9);
         myEmployees.add(emp10);
         myEmployees.add(emp11);
         myEmployees.add(emp12);
         myEmployees.add(emp13);
         
 		   //print employeeSet and show capacity
         System.out.println(myEmployees);
		   System.out.println("The capacity is now: " + myEmployees.capacity());
         System.out.println("Number of employees here: " + myEmployees.size());
         
         //add more employees to new Employee Set
         EmployeeSet myNewEmployees = new EmployeeSet(myEmployees);
         myNewEmployees.add(emp14);
         myNewEmployees.add(emp15);
         myNewEmployees.add(emp16);
         myNewEmployees.add(emp17);
         myNewEmployees.add(emp18);
         myNewEmployees.add(emp19);
         myNewEmployees.add(emp20);
         myNewEmployees.add(emp21);
         myNewEmployees.add(emp22);
         myNewEmployees.add(emp23);
         myNewEmployees.add(emp24);
         myNewEmployees.add(emp25);
         
         //print updated EmployeeSet and show capacity
         System.out.println(myNewEmployees);
 		   System.out.println("The capacity is now (for new EmployeeSet): " + myNewEmployees.capacity());
         System.out.println("Number of employees here: " + myNewEmployees.size());
         
         //Testing contains() function
         if(myNewEmployees.contains(emp25)){
           System.out.println("myNewEmployees contains emp25");          
         }//end if
         else System.out.println("myNewEmployees does NOT contain emp25");
         Employee testEmp = new Employee();
         testEmp.setEmployeeNo(99999);
         if(myNewEmployees.contains(testEmp)){
           System.out.println("myNewEmployees contains testEmp");          
         }//end if
         else System.out.println("myNewEmployees does NOT contain testEmp");
         
         //Testing Remove function
         myNewEmployees.remove(21000);
         System.out.println(myNewEmployees);
         System.out.println("The capacity is now (for new EmployeeSet): " + myNewEmployees.capacity());
         System.out.println("Number of employees here: " + myNewEmployees.size());
         
         //Testing ensureCapacity function
         myNewEmployees.ensureCapacity(50);
         System.out.println("The capacity is now (for new EmployeeSet): " + myNewEmployees.capacity());
         System.out.println("Number of employees here: " + myNewEmployees.size());
         
         //Testing addOrdered() method
         EmployeeSet orderEmployees = new EmployeeSet();
         orderEmployees.add(emp1);
         orderEmployees.add(emp12);
         orderEmployees.add(emp15);
         orderEmployees.addOrdered(emp13);
         //orderEmployees.addOrdered(emp2);
         System.out.println(orderEmployees);
         
	}//end main

}//end class
