package hexlet.code.games.extn;

import static hexlet.code.Utils.isPrime;

import hexlet.code.games.PatternForGame;

public class Prime extends PatternForGame {

    @Override
    protected String[] invariant() {
        int number = random.nextInt(3573);
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