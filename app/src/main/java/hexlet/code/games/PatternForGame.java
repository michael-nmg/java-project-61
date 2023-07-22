package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public abstract class PatternForGame implements Game {

    protected final Random random = new Random();

    public String start(String name) {
        greeting();
        int count = 0;

        while (count < 3) {
            String[] result = invariant();
            String answer = result[0];
            String check = result[1];

            if (!answer.equals(check)) {
                return incorrect(answer, check, name);
            }

            System.out.println("Correct!");
            ++count;
        }
        return itsTrue(name);
    }

    protected abstract String[] invariant();

    protected abstract void greeting();

    protected String doAnswer(String question) {
        System.out.format("Question: %s%n", question);
        System.out.print("Your answer: ");
        return new Scanner(System.in).nextLine();
    }

    protected String itsTrue(String name) {
        return String.format("Congratulations, %s!", name);
    }

    protected String incorrect(String answer, String check, String name) {
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
