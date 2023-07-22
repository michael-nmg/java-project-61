package hexlet.code.games.extn;

import static hexlet.code.Utils.calcEval;

import hexlet.code.games.PatternForGame;

public class Calc extends PatternForGame {

    private final String[] operations = {"+", "-", "*"};

    @Override
    protected String[] invariant() {
        int left = random.nextInt(100);
        int right = random.nextInt(100);
        String oper = operations[random.nextInt(3)];
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
