package hexlet.code.games;

import static hexlet.code.Response.round;
import static hexlet.code.Response.itsTrue;
import static hexlet.code.Utils.makeSequence;
import static hexlet.code.Utils.getRandomNumber;

public final class Progression {

    private static final int LENGTH_SEQUENCE = 10;
    private static final int RANGE_OF_DIFFERENCE = 100;

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
        int diff = getRandomNumber(RANGE_OF_DIFFERENCE);
        int holeNumber = getRandomNumber(LENGTH_SEQUENCE);
        String check = String.valueOf((holeNumber + 1) * diff);
        String question = makeSequence(LENGTH_SEQUENCE, holeNumber, diff);
        return new String[]{question, check};
    }

    private static void description() {
        System.out.println("\nWhat number is missing in the progression?");
    }

}
