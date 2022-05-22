package src;

public class Game {

    public int startMenu() {
        //insert "press to start" button and welcome screen
        //when button is pressed, show the next screen with two options(single or multi)
        //if player chooses single, ask difficulty out of 3(1,2,3) with three buttons and return the number
        //if player chooses multi, return 4
    }

    public void displayGraphics() {

        //insert method here to display all graphics here(display map, blocked tiles, cat)

    }

    private int turnCount=0;

    public void PlayGame(int diff) {

        boolean endCondition=false;

        Cat kitty = new Cat(diff);
        kitty.initializeCatLocation();
        Map arena = new Map();
        displayGraphics();

        do {
            blockerInput().setIsitBlocked(true);
            endCondition = endCurrentTurn();
            if(!endCondition) {
                kitty.moveCat();
                endCondition = endCurrentTurn();
            }

        } while(endCondition);


        //add userinput here when game ends(endinginput)
        //retry or return to main menu


    }
    public boolean endCurrentTurn(){
        //check end conditions based on turn count
        displayGraphics();
        turnCount++;
        //return end condition
    }

    public Tile blockerInput(){
        //method that takes the input of the blocker by clicking a button
        // until the press is valid(chekck if blocked or has cat on it)
        // and returns the cell pressed
    }

}
