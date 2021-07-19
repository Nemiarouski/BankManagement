package com.intexsoft.project.utils;

import java.util.List;
import java.util.Scanner;

public class CommandHelper {
    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        String name;
        do {
            name = scanner.nextLine();
        } while (name.length() <= 0);
        return name;
    }

    public int validateIntToValue(int value) {
        int inputNumber;
        do {
            System.out.println("[INFO]: Input number 1-" + value + ":");
            while (!scanner.hasNextInt()) {
                System.out.println("[INFO]: Input number 1-" + value + ":");
                scanner.next();
            }
            inputNumber = scanner.nextInt();
        } while (inputNumber <= 0 || inputNumber > value);
        return inputNumber;
    }

    public int validateInt() {
        int inputNumber;
        do {
            System.out.println("[INFO]: Input positive number:");
            while (!scanner.hasNextInt()) {
                System.out.println("[INFO]: Input positive number:");
                scanner.next();
            }
            inputNumber = scanner.nextInt();
        } while (inputNumber <= 0);
        return inputNumber;
    }

    public double validateDouble() {
        double inputNumber;
        do {
            System.out.println("[INFO]: Input positive number:");
            while (!scanner.hasNextDouble()) {
                System.out.println("[INFO]: Input positive number:");
                scanner.next();
            }
            inputNumber = scanner.nextDouble();
        } while (inputNumber <= 0);
        return inputNumber;
    }

    public  <T> void show(List<T> t) {
        for (int i = 0; i < t.size(); i++) {
            System.out.println((i + 1) + ") " + t.get(i));
        }
    }

    public  <T> T getEntity(List<T> entities) {
        show(entities);
        int entityToAdd = validateIntToValue(entities.size());
        return entities.get(entityToAdd - 1);
    }
}