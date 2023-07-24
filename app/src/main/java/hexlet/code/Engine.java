package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {

    private static final int GAME_ROUNDS = 3;
    private static String[] games = {"Even", "Calc", "Gcd", "Progression", "Prime"};

    public static void start() {
        while (true) {
            System.out.println(previewTitles());
            Integer choice = doSelectTitle();

            if (choice == null) {
                System.out.println("\nTry again.\n");
                continue;
            }

            String result = selectChoice(choice);
            System.out.println(result);
            break;
        }
    }

    public static String previewTitles() {
        int index = 2;
        StringBuilder list = new StringBuilder();
        list.append("Please enter the game number and press Enter.\n");
        list.append("1 - Greet\n");

        for (String title : games) {
            list.append(String.format("%s - %s%n", index++, title));
        }

        list.append("0 - Exit");
        return list.toString();
    }

    private static Integer doSelectTitle() {
        System.out.print("Your choice: ");
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) {
            return null;
        }

        int choice = scan.nextInt();

        if (choice < 0 || games.length + 1 < choice) {
            return null;
        }

        return choice;
    }

    private static String voidStringAfterGreeting() {
        Cli.greeting();
        return "";
    }

    public static String selectChoice(int choice) {
        return switch (choice) {
            case 0:
                yield "Goodbye.";
            case 1:
                yield voidStringAfterGreeting();
            case 2:
                yield Even.game(Cli.greeting(), GAME_ROUNDS);
            case 3:
                yield Calc.game(Cli.greeting(), GAME_ROUNDS);
            case 4:
                yield Gcd.game(Cli.greeting(), GAME_ROUNDS);
            case 5:
                yield Progression.game(Cli.greeting(), GAME_ROUNDS);
            default:
                yield Prime.game(Cli.greeting(), GAME_ROUNDS);
        };
    }

}
