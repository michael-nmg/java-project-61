package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc {

    private static Random random = new Random();
    private static String[] operations = {"+", "-", "*"};

    public static String game(String name) {
        int count = 0;

        while (count < 3) {
            int left = random.nextInt(100);
            int right = random.nextInt(100);
            String oper = operations[random.nextInt(3)];
            String eval = String.format("%s %s %s", left, oper, right);
            String check = String.valueOf(doCorrect(left, right, oper));
            String answer = doAnswer(eval);

            if (!answer.equals(check)) {
                return incorrect(answer, check, name);
            }

            System.out.println("Correct!");
            ++count;
        }
        return itsTrue(name);
    }

    private static String doAnswer(String eval) {
        System.out.format("Question: %s%n", eval);
        System.out.print("Your answer: ");
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

    private static void greeting() {
        System.out.println("What is the result of the expression?\n");
    }

    private static int doCorrect(int left, int right, String oper) {
        return switch (oper) {
            case "+" -> left + right;
            case "-" -> left - right;
            default -> left * right;
        };
    }
}
