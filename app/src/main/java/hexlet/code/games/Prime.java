package hexlet.code.games;

import static hexlet.code.Utils.isPrime;
import static hexlet.code.Utils.getRandomNumber;

public final class Prime {

    private static final int END_OF_RANGE = 3573;

    public static String[] invariant() {
        int number = getRandomNumber(END_OF_RANGE);
        String check = isPrime(number) ? "yes" : "no";
        return new String[]{String.valueOf(number), check};
    }

    public static void description() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

}
