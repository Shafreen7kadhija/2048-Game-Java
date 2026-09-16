public static void main(String[] args) {

    Game game = new Game();

    System.out.println("========== 2048 GAME ==========");

    System.out.println("\nInitial Board:");
    game.displayBoard();

    System.out.println("\nAfter LEFT:");
    game.moveLeft();
    game.displayBoard();

    System.out.println("\nAfter RIGHT:");
    game.moveRight();
    game.displayBoard();

    System.out.println("\nAfter UP:");
    game.moveUp();
    game.displayBoard();

    System.out.println("\nAfter DOWN:");
    game.moveDown();
    game.displayBoard();
}