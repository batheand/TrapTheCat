package src;

import javax.swing.*;
import java.util.Scanner;

public class Game extends Map{

    public int startMenu() {
      System.out.println("Please choose your game mode!");
      System.out.println("1-Vs Easy AI      2-Vs Average AI     3-Vs Strong AI      4-Multiplayer");
      Scanner k = new Scanner(System.in);
      return k.nextInt();
    }

    public void displayGraphics(Cat kitty, JFrame screen) {
        Panel p = new Panel();
        p.receiveGameState(tiles,kitty);
        screen.add(p);
        screen.pack();
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);




    }

    private int turnCount=0;

    boolean hasCatWon;
    public void PlayGame(int diff, JFrame screen) {

        boolean endCondition;

        Cat kitty = new Cat(diff);
        kitty.initializeCatLocation();
        Map arena = new Map();
        displayGraphics(kitty,screen);

        do {
            tiles[blockerInput(kitty)].setIsitBlocked(true);
            endCondition = endCurrentTurn(kitty, screen);
            if(!endCondition) {
                kitty.moveCat();
                endCondition = endCurrentTurn(kitty, screen);
            }

        } while(!endCondition);

        hasCatWon=kitty.isItOnEdge();

    }

    public boolean gameOver(){
        System.out.print("Game over: ");
        if(hasCatWon){
            System.out.println("The Cat Shall Escape Into A New Reality, Unchained and Free.");
        }
        else{
            System.out.println("Have it writ on thy meagre grave, A Cat Forever Bound to chain");

        }
        System.out.println("After all that, do you still wish to keep going?");
        System.out.println("If so, do enter 1.");
        System.out.println("HOWEVER");
        System.out.println("Should you wish to stop this madness at once, pressing any other number just might help...");
        Scanner k = new Scanner(System.in);
        return k.nextInt() == 1;
    }


    public boolean endCurrentTurn(Cat kitty, JFrame screen){

        displayGraphics(kitty, screen);
        turnCount++;
        if(turnCount%2==1){
            return !kitty.validMovesLeft();
        }
        else{
            return kitty.isItOnEdge();
        }
    }

    public int blockerInput(Cat kitty){
        int x,y;
        boolean arewethereyet;
        do {
            arewethereyet = false;
            Scanner k = new Scanner(System.in);
            System.out.println("Please enter the x value for the tile you wish to block.");
            x = k.nextInt();
            System.out.println("Please enter the y value for the tile you wish to block.");
            y = k.nextInt();
            if(tiles[Tile.getTileWithCoordinates(x,y)].getIsitBlocked()||kitty.getCatTile()==Tile.getTileWithCoordinates(x,y)){
                System.out.println("The tile you have selected is either already blocked or has a cat on it, please try again.");
            arewethereyet =true;
            }
        }while(arewethereyet);

        return Tile.getTileWithCoordinates(x,y);
    }


}
