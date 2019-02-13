// Name: Sean Newell
//
// Date: 9/14/18
//
// Class: CSC 1120
//
// Pledge: I have neither given nor received unauthorized aid on this program.
//
// Description: This is a game in which two opponents try to get four of their disks
//              in a row.
//
// Input: The user types commands such as their name, and the row and column they wish
//        to place their disk in.
//
// Output: The program will display updated maps and the winner after several rounds of play.
//

public class RunFourInARow {

    public static void main(String[] args){

        //Create a game
        Game game = new Game();

        //Create two players
        Player red = new Player();
        Player blue = new Player();

        //Print instructions to screen
        game.printInstructions();

        System.out.print("Enter Player 1's name: ");
        red.setPlayer();
        System.out.println("Thanks " + red.getName() + ", you will have the red disks.");
        System.out.println();
        System.out.print("Enter Player 2's name: ");
        blue.setPlayer();
        System.out.println("Thanks " + blue.getName() + ", you will have the blue disks.");
        System.out.println();
        game.printMap();

        //This loop goes for the length of the game
        while (!game.checkWin()) {
            System.out.println();
            System.out.println(red.getName() + ", it is your turn.");
            game.playerOneTurn();
            game.printMap();
            //Check for win
            if (game.checkWin()){
                System.out.println("Game Over. " + red.getName() + "wins!");
                return;
            }
            //Check for tie
            if (game.checkTie()){
                System.out.println("It's a tie!");
                return;
            }
            System.out.println();
            System.out.println(blue.name + ", it is your turn.");
            game.playerTwoTurn();
            game.printMap();
            //Check for win
            if (game.checkWin()){
                System.out.println("Game Over. " + blue.getName() + "wins!");
                return;
            }
            //Check for tie
            if (game.checkTie()){
                System.out.println("It's a tie!");
                return;
            }
        }
    }
}
