package hexlet.code.games;

import static hexlet.code.Response.round;
import static hexlet.code.Response.itsTrue;
import static hexlet.code.Utils.calcEval;
import static hexlet.code.Utils.getRandomNumber;

public class Calc {

    private static final int END_OF_RANGE = 100;
    private static final int COUNT_OPERATIONS = 3;
    private static String[] operations = {"+", "-", "*"};

    public static String game(String name, int roundsCount) {
        description();
        int count = 0;

        while (count < roundsCount) {
            String result = round(name, invariant());

            if (!result.equals("Correct!")) {
                return result;
            }

            System.out.println("Correct!");
            ++count;
        }

        return itsTrue(name);
    }

    private static String[] invariant() {
        int left = getRandomNumber(END_OF_RANGE);
        int right = getRandomNumber(END_OF_RANGE);
        String oper = operations[getRandomNumber(COUNT_OPERATIONS)];
        String question = String.format("%s %s %s", left, oper, right);
        String check = String.valueOf(calcEval(left, right, oper));
        return new String[]{question, check};
    }

    private static void description() {
        System.out.println("\nWhat is the result of the expression?");
    }

}
