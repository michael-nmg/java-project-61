package hexlet.code.games.extn;

import static hexlet.code.Utils.calcEval;
import static hexlet.code.Utils.getRandomNumber;

import hexlet.code.games.PatternForGame;

public final class Calc extends PatternForGame {

    private final int endOfRange = 100;
    private final int countOperations = 3;
    private final String[] operations = {"+", "-", "*"};

    @Override
    protected String[] invariant() {
        int left = getRandomNumber(endOfRange);
        int right = getRandomNumber(endOfRange);
        String oper = operations[getRandomNumber(countOperations)];
        String question = String.format("%s %s %s", left, oper, right);
        String check = String.valueOf(calcEval(left, right, oper));
        String answer = doAnswer(question);
        return new String[]{answer, check};
    }

    @Override
    protected void greeting() {
        System.out.println("\nWhat is the result of the expression?");
    }

    public String getName() {
        return "Calc";
    }

}
