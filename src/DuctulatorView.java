import java.awt.*;       
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.layout.Grid; 
import net.miginfocom.swing.MigLayout;

/**
   DuctulatorView sets up the UI for this GUI
*/
public class DuctulatorView extends JFrame {
   private DuctulatorModel model;
   private JRadioButton straightDuct;
   private JRadioButton transition;
   private JRadioButton rectElbow;
   private JRadioButton takeOff;
   private ButtonGroup buttonGroup;
   private JLabel lengthLabel1;
   private JLabel widthLabel1;
   private JLabel totalLabel;
   private JTextField lengthTextField1;
   private JTextField widthTextField1;
   private JTextField totalTextField;
   private JLabel lengthLabel2;
   private JLabel widthLabel2;
   private JTextField lengthTextField2;
   private JTextField widthTextField2;
   private JButton addButton;
   private JTextArea listTextArea;
   private JScrollPane listScrollPane;

   /*
      Constructor
         Receives a reference to DuctulatorModel for delegation
         Sets up UI
   */
   public DuctulatorView(DuctulatorModel model) {
   super("MigLayout Basic");
   this.model = model;
   
   //Sets the layout to MigLayout
   setLayout(new MigLayout("insets 10 n n n", "10[]30[]10[]30"));
  
   straightDuct = new JRadioButton("Straight Duct", true);
   transition = new JRadioButton("Transition", false);
   rectElbow = new JRadioButton("Rect. Elbow", false);
   takeOff = new JRadioButton("Take Off", false);
   
   if(straightDuct.isSelected()) {
      model.setSelectedDuctType("Straight Duct");
   }
   else if(transition.isSelected()) {
      model.setSelectedDuctType("Transition");
   }
   else if(rectElbow.isSelected()) {
      model.setSelectedDuctType("Rectangular Elbow");
   }
   else if(takeOff.isSelected()) {
      model.setSelectedDuctType("Take Off");
   }  
   
   buttonGroup = new ButtonGroup();
   buttonGroup.add(straightDuct);
   buttonGroup.add(transition);
   buttonGroup.add(rectElbow);
   buttonGroup.add(takeOff);
  
   add(straightDuct, "left");
   add(transition, "left, cell 0 1");
   add(rectElbow, "left, cell 0 2");
   add(takeOff, "left, cell 0 3");
  
   lengthLabel1 = new JLabel("Length:");
   widthLabel1 = new JLabel("Width:");
   totalLabel = new JLabel("Total:");
   lengthTextField1 = new JTextField();
   widthTextField1 = new JTextField();
   totalTextField = new JTextField();
   lengthLabel2 = new JLabel("Length:");
   widthLabel2 = new JLabel("Width:");
   lengthTextField2 = new JTextField();
   widthTextField2 = new JTextField();
   addButton = new JButton("Add");
   
   add(lengthLabel1, "left, cell 1 0");
   add(lengthTextField1, "wrap, w 100");
   add(widthLabel1, "left, cell 1 1");
   add(widthTextField1, "wrap, w 100");
   add(lengthLabel2, "left, cell 1 2");
   add(lengthTextField2, "wrap, w 100");
   add(widthLabel2, "left, cell 1 3");
   add(widthTextField2, "wrap, w 100");
   add(totalLabel, "left, cell 1 4");
   add(totalTextField, "wrap, w 100");
   add(addButton, "right, cell 2 5, wrap");
  
   lengthLabel2.setVisible(false);
   lengthTextField2.setVisible(false);
   widthLabel2.setVisible(false);
   widthTextField2.setVisible(false);

   listTextArea = new JTextArea(10, 20);
   listTextArea.setLineWrap(true);
   listScrollPane = new JScrollPane(listTextArea);
   listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   add(listScrollPane, "east, pad 10 0 0 0");
   
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   pack();
   setLocationRelativeTo(null);
   setResizable(false);
   }
   
   //Add action listeners for each of the radio buttons
   public void addRadioButtonListener(ActionListener radioButtonListener) {
      straightDuct.addActionListener(radioButtonListener);
      transition.addActionListener(radioButtonListener);
      rectElbow.addActionListener(radioButtonListener);
      takeOff.addActionListener(radioButtonListener);
   }
   
   //Add action listeners for each of the buttons
   public void addButtonListener(ActionListener buttonListener) {
      addButton.addActionListener(buttonListener);
   }
   
   //Displays the correct UI for the specific type of duct
   public void displayDuctTypeInfo(String type) {
      if(type == "Type 1") {
         lengthLabel2.setVisible(false);
         lengthTextField2.setVisible(false);
         widthLabel2.setVisible(false);
         widthTextField2.setVisible(false);
      }
      else if(type == "Type 2") {
         lengthLabel2.setVisible(true);
         lengthTextField2.setVisible(true);
         widthLabel2.setVisible(true);
         widthTextField2.setVisible(true);
      }
   }
   
   //Gets the radio button that's currently selected and returns the text from it
   public String getSelection() {
      if(straightDuct.isSelected()) 
         return straightDuct.getText();

      else if(transition.isSelected()) 
         return transition.getText();

      else if(rectElbow.isSelected())
         return rectElbow.getText();
         
      else if(takeOff.isSelected())
         return takeOff.getText();
         
      //This return statement does nothing and is only needed to complete the method. 
      //A radio button will always be selected   
      return null;
   }
   
   //Gets the Duct size by adding the length and width that are entered
   // in lengthTextField1 and widthTextField1
   public int getDuctSize() {
      int length = Integer.parseInt(lengthTextField1.getText());
      int width = Integer.parseInt(widthTextField1.getText());
      int ductSize = length + width;
      return ductSize;
   }
   
   //Gets the total amount of duct entered in totalTextField
   public int getDuctTotal() {
      int total = Integer.parseInt(totalTextField.getText());
      return total;
   }
   
   //Displays the data stored in the linked list of the selected radio button
   public void displayTextArea(String text) {
      listTextArea.setText(text);
   }
}