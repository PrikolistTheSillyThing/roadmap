import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        int chances = 5;
        int minAttempts = Integer.MAX_VALUE;
        var sc = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + chances + " chances to guess the correct number.");
        System.out.println();

        while (true) {
            System.out.println("Please select the difficulty level:");
            System.out.println("1. Easy (10 chances)");
            System.out.println("2. Medium (5 chances)");
            System.out.println("3. Hard (3 chances)");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Great! You have selected the Easy difficulty level.");
                        chances = 10;
                        break;
                    case 2:
                        System.out.println("Great! You have selected the Medium difficulty level.");
                        chances = 5;
                        break;
                    case 3:
                        System.out.println("Great! You have selected the Hard difficulty level.");
                        chances = 3;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
                continue;
            }

            System.out.println();
            System.out.println("Let's start the game!");
            var rand = new Random();
            int realNum = rand.nextInt(100) + 1;
            boolean won = false;
            System.out.println();

            for (int i = 0; i < chances; i++) {
                System.out.print("Enter your guess: ");
                int userNum = Integer.parseInt(sc.nextLine());
                if (userNum < 1 || userNum > 100) {
                    System.out.println("Number must be between 1 and 100.");
                    i--;
                    continue;
                }
                if (userNum == realNum) {
                    System.out.println("Congratulations! You guessed the correct number in " + (i+1) + " attempts.");
                    won = true;
                    if (i + 1 < minAttempts) {
                        minAttempts = i + 1;
                    }
                    System.out.println("Highest score: " + minAttempts + " attempts");
                    break;
                } else if (userNum > realNum){
                    System.out.println("Incorrect! the number is less than " + userNum + ".");
                } else if (userNum < realNum) {
                    System.out.println("Incorrect! the number is greater than " + userNum + ".");
                }
            }

            if (!won) {
                System.out.println("Out of chances! The number was: " + realNum);
            }
            System.out.print("Continue?: ");
            String value = sc.nextLine();
            if (value.equalsIgnoreCase("y")) {
                System.out.println("Starting another round...");
            } else {
                System.out.println("Goodbye!");
                return;
            }
        }
    }
}