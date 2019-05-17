//Scoreboard
//GamePanel
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.JOptionPane;
public class Scoreboard extends JPanel
{
   private JLabel tools, date, dat, name, gender;
   private JButton exit, sis, health;
   private int month,day,year;
   public Scoreboard(Student s)
   {
      setBorder(BorderFactory.createLineBorder(Color.black, 2))   ;
      day = 28;
      month = 8;
      year = 2018;
      setLayout(new GridLayout(7,1));
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
   }
   public void updateDate()
   {
      day++;
      if((year==2018 && month%2==0 && day>31)||(year==2019 && month%2==1 && day>31))
      {
         day = 1;
         month++;
         if(month>12)
         {
            year++;
            month = 1;
         }     
      }
      else if((year==2018 && month%2==1 && day>30)||(year==2019 && month%2==0 && day>30))
      {
         day = 1;
         month++;
         if(month>12)
         {
            year++;
            month = 1;
         }     
      }      
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
               int d = JOptionPane.showConfirmDialog(null, "Are you sure you want to drop out?");
               switch(d)
               {
                  case 0: System.exit(0);
                  case 1: ;
                  case 2: ;
               }
         }
      
   }
}