import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== 2048 GAME ==========");

        System.out.println("\nControls:");
        System.out.println("W - Up");
        System.out.println("A - Left");
        System.out.println("S - Down");
        System.out.println("D - Right");
        System.out.println("Q - Quit");

        boolean gameRunning = true;

        while (gameRunning) {

            game.displayBoard();

            System.out.print("\nEnter your move: ");

            String input = scanner.nextLine().toLowerCase();

            if (input.equals("w")) {

                if (!game.moveUp()) {
                    System.out.println("\nNo tiles can move UP.");
                }

            } else if (input.equals("a")) {

                if (!game.moveLeft()) {
                    System.out.println("\nNo tiles can move LEFT.");
                }

            } else if (input.equals("s")) {

                if (!game.moveDown()) {
                    System.out.println("\nNo tiles can move DOWN.");
                }

            } else if (input.equals("d")) {

                if (!game.moveRight()) {
                    System.out.println("\nNo tiles can move RIGHT.");
                }

            } else if (input.equals("q")) {
                gameRunning = false;
                System.out.println("\nGame ended.");

            } else {
                System.out.println("\nInvalid input! Use W, A, S, D or Q.");
            }

            if (gameRunning && game.isGameOver()) {

                game.displayBoard();

                System.out.println("\n========== GAME OVER ==========");
                System.out.println("Final Score: " + game.getScore());
                gameRunning = false;
            }
        }

        scanner.close();
    }
}