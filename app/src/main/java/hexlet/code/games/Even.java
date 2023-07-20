package hexlet.code.game;

import java.util.Random;
import java.util.Scanner;

public class Even {
    private static Random random = new Random();

    public static String game(String name) {
        greeting();
        int count = 0;

        while (count < 3) {
            int number = random.nextInt(1000);
            String check = (number % 2 == 0) ? "yes" : "no";
            String answer = doAnswer(number);

            if (!answer.equals(check)) {
                return incorrect(answer, check, name);
            }

            System.out.println("Correct!");
            ++count;
        }
        return itsTrue(name);
    }

    private static void greeting() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    private static String doAnswer(int number) {
        System.out.format("Question: %s%n", number);
        System.out.print("Your answer (yes or no): ");
        return new Scanner(System.in).nextLine();
    }

    private static String incorrect(String answer, String check, String name) {
        return new StringBuilder("'")
                .append(answer)
                .append("' is wrong answer ;(. Correct answer was '")
                .append(check)
                .append("'.\nLet's try again, ")
                .append(name)
                .append("!\n")
                .toString();
    }

    private static String itsTrue(String name) {
        return String.format("Congratulations, %s!%n", name);
    }
}
