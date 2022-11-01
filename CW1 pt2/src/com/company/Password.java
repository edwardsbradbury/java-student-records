package com.company;

public class Password {
  // I had to make these arrays static and global Password class variables so both generator and validator can access them
  // Initialise an array of numbers to randomly pick from
  static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
  // Initialise an array of all the non-alphanumemric characters on my keyboard
  static char[] symbolChars = {'\u005c\u0027','±', '!', '@', '€', '£', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '{', '}', ';', ':', '"', '|', '`', '~', ',', '.', '<', '>', '/', '\\', '?'};
  // Initialise an array of all upper and lowercase letters in the alphabet to randomly pick from
  static char[] alphabet = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z'};

  public static String generator(int length, int symbols, int digits) {
    // I will create separate strings for the numbers, symbols and letters to include in the password.
    // I chose strings so I can use methods like 'contains', instead of having a hundred for loops iterating over arrays
    String passwordNums = "";
    String passwordSymbs = "";
    String passwordLets = "";
    // preJumble will be the randomly generated numbers, symbols and letters concatenated together
    String preJumble = "";
    // password will be the final password returned to the user, a jumbled up version of preJumble
    String password = "";

    // Calculate how many random letters will need to be generated
    int numLetters = length - (symbols + digits);

    // Repeat code inside loop as long as iterator is less than symbols number
    for (int i = 0; i < symbols; i++) {
      // Generate a random number in the range of the length of the symbolChars array - will be used to access an index in the array
      int symbsIndex = (int) (Math.random() * symbolChars.length);
      // Concatenate the symbol - at the random index of the symbolChars array - to the passwordSymbs string
      passwordSymbs += symbolChars[symbsIndex];

    }

    // Repeat the code block as long as iterator is less than the number of digits
    for (int i = 0; i < digits; i++) {
      // Generate a random number in range of the length of the numbers array, to access a random index in the array
      int numsIndex = (int) (Math.random() * numbers.length);
      // Concatenate the number - at the random index of the numbers array - to the passwordNums string
      passwordNums += numbers[numsIndex];
    }

    // Repeat the code block whilst counter is less than numLetters
    for (int i = 0; i < numLetters; i++) {
      // Generate a random number in range of the length of the alphabet array, to access a random index in the array
      int letIndex = (int) (Math.random() * alphabet.length);
      // Concatenate the letter - at the random index of the alphabet array - to the passwordLets string
      passwordLets += alphabet[letIndex];
    }

    // Concatenate the randomly generated numbers, symbols and letters
    preJumble = passwordNums + passwordSymbs + passwordLets;

    // Initialise counter for controlling while loop
    int counter = 0;
    // Implementing the 'Fisher-Yates shuffle' algorithm to jumble the password string. Need an array of the characters in preJumble so that
    // as the character at an index is concatenated to the password String, the index is assigned a 'null' character
    char[] preJumbledArr = preJumble.toCharArray();
    // While counter is less than the length of the preJumble string
    while (counter < preJumbledArr.length) {
      // Generate a random number in range of the length of the preJumbledArr array, to access a random index in the array
      int randIndex = (int)(Math.random() * preJumble.length());
      // If the character at the random index in the array is null, the character which was there has already been added to password.
      if (preJumbledArr[randIndex] != '\0') {
        // If the character at that index isn't null, concatenate it into the password string
        password += preJumbledArr[randIndex];
        // Since the password may contain random symbols, digits & letters, a different value is needed to represent an empty index
        // Set the character at the index in the array to null, to avoid duplication
        preJumbledArr[randIndex] = '\0';
        // Increase counter
        counter++;
      }
    }
    // Return the random password
    return password;

  }

  public static String validator(String aPassword) {
    // Need an array of characters in password string, so I can count how many of each type of character there are
    char[] passwordChars = aPassword.toCharArray();
    // Variable for length of password
    int passLength = aPassword.length();
    // Variable for number of symbols in password
    int passSymbs = 0;
    // Variable for number of digits in password
    int passDigits = 0;
    // Boolean for whether or not the password contains an uppercase letter
    boolean hasUpperCase = false;
    // Boolean for whether or not the password contains a lowercase letter
    boolean hasLowerCase = false;
    // Boolean for whether or not letter cases are mixed
    boolean mixedCases = false;
    // Booleans for whether the password meets criteria
    boolean isPoor = false;
    boolean isOk = false;
    boolean isGood = false;
    boolean isExcellent = false;
    // outputstring will be the verdict on how good the password is
    String outputString = "";

    // Iterate through array of password characters
    for (char aChar : passwordChars) {
      // Compare each character to every number
      for (int aNum : numbers) {
        // If a member of numbers array matches the password character
        // (because one value is a char & the other is an int, I want to compare both as strings)
        if ((""+aNum+"").equals(""+aChar+"")) {
          // Increment the counter of digits in the password
          passDigits++;
        }
      }
    }

    // Iterate through array of password characters
    for (char aChar : passwordChars) {
      // Compare each character to every symbol
      for (char aSymb : symbolChars) {
        // If a member of symbols array matches the password character
        if (aChar == aSymb) {
          // Increment the counter of symbols in the password
          passSymbs++;
        }
      }
    }

    // Iterate over the lowercase alphabet
    for (char lowerChar = 'a'; lowerChar <= 'z'; lowerChar++) {
      // Check whether the password the user entered contains each lowercase letter
      // Wanted to use contains method to avert writing another for-loop and still needing if comparison inside
      if (aPassword.contains(""+lowerChar+"")) {
        // If any lowercase letters match, hasLowerCase is true
        hasLowerCase = true;
        // It's not necessary to confirm more than one lowercase character
        break;
      }
    }

    // Iterate over the uppercase alphabet
    for (char upperChar = 'A'; upperChar <= 'Z'; upperChar++) {
      // Check whether the password the user entered contains each uppercase letter
      // Wanted to use contains method to avert writing another for-loop and still needing if comparison inside
      if (aPassword.contains(""+upperChar+"")) {
        // If any uppercase letters match, hasUpperCase is true
        hasUpperCase = true;
        // It's not necessary to confirm more than one uppercase character
        break;
      }
    }

    // If both hasLowerCase and hasUpperCase are true
    if (hasLowerCase && hasUpperCase) {
      // Then hasMixedCases is true
      mixedCases = true;
    }

    // Compound conditionals to determine whether the password entered is poor, ok, good or excellent
    // Lots of cases won't match any of these categories
    isExcellent = (passLength >= 16 && passSymbs > 4 && passDigits > 4 && mixedCases);
    isGood = (passLength > 12 && passSymbs > 3 && passDigits > 2 && mixedCases);
    isOk = (passLength > 8 && passSymbs > 1 && passDigits > 2 && !mixedCases);
    isPoor = (passLength <= 8 && passDigits == 0 && passSymbs == 0 && !mixedCases);

    // If the password matched the conditions for the excellent category
    if (isExcellent) {
      // Return that the password is excellent
      outputString += "The password is excellent";
    // If it matched the conditions for the good catergory
    } else if (isGood) {
      // Return that the password is good
      outputString += "The password is good";
    // Etc etc you don't need me to explain the rest of these
    } else if (isOk) {
      outputString += "The password is OK";
    } else if (isPoor) {
      outputString += "The password is poor";
    // Handle the many cases which won't match any of the very specific categories provided
    } else {
      outputString += "The password is terrible";
    }
    // Return the outputString to the method call in the menu
    return outputString;
  }

}