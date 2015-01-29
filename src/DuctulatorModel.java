import java.awt.*;

/**
   DuctulatorModel stores and handles the information for the GUI
*/
public class DuctulatorModel {
   private LinkedList straightDuctList;
   private LinkedList transitionsList;
   private LinkedList elbowsList;
   private LinkedList takeOffsList;
   private String selectedRadioButton;
   private String selectedDuctTypeComboBoxItem;
   private String selectedDuctMaterialComboBoxItem;

   /*
      Constructor
   */
   public DuctulatorModel() {
      straightDuctList = new LinkedList();
      transitionsList = new LinkedList();
      elbowsList = new LinkedList();
      takeOffsList = new LinkedList();
      selectedRadioButton = "Straight Duct";
      selectedDuctTypeComboBoxItem = "Square";
      selectedDuctMaterialComboBoxItem = "Galvanized";
   }
   
   //Adds a part to the straight duct list
   public void addToStraightDuctList(int ductMaterial, int ductFitting, int total, int ductSize) {
      straightDuctList.add(ductMaterial, ductFitting, total, ductSize);
   }

   //Adds a part to the transition list
   public void addToTransitionsList(int ductMaterial, int ductFitting, int total, int ductSize1, int ductSize2) {
      transitionsList.add(ductMaterial, ductFitting, total, ductSize1, ductSize2);
   }

   //Adds a part to the rectangular elbow duct list
   public void addToElbowsList(int ductMaterial, int ductFitting, int total, int ductSize) {
      elbowsList.add(ductMaterial, ductFitting, total, ductSize);
   }
   
   //Adds a part to the take off list   
   public void addToTakeOffsList(int ductMaterial, int ductFitting, int total, int ductSize) {
      takeOffsList.add(ductMaterial, ductFitting, total, ductSize);
   }
   
   //Gets the selected radio button
   public String getSelectedRadioButton() {
      return selectedRadioButton;
   }

   //Gets the selected combo box item
   public String getSelectedDuctTypeComboBoxItem() {
      return selectedDuctTypeComboBoxItem;
   }
      //Gets the selected combo box item
   public String getSelectedDuctMaterialComboBoxItem() {
      return selectedDuctMaterialComboBoxItem;
   }

   //Sets the correct radio button
   public void setSelectedRadioButton(String selectedRadioButton) {
      this.selectedRadioButton = selectedRadioButton;
   }

   //Sets the correct combo box item
   public void setSelectedDuctTypeComboBoxItem(String selectedDuctTypeComboBoxItem) {
      this.selectedDuctTypeComboBoxItem = selectedDuctTypeComboBoxItem;
   }
   //Sets the correct combo box item
   public void setSelectedDuctMaterialComboBoxItem(String selectedDuctMaterialComboBoxItem) {
      this.selectedDuctMaterialComboBoxItem = selectedDuctMaterialComboBoxItem;
   }
   
   //Gets a list of the total duct in the straight duct linked list
   public String getStraightDuctTotal() {
      String text = "Duct Size                 Total\n";
      text += straightDuctList.toString(selectedDuctMaterialComboBoxItem, selectedDuctTypeComboBoxItem);
      return text;
   }
   
   //Gets a list of the total duct in the transition linked list 
   public String getTransitionsTotal() {
      String text = "Duct Size                 Total\n";
      if(selectedDuctMaterialComboBoxItem == "Square to Round")
         text += transitionsList.roundTransitionToString(selectedDuctMaterialComboBoxItem, selectedDuctTypeComboBoxItem);
      else
         text += transitionsList.transitionToString(selectedDuctMaterialComboBoxItem, selectedDuctTypeComboBoxItem);
      return text;
   }
   
   //Gets a list of the total duct in the rectangular elbow linked list
   public String getElbowsTotal() {
      String text = "Duct Size                 Total\n";
      text += elbowsList.toString(selectedDuctMaterialComboBoxItem, selectedDuctTypeComboBoxItem);
      return text;
   }
   
   //Gets a list of the total duct in the take off linked list
   public String getTakeOffsTotal() {
      String text = "Duct Size                 Total\n";
      text += takeOffsList.toString(selectedDuctMaterialComboBoxItem, selectedDuctTypeComboBoxItem);
      return text;
   }
}
