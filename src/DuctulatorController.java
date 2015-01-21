import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
   DuctulatorController handles the interaction between DuctulatorModel
      and DuctulatorView. Handles the logic behind everything
*/
public class DuctulatorController {
   //Create a model and view for delegation
   private DuctulatorModel model;
   private DuctulatorView view;

   /*
      Constructor
         This is instantiated with a reference to the model and view
         Adds function to the application by adding listeners
   */
   public DuctulatorController(DuctulatorModel model, DuctulatorView view) {
      this.model = model;
      this.view = view;
      this.view.addRadioButtonListener(new RadioButtonListener());
      this.view.addButtonListener(new ButtonListener());
      this.view.addComboBoxListener(new ComboBoxListener());
   }
   
   /*
      Private inner class that deals with radio button functions
   */
   class RadioButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String radioButtonSelection = view.getRadioButtonSelection();
         if(radioButtonSelection == "Straight Duct") {
            model.setSelectedRadioButton(radioButtonSelection);
            model.setSelectedDuctTypeComboBoxItem("Square");
            view.displayComboBox(radioButtonSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(radioButtonSelection == "Transitions") {
            model.setSelectedRadioButton(radioButtonSelection);
            view.displayComboBox(radioButtonSelection);
            view.displayComboBoxInfo("Type 2");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if(radioButtonSelection == "Elbows") {
            model.setSelectedRadioButton(radioButtonSelection);
            view.displayComboBox(radioButtonSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getElbowsTotal());
         }
         else if(radioButtonSelection == "Take Offs") {
            model.setSelectedRadioButton(radioButtonSelection);
            view.displayComboBox(radioButtonSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getTakeOffsTotal());
         }
      }
   }   
   
   /*
      Private inner class that deals with button functions
   */
   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         int ductMaterial = view.getDuctMaterial();
         int total = view.getDuctTotal();
         int ductSize = view.getDuctSize();

         String radioButtonSelection = view.getRadioButtonSelection();
         String comboBoxSelection = view.getDuctTypeComboBoxSelection();

         
         if(radioButtonSelection == "Straight Duct") {
            model.addToStraightDuctList(ductMaterial, total, ductSize);
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(radioButtonSelection == "Transitions") {
            int ductSize2 = view.getSecondDuctSize();
            model.addToTransitionsList(ductMaterial, total, ductSize, ductSize2);
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if(radioButtonSelection == "Elbows") {
            model.addToElbowsList(ductMaterial, total, ductSize);
            view.displayTextArea(model.getElbowsTotal());
         }
         else if(radioButtonSelection == "Take Offs") {
            model.addToTakeOffsList(ductMaterial, total, ductSize);
            view.displayTextArea(model.getTakeOffsTotal());
         }
      }
   }

   /*
   Private inner class that deals with combo box functions
   */
   class ComboBoxListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         //Gets the selected duct material combo box item
         String ductMaterialSelection = view.getDuctMaterialComboBoxSelection() + " Duct";
         //Displays the selected duct material above the JTextArea
         view.setDuctMaterialLabel(ductMaterialSelection);

         //Gets the selected duct type combo box item
         String ductTypeSelection = view.getDuctTypeComboBoxSelection();
         //Displays the correct combo box info and the duct list according to the
         // selected duct type
         if(ductTypeSelection == "Square" || ductTypeSelection == "Oval") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(ductTypeSelection == "Round") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 4");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(ductTypeSelection == "Rectangular" || ductTypeSelection == "Rect. w/ Vanes" ||
                 ductTypeSelection == "Radius") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getElbowsTotal());
         }
         else if (ductTypeSelection == "Square to Square" || ductTypeSelection == "Square to Oval") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 2");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if (ductTypeSelection == "Square to Round") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 3");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if (ductTypeSelection == "Side Take-off" || ductTypeSelection == "Top Take-off") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getTakeOffsTotal());
         }
      }
   }
}