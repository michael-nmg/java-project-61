package hexlet.code;

import java.util.Scanner;

public class Choice {
    private static String[] options = {"Greet", "Even"};

    public static void choiceTitle() {
        int size = options.length;
        System.out.println("Please enter the game number and press Enter.");

        for (int i = 0; i < size; ++i) {
            System.out.format("%s - %s\n", i + 1, options[i]);
        }

        System.out.println("0 - Exit");
    }

    public static void selectChoice() {
        System.out.print("Your choice: ");
        Scanner scan = new Scanner(System.in);

        if (scan.hasNextInt()) {
            int choice = scan.nextInt();

            if (choice == 0) {
                System.out.println("\nGoodbye.");
            } else if (0 < choice && choice <= options.length) {
                String name = Cli.greeting();
                switch (choice) {
                    case 2:
                        System.out.println(Even.game(name));
                        break;
                    default:
                        break;
                }
            } else {
                tryAgain();
            }
        } else {
            tryAgain();
        }
    }

    private static void tryAgain() {
        System.out.println("\nTry again!\n");
        choiceTitle();
        selectChoice();
    }
}
