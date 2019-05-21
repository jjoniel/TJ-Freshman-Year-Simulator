//Scoreboard
//GamePanel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Scoreboard extends JPanel
{
   private JLabel tools, date, dat, name, gender;
   private JButton exit, sis, health, highest;
   private int month,day,year;
   private Scanner infile;
   public Scoreboard(Student s)
   {
      setBorder(BorderFactory.createLineBorder(Color.black, 2))   ;
      day = 28;
      month = 8;
      year = 2018;
      setLayout(new GridLayout(8,1));
      tools = new JLabel("TOOLS");
      tools.setFont( new Font("Calibri", Font.BOLD, 25));
      tools.setHorizontalAlignment(SwingConstants.CENTER);
      add(tools);
      
      //date
      JPanel datePanel = new JPanel();
      datePanel.setLayout(new FlowLayout());
      date = new JLabel("Date");
      date.setFont( new Font("Calibri", Font.PLAIN, 25));
      date.setHorizontalAlignment(SwingConstants.CENTER);
      datePanel.add(date);
      dat = new JLabel(month+"/"+day+"/"+year);
      dat.setFont( new Font("Calibri", Font.PLAIN, 25));
      dat.setHorizontalAlignment(SwingConstants.CENTER);
      datePanel.add(dat);
      add(datePanel);
      
      
      //stats buttons
      sis = new JButton("Check SIS");
      sis.setFont( new Font("Calibri",Font.PLAIN, 25));
      sis.addActionListener(new gradeListener(s));
      sis.setBackground(Color.WHITE);
      add(sis);
      
      health = new JButton("Check Health");
      health.setFont( new Font("Calibri",Font.PLAIN, 25));
      health.addActionListener(new healthListener(s));
      health.setBackground(Color.WHITE);
      add(health);
      
      
            
      //info 
      name = new JLabel(""+s.getName());
      name.setFont( new Font("Calibri", Font.PLAIN, 25));
      name.setHorizontalAlignment(SwingConstants.CENTER);
      add(name);
      if(s.getGender()=='m'||s.getGender()=='M')
         gender = new JLabel("Male");
      else
         gender = new JLabel("Female");
      gender.setHorizontalAlignment(SwingConstants.CENTER);
      gender.setFont( new Font("Calibri",Font.PLAIN, 25));
      add(gender);
      
      //dropout button
      exit = new JButton("Dropout");
      exit.setFont( new Font("Calibri",Font.PLAIN, 25));
      exit.setBackground(new Color(59, 89, 182));
      exit.setBackground(Color.RED);
      exit.addActionListener(new quitListener());
      add(exit);
      
      //highest scores button
      highest = new JButton("Highest Scores");
      highest.setFont( new Font("Calibri",Font.PLAIN, 25));
      highest.setBackground(new Color(59, 89, 182));
      highest.setBackground(Color.WHITE);
      highest.addActionListener(new highestListener());
      add(highest);
      highest.setVisible(false);
   }
   public void setDate(int m, int d, int y)
   {
      month = m;
      day = d;
      year = y;
      dat.setText(month+"/"+day+"/"+year);
      
   }
   public int getMonth()
   {
      return month;
   }
   public int getDay()
   {
      return day;
   }
   public int getYear()
   {
      return year;
   }
   public void endingScoreboard()
   {
      exit.setText("End Game");
      highest.setVisible(true);
   }
   private class gradeListener implements ActionListener
   {
         Student p;
         public gradeListener(Student s)
         {
            p = s;
         }
         public void actionPerformed(ActionEvent e)
         {
            int[] grades = p.getGrades();
            String output = "";
            for(int x=0; x<7; x++)
            {
               output=output+"Period "+(x+1)+": "+grades[x]+"\n"; 
            }
            JOptionPane.showMessageDialog(null,""+output);
         }
      
   }
   private class healthListener implements ActionListener
   {
         Student p;
         public healthListener(Student s)
         {
            p = s;
         }      
         public void actionPerformed(ActionEvent e)
         {
            int[] grades = p.getGrades();
            JOptionPane.showMessageDialog(null,"Health: "+p.getHealth());
         }
      
   }
   
   private class quitListener implements ActionListener
   {
         public void actionPerformed(ActionEvent e)
         {
               String k = "";
               k = exit.getText();
               if(k.equals("End Game"))
               {
                  System.exit(0);
               }
               int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to drop out?");
               switch(d)
               {
                  case 0: System.exit(0);
                  case 1: ;
                  case 2: ;
               }
         }
      
   }
   private class highestListener implements ActionListener
   {
         Student p;
         public highestListener(Student s)
         {
            p = s;
         }      
         public void actionPerformed(ActionEvent e)
         {
            
            PrintStream outfile = null;
            try
            {
               outfile = new PrintStream(new FileOutputStream("HighScores.txt"));
            }
            catch(FileNotFoundException e)
            {
               JOptionPane.showMessageDialog(null,"The file could not be created.");
            }
          	outfile.println(5);
            for(int x = 0; x < 5; x++)
            {
               outfile.print
            outfile.close();
         }
      
   }
   
}