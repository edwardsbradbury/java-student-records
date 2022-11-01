package com.company;
// Import the ArrayList package
import java.util.ArrayList;

// Class for creating Student instances, with getter and setter methods
public class Student {

  // Name, department, age, userName, studentNumber, fullTime and grades are all properties of Student instances
  private String name;
  private String department;
  private int age;
  private String userName;
  private int studentNumber;
  private boolean fullTime;
  // The grades property is an ArrayList holding instances of Grade. publicly accessible so Main class can add Grades to it
  public ArrayList<Grade> grades = new ArrayList<Grade>();

  // Getter method so other modules can access the private name property
  public String getName() {
    return this.name;
  }
  // Setter method so other modules can update the private name property
  public void setName(String newName) {
    this.name = newName;
  }
  // Getter method so other modules can access the private department property
  public String getDept() {
    return department;
  }
  // Setter method so other modules can update the private department property
  public void setDept(String newDept) {
    this.department = newDept;
  }
  // Getter method so other modules can access the private age property
  public int getAge() {
    return age;
  }
  // Setter method so other modules can update the private age property
  public void setAge(int newAge) {
    this.age = newAge;
  }
  // Getter method so other modules can access the private userName property
  public String getUserName() {
    return userName;
  }
  // Setter method so other modules can update the private userName property
  public void setUserName(String newUserName) {
    this.userName = newUserName;
  }
  // Getter method so other modules can access the private studentNumber property
  public int getStudentNumber() {
    return studentNumber;
  }
  // Setter method so other modules can update the private studentNumber property
  public void setStudentNumber(int newStudentNumber) {
    this.studentNumber = newStudentNumber;
  }
  // Getter method so other modules can access the private fullTime property
  public boolean getFullTimeStatus() {
    return fullTime;
  }
  // Setter method so other modules can update the private fullTime property
  public void setFullTimeStatus(boolean newStatus) {
    this.fullTime = newStatus;
  }
  // Getter method so other modules can access the grades property
  public ArrayList<Grade> getGrades() {
    return this.grades;
  }

  // Method to generate and format student record as string for output
  public static String toString(Student aStudent) {
    // Create a string with the student instance's properties, each labelled and on a new line
    String studentRecord = "Name: "+aStudent.getName()+"\nDepartment: "+aStudent.getDept()+"\nAge: "+aStudent.getAge()+"\nUsername: "+aStudent.getUserName()+"\nStudent number: "+aStudent.getStudentNumber()+"\nFull time status: "+aStudent.getFullTimeStatus()+"\n";
    // Create a string which will have the student instance's grades added to it
    String studentGrades = "\nGrades:\n";
    for (Grade aGrade : aStudent.grades) {
      // Retrieve and store the subject property of the current Grade instance
      String gradeSubject = aGrade.getSubject()+": ";
      // Retrieve the current Grade instance's score, pass it to Grade's getLetter method, convert to a string and assign to a variable
      String gradeLetter = ""+Grade.getLetterGrade(aGrade.getScore())+"";
      // Now build a string with the Grade's subject and grade letter, assign it to the previously initialised studentGrades string
      studentGrades += gradeSubject.concat(gradeLetter) +"\n";
    }
    // Concatenate the student's grades to their record
    studentRecord += studentGrades;
    // Return the record to the method call
    return studentRecord;
  }

  // Method to output the name of any student who failed a module and which module they failed
  public static void checkFailed(Student aStudent) {
    // Iterate through each Student instance's Grade instances
    for (Grade aGrade : aStudent.grades) {
      // Check whether each Grade's score property is below the threshold for a pass
      if (aGrade.getScore() < 40) {
        // If so, output the current Student's name and the title of the failed module
        System.out.println(aStudent.getName()+" failed the '"+aGrade.getSubject()+"' module.");
      }
    }
  }

  // Constructor for Student instances
  public Student(String name, String department, int age, String userName, int studentNumber, boolean fullTime) {
    this.name = name;
    this.department = department;
    this.age = age;
    this.userName = userName;
    this.studentNumber = studentNumber;
    this.fullTime = fullTime;
  }

}
