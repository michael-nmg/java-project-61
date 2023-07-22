package hexlet.code.games.extn;

import static hexlet.code.Utils.isPrime;
import static hexlet.code.Utils.getRandomNumber;

import hexlet.code.games.PatternForGame;

public final class Prime extends PatternForGame {

    private final int endOfRange = 3573;

    @Override
    protected String[] invariant() {
        int number = getRandomNumber(endOfRange);
        String check = isPrime(number) ? "yes" : "no";
        String answer = doAnswer(String.valueOf(number));
        return new String[]{answer, check};
    }

    @Override
    protected void greeting() {
        System.out.println("\nAnswer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public String getName() {
        return "Prime";
    }

}
