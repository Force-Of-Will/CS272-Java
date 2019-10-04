/**@author Benjamin Longwell
9/20/2019
IntNode Class and main() funtion
*/
public class IntNode{
   //Instance Variables
   int data;
   IntNode link;
   
   /**Constructor (no-argument) creates a null IntNode object
   @Precondition: non-inititialized object
   @Postcondition: An initialized IntNode object with null link and 0 data
   */
   public IntNode(){
      data = 0;
      link = null;
   }//end IntNode no-argument constructor
   
   /**IntNode constructor (2 arguments)
   @Precondition: non-initialized object, takes 2 parameters to create IntNode object
   @Postcondition: An initialized IntNode object with specific link and data
   @param myData
   @param myLink
    */
   public IntNode(int myData, IntNode myLink){
      setData(myData);
      setLink(myLink);   
   }//end IntNode consructor (2 agrguments)
   
   /**IntNode constructor (1 argument, NOT REQUIRED BY ASSIGNMENT PARAMETERS)
   @Precondition: non-initialized object
   @Postcondition: An initialized IntNode object with specific data and null link
    * 
    * @param myData
    */
   public IntNode(int myData){
      setData(myData);
      link = null;
   }//end IntNode constructor (1 argument)
   
   //Getters and Setters
  /**@Precondition: existing IntNode Object with non-null data 
   * @Postcondition: returned data value
   * @return data
   */
   public int getData(){return data;}//end getData
   
   /**Precondition: existing IntNode Object
    * @Postcondition: returned link to IntNode
    * @return
    */
   public IntNode getLink(){return link;}//end getLink 
   
   /**SetData: sets the data value of the IntNode object
   @Precondition: existing IntNode object
   @Postcondition: IntNode Object with changed data value
    * 
    * @param myNum
    */
   public void setData(int myNum){
      data = myNum;
   }//end setData
   
   /**SetLink method: sets the link value of the intNode object
   @Precondition: existing IntNode object
   @Postcondition: IntNode object with changed link
    * 
    * @param myLink
    */
   public void setLink(IntNode myLink){
      link = myLink;
   }//end setLink
   
   //NOT REQUIRED BY ASSIGNMENT PARAMETERS
   public void setLink(){
      link = null;
   }//end setLink NO PARAMETER
   
   /**toString() method returns a string with a representation of the IntNode object
   @Precondition: IntNode is non-null
   @Postcondition: returned string representation of IntNode object
    * 
    */
   public String toString(){
	   if (this.getLink() == null)
	      return data + "";
	   else 
	      return data + "->" + this.getLink().toString();
    }
   
   /**addNodeAfterThis method adds a node after the calling object
   @precondition: existing IntNode object
   @postcondition: changed link of intNode object
    * 
    * @param newdata
    */
   public void addNodeAfterThis(int newdata){
      if(this.getLink() == null) this.setLink(new IntNode(newdata));
      else{
         IntNode addedNode = new IntNode(newdata, this.getLink());
         this.setLink(addedNode);
      }//end else
   }//end addNodeAfterThis method
   
   /**removeNodeAfterThis() method: removes the node after the calling node
   @precondition: there is a node after the calling object, IntNode object exists, calling object has non-null link
   @postcondition: removed node after calling object
    * 
    */

public void removeNodeAfterThis(){
      IntNode testLink = this.getLink().getLink();
      if(testLink == null) link = null;
      else{
         link = testLink;
      }//end else
   }//end removeNodeAfterThis function
   
   /**listLength method: returns the length of the list
   @Precondition: existing IntNode object
   @Postcondition: no changes to linked list, return length of list (x elements = x return value)
    * 
    * @param head
    * @return
    */
   public static int listLength(IntNode head){
      int count = 1;
      IntNode cursor = head;
      while(cursor.getLink() != null){
         count++;
         cursor = cursor.getLink();
      }//end while
      return count;
   }//end listLength method
   
   /**search() method: returns true if a given value is found in the list, otherwise false
   @Precondition: head is not null
   @Postcondition: unchanged list, returns true for found data, otherwise false
    * 
    * @param head
    * @param data
    * @return
    */
   public static boolean search(IntNode head, int data){
      IntNode cursor = head;
      while(cursor.getLink() != null){
         if(cursor.getData() == data) return true;
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null && cursor.getData() == data) return true;
      return false;
   }//end search() method
   
   /**listEvenNumber()method: returns the number of even elements in the array
   @Precondition: list is not cyclic
   @Postcondition: unchanged list, returns the number of even elements in list
    *
    *@param head
    *@return
    */
   public static int listEvenNumber(IntNode head){
      if(head == null) return 0;
      int count = 0;
      IntNode cursor = head;
      while(cursor.getLink() != null){
         if((cursor.getData()%2) == 0){
            count++;
         }//end if
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null && (cursor.getData()%2 == 0)) count++;
      return count;
   }//end listEvenNumber
   
   /** addToEnd function: adds a data member to the last element that starts from the calling node
   @Precondition: list is not cyclic
   @Postcondition: no returns, modified list with value added at the end
    *
    *@param newdata
   */
   public void addToEnd(int newdata){
      IntNode cursor = this;
      while(cursor.getLink() != null){
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null) cursor.setLink(new IntNode(newdata));
   }//end addToEnd() method
   
   //NOT REQUIRED BY ASSIGNMENT PARAMETERS
   public void addToEnd(IntNode myNode){
      IntNode cursor = this;
      while(cursor.getLink() != null){
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null) cursor.setLink(new IntNode(myNode.getData(), myNode.getLink()));
   }//end addToEnd() method

   /** sumLast function: sums together the last 'num' elemetns in the list
   @Precondition: list is not cyclic
   @Postcondition: return the sum, unchanged list
    *@param head
    *@param num
    *@return
   */
   public static int sumLast(IntNode head, int num){
    int myLength = listLength(head);
    int count = 0;
    int sum = 0;
    IntNode cursor = head;
    if(num >= myLength){
      while(cursor.getLink() != null){
         sum = sum + cursor.getData();
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null) sum = sum + cursor.getData();
    }//end if
    else{
      //Get the cursor to the num->last element
      while(cursor.getLink() != null){
         cursor = cursor.getLink();
         count++;
         if((myLength - count) == num) break;
      }//end while, CURSOR IS NOW AT NUM-> LAST ELEMENT
      while(cursor.getLink() != null){
         sum = sum + (cursor.getData());
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null) sum = sum + cursor.getData();
    }//end ELSE
    return sum;
   }//end sumLast
   
   /**copyOdd method returns a new IntNode list of all the odd numbers in a given list from a given head
    *@Precondition: list is not cyclic
    *@Postcondition: returns a new list, non-changed list from parameter
    *@param head
    *@return
    */
   public static IntNode copyOdd(IntNode head){
      IntNode cursor = head;
      IntNode newNode = new IntNode(-1);
      if(head == null) return null;
      
      while(cursor.getLink() != null){
         if(cursor.getData()%2 != 0) newNode.addToEnd(cursor.getData());
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null && cursor.getData()%2 !=0) newNode.addToEnd(cursor.getData());
      newNode = newNode.getLink();
      
   
      return newNode;
   }//end copyOld
   
   //NOT REQUIRED BY ASSIGNMENT PARAMETERS (used for reverse() method)
   public int atIndex(int c){
      int count = 0;
      IntNode cursor = this;
      while(cursor.getLink() != null){
         if(count == c) return cursor.getData();
         count++;
         cursor = cursor.getLink();
      }//end while
      if(cursor.getLink() == null && count == c) return cursor.getData();
      return -1;
   }//end atIndex()
   
   /**reverse() method
    *@Precondition: list is not cyclic
    *@Postcondition: return a reversed IntNode head
    */
   public static IntNode reverse (IntNode head){ 
      IntNode myNode = new IntNode(head.atIndex(listLength(head) - 1));
      for(int i = listLength(head) - 2; i >=0; i--){
         myNode.addToEnd(head.atIndex(i));
      }//end for
      return myNode; 
   }//end reverse
   
   /**removeAll() method: removes all elements with value e in array given head
     *@Precondition: list is non-cyclical
     *@Postcondition: changed list removed the value e   
   */
   public static IntNode removeAll(IntNode head, int e){
      IntNode precursor = head;
      IntNode cursor = precursor.getLink(); 
         if(head == null) return null;//null
         while(cursor.getLink() != null){
            if(precursor.getLink().getData() == e){
               precursor.setLink(cursor.getLink());
               //cursor = cursor.getLink();
            }//end elseif
            else{
               precursor = precursor.getLink();
            }//end else
            cursor = cursor.getLink();
            
         }//end while
         if(cursor.getLink() == null && cursor.getData() == e) precursor.setLink();
         
      return head;
   }//end removeAll
   
   //NOT REQUIRED BY ASSIGNMENT PARAMETERS
   public boolean equals(IntNode n){
      if(this.data == n.getData() && this.link == n.getLink())return true;
      else return false;
   }//end method
   
   public static boolean hasCycle(IntNode head){
        IntNode fastCursor = head;
        IntNode cursor = head;
       
        while(fastCursor!= null && fastCursor.getLink() != null){
            fastCursor = fastCursor.getLink().getLink();
            cursor = cursor.getLink();
           
            //if fast and slow cursors are meeting then LinkedList is cyclic
            if(fastCursor == cursor){
                return true;
            }
        }
        return false;
    }
}//end class definition for IntNode



