public class Game {

    //Create two players
    private Player red = new Player();
    private Player blue = new Player();


    //Initialize array for the board
    protected String[][] map = {
            {"-","-","-","-"},
            {"-","-","-","-"},
            {"-","-","-","-"},
            {"-","-","-","-"}};

    //This method prints an intro explaining how to play the game
    public void printInstructions(){
        System.out.println("Welcome to Four In A Row!");
        System.out.println("In this game, you will try to get four " +
                "of your disks in a row before your opponent. Who ever gets four in a row first, wins.");
        System.out.println("To choose a move, simply enter " +
                "the row (0-3), and then the column (0-3).");
        System.out.println();
    }

    //This method prints a map to the screen
    public void printMap(){
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //This function goes through what is necessary to complete Player 1's turn
    public void playerOneTurn(){

        red.setMove();

        //Check to see if coordinate is already taken
        if (map[red.row][red.col].contains("R") || map[red.row][red.col].contains("B")){
            System.out.println("Invalid move! Try again!");
            playerOneTurn();
        }

        //Check to see if there is a disk below the coordinate
        if (red.row != 3) {
            if (map[red.row + 1][red.col].contains("-") || map[red.row + 1][red.col] == null) {
                System.out.println("Invalid move! Try again!");
                playerOneTurn();
            }
        }

        map[red.row][red.col] = "R";
    }

    //This function goes through what is necessary to complete Player 2's turn
    public void playerTwoTurn(){

        blue.setMove();

        //Check to see if coordinate is already taken
        if (map[blue.row][blue.col].contains("R") || map[blue.row][blue.col].contains("B")){
            System.out.println("Invalid move! Try again!");
            playerTwoTurn();
        }

        //Check to see if there is a disk below the coordinate
        if (blue.row != 3) {
            if (map[blue.row + 1][blue.col].contains("-") || map[blue.row +1][blue.col] == null) {
                System.out.println("Invalid move! Try again!");
                playerTwoTurn();
            }
        }
        map[blue.row][blue.col] = "B";
    }


    //This function check if the are 4 consecutive disks in a row
    public boolean checkHoriz(){
        for (int i = 0; i < 4; i++){
            //Check each row for 4 "R" in a row
            int count = 0;

            for (int j = 0; j < 4; j ++) {
                if (map[i][j].contains("R")) {
                    count++;
                }
                if (count == 4){
                    return true;
                }
            }
        }
        for (int i = 0; i < 4; i++){
            //Check each row for 4 "B" in a row
            int count = 0;

            for (int j = 0; j < 4; j ++) {
                if (map[i][j].contains("B")) {
                    count++;
                }
                if (count == 4){
                    return true;
                }
            }
        }
        return false;
    }

    //This function check if the are 4 consecutive disks in a column
    public boolean checkVertical(){
        for (int i = 0; i < 4; i++){
            //Check each col for 4 "R" in a row
            int count = 0;

            for (int j = 0; j < 4; j ++) {
                if (map[j][i].contains("R")) {
                    count++;
                }
                if (count == 4){
                    return true;
                }
            }
        }
        for (int i = 0; i < 4; i++){
            //Check each col for 4 "B" in a row
            int count = 0;

            for (int j = 0; j < 4; j ++) {
                if (map[j][i].contains("B")) {
                    count++;
                }
                if (count == 4){
                    return true;
                }
            }
        }

        return false;
    }

    //This function check if the are 4 consecutive disks in a diagonal
    public boolean checkDiagonal(){

        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][i].contains("R")) {
                count++;
            }
            if (count == 4){
                return true;
            }
        }
        count = 0;
        for (int i = 0; i < 4; i++) {
            if (map[i][i].contains("B")) {
                count++;
            }
            if (count == 4){
                return true;
            }
        }

        count = 0;
        if (map[0][3].contains("R")){
            count++;
        }
        if (map[1][2].contains("R")){
            count++;
        }
        if (map[2][1].contains("R")){
            count++;
        }
        if (map[3][0].contains("R")){
            count++;
        }
        if (count == 4){
            return true;
        }

        count = 0;
        if (map[0][3].contains("B")){
            count++;
        }
        if (map[1][2].contains("B")){
            count++;
        }
        if (map[2][1].contains("B")){
            count++;
        }
        if (map[3][0].contains("B")){
            count++;
        }
        if (count == 4){
            return true;
        }

        return false;
    }

    //This function checks if there have been four consecutive disks
    public boolean checkWin(){
        checkHoriz();
        checkVertical();
        checkDiagonal();

        if (checkHoriz()){
            return true;
        }
        if(checkVertical()){
            return true;
        }
        if(checkDiagonal()){
            return true;
        }

        return false;
    }

    //This function checks for a tie
    public boolean checkTie(){

        int count = 0;
        for (int i = 0; i < 4; i ++){

            for (int j = 0; j < 4; j++){
                if (!map[i][j].contains("-")){
                    count++;
                }
            }
        }
        if (count == 16){
            return true;
        }

        return false;
    }

}
