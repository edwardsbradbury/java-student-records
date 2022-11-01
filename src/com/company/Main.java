package com.company;
// Import the ArrayList package
import java.util.ArrayList;
// Import the scanner class
import java.util.Scanner;

public class Main {

  // Declare the ArrayList which will store the instances of student class
  private static ArrayList<Student> students = new ArrayList<Student>();
  
  // Method for the menu by which user's interact with the program
  public static void menu() {

    // Create scanner object and assign to variable
    Scanner in = new Scanner(System.in);
    // Variable which will store the number entered by the user
    int option;
    // Control variable for do/while loop
    boolean isValid = false;

    // The user should see the menu at least once
    do {
      // Print instructions to the console for how the user should operate the program
      System.out.println("\nType the number for the option you want, followed by return:\n 1: List all students & their grades\n 2: List students who have failed a module\n 3: List each student's average grade\n 4: Quit the program");
      // Loop to handle invalid (non-numeric) input
      while (!in.hasNextInt()) {
        // Display error prompt to user
        System.out.println("Invalid option: choose 1, 2, 3 or 4");
        // Print instructions to the console for how the user should operate the program
        System.out.println("\nType the number for the option you want, followed by return:\n 1: List all students & their grades\n 2: List students who have failed a module\n 3: List each student's average grade\n 4: Quit the program");
        // Check for another input from user
        in.next();
      }
      // Take the user input and assign it to the option variable
      option = in.nextInt();
      // Record whether the character the user input corresponds to a valid menu option. Used for the while condition later
      isValid = (!(option <= 0) || !(option > 4) || option == 1 || option == 2 || option == 3);

      // Display error prompt if number entered is not a valid option
      if (option <= 0 || option > 4) {
        // Display error prompt to user
        System.out.println("\nInvalid option: choose 1, 2, 3 or 4");
      }


      // Conditional logic to execute functionality corresponding to the chosen menu option
      switch (option) {
        // If the user chose option 1
        case 1:
          // Iterate through the ArrayLost of Student instances
          for (Student student : students) {
            // Use the Student class' toString method to return each student's record and display it
            System.out.println(Student.toString(student));
          }
          break;
        // If user chose option 2
        case 2:
          // Iterate through the Student instances
          for (Student student : students) {
            // Pass each Student instance to the Student class' checkFailed method, which outputs whether they failed modules and if so, which modules
            Student.checkFailed(student);
          }
          break;
        // If user chose option 3
        case 3:
          // Iterate through Student instances
          for (Student student : students) {
            // Output each student's average score by calling Grade class' getAveScore method, passing each student as an argument
            System.out.println(Grade.getAveScore(student));
          }
          break;
      }

    // The menu should run repeatedly whilst the user input is valid (see line 25) and is not 4 (option 4 should terminate execution)
    } while ((option <= 0 || option > 4) || (isValid && option != 4)); {
      // Output message to console to inform user that program is terminating
      System.out.println("Goodbye");
    }

  }

  public static void main(String[] args) {

    // Create new instance of Student class
    Student bertSmith = new Student("Bert Smith", "computing", 21, "bsmit001", 12345, true);
    // Add grades to Student's record
    bertSmith.grades.add(new Grade("programming", 52));
    bertSmith.grades.add(new Grade("web dev", 63));
    bertSmith.grades.add(new Grade("maths", 76));
    bertSmith.grades.add(new Grade("algorithms", 68));

    // Create new instance of Student class
    Student oliviaGreen = new Student("Olivia Green", "computing", 19, "ogree001", 12346, true);
    // Add grades to Student's record
    oliviaGreen.grades.add(new Grade("programming", 73));
    oliviaGreen.grades.add(new Grade("web dev", 82));
    oliviaGreen.grades.add(new Grade("maths", 72));
    oliviaGreen.grades.add(new Grade("algorithms", 66));

    // Create new instance of Student class
    Student eloiseJones = new Student("Eloise Jones", "computing", 18, "ejone001", 12347, true);
    // Add grades to Student's record
    eloiseJones.grades.add(new Grade("programming", 65));
    eloiseJones.grades.add(new Grade("web dev", 63));
    eloiseJones.grades.add(new Grade("maths", 37));
    eloiseJones.grades.add(new Grade("algorithms", 40));

    // Create new instance of Student class
    Student benBird = new Student("Ben Bird", "computing", 42, "bbird001", 12348, false);
    // Add grades to Student's record
    benBird.grades.add(new Grade("programming", 55));
    benBird.grades.add(new Grade("web dev", 29));
    benBird.grades.add(new Grade("maths", 56));
    benBird.grades.add(new Grade("algorithms", 38));

    // Create new instance of Student class
    Student karenBrown = new Student("Karen Brown", "computing", 25, "kbrow002", 12349, false);
    // Add grades to Student's record
    karenBrown.grades.add(new Grade("programming", 62));
    karenBrown.grades.add(new Grade("web dev", 51));
    karenBrown.grades.add(new Grade("maths", 43));
    karenBrown.grades.add(new Grade("algorithms", 43));

    // Add the newly instantiated Students to the students ArrayList
    students.add(bertSmith);
    students.add(oliviaGreen);
    students.add(eloiseJones);
    students.add(benBird);
    students.add(karenBrown);

    // Execute the menu function
    menu();

  }
}
