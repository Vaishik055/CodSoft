import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int score = 0;

        while (playAgain) {

            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n🎯 Guess the number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Correct! You guessed in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } 
                else if (userGuess < targetNumber) {
                    System.out.println("Too Low!");
                } 
                else {
                    System.out.println("Too High!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println(" Out of attempts! The number was: " + targetNumber);
            }

            System.out.println("🏆 Your Score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
