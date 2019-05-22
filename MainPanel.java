import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class MainPanel extends JPanel
{
   private static final int FRAME = 400;   
   private static final Color BACKGROUND = new Color(204, 204, 204);
   //fields

   private GamePanel gamepanel;
   private Student student;
   public Scoreboard scoreboard;
   private String gender = "";
   private JButton instructions;   
   public MainPanel() throws Exception
   {
       setBackground(new Color(64,224,208));
       setLayout(new BorderLayout());
       String name = JOptionPane.showInputDialog("What is your first name?"); 
       while(!(gender.equalsIgnoreCase("m")||gender.equalsIgnoreCase("f")))
       {
         gender = (JOptionPane.showInputDialog("What is your gender, M or F?"));
       }       
       int type = (int)(Math.random()*3);
       switch(type)
       {
         case 0: student = new BadStudent( gender.charAt(0), name); 
                 break;
         case 1: student = new GoodStudent( gender.charAt(0), name);
                 break;
         case 2: student = new AverageStudent( gender.charAt(0), name);
                 break;        
         
       }
       scoreboard = new Scoreboard(student);
       add(new GamePanel(student, scoreboard), BorderLayout.CENTER);
       add(scoreboard, BorderLayout.EAST);
       instructions = new JButton("INSTRUCTIONS");
       instructions.setFont(new Font("Times New Roman", Font.BOLD, 15));
       instructions.addActionListener(new InstructionsListener());
       instructions.setPreferredSize(new Dimension(125, 50));
       add(instructions, BorderLayout.NORTH);

   }
   private class InstructionsListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JOptionPane.showMessageDialog(null, "1. You will be presented with two options, you must choose one of the two in order to proceed throughout the game.\n2. Each choice will change your health and grades accordingly\n3. You can check your grades using the sis button and health with the health button. You may also dropout at any time\n4. ENJOY!!");
      }
   }
}