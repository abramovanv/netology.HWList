import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> job = new ArrayList<>();


    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printText();
            String input = scanner.nextLine();
            try {
                choice = Integer.valueOf(input);
            } catch (NumberFormatException e) {
                System.out.println("Введен некорректный номер операции");
            }
            if (choice > 5) {
                System.out.println("Введен некорректный номер операции");
                continue;
            }

            if (choice == 0) {
                break;
            }

            switch (choice) {

                case 1: {
                    add();
                    break;
                }
                case 2: {
                    printList();
                    break;
                }
                case 3: {
                    deleteByIndex();
                    break;
                }
                case 4: {
                    deleteByName();
                    break;
                }
                case 5: {
                    deleteByWord();
                    break;
                }
            }
        }
    }

    private static void deleteByWord() {
        System.out.print("Введите ключевое слово для удаления: ");
        Scanner scanner = new Scanner(System.in);
        String inputname = scanner.nextLine();
        List<String> help = new ArrayList<>();

        for (String task : job) {
            if (task.indexOf(inputname) == -1) {
                help.add(task);
            }
        }
        job.clear();
        job.addAll(help);
        printList();
    }

    public static void deleteByIndex() {
        System.out.print("Введите номер для удаления: ");
        Scanner scanner = new Scanner(System.in);
        String inputnum = scanner.nextLine();
        int choice = -1;

        try {
            choice = Integer.valueOf(inputnum);
        } catch (NumberFormatException e) {
            System.out.println("Введен некорректный номер дела");
        }

        if (choice <= job.size()) {
            job.remove(choice - 1);
            System.out.println("Удалено!");
            printList();
        } else {
            System.out.println("Такого дела не существует!");
            printList();
        }

    }

    public static void deleteByName() {
        System.out.print("Введите название задачи для удаления: ");
        Scanner scanner = new Scanner(System.in);
        String inputname = scanner.nextLine();
        int position = job.indexOf(inputname);
        if (position >= 0) {
            job.remove(position);
            System.out.println("Удалено!");
            printList();
        } else {
            System.out.println("Такого дела не существует!");
            printList();
        }
    }

    public static void add() {
        System.out.print("Введите название задачи: ");
        Scanner scanner = new Scanner(System.in);
        String inputjob = scanner.nextLine();
        if (!job.contains(inputjob)) {
            job.add(inputjob);
            System.out.println("Добавлено!");
        } else {
            System.out.println("Уже есть в списке дел!");
        }
        printList();

    }

    public static void printList() {
        int shiftnum = 1;
        System.out.println("Ваш список дел:");
        for (int i = 0; i < job.size(); i++) {
            System.out.println((shiftnum) + ". " + job.get(i));
            shiftnum++;
        }
        System.out.println();
    }

    public static void printText() {
        System.out.println("Выберите операцию:" + "\n" +
                "0. Выход из программы" + "\n" +
                "1. Добавить дело" + "\n" +
                "2. Показать дела" + "\n" +
                "3. Удалить дело по номеру" + "\n" +
                "4. Удалить дело по названию" + "\n" +
                "5. Удалить по ключевому слову");
        System.out.print("Ваш выбор: ");
    }
}