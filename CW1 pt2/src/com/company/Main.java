package com.company;

// Import the scanner class
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Declare variable which will be assigned the user's input
    int option = 0;
    // Control variable for do/while loop
    boolean isValid;
    // Create scanner object and assign to variable
    Scanner in = new Scanner(System.in);
    do {
      // Display the menu options to the user
      System.out.println("\nSelect an option by typing the corresponding number:\n1) Generate a random password\n2) Validate a password\n3) Quit program");
      // Loop to handle invalid (non-numeric) input
      while (!in.hasNextInt()) {
        // Display error prompt to user
        System.out.println("\nInvalid option: choose 1, 2 or 3");
        // Re-display the menu options to the user
        System.out.println("\nSelect an option by typing the corresponding number:\n1) Generate a random password\n2) Validate a password\n3) Quit program");
        // Check for another input from user
        in.next();
      }
      // Take the user input and assign it to the option variable
      option = in.nextInt();
      // Handle integer input which doesn't correspond to a menu option
      if (option <= 0 || option > 3) {
        // Display error prompt to user
        System.out.println("\nInvalid option: choose 1, 2 or 3");
      }
      // Compound conditional for the while clause of the outer do/while loop (i.e. the main menu)
      isValid = (!(option <= 0) || !(option > 3) || option == 1 || option == 2);

      // Switch statement executes functionality according to the chosen menu 'option'
      switch (option) {

        // If the user entered 1, indicating they wish to generate a password
        case 1:
          // Initialise variables later passed as arguments to Password.generator
          int length = 0;
          int symbols = 0;
          int digits = 0;

          do {
            // Prompt to request user enter the overall length of the password
            System.out.println("\nEnter the total length (whole number of characters) for your password:");
            // Loop to handle invalid (non-numeric) input
            while (!in.hasNextInt()) {
              // Display error prompt to user
              System.out.println("Invalid length: must be a whole number and greater than 0");
              // Re-display input prompt to user
              System.out.println("Enter the total length (whole number of characters) for your password:");
              // Check for another input from user
              in.next();
            }
            // Take the valid number input and assign to variable which will be 'length' argument passed to Password.generator method
            length = in.nextInt();
            // User has entered a number less than 1
            if (length < 1) {
              System.out.println("Invalid length: must be a whole number and greater than 0");
            }
          // Repeat everything in the 'do' block above until length is 1 or more
          } while (length < 1); {
          }

          // Control variable for validating number of digits later
          int lengthMinusSymbs;

          do {
            // Prompt user to enter the number of symbols the password should include
            System.out.println("Enter the whole number of symbols you want in your password:");
            // Loop to handle invalid (non-numeric) input
            while (!in.hasNextInt()) {
              // Display error prompt to user
              System.out.println("Invalid input: must be a whole number, from 0 to "+length);
              // Re-display input prompt to user
              System.out.println("Enter the whole number of symbols you want in your password:");
              // Check for another input from user
              in.next();
            }
            // Take the valid number input and assign to variable which will be 'symbols' argument passed to Password.generator method
            symbols = in.nextInt();
            // User has asked for more symbols than the password has length
            if (symbols > length || symbols < 0) {
              System.out.println("Invalid input: must be a whole number, from 0 to "+length);
            }
          // Repeat everything in the 'do' block above until (0 <= symbols < length)
          } while (symbols > length || symbols < 0); {
            // Since by now symbols is fully validated...
            lengthMinusSymbs = length - symbols;
          }

          do {
            // Prompt user to enter the number of numeric digits the password should include
            System.out.println("Enter the whole number of numeric digits you want in your password:");
            // Loop to handle invalid (non-numeric) input
            while (!in.hasNextInt()) {
              // Display error prompt to user
              System.out.println("Invalid input: must be a whole number");
              // Re-display input prompt to user
              System.out.println("Enter the whole number of numeric digits you want in your password:");
              // Check for another input from user
              in.next();
            }
            // Take the valid number input and assign to variable which will be 'digits' argument passed to Password.generator method
            digits = in.nextInt();
            // User has asked for more digits than there is space for after 'symbols' is subtracted from 'length'
            if ((digits > lengthMinusSymbs) || digits < 0 ) {
              System.out.println("Your password length is "+length+" & you asked for "+symbols+" symbols. You can have 0 to "+(length-symbols)+" digits.");
            }
            // Repeat everything in the 'do' block above until (0 <= digits < (length - symbols))
          } while ((digits > lengthMinusSymbs) || digits < 0); {
          }

          // Print result of invoking the Password.generator method, passing the length, symbols & digits variables as arguments
          System.out.println("Your password is: " + Password.generator(length, symbols, digits));
          // Prevent the program executing the other menu option which wasn't chosen
          break;

        // If the user entered 2, indicating they wish to validate a password
        case 2:
          // Prompt user to enter a password to validate
          System.out.println("\nEnter a password:");
          // Check for user input and assign to a variable
          String toCheck = in.next();
          // Print result of invoking the Password.validator function, passing it the user entered password as an argument
          System.out.println(Password.validator(toCheck));
          break;
      }
    // Conditions under which the menu should continue to be executed
    } while ((option <= 0 || option > 3) || (isValid && option!=3)); {
      // Display confirmation that the program is terminating (i.e. if the user entered 3 or something other than a valid menu option - not 1 or 2)
      System.out.println("Goodbye");
    }

  }
}
