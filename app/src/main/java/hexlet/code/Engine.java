package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {

    private static int gameRounds = 3;
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

    public static String selectChoice(int choice) {
        return switch (choice) {
            case 0 -> "Goodbye.";
            case 1 -> {
                Cli.greeting();
                yield "";
            }
            case 2 -> Even.game(Cli.greeting(), gameRounds);
            case 3 -> Calc.game(Cli.greeting(), gameRounds);
            case 4 -> Gcd.game(Cli.greeting(), gameRounds);
            case 5 -> Progression.game(Cli.greeting(), gameRounds);
            default -> Prime.game(Cli.greeting(), gameRounds);
        };
    }

}
