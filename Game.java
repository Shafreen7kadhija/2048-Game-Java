import java.util.Random;

public class Game {

    private int[][] board;
    private Random random;

    public Game() {
        board = new int[4][4];
        random = new Random();

        addRandomTile();
        addRandomTile();
    }

    private void addRandomTile() {

        int row;
        int column;

        do {
            row = random.nextInt(4);
            column = random.nextInt(4);
        } while (board[row][column] != 0);

        board[row][column] = 2;
    }

    public void moveLeft() {

        for (int row = 0; row < 4; row++) {

            int[] newRow = new int[4];
            int index = 0;

            for (int column = 0; column < 4; column++) {

                if (board[row][column] != 0) {
                    newRow[index] = board[row][column];
                    index++;
                }
            }

            for (int column = 0; column < 4; column++) {
                board[row][column] = newRow[column];
            }
        }
    }

    public void moveRight() {

        for (int row = 0; row < 4; row++) {

            int[] newRow = new int[4];
            int index = 3;

            for (int column = 3; column >= 0; column--) {

                if (board[row][column] != 0) {
                    newRow[index] = board[row][column];
                    index--;
                }
            }

            for (int column = 0; column < 4; column++) {
                board[row][column] = newRow[column];
            }
        }
    }

    public void moveUp() {

        for (int column = 0; column < 4; column++) {

            int[] newColumn = new int[4];
            int index = 0;

            for (int row = 0; row < 4; row++) {

                if (board[row][column] != 0) {
                    newColumn[index] = board[row][column];
                    index++;
                }
            }

            for (int row = 0; row < 4; row++) {
                board[row][column] = newColumn[row];
            }
        }
    }

    public void moveDown() {

        for (int column = 0; column < 4; column++) {

            int[] newColumn = new int[4];
            int index = 3;

            for (int row = 3; row >= 0; row--) {

                if (board[row][column] != 0) {
                    newColumn[index] = board[row][column];
                    index--;
                }
            }

            for (int row = 0; row < 4; row++) {
                board[row][column] = newColumn[row];
            }
        }
    }

    public void displayBoard() {

        System.out.println("\n+----+----+----+----+");

        for (int i = 0; i < 4; i++) {

            System.out.print("|");

            for (int j = 0; j < 4; j++) {

                if (board[i][j] == 0) {
                    System.out.print("    |");
                } else {
                    System.out.printf("%4d|", board[i][j]);
                }
            }

            System.out.println();
            System.out.println("+----+----+----+----+");
        }
    }
}