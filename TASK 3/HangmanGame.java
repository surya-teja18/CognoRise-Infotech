import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        String[] words = {"java", "python", "programming", "hangman", "development"};
        
        Random rand = new Random();
        String chosenWord = words[rand.nextInt(words.length)];
        char[] wordArray = new char[chosenWord.length()];
        Arrays.fill(wordArray, '_'); 
        
        int maxAttempts = 6;  
        int incorrectGuesses = 0;
        
        Scanner sc = new Scanner(System.in);
        while (incorrectGuesses < maxAttempts) {
            System.out.println("Current word: " + String.valueOf(wordArray));
            System.out.print("Guess a letter: ");
            char guessedLetter = sc.next().toLowerCase().charAt(0);
            
            boolean found = false;
            for (int i = 0; i < chosenWord.length(); i++) {
                if (chosenWord.charAt(i) == guessedLetter) {
                    wordArray[i] = guessedLetter;
                    found = true;
                }
            }
            
            if (!found) {
                incorrectGuesses++;
                System.out.println("Incorrect guess! You have " + (maxAttempts - incorrectGuesses) + " guesses left.");
                displayHangman(incorrectGuesses);
            }
            
            if (String.valueOf(wordArray).equals(chosenWord)) {
                System.out.println("Congratulations! You've guessed the word: " + chosenWord);
                break;
            }
        }
        
        if (incorrectGuesses == maxAttempts) {
            System.out.println("Game over! The word was: " + chosenWord);
        }
        
        sc.close();
    }

    public static void displayHangman(int incorrectGuesses) {
        switch (incorrectGuesses) {
            case 1:
                System.out.println(" O ");
                break;
            case 2:
                System.out.println(" O ");
                System.out.println(" | ");
                break;
            case 3:
                System.out.println(" O ");
                System.out.println(" | ");
                System.out.println("/");
                break;
            case 4:
                System.out.println(" O ");
                System.out.println(" | ");
                System.out.println("/ \\");
                break;
            case 5:
                System.out.println(" O ");
                System.out.println("-| ");
                System.out.println("/ \\");
                break;
            case 6:
                System.out.println(" O ");
                System.out.println("-|-");
                System.out.println("/ \\");
                System.out.println("You are hanged!");
                break;
        }
    }
}
