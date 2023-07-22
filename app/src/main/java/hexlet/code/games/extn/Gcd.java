package hexlet.code.games.extn;

import static hexlet.code.Utils.gcd;

import hexlet.code.games.PatternForGame;

public class Gcd extends PatternForGame {

    @Override
    protected String[] invariant() {
        int left = random.nextInt(100);
        int rigth = random.nextInt(100);
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
