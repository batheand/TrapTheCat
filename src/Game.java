package src;

public class Game extends Map{

    public int startMenu() {
        //insert "press to start" button and welcome screen
        //when button is pressed, show the next screen with two options(single or multi)
        //if player chooses single, ask difficulty out of 3(1,2,3) with three buttons and return the number
        //if player chooses multi, return 4
    }

    public void displayGraphics() {

        //insert method here to display(and refresh) all graphics(display map, blocked tiles, cat)

    }

    private int turnCount=0;

    public void PlayGame(int diff) {

        boolean endCondition=false;

        Cat kitty = new Cat(diff);
        kitty.initializeCatLocation();
        Map arena = new Map();
        displayGraphics();

        do {
            blockerInput(kitty).setIsitBlocked(true);
            endCondition = endCurrentTurn(kitty);
            if(!endCondition) {
                kitty.moveCat();
                endCondition = endCurrentTurn(kitty);
            }

        } while(!endCondition);
    }

    public boolean gameOver(){
        //add userinput here when game ends(goagain)
        //main menu or exit
    }


    public boolean endCurrentTurn(Cat kitty){
        displayGraphics();
        turnCount++;
        if(turnCount%2==1){
            return !kitty.validMovesLeft();
        }
        else{
            return kitty.isItOnEdge();
        }
    }

    public Tile blockerInput(Cat kitty){
        //method in a loop that takes the input of the blocker by clicking a button(buttons return an integer called t)
        // until the press is valid
        //press validation
        int t=0; //buttons result here
        if(tiles[t].getIsitBlocked()||t== kitty.getCatTile()){
            //invalid action, reset back the loop
        }
        else {//return tiles[t];
        }

    }

}
