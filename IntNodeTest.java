class IntNodeTest extends IntNode{
   //Main Function
   public static void main(String[] args){
      //create intNode
      IntNode myList = new IntNode(5);
      myList.addNodeAfterThis(4);
      //print out this node
      System.out.println(myList);
      //test remove function
      myList.removeNodeAfterThis();
      System.out.println(myList);
      //make new list
      IntNode myNextList = new IntNode(6, myList);
      System.out.println(myNextList);
      //Add elements to list
      myNextList.addNodeAfterThis(5);
      myNextList.addNodeAfterThis(13);
      myNextList.addNodeAfterThis(21);
      System.out.println(myNextList);
      //test remove function
      myNextList.removeNodeAfterThis();
      System.out.println(myNextList);
      //Test listLength() method
      System.out.println("there are "+ listLength(myNextList) + " elements in this list.");
      //Test search() function
      System.out.println(search(myNextList, 10));
      System.out.println(search(myNextList, 13));
   }//end main method
}//end class IntNodeTest