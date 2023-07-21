package hexlet.code.games.extn;

import hexlet.code.games.PatternForGame;

public class Calc extends PatternForGame {

    private final String[] operations = {"+", "-", "*"};

    @Override
    protected String[] invariant() {
        int left = random.nextInt(100);
        int right = random.nextInt(100);
        String oper = operations[random.nextInt(3)];
        String eval = String.format("%s %s %s", left, oper, right);
        String check = String.valueOf(doCorrect(left, right, oper));
        String answer = doAnswer(eval);
        return new String[]{answer, check};
    }

    @Override
    protected void greeting() {
        System.out.println("\nWhat is the result of the expression?");
    }

    private int doCorrect(int left, int right, String oper) {
        return switch (oper) {
            case "+" -> left + right;
            case "-" -> left - right;
            default -> left * right;
        };
    }

    public String getName() {
        return "Calc";
    }

}
