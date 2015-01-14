/**
   DuctulatorModel stores and handles the information for the GUI
*/
public class DuctulatorModel {
   private LinkedList straightDuctList;
   private LinkedList transitionsList;
   private LinkedList elbowsList;
   private LinkedList takeOffsList;
   private String selectedRadioButton;
   private String selectedComboBoxItem;

   /*
      Constructor
   */
   public DuctulatorModel() {
      straightDuctList = new LinkedList();
      transitionsList = new LinkedList();
      elbowsList = new LinkedList();
      takeOffsList = new LinkedList();
      selectedRadioButton = "Straight Duct";
      selectedComboBoxItem = "Galvanized";
   }  
   
   //Adds a part to the straight duct list
   public void addToStraightDuctList(int ductSize, int total) {
      straightDuctList.add(ductSize, total);
   }

   //Adds a part to the transition list
   public void addToTransitionsList(int ductSize, int total) {
      transitionsList.add(ductSize, total);
   }

   //Adds a part to the rectangular elbow duct list
   public void addToElbowsList(int ductSize, int total) {
      elbowsList.add(ductSize, total);
   }
   
   //Adds a part to the take off list   
   public void addToTakeOffsList(int ductSize, int total) {
      takeOffsList.add(ductSize, total);
   }
   
   //Gets the selected radio button
   public String getSelectedRadioButton() {
      return selectedRadioButton;
   }

   //Gets the selected combo box item
   public String getSelectedComboBoxItem() {
      return selectedComboBoxItem;
   }
   
   //Sets the correct radio button
   public void setSelectedRadioButton(String selectedRadioButton) {
      this.selectedRadioButton = selectedRadioButton;
   }

   //Sets the correct combo box item
   public void setSelectedComboBoxItem(String selectedComboBoxItem) {
      this.selectedComboBoxItem = selectedComboBoxItem;
   }
   
   //Gets a list of the total duct in the straight duct linked list
   public String getStraightDuctTotal() {
      String text = "Duct Size          Total\n";
      text += straightDuctList.toString();
      return text;
   }
   
   //Gets a list of the total duct in the transition linked list 
   public String getTransitionsTotal() {
      String text = "Duct Size          Total\n";
      text += transitionsList.toString();
      return text;
   }
   
   //Gets a list of the total duct in the rectangular elbow linked list
   public String getElbowsTotal() {
      String text = "Duct Size          Total\n";
      text += elbowsList.toString();
      return text;
   }
   
   //Gets a list of the total duct in the take off linked list
   public String getTakeOffsTotal() {
      String text = "Duct Size          Total\n";
      text += takeOffsList.toString();
      return text;
   }
}
