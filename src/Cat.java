package src;

import java.util.Arrays;
import java.util.Scanner;


public class Cat extends Map{



    private final int difficulty;
    private int catTile;

    public Cat(int diff){
        difficulty=diff;
    }

    public void initializeCatLocation(){
        catTile=60;
    }




    public boolean isItNear(Tile cell){  // used to check if the tile given in parameter is adjacent to the cat

boolean result = false;

        if(cell.getX()==tiles[catTile].getX() && cell.getY()==tiles[catTile].getY()-1)
            result = true;
        if(cell.getX()==tiles[catTile].getX() && cell.getY()==tiles[catTile].getY()+1)
            result=true;
        if(cell.getX()==tiles[catTile].getX()-1 && cell.getY()==tiles[catTile].getY())
            result=true;
        if(cell.getX()==tiles[catTile].getX()+1 && cell.getY()==tiles[catTile].getY())
            result=true;

        if(tiles[catTile].getY()%2==0) {
            if (cell.getX() == tiles[catTile].getX() - 1 && cell.getY() == tiles[catTile].getY() + 1)
                result=true;
            if (cell.getX() == tiles[catTile].getX() - 1 && cell.getY() == tiles[catTile].getY() - 1)
                result=true;
        }
        if(tiles[catTile].getY()%2==1) {
            if (cell.getX() == tiles[catTile].getX() + 1 && cell.getY() == tiles[catTile].getY() + 1)
                result=true;
            if (cell.getX() == tiles[catTile].getX() + 1 && cell.getY() == tiles[catTile].getY() - 1)
                result=true;
        }
                  return result;

    }

    public boolean isItOnEdge(){  //used to check if the cat is on the edge of the map, in which case it will win
        return tiles[catTile].getX() == 1 || tiles[catTile].getX() == 11 || tiles[catTile].getY() == 1 || tiles[catTile].getY() == 11;
    }
    public boolean validMovesLeft(){ //used to check if the cat has any possible moves left to play, if not, the blocker will win
        boolean valid=false;

        for(int i=0; i<121;i++){
                        if(isItNear(tiles[i]) && !tiles[i].getIsitBlocked()){
                valid = true;
            }
        }
        return valid;
    }



    public void moveCat() { //general method to move the cat, will take into consideration both gameplay mode and AI difficulty

        if (difficulty == 4) {
            moveByCatInput();
        } else {
            moveCatWithCPU();
        }
    }

    public void moveByCatInput(){
        int x,y;
        boolean arewethereyet;
        do {
            arewethereyet = false;
            Scanner k = new Scanner(System.in);
            System.out.println("Please enter the x value for the tile you wish to move to.");
            x = k.nextInt();
            System.out.println("Please enter the y value for the tile you wish to move to.");
            y = k.nextInt();
            if(tiles[Tile.getTileWithCoordinates(x,y)].getIsitBlocked()||!isItNear(tiles[Tile.getTileWithCoordinates(x,y)])){
                System.out.println("The tile you have selected is either blocked or too far away, please try again.");
                arewethereyet =true;
            }
        }while(arewethereyet);
        catTile=Tile.getTileWithCoordinates(x,y);
    }

    // due to a local array duplication bug i am yet to understand, the AI is partially broken as it can sometimes move to blocked tiles as well
    // same error causes difficulty adjustment to work less than it is supposed to

    //use an algorithm to assign each tile a dtw value(how many moves left until a state of victory is reached),
    // a route value(how many routes can be taken for victory in said the least amount of moves)
    //a score value(routes /distance to win)
    //the algorithm is something i came up with during my research on MiniMax and Breadth first search algorithms for this project
    //if needed i can provide a fully detailed explanation on how the AI functions( yuksel.baypinar@tedu.edu.tr)
    public void moveCatWithCPU(){
        dtwAssignment();

        routeAssignment();

        scoreAssignment();

        int[] nextscores = new int[adjacent((tiles[catTile])).length];

        for(int i=0; i<adjacent(tiles[catTile]).length; i++ ){
        nextscores[i]=adjacent(tiles[catTile])[i].getScore();
        }
        Arrays.sort(nextscores);
        int lowestindex=0, highestindex=0;

        for(int i=0; i<adjacent(tiles[catTile]).length; i++){

            if (adjacent(tiles[catTile])[i].getScore()==nextscores[0]){

                lowestindex= Tile.getTileWithCoordinates(adjacent(tiles[catTile])[i].getX(),adjacent(tiles[catTile])[i].getY());

            }
            if  (adjacent(tiles[catTile])[i].getScore()==nextscores[nextscores.length-1]){
                highestindex= Tile.getTileWithCoordinates(adjacent(tiles[catTile])[i].getX(),adjacent(tiles[catTile])[i].getY());
            }
        }
        if(difficulty==3){
            setCatTile(highestindex);
        }
        if(difficulty==2){
            if(Math.random()*100<25){
                setCatTile(lowestindex);
            }
            else{
                setCatTile(highestindex);
            }
        }
        if(difficulty==1){
                setCatTile(lowestindex);
            }


    }

    public void dtwAssignment() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11 - 2 * i; j++) {
                if(!tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].setDistanceToWin(i);

                if(!tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].setDistanceToWin(i);

                if(!tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].setDistanceToWin(i);

                if(!tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].setDistanceToWin(i);
                if (i == 0) {
                    if(!tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].setRoutes(i);

                    if(!tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].setRoutes(i);

                    if(!tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].setRoutes(i);

                    if(!tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].setRoutes(i);
                }
            }
            if (i > 0) {
                for (int b = 0; b < 121; b++) {
                    if (tiles[b].getDistanceToWin()==i){
                        boolean dtwneg=true;
                            for(int c=0; c<adjacent(tiles[b]).length; c++ ){
                            if(adjacent(tiles[b])[c].getDistanceToWin()==i-1){
                                dtwneg=false;
                            }
                        }
                        if(dtwneg){
                            tiles[b].setDistanceToWin((tiles[b].getDistanceToWin())+1);
                        }
                    }
                }
            }
        }

    }

        public void routeAssignment(){
            for (int i = 1; i < 6; i++) {
                for (int j = 0; j < 11 - 2 * i; j++) {
                    if (!tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].getIsitBlocked()){
                        int lala=0;
                      for(int b=0; b<adjacent(tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)]).length; b++){
                          if(adjacent(tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)])[b].getDistanceToWin()<i){
                              lala += adjacent(tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)])[b].getRoutes();}

                      }
                        tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].setRoutes(lala);
                    }


                    if (!tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].getIsitBlocked()){
                        int lala=0;
                        for(int b=0; b<adjacent(tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)]).length; b++){
                            if(adjacent(tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)])[b].getDistanceToWin()<i){
                                lala += adjacent(tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)])[b].getRoutes();}

                        }
                        tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].setRoutes(lala);
                    }
                    if (!tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].getIsitBlocked()){
                        int lala=0;
                        for(int b=0; b<adjacent(tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)]).length; b++){
                            if(adjacent(tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)])[b].getDistanceToWin()<i){
                                lala += adjacent(tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)])[b].getRoutes();}

                        }
                        tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].setRoutes(lala);
                    }
                    if (!tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].getIsitBlocked()){
                        int lala=0;
                        for(int b=0; b<adjacent(tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)]).length; b++){
                            if(adjacent(tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)])[b].getDistanceToWin()<i){
                                lala += adjacent(tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)])[b].getRoutes();}

                        }
                        tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].setRoutes(lala);
                    }
                }
            }}

        public void scoreAssignment(){
        for(int i=0; i<121; i++){
            if (!(tiles[i].getDistanceToWin()==0||!tiles[i].getIsitBlocked())){
                tiles[i].setScore(tiles[i].getRoutes()/tiles[i].getDistanceToWin());
        }}
        }


        public void setCatTile ( int i){
            catTile = i;
        }

        public int getCatTile () {
            return catTile;
        }
    }
