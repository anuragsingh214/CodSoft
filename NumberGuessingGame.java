import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\nStarting a new round!");
            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = 5;
            roundsPlayed++;

            System.out.println("I've picked a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + attemptsLeft + " attempts to guess correctly.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");

                try {
                    int guess = scanner.nextInt();

                    if (guess < 1 || guess > 100) {
                        System.out.println("Your guess must be between 1 and 100. Try again.");
                        continue;
                    }

                    if (guess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the correct number!");
                        score++;
                        break;
                    } else if (guess < numberToGuess) {
                        System.out.println("Too low!");
                    } else {
                        System.out.println("Too high!");
                    }

                    attemptsLeft--;
                    if (attemptsLeft > 0) {
                        System.out.println("You have " + attemptsLeft + " attempts left.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    scanner.next(); // Clear invalid input
                }
            }

            if (attemptsLeft == 0) {
                System.out.println("You're out of attempts! The number was " + numberToGuess + ".");
            }

            System.out.println("Your score so far: " + score + " point(s) after " + roundsPlayed + " round(s).\n");

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Final score: " + score + " point(s) after " + roundsPlayed + " round(s). Goodbye!");

        scanner.close();
    }
}
