/*****************************************************************
* A Student is an Object that maintains information about its gender, name, grades, health, stress, and sleep. A Student
* knows how to return its grades, gender, and name. It also knows how to update its stress, health, sleep, and grades.
	 
* @author Joniel, Madhav, Zaeem 
* @version 1 
****************************************************************/
public abstract class Student
{
   private char gender;
   private String name;    
   private int health;
   /************************************************************* 
   * Constructs a student with gender specified by g and a name specified by n.
   * @param g    gender
   * @param n    name
   **************************************************************/
   public Student(char g, String n)
   {
      gender = g;
      name = (""+n.charAt(0)).toUpperCase();
      name +=n.substring(1).toLowerCase(); 
      
      health = 75;
   }
   /*************************************************************** 
   * Returns the students's gender
   * @return	 gender
   **************************************************************/
   public char getGender()
   {
      return gender;
   }
   /*************************************************************** 
   * Returns the students's name
   * @return	 name
   **************************************************************/
   public String getName()
   {
      return name;
   }
   /*************************************************************** 
   * Returns the students's health
   * @return	 health
   **************************************************************/
   public int getHealth()
   {
      return health;
   }
   /*************************************************************** 
   * Updates the students's health
   * @param x health
   **************************************************************/
   public void updateHealth(int x)
   {
      health = (health+x)/2;
      if(health>100) health = 100;
   }
   /***************************************************************
   * Sets student's grades to a default value.
   **************************************************************/
   public abstract void startingGrades();
   /***************************************************************
   * Retrives a question from data file
   * @param l line number
   * @return question
   **************************************************************/
   public abstract String askQuestion(int l);
   /*************************************************************** 
   * Returns the students's grades
   * @return	 grades
   **************************************************************/
   public abstract int[] getGrades();
   /*************************************************************** 
   * Adds a grade to one of the student's classes
   * @param period
   * @param grade
   **************************************************************/
   public abstract void addGrade(int period, int grade);
}
