package app.views;

import java.util.Scanner;

public class AppView {

    public int getOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Choose option:
                1 - create file and write content
                2 - read file
                0 - close app
                """);
        return scanner.nextInt();
    }

    public  String getText(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
