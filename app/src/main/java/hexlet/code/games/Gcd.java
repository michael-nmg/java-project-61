package hexlet.code.games;

import static hexlet.code.Utils.gcd;
import static hexlet.code.Utils.getRandomNumber;

public final class Gcd {

    private static final int END_OF_RANGE = 100;

    public static String[] invariant() {
        int left = getRandomNumber(END_OF_RANGE);
        int rigth = getRandomNumber(END_OF_RANGE);
        rigth += (rigth == 0) ? 1 : 0;
        String check = String.valueOf(gcd(left, rigth));
        String question = String.format("%s %s", left, rigth);
        return new String[]{question, check};
    }

    public static void description() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

}
