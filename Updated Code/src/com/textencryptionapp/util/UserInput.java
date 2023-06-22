package com.textencryptionapp.util;
import java.util.Scanner;

public class UserInput {
    private final Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput(String instruction) {
        System.out.println(instruction);
        return scanner.nextLine();
    }

    public void displayOutput(String output) {
        System.out.println("ENCRYPTED RESULT:");
        System.out.println(output);
    }
}