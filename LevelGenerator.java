import java.util.Random;

public class LevelGenerator {
    private static Random random = new Random();
    private static char wallSymbol = '█';

    public static void generateLevel() {
        GameManager.setGameField(new char[GameManager.getVerticalSize()][GameManager.getHorizontalSize()]);
        generateRightPath();
        GameManager.getGameField()[GameManager.getVerticalSize() - 1][GameManager.getHorizontalSize() - 1] = 'p';
        generateWalls();
        for (int i = 0; i < GameManager.getVerticalSize(); i++) {
            for (int j = 0; j < GameManager.getHorizontalSize(); j++) {
                if (GameManager.getGameField()[i][j] == 'p') {
                    GameManager.getGameField()[i][j] = ' ';
                }
            }
        }
    }

    private static void generateRightPath() {
        int[] currentPosition = new int[]{0, 0};
        int chooserOfDirection;
        int chooserOfVector;
        String vector = "vertical";
        String direction;

        while (!Services.compareIntArrays(currentPosition, new int[]{GameManager.getVerticalSize() - 1, GameManager.getHorizontalSize() - 1})) {
            chooserOfDirection = random.nextInt(3);
            chooserOfVector = random.nextInt(3);
            switch (chooserOfDirection) {
                case 0:
                    direction = "up or right";
                    break;
                default:
                    direction = "down or left";
                    break;
            }
            if (vector == "horizontal") {
                switch (chooserOfVector) {
                    case 0:
                        vector = "horizontal";
                        break;
                    default:
                        vector = "vertical";
                        break;
                }
            } else {
                switch (chooserOfVector) {
                    case 0:
                        vector = "vertical";
                        break;
                    default:
                        vector = "horizontal";
                        break;
                }
            }

            if (vector == "vertical") {
                if (direction == "down or left") {
                    if (currentPosition[0] < GameManager.getVerticalSize() - 1) {
                        currentPosition[0]++;
                    }
                } else {
                    if (currentPosition[0] > 0) {
                        currentPosition[0]--;
                    }
                }
            } else {
                if (direction == "down or left") {
                    if (currentPosition[1] < GameManager.getHorizontalSize() - 1) {
                        currentPosition[1]++;
                    }
                } else {
                    if (currentPosition[1] > 0) {
                        currentPosition[1]--;
                    }
                }
            }
            GameManager.getGameField()[currentPosition[0]][currentPosition[1]] = 'p';
        }
    }

    public static void generateWalls() {
        for (int i = 0; i < GameManager.getVerticalSize(); i++) {
            for (int j = 0; j < GameManager.getHorizontalSize(); j++) {
                if (GameManager.getGameField()[i][j] != 'p') {
                    int chanceOfWallGenerating = random.nextInt(2);
                    if (chanceOfWallGenerating == 0) {
                        GameManager.getGameField()[i][j] = wallSymbol;
                    }
                    else {
                        GameManager.getGameField()[i][j] = ' ';
                    }
                }
            }
        }
    }
}
