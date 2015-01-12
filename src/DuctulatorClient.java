import javax.swing.*;

public class DuctulatorClient {
   public static void main(String[] args) {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            DuctulatorModel model = new DuctulatorModel();
            DuctulatorView view = new DuctulatorView(model);
            DuctulatorController controller = new DuctulatorController(model, view);
            view.setVisible(true);

         }
      });
   } 
}