package hexlet.code.games;

import static hexlet.code.Response.round;
import static hexlet.code.Response.itsTrue;
import static hexlet.code.Utils.isPrime;
import static hexlet.code.Utils.getRandomNumber;

public final class Prime {

    private static final int END_OF_RANGE = 3573;

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
        String check = isPrime(number) ? "yes" : "no";
        return new String[]{String.valueOf(number), check};
    }

    private static void description() {
        System.out.println("\nAnswer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

}
