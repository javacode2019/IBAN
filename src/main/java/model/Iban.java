package model;

import utils.Print;
import utils.ReadAndWrite;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Iban {

    private String iBAN;
    private String countryCode;
    private int iBANLength;
    private boolean checkCountryCode;

    public Iban() {
    }

    public void start() {
        while (true) {
            Print.printMainMenu();
            int playerChoice = checkChoice();
            switch (playerChoice) {
                case 1:
                    inputFromKeyboard();
                    break;
                case 2:
                    inputFromFile();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void inputFromFile() {

        HashMap databaseMap;
        Contants contants = new Contants();
        ReadAndWrite readAndWrite = new ReadAndWrite();
        databaseMap = contants.createDb();
        readAndWrite.readAndWrite(databaseMap);

    }

    private void inputFromKeyboard() {
        HashMap databaseMap;
        Contants contants = new Contants();
        databaseMap = contants.createDb();
        validation(databaseMap);
    }

    private void validation(Map<String, Integer> map) {
        System.out.println("Input IBAN code");
        Scanner scanner = new Scanner(System.in);
        iBAN = scanner.nextLine();
        String ibanUperCaseWithoutSpace = iBAN.toUpperCase().replaceAll("\\s", "");
        countryCode = ibanUperCaseWithoutSpace.substring(0, 2);
        iBANLength = ibanUperCaseWithoutSpace.length();
        checkCountryCode = map.containsKey(countryCode);
        if (checkCountryCode && iBANLength == map.get(countryCode)) {
            System.out.println(ibanUperCaseWithoutSpace + ";true");
        } else {
            System.out.println(ibanUperCaseWithoutSpace + ";false");
        }

    }

    private int checkChoice() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            try {
                int value = Integer.parseInt(choice);
                if (value == 1 || value == 2 || value == 3) {
                    return value;
                } else {
                    System.out.println("Wrong enter, try again");
                    System.out.println("Enter only 1,2 or 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong enter, only numbers, try again");
                System.out.println("Enter only 1,2 or 3");
            }
        }
    }
}
