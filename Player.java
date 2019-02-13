import java.util.Scanner;

public class Player {

    private String redPlayer = "";
    private String bluePlayer = "";
    String name;

    protected int row = 0;
    protected int col = 0;

    //Create a scanner for user input
    public Scanner sc = new Scanner(System.in);


    //This method allows the user to enter their name
    public void setPlayer(){
        name = sc.next();
    }

    //Accessor method, so that the names may be accessed in the main class
    public String getName(){
        return name;
    }

    //This function gets the players valid move
    public void setMove() {

        System.out.println("Please select a tile coordinate to choose your move.");
        row = sc.nextInt();
        col = sc.nextInt();

        //Check if move is within array bounds
        if ((row > 3 || row < 0) || (col > 3 || col < 0)) {
            System.out.println("Invalid move! Try again!");
            setMove();
        }
    }

}
