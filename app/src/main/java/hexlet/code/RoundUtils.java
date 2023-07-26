package hexlet.code;

import java.util.Scanner;

public class RoundsUtils {

    public static String getRound(String name, String[] questionAndCheck) {
        String question = questionAndCheck[0];
        String check = questionAndCheck[1];
        getQuestion(question);
        String answer = setAnswer();
        return compare(answer, check) ? "Correct!" : incorrect(answer, check, name);
    }

    public static String itsTrue(String name) {
        return String.format("Congratulations, %s!", name);
    }

    public static void goodbye() {
        System.out.println("Goodbye.");
    }

    public static void nextTry() {
        System.out.println("\nTry again.\n");
    }

    private static boolean compare(String answer, String check) {
        return answer.equals(check);
    }

    private static void getQuestion(String eval) {
        System.out.format("Question: %s%n", eval);
    }

    private static String setAnswer() {
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
                .append("!")
                .toString();
    }

}
