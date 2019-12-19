package utils;

public class Print {
    public static void printMainMenu() {

        System.out.println(String.format("x%-200s", "x".repeat(50)));
        System.out.println(String.format("%-200s", "               Main menu"));
        System.out.println(String.format("x%-200sx", "x".repeat(50)));
        System.out.println(String.format("%-200s", "    1. Input from keyboard"));
        System.out.println(String.format("%-200s", "    2. Input from file"));
        System.out.println(String.format("%-200s", "    3. Exit"));
        System.out.println(String.format("x%-200s", "x".repeat(50)));
        System.out.println(String.format("%-200s", "    Input number from menu..."));
        System.out.println(String.format("x%-200s", "x".repeat(50)));
    }
}
