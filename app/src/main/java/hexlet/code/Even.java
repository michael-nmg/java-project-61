package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    public static String game(String name) {
        Random rand = new Random();
        int count = 0;
        greeting();

        while (count < 3) {
            int number = rand.nextInt(1000);
            String check = (number % 2 == 0) ? "yes" : "no";
            String answer = doAnswer(number);

            if (answer.equals(check)) {
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

    private static void greeting() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static String doAnswer(int number) {
        System.out.format("Question: %s\n", number);
        System.out.print("Your answer (yes or no): ");
        return new Scanner(System.in).nextLine();
    }
}
