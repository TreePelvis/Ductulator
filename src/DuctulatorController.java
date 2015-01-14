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
         String selection = view.getRadioButtonSelection();
         if(selection == "Straight Duct") {
            model.setSelectedRadioButton(selection);
            view.displayComboBox(selection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(selection == "Transitions") {
            model.setSelectedRadioButton("selection");
            view.displayComboBox(selection);
            view.displayComboBoxInfo("Type 2");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if(selection == "Elbows") {
            model.setSelectedRadioButton(selection);
            view.displayComboBox(selection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getElbowsTotal());
         }
         else if(selection == "Take Offs") {
            model.setSelectedRadioButton(selection);
            view.displayComboBox(selection);
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
         int ductSize = view.getDuctSize();
         int total = view.getDuctTotal();
         
         String selection = view.getRadioButtonSelection();
         
         if(selection == "Straight Duct") {
            model.addToStraightDuctList(ductSize, total);
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(selection == "Transitions") {
            model.addToTransitionsList(ductSize, total);
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if(selection == "Elbows") {
            model.addToElbowsList(ductSize, total);
            view.displayTextArea(model.getElbowsTotal());
         }
         else if(selection == "Take Offs") {
            model.addToTakeOffsList(ductSize, total);
            view.displayTextArea(model.getTakeOffsTotal());
         }
      }
   }

   /*
   Private inner class that deals with button functions
   */
   class ComboBoxListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String selection = view.getComboBoxSelection();
         if(selection == "Galvanized" || selection == "Steel" ||
                 selection == "Aluminum" || selection == "Galvanneal" ||
                 selection == "Side Take-off" ||
                 selection == "Top Take-off") {
            model.setSelectedComboBoxItem(selection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(selection == "Rectangular" || selection == "Rect. w/ Vanes" ||
                 selection == "Radius") {
            model.setSelectedComboBoxItem(selection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getElbowsTotal());
         }
         else if (selection == "Square to Square" || selection == "Square to Oval") {
            model.setSelectedComboBoxItem(selection);
            view.displayComboBoxInfo("Type 2");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if (selection == "Square to Round") {
            model.setSelectedComboBoxItem(selection);
            view.displayComboBoxInfo("Type 3");
            view.displayTextArea(model.getTransitionsTotal());
         }
         else if (selection == "Side Take-off" || selection == "Top Take-off") {
            model.setSelectedComboBoxItem(selection);
            view.displayComboBoxInfo("Type 1");
            view.displayTextArea(model.getTakeOffsTotal());
         }

      }
   }
   private String[] transitionDuctTypes = {"Square to Square", "Square to Round", "Square to Oval"};
}