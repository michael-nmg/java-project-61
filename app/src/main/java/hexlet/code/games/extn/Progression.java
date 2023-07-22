package hexlet.code.games.extn;

import static hexlet.code.Utils.makeSequence;

import hexlet.code.games.PatternForGame;

public class Progression extends PatternForGame {

    @Override
    protected String[] invariant() {
        int number = random.nextInt(10);
        int diff = random.nextInt(100);
        String check = String.valueOf((number + 1) * diff);
        String question = makeSequence(number, diff);
        String answer = doAnswer(question);
        return new String[]{answer, check};
    }

    @Override
    protected void greeting() {
        System.out.println("\nWhat number is missing in the progression?");
    }

    public String getName() {
        return "Progression";
    }

}
