import java.util.Scanner;

public class ConsoleMenu {

    private static Scanner scanner = new Scanner(System.in);

    public static void getUserInputInMenu() {
        GameManager.clearConsole();
        System.out.println("====== ИГРОВОЕ МЕНЮ ======");
        System.out.println("1. Новая игра");
        System.out.println("0. Выход");
        System.out.print("Выберите опцию: ");

        int choice;
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                LevelGenerator.generateLevel();
                PlayerController.movePlayer();
                break;
            case 0:
                System.out.println("Выход из программы...");
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                getUserInputInMenu();
                break;
        }
        System.out.println();
    }
}