public class GameManager {
    private static char[][] gameField;
    private static int verticalSize = 20;
    private static int horizontalSize = 42;


    public static char[][] getGameField() {
        return gameField;
    }

    public static void setGameField(char[][] gameField) {
        GameManager.gameField = gameField;
    }

    public static int getVerticalSize() {
        return verticalSize;
    }

    public static int getHorizontalSize() {
        return horizontalSize;
    }

    public static void main(String[] args) {
        ConsoleMenu.getUserInputInMenu();
    }

    public static void printGameField(char[][] gameField) {
        String gameFieldOutput = "";
        for (int i = 0; i < getVerticalSize(); i++) {
            for (int j = 0; j < getHorizontalSize(); j++) {
                if (i == PlayerController.getPositionOfPlayer()[0] && j == PlayerController.getPositionOfPlayer()[1]) {
                    gameFieldOutput += "*";
                }
                else {
                    gameFieldOutput += gameField[i][j];
                }
            }
            gameFieldOutput += "\n";
        }
        System.out.println(gameFieldOutput);
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}
