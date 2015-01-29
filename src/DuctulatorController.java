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
         model.setSelectedRadioButton(radioButtonSelection);
         view.setSelectedFittingComboBox(radioButtonSelection);
         view.displayComboBox(radioButtonSelection);

         if(radioButtonSelection == "Straight Duct") {
            model.setSelectedDuctTypeComboBoxItem("Square");
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(radioButtonSelection == "Transitions") {
            model.setSelectedDuctTypeComboBoxItem("Square to Square");
            view.displayComboBoxInfo("Type 2");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if(radioButtonSelection == "Elbows") {
            model.setSelectedDuctTypeComboBoxItem("Rectangular");
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getElbowsTotal());
         }
         else if(radioButtonSelection == "Take Offs") {
            model.setSelectedDuctTypeComboBoxItem("Side Take-Off");
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
         String radioButtonSelection = view.getRadioButtonSelection();

         int ductMaterial = view.getDuctMaterial();
         int ductFitting = view.getDuctFitting();
         int total = view.getDuctTotal();
         int ductSize;
         int ductSize2;
         int ductDiameter;

         if(radioButtonSelection == "Straight Duct") {
            if(model.getSelectedDuctTypeComboBoxItem() == "Round") {
               ductDiameter = view.getDuctDiameter();
               model.addToStraightDuctList(ductMaterial, ductFitting, total, ductDiameter);
            }
            else {
               ductSize = view.getDuctSize();
               model.addToStraightDuctList(ductMaterial, ductFitting, total, ductSize);
            }

            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(radioButtonSelection == "Transitions") {
            if(model.getSelectedDuctTypeComboBoxItem() == "Square to Round") {
               ductSize = view.getDuctSize();
               ductDiameter = view.getDuctDiameter();
               model.addToTransitionsList(ductMaterial, ductFitting, total, ductSize, ductDiameter);
            }
            else  {
               ductSize = view.getDuctSize();
               ductSize2 = view.getSecondDuctSize();
               model.addToTransitionsList(ductMaterial, ductFitting, total, ductSize, ductSize2);
            }
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if(radioButtonSelection == "Elbows") {
            ductSize = view.getDuctSize();
            model.addToElbowsList(ductMaterial, ductFitting, total, ductSize);
            view.displayTextArea(model.getElbowsTotal());
         }
         else if(radioButtonSelection == "Take Offs") {
            ductSize = view.getDuctSize();
            model.addToTakeOffsList(ductMaterial, ductFitting, total, ductSize);
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
         String ductMaterialSelection = view.getDuctMaterialComboBoxSelection();
         model.setSelectedDuctMaterialComboBoxItem(ductMaterialSelection);
         //Displays the selected duct material above the JTextArea
         view.setDuctMaterialLabel(ductMaterialSelection + " Duct");
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
         else if (ductTypeSelection == "Side Take-Off" || ductTypeSelection == "Top Take-Off") {
            model.setSelectedDuctTypeComboBoxItem(ductTypeSelection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getTakeOffsTotal());
         }
      }
   }
}