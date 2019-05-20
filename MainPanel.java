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
   
   public MainPanel() throws Exception
   {
       setBackground(new Color(64,224,208));
       setLayout(new BorderLayout());
       String name = JOptionPane.showInputDialog("What is your name?");
       while(!(gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f"))) 
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

   }
}