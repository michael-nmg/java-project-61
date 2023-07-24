package hexlet.code.games;

import static hexlet.code.Response.round;
import static hexlet.code.Response.itsTrue;
import static hexlet.code.Utils.getRandomNumber;

public final class Even {

    private static final int END_OF_RANGE = 1000;

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
        int number = getRandomNumber(END_OF_RANGE);
        String check = (number % 2 == 0) ? "yes" : "no";
        return new String[]{String.valueOf(number), check};
    }

    private static void description() {
        System.out.println("\nAnswer 'yes' if the number is even, otherwise answer 'no'.");
    }

}
