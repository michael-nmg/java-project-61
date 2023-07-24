package hexlet.code.games;

import static hexlet.code.Response.round;
import static hexlet.code.Response.itsTrue;
import static hexlet.code.Utils.calcEval;
import static hexlet.code.Utils.getRandomNumber;

public class Calc {

    private static int endOfRange = 100;
    private static int countOperations = 3;
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
        int left = getRandomNumber(endOfRange);
        int right = getRandomNumber(endOfRange);
        String oper = operations[getRandomNumber(countOperations)];
        String question = String.format("%s %s %s", left, oper, right);
        String check = String.valueOf(calcEval(left, right, oper));
        return new String[]{question, check};
    }

    private static void description() {
        System.out.println("\nWhat is the result of the expression?");
    }

}
