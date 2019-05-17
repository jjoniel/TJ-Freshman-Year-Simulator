   import javax.swing.JFrame;
    public class Driver
   {
       public static void main(String[] args) throws Exception
      { 
         JFrame frame = new JFrame("TJ Freshmen Year Simulator");
         frame.setLocation(0, 0);
         frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	frame.setContentPane(new MainPanel());
         frame.setVisible(true);
      }
   }