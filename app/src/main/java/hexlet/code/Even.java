package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static String game(String name) {
        Random rand = new Random();
        boolean state = true;
        int count = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (count < 3 && state) {
            int number = rand.nextInt(1000);
            String check = (number % 2 == 0) ? "yes" : "no";

            System.out.format("Question: %s\n", number);
            System.out.print("Your answer (yes or no): ");
            String answer = new Scanner(System.in).nextLine();

            state &= answer.equals(check);

            if (state) {
                count += 1;
                System.out.println("Correct!");
            } else {
                return String.format("'%s' is wrong answer ;(. "
                        + "Correct answer was '%s'.\n"
                        + "Let's try again, %s!",
                        answer,
                        check,
                        name);
            }
        }
        return String.format("Congratulations, %s!", name);
    }
}
