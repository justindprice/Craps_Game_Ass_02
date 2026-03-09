import java.util.Random;
import java.util.Scanner;

public class Ass_02_Craps { // Updated to reflect Assignment 02
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            // Initial Roll: Sum of 2-12 [cite: 28]
            int die1 = rnd.nextInt(6) + 1; // [cite: 19]
            int die2 = rnd.nextInt(6) + 1; // [cite: 20, 21]
            int crapsRoll = die1 + die2;   // [cite: 22]

            System.out.println("Roll: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + crapsRoll); // [cite: 34]

            // Rule Check: Craps [cite: 29]
            if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                System.out.println("Result: Craps! You crapped out and lost."); // [cite: 35]
            }
            // Rule Check: Natural [cite: 30]
            else if (crapsRoll == 7 || crapsRoll == 11) {
                System.out.println("Result: Natural! You win!"); // [cite: 35]
            }
            // Rule Check: The Point [cite: 31]
            else {
                int point = crapsRoll;
                System.out.println("The sum is now the point: " + point); // [cite: 36]
                boolean pointPhase = true;

                while (pointPhase) { // Indefinite repetition until win/loss [cite: 12]
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    int sum = die1 + die2;

                    System.out.println("Trying for point: Die 1 = " + die1 + ", Die 2 = " + die2 + ", Sum = " + sum); // [cite: 37, 38]

                    if (sum == point) {
                        System.out.println("Made point and won!"); // [cite: 39]
                        pointPhase = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost."); // [cite: 40]
                        pointPhase = false;
                    }
                }
            }

            // Prompt to play again [cite: 33, 43]
            System.out.print("Do you want to play again? (y/n): ");
            String userResponse = in.nextLine();
            if (!userResponse.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }
        System.out.println("Game Over.");
    }
}