import javax.swing.*;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;

/**
   DuctulatorView sets up the UI for this GUI
*/
public class DuctulatorView extends JFrame {
   private String[] straightDuctTypes = {"Galvanized", "Steel", "Aluminum", "Galvanneal"};
   private String[] transitionDuctTypes = {"Square to Square", "Square to Round", "Square to Oval"};
   private String[] elbowDuctTypes = {"Rectangular", "Rect. w/ Vanes", "Radius"};
   private String[] takoOffDuctTypes = {"Side Take-off", "Top Take-off"};
   private JComboBox straightDuctComboBox;
   private JComboBox transitionComboBox;
   private JComboBox elbowComboBox;
   private JComboBox takeOffComboBox;
   private DuctulatorModel model;
   private JRadioButton straightDuct;
   private JRadioButton transitions;
   private JRadioButton elbows;
   private JRadioButton takeOffs;
   private ButtonGroup buttonGroup;
   private JLabel lengthLabel1;
   private JLabel widthLabel1;
   private JLabel totalLabel;
   private JLabel diameterLabel;
   private JTextField lengthTextField1;
   private JTextField widthTextField1;
   private JTextField totalTextField;
   private JTextField diameterTextField;
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
      setLayout(new MigLayout("hidemode 3, insets 10 n n n, fill", "10[]30[][127]30[]"));

      straightDuct = new JRadioButton("Straight Duct", true);
      transitions = new JRadioButton("Transitions", false);
      elbows = new JRadioButton("Elbows", false);
      takeOffs = new JRadioButton("Take Offs", false);

      if(straightDuct.isSelected()) {
         model.setSelectedRadioButton("Straight Duct");
      }
      else if(transitions.isSelected()) {
         model.setSelectedRadioButton("Transitions");
      }
      else if(elbows.isSelected()) {
         model.setSelectedRadioButton("Elbows");
      }
      else if(takeOffs.isSelected()) {
         model.setSelectedRadioButton("Take Offs");
      }

      buttonGroup = new ButtonGroup();
      buttonGroup.add(straightDuct);
      buttonGroup.add(transitions);
      buttonGroup.add(elbows);
      buttonGroup.add(takeOffs);

      add(straightDuct, "left");
      add(transitions, "left, cell 0 1");
      add(elbows, "left, cell 0 2");
      add(takeOffs, "left, cell 0 3");

      straightDuctComboBox = new JComboBox(straightDuctTypes);
      transitionComboBox = new JComboBox(transitionDuctTypes);
      elbowComboBox = new JComboBox(elbowDuctTypes);
      takeOffComboBox = new JComboBox(takoOffDuctTypes);

      add(straightDuctComboBox, "left, cell 2 0, growx");
      add(transitionComboBox, "left, cell 2 0, growx");
      add(elbowComboBox, "left, cell 2 0, growx");
      add(takeOffComboBox, "left, cell 2 0, growx");

      transitionComboBox.setVisible(false);
      elbowComboBox.setVisible(false);
      takeOffComboBox.setVisible(false);

      lengthLabel1 = new JLabel("Length:     ");
      widthLabel1 = new JLabel("Width:     ");
      totalLabel = new JLabel("Total:     ");
      diameterLabel = new JLabel("Diameter:");
      lengthTextField1 = new JTextField();
      widthTextField1 = new JTextField();
      totalTextField = new JTextField();
      diameterTextField = new JTextField();
      lengthLabel2 = new JLabel("Length:     ");
      widthLabel2 = new JLabel("Width:     ");
      lengthTextField2 = new JTextField();
      widthTextField2 = new JTextField();
      addButton = new JButton("Add");

      add(lengthLabel1, "right, cell 1 1");
      add(lengthTextField1, "wrap, w 100, growx");
      add(widthLabel1, "right, cell 1 2");
      add(widthTextField1, "wrap, w 100, growx");
      add(diameterLabel, "right, cell 1 3");
      add(diameterTextField, "wrap, w 100, growx");
      add(lengthLabel2, "right, cell 1 3");
      add(lengthTextField2, "wrap, w 100, growx");
      add(widthLabel2, "right, cell 1 4");
      add(widthTextField2, "wrap, w 100, growx");
      add(totalLabel, "right, cell 1 5");
      add(totalTextField, "wrap, w 100, growx");
      add(addButton, "right, cell 2 7, wrap");

      diameterLabel.setVisible(false);
      diameterTextField.setVisible(false);
      lengthLabel2.setVisible(false);
      lengthTextField2.setVisible(false);
      widthLabel2.setVisible(false);
      widthTextField2.setVisible(false);

      listTextArea = new JTextArea(10, 15);
      listTextArea.setLineWrap(true);
      listScrollPane = new JScrollPane(listTextArea);
      listScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      add(listScrollPane, "east, pad 10 0 0 0");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setLocationRelativeTo(null);
//      setResizable(false);
   }
   
   //Add action listeners for each of the radio buttons
   public void addRadioButtonListener(ActionListener radioButtonListener) {
      straightDuct.addActionListener(radioButtonListener);
      transitions.addActionListener(radioButtonListener);
      elbows.addActionListener(radioButtonListener);
      takeOffs.addActionListener(radioButtonListener);
   }

   //Add action listeners for the combo boxes
   public void addComboBoxListener(ActionListener comboBoxListener) {
      straightDuctComboBox.addActionListener(comboBoxListener);
      transitionComboBox.addActionListener(comboBoxListener);
      elbowComboBox.addActionListener(comboBoxListener);
      takeOffComboBox.addActionListener(comboBoxListener);
   }

   //Add action listeners for each of the buttons
   public void addButtonListener(ActionListener buttonListener) {
      addButton.addActionListener(buttonListener);
   }

   public void displayComboBox(String radioButtonSelection) {
      if(radioButtonSelection == "Straight Duct") {
         straightDuctComboBox.setVisible(true);
         transitionComboBox.setVisible(false);
         elbowComboBox.setVisible(false);
         takeOffComboBox.setVisible(false);
      }
      else if(radioButtonSelection == "Transitions") {
         straightDuctComboBox.setVisible(false);
         transitionComboBox.setVisible(true);
         elbowComboBox.setVisible(false);
         takeOffComboBox.setVisible(false);
      }
      else if(radioButtonSelection == "Elbows") {
         straightDuctComboBox.setVisible(false);
         transitionComboBox.setVisible(false);
         elbowComboBox.setVisible(true);
         takeOffComboBox.setVisible(false);
      }
      else if(radioButtonSelection == "Take Offs") {
         straightDuctComboBox.setVisible(false);
         transitionComboBox.setVisible(false);
         elbowComboBox.setVisible(false);
         takeOffComboBox.setVisible(true);
      }
   }

   //Displays the correct UI for the specific type of duct
   public void displayComboBoxInfo(String comboBox) {
      if(comboBox == "Type 1") {
         lengthLabel2.setVisible(false);
         lengthTextField2.setVisible(false);
         widthLabel2.setVisible(false);
         widthTextField2.setVisible(false);
         diameterLabel.setVisible(false);
         diameterTextField.setVisible(false);
      }
      else if(comboBox == "Type 2") {
         lengthLabel2.setVisible(true);
         lengthTextField2.setVisible(true);
         widthLabel2.setVisible(true);
         widthTextField2.setVisible(true);
         diameterLabel.setVisible(false);
         diameterTextField.setVisible(false);
      }
      else if(comboBox == "Type 3") {
         lengthLabel2.setVisible(false);
         lengthTextField2.setVisible(false);
         widthLabel2.setVisible(false);
         widthTextField2.setVisible(false);
         diameterLabel.setVisible(true);
         diameterTextField.setVisible(true);
      }
   }
   
   //Gets the radio button that's currently selected and returns the text from it
   public String getRadioButtonSelection() {
      if(straightDuct.isSelected()) 
         return straightDuct.getText();

      else if(transitions.isSelected())
         return transitions.getText();

      else if(elbows.isSelected())
         return elbows.getText();
         
      else if(takeOffs.isSelected())
         return takeOffs.getText();
         
      //This return statement does nothing and is only needed to complete the method. 
      //A radio button will always be selected   
      return null;
   }

   //Gets the combo box item that's currently selected and returns the text from it
   public String getComboBoxSelection() {
      String selection;
      if(straightDuct.isSelected()) {
         selection = (String) straightDuctComboBox.getSelectedItem();
         return selection;
      }
      else if(transitions.isSelected()) {
         selection = (String) transitionComboBox.getSelectedItem();
         return selection;
      }
      else if(elbows.isSelected()) {
         selection = (String) elbowComboBox.getSelectedItem();
         return selection;
      }
      else if(takeOffs.isSelected()) {
         selection = (String) takeOffComboBox.getSelectedItem();
         return selection;
      }
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