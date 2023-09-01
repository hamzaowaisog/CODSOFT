import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        guessingnumber gn = new guessingnumber();

    }
}
class guessingnumber{
    guessingnumber() {
        System.out.println("Welcome to the guessing number game");
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int low_range = 1;
        int high_range = 100;
        int total_attempt = 0;
        int attempt = 0;
        int round = 0;
        int attempt_left=total_attempt;
        int user_guess;
        int win=0;
        while (true) {
            int guess_number = rand.nextInt(high_range - low_range) + low_range;
            round++;
            attempt=0;
            total_attempt =10;
            attempt_left=total_attempt;
            System.out.println("Round:" + round);
            System.out.println("Guess the number between 1 to 100");
            System.out.println("You have " + attempt_left + " attempt left");
            while (attempt < total_attempt && attempt_left >0) {
                attempt++;
                attempt_left = total_attempt - attempt;
                System.out.println("Enter your guess");
                user_guess = sc.nextInt();
                if (user_guess >0 && user_guess < 101) {
                    if (user_guess == guess_number) {
                        System.out.println("You have guessed the correct number");
                        win++;
                        break;
                    } else if (user_guess > guess_number) {
                        System.out.println("Your guess is too high");
                        System.out.println("You have " + attempt_left + " attempt left");
                    } else if (user_guess < guess_number) {
                        System.out.println("Your guess is too low");
                        System.out.println("You have " + attempt_left + " attempt left");
                    } else {
                        System.out.println("You have " + attempt_left + " attempt left");
                        System.out.println("Invalid input");
                    }
                } else {
                    System.out.println("You have " + attempt_left + " attempt left");
                    System.out.println("Invalid input");
                }

            }
            System.out.println("The number is " + guess_number);
            System.out.println("Do you want to continue? (y/n)");
            String choice = sc.next();
            if (choice.equals("n")) {
                break;
            }
        }
        System.out.println("Thank you for playing");
        System.out.println("You have won " + win + " times");
        System.out.println("You have lost " + (round - win) + " times");
        System.out.println("You have played " + round + " times");
    }
}

