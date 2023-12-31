package hexlet.code.games;

import java.util.Scanner;

public abstract class PatternForGame implements Game {

    private final int gameRounds = 3;

    public final String start(String name) {
        greeting();
        int count = 0;

        while (count < gameRounds) {
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

    protected final String doAnswer(String question) {
        System.out.format("Question: %s%n", question);
        System.out.print("Your answer: ");
        return new Scanner(System.in).nextLine();
    }

    /**
     * Universal for a right ending.
     *
     * @param name For back end string text
     * @return String text
     */
    private String itsTrue(String name) {
        return String.format("Congratulations, %s!", name);
    }

    /**
     * Universal for a wrong ending.
     *
     * @param answer Username answer of subclass for back end string text
     * @param check  Right answer of subclass for back end string text
     * @param name   Username of Cli_greeting for back end string text
     * @return String text
     */
    private String incorrect(String answer, String check, String name) {
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
