//Benjamin Longwell
//9/20/2019
//CS272 Data Structures
//IntNode Class and main() funtion
public class IntNode{
   //Instance Variables
   int data;
   IntNode link;
   
   //Constructor (no-argument) creates a null IntNode object
   //Precondition: non-inititialized object
   //Postcondition: An initialized IntNode object with null link and 0 data
   public IntNode(){
      data = 0;
      link = null;
   }//end IntNode no-argument constructor
   
   //IntNode constructor (2 arguments)
   //Precondition: non-initialized object, takes 2 parameters to create IntNode object
   //Postcondition: An initialized IntNode object with specific link and data
   public IntNode(int myData, IntNode myLink){
      setData(myData);
      setLink(myLink);   
   }//end IntNode consructor (2 agrguments)
   
   //IntNode constructor (1 argument, NOT REQUIRED BY ASSIGNMENT PARAMETERS)
   //PreCondition: non-initialized object
   //Postcondition: An initialized IntNode object with specific data and null link
   public IntNode(int myData){
      setData(myData);
      link = null;
   }//end IntNode constructor (1 argument)
   
   //Getters and Setters
   public int getData(){return data;}//end getData //Precondition: existing IntNode Object with non-null data //post condition: returned data value
   
   public IntNode getLink(){return link;}//end getLink //Precondition: existing IntNode Object//postCondition: returned link to IntNode
   
   //SetData: sets the data value of the IntNode object
   //Precondition: existing IntNode object
   //Post condition: IntNode Object with changed data value
   public void setData(int myNum){
      data = myNum;
   }//end setData
   
   //SetLink method: sets the link value of the intNode object
   //Precondition: existing IntNode object
   //PostCondition: IntNode object with changed link
   public void setLink(IntNode myLink){
      link = myLink;
   }//end setLink
   
   //toString() method returns a string with a representation of the IntNode object
   //Precondition: IntNode is non-null
   //postcondition: returned string representation of IntNode object
   public String toString(){
	   if (this.getLink() == null)
	      return data + "";
	   else 
	      return data + "->" + this.getLink().toString();
    }
   
   //addNodeAfterThis method adds a node after the calling object
   //precondition: existing IntNode object
   //postcondition: changed link of intNode object
   public void addNodeAfterThis(int newdata){
      if(this.getLink() == null) this.setLink(new IntNode(newdata));
      else{
         IntNode addedNode = new IntNode(newdata, this.getLink());
         this.setLink(addedNode);
      }//end else
   }//end addNodeAfterThis method
   
   //removeNodeAfterThis() method: removes the node after the calling node
   //precondition: there is a node after the calling object, IntNode object exists, calling object has non-null link
   //postcondition: removed node after calling object
   public void removeNodeAfterThis(){
      IntNode testLink = this.getLink().getLink();
      if(testLink == null) link = null;
      else{
         link = testLink;
      }//end else
   }//end removeNodeAfterThis function
   
   //listLength method: returns the length of the list
   //Precondition: existing IntNode object
   //Postcondition: no changes to linked list, return length of list (x elements = x return value)
   public static int listLength(IntNode head){
      int count = 1;
      IntNode cursor = head;
      while(cursor.getLink() != null){
         count++;
         cursor = cursor.getLink();
      }//end while
      return count;
   }//end listLength method
   
   //search() method: returns true if a given value is found in the list, otherwise false
   //Precondition: head is not null
   //Postcondition: unchanged list, returns true for found data, otherwise false
   public static boolean search(IntNode head, int data){
      IntNode cursor = head;
      while(cursor.getLink() != null){
         if(cursor.getData() == data) return true;
         cursor = cursor.getLink();
      }//end while
      return false;
   }//end search() method

}//end class definition for IntNode