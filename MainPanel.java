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
   private GoodStudent gStudent;
   private BadStudent bStudent;
   
   public MainPanel() throws Exception
   {
       setBackground(new Color(64,224,208));
       setLayout(new BorderLayout());
       String name = JOptionPane.showInputDialog("What is your name?");
       String gender = (JOptionPane.showInputDialog("What is your gender, M or F?"));
       gStudent = new GoodStudent( gender.charAt(0), name);
       add(new GamePanel(gStudent), BorderLayout.CENTER);
       add(new Scoreboard(gStudent), BorderLayout.EAST);

   }
}