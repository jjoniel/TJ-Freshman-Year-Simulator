/*****************************************************************
* A AverageStudent is a Student that maintains information about its gender, name, grades, health, stress, and sleep. A AverageStudent
* knows how to return its grades, gender, and name. It also knows how to update its stress, health, sleep, and grades. 
* It also knows how to retrieve a question from the data file and how to set its grades to the starting values.
	 
* @author Joniel, Madhav, Zaeem 
* @version 1 
****************************************************************/
public class AverageStudent extends Student
{
   private int[] grades = new int[7]; 
   /************************************************************* 
   * Constructs a average student with gender specified by g and a name specified by n.
   * @param s student
   **************************************************************/
   public AverageStudent(Student s)
   {
      super(s.getGender(), s.getName());
      startingGrades();
   }
   /************************************************************* 
   * Constructs a average student with gender specified by g and a name specified by n.
   * @param g gender
   * @param n name
   **************************************************************/
   public AverageStudent(char g, String n)
   {
      super(g, n);
      startingGrades();
   }
   public int[] getGrades()
   {
      return grades;
   }
   /***************************************************************
   * Sets the average student's grade for a specific class. 
   * @param period identifies class
   * @param grade new grade
   **************************************************************/
   public void setGrade(int period, int grade)
   {
      grades[period] = grade;
   }
   /***************************************************************
   * Sets  the average student's grades to a default value.
   **************************************************************/
   public void startingGrades()
   {
      for(int x = 0; x<grades.length; x++)
      {
         grades[x]=85;
      }  
   }
   /***************************************************************
   * Calculates and sets one of the average students's grades.
   * @param period identifies class
   * @param grade new grade
   **************************************************************/
   public void addGrade(int period, int grade)
   {
      grades[period] = (grades[period]+grade)/2;
   }
   /***************************************************************
   * Retrives a question from average student's data file
   **************************************************************/
   public String askQuestion(int l)
   {
      return "";
   }
}
