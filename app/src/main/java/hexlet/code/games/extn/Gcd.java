package hexlet.code.games.extn;

import static hexlet.code.Utils.gcd;
import static hexlet.code.Utils.getRandomNumber;

import hexlet.code.games.PatternForGame;

public final class Gcd extends PatternForGame {

    private final int endOfRange = 100;

    @Override
    protected String[] invariant() {
        int left = getRandomNumber(endOfRange);
        int rigth = getRandomNumber(endOfRange);
        rigth += (rigth == 0) ? 1 : 0;
        String check = String.valueOf(gcd(left, rigth));
        String question = String.format("%s %s", left, rigth);
        String answer = doAnswer(question);
        return new String[]{answer, check};
    }

    @Override
    protected void greeting() {
        System.out.println("\nFind the greatest common divisor of given numbers.");
    }

    public String getName() {
        return "GCD";
    }

}
