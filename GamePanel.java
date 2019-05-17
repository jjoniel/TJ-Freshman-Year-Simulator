//GamePanel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.Timer;
import java.io.*;
public class GamePanel extends JPanel
{
   private static final int FRAME = 1000;   
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private int health1, grade1, health2, grade2;
   private JButton q1, q2, start;
   private JLabel pic1, pic2,tj1;
   private BufferedImage myImage;
   private Graphics g;
   private int xPos, yPos;
   private Scanner scanner;
   private JLabel welcome, or;
   private JPanel subpanel, choicepanel;
   private Timer t;
   private int currIndex;
   private ImageIcon[] arrayOfFrames;
   private JLabel imageLabel;
   private Student s;
   private ImageIcon pic, pi2;
   public GamePanel(Student student) throws Exception
   {
      setLayout(new BorderLayout());
      setBackground(new Color(64,224,208));
      scanner= new Scanner(new File("AQuest.txt"));
      s=student;
      subpanel = new JPanel();
      subpanel.setBackground(new Color(64,224,208));
      subpanel.setLayout(new BorderLayout());
      welcome = new JLabel("");
      welcome.setFont( new Font("Times New Roman", Font.BOLD, 30));
      welcome.setText("HELLO "+s.getName().toUpperCase()+"! \nWELCOME TO TJ FRESHMEN YEAR SIMULATOR");
      welcome.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(welcome, BorderLayout.CENTER);
    
      start = new JButton("START");
      start.setFont( new Font("Times New Roman", Font.BOLD, 25));
      start.addActionListener(new StartListener());
      start.setPreferredSize(new Dimension(10,30));
      subpanel.add(start, BorderLayout.SOUTH);
      
      // tj1 = new JLabel();
//       ImageIcon tj = new ImageIcon(new ImageIcon("animation_0.jpg").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
//       tj1.setIcon(tj);
//       tj1.setHorizontalAlignment(SwingConstants.CENTER);
//       subpanel.add(tj1,BorderLayout.NORTH);
      
      currIndex = 0;
      imageLabel = new JLabel();
      imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(imageLabel, BorderLayout.NORTH);
      arrayOfFrames = new ImageIcon[3];
           //read in the images:
      for(int i=0;i<arrayOfFrames.length;i++)
      {
         arrayOfFrames[i] = new ImageIcon(new ImageIcon("animation_"+i+".jpg").getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));;
      }
      int delay =  2000;
      t = new Timer(delay, new AnimationStepper());
      t.start();
      
      add(subpanel, BorderLayout.CENTER);
      
      choicepanel = new JPanel();
      choicepanel.setLayout(new FlowLayout());
      q1 = new JButton("option1");
      q1.addActionListener(new Q1Listener());
      q2 = new JButton("option2");
      q2.addActionListener(new Q2Listener());
      q1.setFont( new Font("Times New Roman", Font.BOLD, 25));
      q2.setFont( new Font("Times New Roman", Font.BOLD, 25));
      
      choicepanel.add(q1);
      or = new JLabel("OR");
      or.setHorizontalAlignment(SwingConstants.CENTER);
      choicepanel.add(or);
      choicepanel.add(q2);
      q1.setVisible(false);
      q2.setVisible(false);
      or.setVisible(false);
      add(choicepanel, BorderLayout.SOUTH);
   }
   public void askQuestion()
   {
      
      if(scanner.hasNext())
      {
            String t = scanner.nextLine();
            q1.setText(t);
            pic = new ImageIcon(new ImageIcon(scanner.next()).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
            pic1.setIcon(pic);
            pic1.setHorizontalAlignment(SwingConstants.CENTER);
            add(pic1,BorderLayout.WEST);
            
            health1 = scanner.nextInt();
            grade1 = scanner.nextInt();
            
            scanner.nextLine();
            String t1 = scanner.nextLine(); 
            q2.setText(t1);  
            pi2 = new ImageIcon(new ImageIcon(scanner.next()).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
            pic2.setIcon(pi2);
            pic2.setHorizontalAlignment(SwingConstants.CENTER);
            add(pic2,BorderLayout.EAST);
            health2 = scanner.nextInt();
            grade2 = scanner.nextInt(); 
            
            scanner.nextLine();
      }
   }

   private class AnimationStepper implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
               
         imageLabel.setIcon(arrayOfFrames[currIndex]);
         currIndex++;
         currIndex%=arrayOfFrames.length;
         subpanel.setBackground(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
      }   
      
   }
   
   private class StartListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //t.stop();
         subpanel.setVisible(false);
         welcome.setVisible(false); 
         start.setVisible(false); 
         q1.setVisible(true);
         or.setVisible(true);
         q2.setVisible(true);
         pic1 = new JLabel();
         pic2 = new JLabel();
         askQuestion();     
      }
   }
   private class Q1Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         s.updateHealth(health1);
         int pm = (int)(Math.random()*2);
         if(pm==0)
         { 
            for(int x=0; x<s.getGrades().length; x++)
            {
               s.addGrade(x,grade1-(int)(Math.random()*6));
            }
         }
         else
         { 
            for(int x=0; x<s.getGrades().length; x++)
            {
               s.addGrade(x,grade1+(int)(Math.random()*6));
            }
         }
         askQuestion(); 
      }
   }
   private class Q2Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         s.updateHealth(health2);
         int pm = (int)(Math.random()*2);
         if(pm==0)
         { 
            for(int x=0; x<s.getGrades().length; x++)
            {
               s.addGrade(x,grade2-(int)(Math.random()*6));
            }
         }
         else
         { 
            for(int x=0; x<s.getGrades().length; x++)
            {
               s.addGrade(x,grade2+(int)(Math.random()*6));
            }
         }
         askQuestion(); 
      }
   }


}
   
