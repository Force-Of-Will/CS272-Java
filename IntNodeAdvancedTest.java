class IntNodeAdvancedTest extends IntNode{
   //Main Function
   public static void main(String[] args){
      //create intNode
      IntNode myList = new IntNode(8);
      myList.addNodeAfterThis(4);
      //print out this node
      //System.out.println(myList);
      //test remove function
      myList.removeNodeAfterThis();
      //System.out.println(myList);
      //make new list
      IntNode myNextList = new IntNode(6, myList);
      //System.out.println(myNextList);
      //Add elements to list
      myNextList.addNodeAfterThis(8);
      myNextList.addNodeAfterThis(13);
      myNextList.addNodeAfterThis(21);
      System.out.println("My list is: " + myNextList);
      //Testing listEvenNumber() method
      System.out.println("There are " + listEvenNumber(myNextList) + " even number(s) in this list");
      myNextList.addToEnd(12);
      System.out.println("My list is now: " + myNextList);
      System.out.println("The sum of the last 3 elements in myNextList is: " + sumLast(myNextList, 3));
      System.out.println("The sum of the last 50 elements (there is less than 50 elements) in myNext list is: " + sumLast(myNextList, 50));
      
      IntNode myThirdList = reverse(myNextList);
      System.out.println("This list reversed is: " +myThirdList);
      
      IntNode myOddList = copyOdd(myNextList);
      System.out.println("All the odd elements in this list are: " + myOddList);
      
      System.out.println("before removeAll " +myNextList);
      removeAll(myNextList, 8);
      System.out.println("after removeAll " + myNextList);
      
      System.out.println("MyNextList has a cycle?: " + hasCycle(myNextList));
      
      IntNode myCircleNode = new IntNode(5);
      myCircleNode.addToEnd(15);
      myCircleNode.addToEnd(22);
      myCircleNode.addToEnd(myCircleNode);
      
      System.out.println("MyCircleNode has a cycle?: " + hasCycle(myCircleNode));
      
   }//end main method
}//end class IntNodeTest