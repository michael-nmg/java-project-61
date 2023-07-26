package hexlet.code.games;

import static hexlet.code.Utils.getRandomNumber;

public final class Even {

    private static final int END_OF_RANGE = 1000;

    public static String[] invariant() {
        int number = getRandomNumber(END_OF_RANGE);
        String check = (number % 2 == 0) ? "yes" : "no";
        return new String[]{String.valueOf(number), check};
    }

    public static void description() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

}
