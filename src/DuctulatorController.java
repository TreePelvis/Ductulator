import java.awt.*;       
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.layout.Grid; 

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
   }
   
   /*
      Private inner class that deals with radio button functions
   */
   class RadioButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String selection = view.getSelection();
         if(selection == "Straight Duct") {
            model.setSelectedDuctType("Straight Duct");
            view.displayDuctTypeInfo("Type 1");
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(selection == "Transition") {
            model.setSelectedDuctType("Transition");
            view.displayDuctTypeInfo("Type 2");
            view.displayTextArea(model.getTransitionTotal());
         }
         else if(selection == "Rect. Elbow") {
            model.setSelectedDuctType("Rect. Elbow");
            view.displayDuctTypeInfo("Type 1");
            view.displayTextArea(model.getRectElbowTotal());
         }
         else if(selection == "Take Off") {
            model.setSelectedDuctType("Take Off");
            view.displayDuctTypeInfo("Type 1");
            view.displayTextArea(model.getTakeOffTotal());
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
         
         String selection = view.getSelection();
         
         if(selection == "Straight Duct") {
            model.addToStraightDuctList(ductSize, total);
            view.displayTextArea(model.getStraightDuctTotal());
         }
         else if(selection == "Transition") {
            model.addToTransitionList(ductSize, total);
            view.displayTextArea(model.getTransitionTotal());
         }
         else if(selection == "Rect. Elbow") {
            model.addToRectElbowList(ductSize, total);
            view.displayTextArea(model.getRectElbowTotal());
         }
         else if(selection == "Take Off") {
            model.addToTakeOffList(ductSize, total);
            view.displayTextArea(model.getTakeOffTotal());
         }
      }
   }  
}