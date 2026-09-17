import java.util.Random;

public class Game {

    private int[][] board;
    private Random random;
    private int score;

    public Game() {

        board = new int[4][4];
        random = new Random();
        score = 0;

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

    public boolean moveLeft() {

        boolean moved = false;

        for (int row = 0; row < 4; row++) {

            int[] originalRow = board[row].clone();

            int[] newRow = new int[4];
            int index = 0;

            for (int column = 0; column < 4; column++) {

                if (board[row][column] != 0) {
                    newRow[index] = board[row][column];
                    index++;
                }
            }

            newRow = mergeRow(newRow);

            for (int column = 0; column < 4; column++) {
                board[row][column] = newRow[column];
            }

            for (int column = 0; column < 4; column++) {

                if (originalRow[column] != board[row][column]) {
                    moved = true;
                    break;
                }
            }
        }

        if (moved) {
            addRandomTile();
        }

        return moved;
    }

    public boolean moveRight() {

        boolean moved = false;

        for (int row = 0; row < 4; row++) {

            int[] originalRow = board[row].clone();

            int[] newRow = new int[4];
            int index = 3;

            for (int column = 3; column >= 0; column--) {

                if (board[row][column] != 0) {
                    newRow[index] = board[row][column];
                    index--;
                }
            }

            newRow = mergeRowRight(newRow);

            for (int column = 0; column < 4; column++) {
                board[row][column] = newRow[column];
            }

            for (int column = 0; column < 4; column++) {

                if (originalRow[column] != board[row][column]) {
                    moved = true;
                    break;
                }
            }
        }

        if (moved) {
            addRandomTile();
        }

        return moved;
    }

    public boolean moveUp() {

        boolean moved = false;

        for (int column = 0; column < 4; column++) {

            int[] originalColumn = new int[4];

            for (int row = 0; row < 4; row++) {
                originalColumn[row] = board[row][column];
            }

            int[] newColumn = new int[4];
            int index = 0;

            for (int row = 0; row < 4; row++) {

                if (board[row][column] != 0) {
                    newColumn[index] = board[row][column];
                    index++;
                }
            }

            newColumn = mergeRow(newColumn);

            for (int row = 0; row < 4; row++) {
                board[row][column] = newColumn[row];
            }

            for (int row = 0; row < 4; row++) {

                if (originalColumn[row] != board[row][column]) {
                    moved = true;
                    break;
                }
            }
        }

        if (moved) {
            addRandomTile();
        }

        return moved;
    }

    public boolean moveDown() {

        boolean moved = false;

        for (int column = 0; column < 4; column++) {

            int[] originalColumn = new int[4];

            for (int row = 0; row < 4; row++) {
                originalColumn[row] = board[row][column];
            }

            int[] newColumn = new int[4];
            int index = 3;

            for (int row = 3; row >= 0; row--) {

                if (board[row][column] != 0) {
                    newColumn[index] = board[row][column];
                    index--;
                }
            }

            newColumn = mergeColumnDown(newColumn);

            for (int row = 0; row < 4; row++) {
                board[row][column] = newColumn[row];
            }

            for (int row = 0; row < 4; row++) {

                if (originalColumn[row] != board[row][column]) {
                    moved = true;
                    break;
                }
            }
        }

        if (moved) {
            addRandomTile();
        }

        return moved;
    }

    private int[] mergeRow(int[] row) {

        int[] mergedRow = new int[4];
        int index = 0;

        for (int i = 0; i < 4; i++) {

            if (row[i] == 0) {
                continue;
            }

            if (i + 1 < 4 && row[i] == row[i + 1]) {

                mergedRow[index] = row[i] * 2;
                score += row[i] * 2;
                index++;

                i++;

            } else {

                mergedRow[index] = row[i];
                index++;
            }
        }

        return mergedRow;
    }

    private int[] mergeRowRight(int[] row) {

        int[] mergedRow = new int[4];
        int index = 3;

        for (int i = 3; i >= 0; i--) {

            if (row[i] == 0) {
                continue;
            }

            if (i - 1 >= 0 && row[i] == row[i - 1]) {

                mergedRow[index] = row[i] * 2;
                score += row[i] * 2;
                index--;

                i--;

            } else {

                mergedRow[index] = row[i];
                index--;
            }
        }

        return mergedRow;
    }

    private int[] mergeColumnDown(int[] column) {

        int[] mergedColumn = new int[4];
        int index = 3;

        for (int i = 3; i >= 0; i--) {

            if (column[i] == 0) {
                continue;
            }

            if (i - 1 >= 0 && column[i] == column[i - 1]) {

                mergedColumn[index] = column[i] * 2;
                score += column[i] * 2;
                index--;

                i--;

            } else {

                mergedColumn[index] = column[i];
                index--;
            }
        }

        return mergedColumn;
    }

    public void displayBoard() {

        System.out.println("\nScore: " + score);
        System.out.println("+----+----+----+----+");

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