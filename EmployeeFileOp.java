//Benjamin Longwell
//CS272
//Lab1
//EmployeeFileOP.java
//reads in employee info from a csv file and prints them in formatted text per line
import	java.io.FileReader;
import java.io.FileWriter;
import	java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
class EmployeeFileOp {

	public static void main (String[] args) throws IOException {
		//declare variables to pass to read and write functions
		String fileName = "core_dataset.csv";
		String toFile = "young_employee.csv";
		
		read(fileName);
		write(toFile);
	}
	
	public static void read(String fName) throws IOException {
		String eName, state, gender, tempString;
		int eNum, zip, age, temp, count;
		eName = "";
		count = 0;
		//create reader
		BufferedReader reader = new BufferedReader(new FileReader(fName));
		
		//read line
		String line = reader.readLine();
		line = reader.readLine();
		
		while(!(line.equals(",,,,,,,,,,,,,,,,,,,,"))){
			//test if the first char is "
			if(line.charAt(0) == '"') line = line.substring(1);
			//System.out.println(line);
		
			//set temp to the first instance of " (after the last name)
			temp = line.indexOf('"');
			if(temp >=0)
				eName = line.substring(0, temp);
		
			line = line.substring(temp);
		
			//removes leading " and ,
			if(line.charAt(0) == '"') line = line.substring(1);
			if(line.charAt(0) == ',') line = line.substring(1);
		
			//employee ID store as string then parse to integer
			temp = line.indexOf(',');
			tempString = line.substring(0, temp);
			tempString = tempString.replaceAll("\\s+", "");
			eNum = Integer.parseInt(tempString);
			line = line.substring(temp);
			if(line.charAt(0) == ',') line = line.substring(1);
		
			//employee state
			temp = line.indexOf(',');
			state = line.substring(0, temp);
			line = line.substring(temp);
			if(line.charAt(0) == ',') line = line.substring(1);
		
			//employee Zip
			temp = line.indexOf(',');
			tempString = line.substring(0,temp);
			tempString = tempString.replaceAll("\\s+", "");
			zip = Integer.parseInt(tempString);
			line = line.substring(temp);
			if(line.charAt(0) == ',') line = line.substring(1);
		
			//eliminate DOB
			temp = line.indexOf(',');
			line = line.substring(temp);
			if(line.charAt(0) == ',') line = line.substring(1);
		
			//age
			temp = line.indexOf(',');
			tempString = line.substring(0, temp);
			tempString = tempString.replaceAll("\\s+", "");
			age = Integer.parseInt(tempString);
			line = line.substring(temp);
			if(line.charAt(0) == ',') line = line.substring(1);
		
			//gender
			temp = line.indexOf(',');
			gender = line.substring(0, temp);
		
			//test print
			count++;
			System.out.printf("Line #%-5d\tEmployee Name: %-25s Employee ID: %-15d State: %-5s Zip: %-10d Age: %-5d Gender: %-4s\n", count, eName, eNum, state, zip, age, gender);
			//System.out.println(line);
			line = reader.readLine();
		}//end while
		reader.close();
	}//end function read
	
	public static void write(String fName) throws IOException {
		//variables
		String eName, state, gender, line;
		int eNum, zip, age;
		BufferedWriter writer = new BufferedWriter(new FileWriter(fName));
		eName = "Benjamin Longwell";
		state = "NM";
		gender = "Male";
		eNum = 123456;
		zip = 88011;
		age = 18;
		
		//specify line format
		line = String.format("%s,%d,%s,%d,%d,%s", eName, eNum, state, zip, age, gender);
		
		//write to file and close the reader
		writer.write(line);
		writer.close();
	}//end function write
}//end class
