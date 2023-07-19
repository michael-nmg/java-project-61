package hexlet.code;

import java.util.Scanner;

public class Choice {
    private static String[] options = {"Greet", "Even"};

    public static void start() {
        while (true) {
            System.out.println(previewTitle());
            Scanner scan = doSelect();

            if (scan.hasNextInt()) {
                int choice = scan.nextInt();

                if (choice < 0 || choice > options.length) {
                    continue;
                }

                System.out.print(selectChoice(choice));
                break;
            }

            System.out.println("\nTry again.\n");
        }
    }

    public static String previewTitle() {
        StringBuilder list = new StringBuilder();
        list.append("Please enter the game number and press Enter.\n");

        for (int i = 0; i < options.length; ++i) {
            list.append(String.format("%s - %s%n", i + 1, options[i]));
        }

        list.append("0 - Exit");
        return list.toString();
    }

    public static String selectChoice(int choice) {
        if (0 < choice) {
            String name = Cli.greeting();
            return switch (choice) {
                case 2 -> Even.game(name);
                case 3 -> "3";
                default -> "";
            };
        }
        return "\nGoodbye.\n";
    }

    private static Scanner doSelect() {
        System.out.print("Your choice: ");
        return new Scanner(System.in);
    }
}
