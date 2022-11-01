package com.company;

// Class for creating Grade instances, with getter and setter methods
public class Grade {

  // subject and score are private properties of Grade instances
  private String subject;
  private double score;

  // Getter method so other modules can access the private subject property
  public String getSubject() {
    return subject;
  }
  // Setter method so other modules can update the private subject property
  public void setSubject(String aSubject) {
    this.subject = aSubject;
  }
  // Getter method so other modules can access the private score property
  public double getScore() {
    return score;
  }
  // Getter method so other modules can update the private score property
  public void setScore(double aScore) {
    this.score = aScore;
  }

  // Method for converting a numeric score to a lettered grade. Static so can be called from other modules, without a specific Grade instance
  static char getLetterGrade(double numericScore){
    // Variable to store the character which will be returned at end of method
    char letterGrade = ' ';
    // When score is 70 or more
    if (numericScore >= 70) {
      // The lettered grade is A
      letterGrade = 'A';
      // When score is 60 or more
    } else if (numericScore >= 60) {
      // The lettered grade is B
      letterGrade = 'B';
      // When score is 50 or more
    } else if (numericScore >= 50) {
      // The lettered grade is C
      letterGrade = 'C';
      // When score is 40 or more
    } else if (numericScore >= 40) {
      // The lettered grade is D
      letterGrade = 'D';
      // When score is less than 40
    } else if (numericScore < 40) {
      // The lettered grade is F
      letterGrade = 'F';
      // When score is less than 0 or more than 100
    } else if (numericScore < 0 || numericScore > 100) {
      // The lettered grade is E for error
      letterGrade = 'E';
    }
    // Return the letter assigned to the letterGrade variable
    return letterGrade;
  }

  public static String getAveScore(Student aStudent) {
    // Variable for keeping a running total of current Student's grade scores
    double totalScore = 0;
    // Need the number of separate Grade instances attached to the Student's record, for calculating the average
    int numGrades = aStudent.grades.size();
    // Iterate through the current Student instance's Grade instances
    for (Grade aGrade : aStudent.grades) {
      // Add the current Grade instance's score property to the running total
      totalScore += aGrade.getScore();
    }
    // Calculate the average score by dividing Student's total score by number of Grades
    double aveGrade = totalScore / numGrades;
    // Output the student's name and average grade
    return aStudent.getName()+"'s average grade score is "+aveGrade;
  }

  // Constructor for Grade instances
  public Grade(String subject, double score) {
    this.subject = subject;
    this.score = score;
  }

}
