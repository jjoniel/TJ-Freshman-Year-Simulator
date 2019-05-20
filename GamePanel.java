//GamePanel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
public class GamePanel extends JPanel
{
   private static final int FRAME = 1000;   
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private JButton q1, q2,start;
   private JLabel pic1, pic2,tj1;
   private BufferedImage myImage;
   private Graphics g;
   private int xPos, yPos;
   private Scanner scanner;
   private JLabel welcome;
   
   public GamePanel(GoodStudent gStudent) throws Exception
   {
      setLayout(new BorderLayout());
      setBackground(new Color(64,224,208));
      scanner= new Scanner(new File("AQuest.txt"));
      
      welcome = new JLabel("");
      welcome.setFont( new Font("Times New Roman", Font.BOLD, 30));
      welcome.setText("Hello "+gStudent.getName()+"! WELCOME TO TJ FRESHMEN YEAR SIMULATOR");
      welcome.setHorizontalAlignment(SwingConstants.CENTER);
      add(welcome, BorderLayout.CENTER);
    
      start = new JButton("START");
      start.addActionListener(new StartListener());
      start.setPreferredSize(new Dimension(10,30));
      add(start, BorderLayout.SOUTH);
      q1 = new JButton("START");
      q1.addActionListener(new Q1Listener());
      q1.setPreferredSize(new Dimension(10,30));
      add(q1, BorderLayout.SOUTH);
      q1.setVisible(false);
      
      q2 = new JButton("START");
      q2.addActionListener(new Q2Listener());
      q2.setPreferredSize(new Dimension(10,30));
      add(q2, BorderLayout.SOUTH);
      q2.setVisible(false);
      
      tj1 = new JLabel();
      ImageIcon tj = new ImageIcon(new ImageIcon("tjhsst-22.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
      tj1.setIcon(tj);
      tj1.setHorizontalAlignment(SwingConstants.CENTER);
      add(tj1,BorderLayout.NORTH);
      
   }
   
   private class StartListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         q1.setVisible(true);
          q2.setVisible(true);
         JLabel or = new JLabel("OR");
         or.setHorizontalAlignment(SwingConstants.CENTER);
         add(or,BorderLayout.CENTER);
         welcome.setVisible(false);
         tj1.setVisible(false); 
         String t = scanner.nextLine();
         
         q1.setText(t);
         pic1 = new JLabel();
         ImageIcon pic = new ImageIcon(new ImageIcon(scanner.nextLine()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
         pic1.setIcon(pic);
         pic1.setText(t);
         pic1.setHorizontalAlignment(SwingConstants.CENTER);
         add(pic1,BorderLayout.EAST);
         String t1 = scanner.nextLine();   
         pic2 = new JLabel();
         ImageIcon pi2 = new ImageIcon(new ImageIcon(scanner.nextLine()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
         pic2.setIcon(pi2);
         q2.setText(t1);
         pic2.setHorizontalAlignment(SwingConstants.CENTER);
         add(pic2,BorderLayout.WEST);
         start.setVisible(false);

      }
   }
   private class Q1Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
       }
   }
      private class Q2Listener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
       }
   }


}
   
