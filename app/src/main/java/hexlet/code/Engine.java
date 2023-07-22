package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.extn.Calc;
import hexlet.code.games.extn.Even;
import hexlet.code.games.extn.Gcd;
import hexlet.code.games.extn.Prime;
import hexlet.code.games.extn.Progression;

import java.util.Scanner;

public class Engine {
    private static Game[] games = {
        new Even(),
        new Calc(),
        new Gcd(),
        new Progression(),
        new Prime(),
    };

    public static void start() {
        while (true) {
            System.out.println(previewTitles());
            Integer choice = doSelect();

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
        StringBuilder list = new StringBuilder();
        list.append("Please enter the game number and press Enter.\n");
        list.append("1 - Greet\n");

        for (int i = 0; i < games.length; ++i) {
            list.append(String.format("%s - %s%n", i + 2, games[i].getName()));
        }

        list.append("0 - Exit");
        return list.toString();
    }

    public static String selectChoice(int choice) {
        var str = "";
        return switch (choice) {
            case 0 -> "Goodbye.";
            case 1 -> {
                Cli.greeting();
                yield "";
            }
            default -> games[choice - 2].start(Cli.greeting());
        };
    }

    private static Integer doSelect() {
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
}
