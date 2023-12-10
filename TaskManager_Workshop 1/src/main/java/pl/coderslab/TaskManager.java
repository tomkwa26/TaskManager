package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static  final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static final String FILE_NAME = "tasks.csv";
    static String[][] tasks;
    public static void main(String[] args) {
        tasks = readTextFromFile(FILE_NAME);
        printOptions(OPTIONS);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                    exitFromTask(FILE_NAME, tasks);
                    System.out.println(ConsoleColors.RED + "See you later alligator");
                    System.exit(0);
                    break;
                case "add":
                    addUserTask();
                    break;
                case "remove":
                    removeUserTask(tasks,getUserNumber());
                    break;
                case "list":
                    printTab(tasks);
                    break;
                default:
                    System.out.println("Please select a correct option");
            }
            printOptions(OPTIONS);
        }
    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option: " + ConsoleColors.RESET);

        for (String option: tab
             ) {
            System.out.println(option);
        }
    }

    public static String[][] readTextFromFile(String fileName) {
        Path dir = Paths.get(fileName);
        if (!Files.exists(dir)) {
            System.out.println("File not exist");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(dir);
            tab = new String[strings.size()][strings.get(0).split(",").length];

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tab;
    }

    public static void printTab(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void addUserTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String description = scanner.nextLine();
        System.out.println("Please add task due data");
        String data = scanner.nextLine();
        System.out.println("Is your task is important: true/false");
        String isImportant = scanner.nextLine();

        tasks = Arrays.copyOf(tasks,tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = description;
        tasks[tasks.length - 1][1] = data;
        tasks[tasks.length - 1][2] = isImportant;
    }
    public static boolean isNumberCorrect(String input) {
        if (NumberUtils.isParsable(input)) {
            return Integer.parseInt(input) >= 0;
        }
        return false;
    }

    public static int getUserNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to delete");
        String number = scanner.nextLine();
        while (!isNumberCorrect(number)) {
            System.out.println("Incorrect argument passed. Please give number greater or equal 0");
            scanner.nextLine();
        }
        return Integer.parseInt(number);
    }
    public static void removeUserTask(String[][] tab, int index) {
        try {
                tasks = ArrayUtils.remove(tab, index);
                //System.out.println(Arrays.toString(tasks));
                System.out.println("Value was successfully deleted");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Element not exist in tab");
        }
    }

    public static void exitFromTask(String fileName, String[][] tab) {
        Path path = Paths.get(fileName);
        String[] exitArr = new String[tasks.length];
        for (int i = 0; i < tab.length; i++) {
            exitArr[i] = String.join(",", tab[i]);
        }
        try {
            Files.write(path, Arrays.asList(exitArr));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
