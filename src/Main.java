import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        int chances = 5;
        var sc = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + chances + " chances to guess the correct number.");
        System.out.println();

        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy (10 chances)");
        System.out.println("2. Medium (5 chances)");
        System.out.println("3. Hard (3 chances)");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        System.out.println();

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
                throw new IllegalArgumentException("Invalid value to enter. ");
        }
    }
}