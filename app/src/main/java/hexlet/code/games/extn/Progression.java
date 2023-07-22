package hexlet.code.games.extn;

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

    private String makeSequence(int number, int diff) {
        StringBuilder result = new StringBuilder();
        int size = 10;

        for (int i = 0; i < size; ++i) {
            int elem = (i + 1) * diff;
            String str = String.format("%s", i == number ? ".." : elem);
            result.append(str);

            if (i != size - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
