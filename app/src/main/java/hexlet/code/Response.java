package hexlet.code;

import java.util.Scanner;

public class Response {

    public static String round(String name, String[] questionAndCheck) {
        String question = questionAndCheck[0];
        String check = questionAndCheck[1];
        String answer = doAnswer(question);
        return answer.equals(check) ? "Correct!" : incorrect(answer, check, name);
    }

    public static String doAnswer(String question) {
        System.out.format("Question: %s%n", question);
        System.out.print("Your answer: ");
        return new Scanner(System.in).nextLine();
    }

    public static String itsTrue(String name) {
        return String.format("Congratulations, %s!", name);
    }

    public static String incorrect(String answer, String check, String name) {
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
