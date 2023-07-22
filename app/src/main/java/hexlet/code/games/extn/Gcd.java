package hexlet.code.games.extn;

import hexlet.code.games.PatternForGame;

public class Gcd extends PatternForGame {

    @Override
    protected String[] invariant() {
        int left = random.nextInt(100);
        int rigth = random.nextInt(100);
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

    private int gcd(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : gcd(b, a % b);
    }

}
