package hexlet.code.games.extn;

import hexlet.code.games.PatternForGame;

public class Even extends PatternForGame {

    @Override
    protected String[] invariant() {
        int number = random.nextInt(1000);
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
