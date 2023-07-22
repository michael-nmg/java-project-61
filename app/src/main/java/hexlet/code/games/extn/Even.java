package hexlet.code.games.extn;

import static hexlet.code.Utils.getRandomNumber;

import hexlet.code.games.PatternForGame;

public final class Even extends PatternForGame {

    private final int endOfRange = 1000;

    @Override
    protected String[] invariant() {
        int number = getRandomNumber(endOfRange);
        String check = (number % 2 == 0) ? "yes" : "no";
        String answer = doAnswer(String.valueOf(number));
        return new String[]{answer, check};
    }

    @Override
    protected void greeting() {
        System.out.println("\nAnswer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public String getName() {
        return "Even";
    }

}
