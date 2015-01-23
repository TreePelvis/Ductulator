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
   public void add(int ductMaterial, int ductFitting, int total, int ductSize) {
      Node temp = new Node(ductMaterial, ductFitting, total, ductSize);
      Node current = head;

      //Starting at the head node, move to the end of the list
      while (current.getNext() != null) {
         if(current.getNext().getFirstDuctSize() == ductSize &&
                 current.getNext().getDuctMaterial() == ductMaterial) {
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

   //Adds an element to the list
   public void add(int ductMaterial, int ductFitting, int total, int ductSize1, int ductSize2) {
      Node temp = new Node(ductMaterial, ductFitting, total, ductSize1, ductSize2);
      Node current = head;

      //Starting at the head node, move to the end of the list
      while (current.getNext() != null) {
         if(current.getNext().getFirstDuctSize() == ductSize1 &&
                 current.getNext().getSecondDuctSize() == ductSize2) {
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
   public String toString(String ductMaterial, String ductFitting) {
      Node current = head.getNext();

      String output = "";

      while (current != null) {
         if(ductMaterial == "Galvanized" && current.getDuctMaterial() == 1)
            output = getOutput(ductFitting, current, output);
         else if(ductMaterial == "Steel" && current.getDuctMaterial() == 2)
            output = getOutput(ductFitting, current, output);
         else if(ductMaterial == "Aluminum" && current.getDuctMaterial() == 3)
            output = getOutput(ductFitting, current, output);
         else if(ductMaterial == "Galvanneal" && current.getDuctMaterial() == 4)
            output = getOutput(ductFitting, current, output);
         else if(ductMaterial == "Welded Grease" && current.getDuctMaterial() == 5)
            output = getOutput(ductFitting, current, output);

         current = current.getNext();
      }
      return output;

        /* if(ductFitting == "Square" && current.getDuctFitting() == 1)
            output += current.getTextualData() + "\n";
         else if(ductFitting == "Round" && current.getDuctFitting() == 2)
            output += current.getTextualData() + "\n";
         else if(ductFitting == "Oval" && current.getDuctFitting() == 3)
            output += current.getTextualData() + "\n";*/


   }

   private String getOutput(String ductFitting, Node current, String output) {
      if(ductFitting == "Square" && current.getDuctFitting() == 1)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Round" && current.getDuctFitting() == 2)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Oval" && current.getDuctFitting() == 3)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Square to Square" && current.getDuctFitting() == 4)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Square to Round" && current.getDuctFitting() == 5)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Square to Oval" && current.getDuctFitting() == 6)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Rectangular" && current.getDuctFitting() == 7)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Rect. w/ Vanes" && current.getDuctFitting() == 8)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Radius" && current.getDuctFitting() == 9)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Side Take-Off" && current.getDuctFitting() == 10)
         output += current.getTextualData() + "\n";
      else if (ductFitting == "Top Take-Off" && current.getDuctFitting() == 11)
         output += current.getTextualData() + "\n";
      return output;
   }

   //Shows the data stored in each node. This data will be displayed in the JTextArea
   public String transitionToString(String ductMaterial) {
      Node current = head.getNext();

      String output = "";

      while (current != null) {
         if(ductMaterial == "Galvanized" && current.getDuctMaterial() == 1 )
            output += current.getTransitionTextualData() + "\n";
         else if(ductMaterial == "Steel" && current.getDuctMaterial() == 2)
            output += current.getTransitionTextualData() + "\n";
         else if(ductMaterial == "Aluminum" && current.getDuctMaterial() == 3)
            output += current.getTransitionTextualData() + "\n";
         else if(ductMaterial == "Galvanneal" && current.getDuctMaterial() == 4)
            output += current.getTransitionTextualData() + "\n";
         else if(ductMaterial == "Welded Grease" && current.getDuctMaterial() == 5)
            output += current.getTransitionTextualData() + "\n";

         current = current.getNext();
      }
      return output;
   }

   //Shows the data stored in each node. This data will be displayed in the JTextArea
   public String roundTransitionToString(String ductMaterial) {
      Node current = head.getNext();

      String output = "";

      while (current != null) {
         if(ductMaterial == "Galvanized" && current.getDuctMaterial() == 1 )
            output += current.getRoundTransitionTextualData() + "\n";
         else if(ductMaterial == "Steel" && current.getDuctMaterial() == 2)
            output += current.getRoundTransitionTextualData() + "\n";
         else if(ductMaterial == "Aluminum" && current.getDuctMaterial() == 3)
            output += current.getRoundTransitionTextualData() + "\n";
         else if(ductMaterial == "Galvanneal" && current.getDuctMaterial() == 4)
            output += current.getRoundTransitionTextualData() + "\n";
         else if(ductMaterial == "Welded Grease" && current.getDuctMaterial() == 5)
            output += current.getRoundTransitionTextualData() + "\n";

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
      public Node(int ductMaterial, int ductFitting, int total, int ductSize) {
         next = null;
         data = new int[4];
         data[0] = ductMaterial;
         data[1] = ductFitting;
         data[2] = total;
         data[3] = ductSize;
      }

      // Node constructor
      public Node(int ductMaterial, int ductFitting, int total, int ductSize1, int ductSize2) {
         next = null;
         data = new int[5];
         data[0] = ductMaterial;
         data[1] = ductFitting;
         data[2] = total;
         data[3] = ductSize1;
         data[4] = ductSize2;
      }

      public int getDuctMaterial() {
         return data[0];
      }

      public int getDuctFitting() {
         return data[1];
      }

      public int getTotal() {
         return data[2];
      }

      public int getFirstDuctSize() {
         return data[3];
      }

      public int getSecondDuctSize() {
         return data[3];
      }


      public void addToTotal(int total) {
         data[2] += total;
      } 
       
      public String getTextualData() {
         return Integer.toString(data[3]) + "\"" +
                 "                           " + Integer.toString(data[2]);
      }

      public String getTransitionTextualData() {
         return Integer.toString(data[3]) + "\"->" + Integer.toString(data[4])
                 + "\"" + "                  " + Integer.toString(data[2]);
      }

      public String getRoundTransitionTextualData() {
         return Integer.toString(data[3]) + "\"->" + Integer.toString(data[4])
                 + "\"round" + "             " + Integer.toString(data[2]);
      }

      public Node getNext() {
         return next;
      }
       
      public void setNext(Node nextValue) {
         next = nextValue;
      }
      
   }
}