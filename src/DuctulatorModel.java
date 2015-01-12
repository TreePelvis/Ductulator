/**
   DuctulatorModel stores and handles the information for the GUI
*/
public class DuctulatorModel {
   private LinkedList straightDuctList;
   private LinkedList transitionList;
   private LinkedList rectElbowList;
   private LinkedList takeOffList;
   private String selectedDuctType;
   
   /*
      Constructor
   */
   public DuctulatorModel() {
      straightDuctList = new LinkedList();
      transitionList = new LinkedList();
      rectElbowList = new LinkedList();
      takeOffList = new LinkedList();   
      selectedDuctType = "Straight Duct";  
   }  
   
   //Adds a part to the straight duct list
   public void addToStraightDuctList(int ductSize, int total) {
      straightDuctList.add(ductSize, total);
   }

   //Adds a part to the transition list
   public void addToTransitionList(int ductSize, int total) {
      transitionList.add(ductSize, total);     
   }

   //Adds a part to the rectangular elbow duct list   
   public void addToRectElbowList(int ductSize, int total) {
      rectElbowList.add(ductSize, total);
   }
   
   //Adds a part to the take off list   
   public void addToTakeOffList(int ductSize, int total) {
      takeOffList.add(ductSize, total);
   }
   
   //Gets the duct type of the selected radio button 
   public String getSelectedDuctType() {
      return selectedDuctType;
   }
   
   //Sets the correct radio button
   public void setSelectedDuctType(String selectedDuctType) {
      this.selectedDuctType = selectedDuctType;
   }
   
   //Gets a list of the total duct in the straight duct linked list
   public String getStraightDuctTotal() {
      String text = straightDuctList.toString();
      return text;
   }
   
   //Gets a list of the total duct in the transition linked list 
   public String getTransitionTotal() {
      String text = transitionList.toString();
      return text;
   }
   
   //Gets a list of the total duct in the rectangular elbow linked list
   public String getRectElbowTotal() {
      String text = rectElbowList.toString();
      return text;
   }
   
   //Gets a list of the total duct in the take off linked list
   public String getTakeOffTotal() {
      String text = takeOffList.toString();
      return text;
   }
}
