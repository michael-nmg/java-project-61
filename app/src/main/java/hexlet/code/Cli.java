package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greeting() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String name = new Scanner(System.in).nextLine();

        System.out.format("Hello, %s!", name);
        return name;
    }
}
