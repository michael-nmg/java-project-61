package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {

    private static final int GAME_ROUNDS = 3;
    private static final int EVEN_TITLE = 2;
    private static final int CALC_TITLE = 3;
    private static final int GCD_TITLE = 4;
    private static final int PROGRESSION_TITLE = 5;
    private static final String[] GAMES = {"Even", "Calc", "Gcd", "Progression", "Prime"};

    public static void start() {
        while (true) {
            previewTitles();
            Integer choice = doSelectTitle();

            if (choice == null) {
                RoundUtils.nextTry();
                continue;
            } else if (choice == 0) {
                RoundUtils.goodbye();
                break;
            } else if (choice == 1) {
                Cli.greeting();
                break;
            }

            String result = roundsControl(choice);
            System.out.println(result);
            break;
        }
    }

    public static void previewTitles() {
        int index = 2;
        StringBuilder list = new StringBuilder();
        list.append("Please enter the game number and press Enter.\n");
        list.append("1 - Greet\n");

        for (String title : GAMES) {
            list.append(String.format("%s - %s%n", index++, title));
        }

        list.append("0 - Exit");
        System.out.println(list);
    }

    private static Integer doSelectTitle() {
        System.out.print("Your choice: ");
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) {
            return null;
        }

        int choice = scan.nextInt();

        if (choice < 0 || GAMES.length + 1 < choice) {
            return null;
        }

        return choice;
    }

    private static String roundsControl(int choice) {
        int count = 0;
        String name = Cli.greeting();
        getDescription(choice);

        while (count < GAME_ROUNDS) {
            String result = RoundUtils.getRound(name, getGameInvariant(choice));

            if (!result.equals("Correct!")) {
                return result;
            }

            System.out.println(result);
            ++count;
        }

        return RoundUtils.itsTrue(name);
    }

    private static String[] getGameInvariant(int choice) {
        return switch (choice) {
            case EVEN_TITLE -> Even.invariant();
            case CALC_TITLE -> Calc.invariant();
            case GCD_TITLE -> Gcd.invariant();
            case PROGRESSION_TITLE -> Progression.invariant();
            default -> Prime.invariant();
        };
    }

    private static void getDescription(int choice) {
        switch (choice) {
            case EVEN_TITLE -> Even.description();
            case CALC_TITLE -> Calc.description();
            case GCD_TITLE -> Gcd.description();
            case PROGRESSION_TITLE -> Progression.description();
            default -> Prime.description();
        }
    }

}
