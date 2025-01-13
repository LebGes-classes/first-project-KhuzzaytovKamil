import java.util.Scanner;

public class PlayerController {
    private static int[] positionOfPlayer = new int[]{0, 0};
    private static Scanner scanner = new Scanner(System.in);

    public static int[] getPositionOfPlayer() {
        return positionOfPlayer;
    }

    public static void setPositionOfPlayer(int[] positionOfPlayer) {
        PlayerController.positionOfPlayer = positionOfPlayer;
    }

    public static void movePlayer() {

        while (true) {
            GameManager.clearConsole();

            char[][] gameField = GameManager.getGameField();
            GameManager.printGameField(gameField);

            System.out.println("Инструкция: Вводите 'W' для увеличения по оси Y, 'S' для уменьшения по оси Y, 'D' для увеличения по оси X и 'A' для уменьшения по оси X.");
            System.out.println("Текущая позиция игрока: [" + positionOfPlayer[0] + ", " + positionOfPlayer[1] + "]");
            System.out.print("Введите команду: ");

            String input = scanner.nextLine();

            switch (input.toUpperCase()) {
                case "A":
                    if (isItCorrectPosition(new int[]{positionOfPlayer[0], positionOfPlayer[1] - 1})) {
                        positionOfPlayer[1]--;
                        break;
                    } else {
                        continue;
                    }
                case "D":
                    if (isItCorrectPosition(new int[]{positionOfPlayer[0], positionOfPlayer[1] + 1})) {
                        positionOfPlayer[1]++;
                        break;
                    } else {
                        continue;
                    }
                case "S":
                    if (isItCorrectPosition(new int[]{positionOfPlayer[0] + 1, positionOfPlayer[1]})) {
                        positionOfPlayer[0]++;
                        break;
                    } else {
                        continue;
                    }
                case "W":
                    if (isItCorrectPosition(new int[]{positionOfPlayer[0] - 1, positionOfPlayer[1]})) {
                        positionOfPlayer[0]--;
                        break;
                    } else {
                        continue;
                    }
                default:
                    System.out.println("Неизвестная команда. Пожалуйста, вводите только 'W', 'A', 'S', 'D'. Нажмите enter, чтобы продолжить.");
                    scanner.nextLine();
                    continue;
            }

            if (positionOfPlayer[0] == GameManager.getVerticalSize() - 1 && positionOfPlayer[1] == GameManager.getHorizontalSize() - 1) {
                System.out.println("Поздравляем! Вы достигли позиции выхода. Игра завершена. Нажмите enter, чтобы продолжить.");
                positionOfPlayer[0] = 0;
                positionOfPlayer[1] = 0;
                scanner.nextLine();
                ConsoleMenu.getUserInputInMenu();
                break;
            }
        }
    }

    private static boolean isItCorrectPosition(int[] positionOfPlayer) {
        if (positionOfPlayer[0] >= 0 && positionOfPlayer[0] < GameManager.getVerticalSize() && positionOfPlayer[1] >= 0
        && positionOfPlayer[1] < GameManager.getHorizontalSize() && GameManager.getGameField()[positionOfPlayer[0]][positionOfPlayer[1]] == ' ') {
            return true;
        }
        System.out.println("Попробуйте двигаться в другом направлении. Нажмите enter, чтобы продолжить.");
        scanner.nextLine();
        return false;
    }
}