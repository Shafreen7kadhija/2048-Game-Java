public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        System.out.println("========== 2048 GAME ==========");

        System.out.println("\nInitial Board:");
        game.displayBoard();

        System.out.println("\nMove LEFT:");
        boolean movedLeft = game.moveLeft();
        System.out.println("Move successful: " + movedLeft);
        game.displayBoard();

        System.out.println("\nMove RIGHT:");
        boolean movedRight = game.moveRight();
        System.out.println("Move successful: " + movedRight);
        game.displayBoard();

        System.out.println("\nMove UP:");
        boolean movedUp = game.moveUp();
        System.out.println("Move successful: " + movedUp);
        game.displayBoard();

        System.out.println("\nMove DOWN:");
        boolean movedDown = game.moveDown();
        System.out.println("Move successful: " + movedDown);
        game.displayBoard();
    }
}