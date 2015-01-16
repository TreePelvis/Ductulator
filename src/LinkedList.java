/**
The LinkedList class is just a simple implementation of a linked list
This will be used to store the sizes of duct along with the length/amount.
*/
public class LinkedList {
   //Reference to the head node.
   private Node head;
   private int listCount;
    
   /*
   Constructor
   */
   public LinkedList() {
      //This is an empty list, so the reference to the head node
      // is set to a new node with no data
      head = new Node();
      listCount = 0;
   }
   
   //Adds an element to the list
   public void add(int ductMaterial, int total, int ductSize) {
      Node temp = new Node(ductMaterial, total, ductSize);
      Node current = head;
      
      //Starting at the head node, move to the end of the list
      while (current.getNext() != null) {
         if(current.getNext().getDuctSize() == ductSize) {
            current.getNext().addToTotal(total);
            return;
         }
         current = current.getNext();
      }   
      //The last node's "next" reference set to our new node
      current.setNext(temp);
      
      //Increment the number of elements variable
      listCount++;
   }

/*
   //Returns the element at the specified position in this list.    
   public int get(int index) {
      // index must be 1 or higher
      if (index <= 0)
         return null;
       
      Node current = head.getNext();
      
      for (int i = 1; i < index; i++) {
         if (current.getNext() == null)
            return null;
          
         current = current.getNext();
      }
      return current.getData();
   }
*/   
 
   //Removes the element at the specified position in this list.   
   public boolean remove(int index){

      //If the index is out of range, exit
      if (index < 1 || index > size())
         return false;
       
      Node current = head;
      
      for (int i = 1; i < index; i++) {
         if (current.getNext() == null)
            return false;
          
         current = current.getNext();
      }
      
      current.setNext(current.getNext().getNext());
      
      //Decrement the number of elements variable
      listCount--; 
      
      return true;
   }
   
   //Returns the number of elements in this list.   
   public int size() {
      return listCount;
   }
   
   
   
   //Shows the data stored in each node. This data will be displayed in the JTextArea
   public String toString() {
      Node current = head.getNext();
      
      String output = "";
      
      while (current != null) {
         output += current.getTextualData() + "\n";
         current = current.getNext();
      }
      return output;
   }

    
   /**
      This private inner class stores the all the information about the node
       and the data it can store in it. In this case, the data is an array of
       size 2. The first element of the array stores the size of the duct. The
       second element stores the length or amount.
   */
   private class Node {
      //Reference to the next node in the chain,
      // or null if there isn't one.
      Node next;
      //Data is stored in an array
      int[] data;
      
      /**
         Node constructor for initial node
          All data values are set to 0 or null
      */
      public Node() {
         data = new int[2];
         next = null;
         data[0] = 0;
         data[1] = 0;
      }
       
      // Node constructor
      public Node(int ductMaterial, int total, int ductSize) {
         next = null;
         data = new int[3];
         data[0] = ductMaterial;
         data[1] = total;
         data[2] = ductSize;
      }

      // Node constructor
      public Node(int ductMaterial, int ductSize1, int ductSize2, int total) {
         next = null;
         data = new int[4];
         data[0] = ductMaterial;
         data[1] = total;
         data[2] = ductSize1;
         data[3] = ductSize2;
      }

      public int getDuctSize() {
         return data[2];
      }
       
      public void addToTotal(int total) {
         data[1] += total;
      } 
       
      public String getTextualData() {
         return Integer.toString(data[2]) +
                 "                      " + Integer.toString(data[1]);
      }
       
      public Node getNext() {
         return next;
      }
       
      public void setNext(Node nextValue) {
         next = nextValue;
      }
      
   }
}