package hexlet.code.games.extn;

import static hexlet.code.Utils.makeSequence;
import static hexlet.code.Utils.getRandomNumber;

import hexlet.code.games.PatternForGame;

public final class Progression extends PatternForGame {

    private final int holeRange = 10;
    private final int rangeOfDifference = 100;

    @Override
    protected String[] invariant() {
        int number = getRandomNumber(holeRange);
        int diff = getRandomNumber(rangeOfDifference);
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
