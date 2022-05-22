package src;

public class Cat extends Map {

    private int difficulty;
    private int catTile;

    public Cat(){}
    public Cat(int diff){
        difficulty=diff;
            }

    public void initializeCatLocation(){
        catTile=60;
    }

    public boolean isItNear(Tile cell) {
                boolean isNear;
        isNear= ((cell.getY() > (tiles[catTile].getY() - 2)) && (cell.getY() < (tiles[catTile].getY() + 2))) && ((cell.getX() > (tiles[catTile].getX() - 2)) && (cell.getX() < (tiles[catTile].getX() + 2)));
        return isNear;
    }

    public boolean isItOnEdge(){
        if(tiles[catTile].getX()==1 || tiles[catTile].getX()==11 || tiles[catTile].getY()==1 || tiles[catTile].getY()==11){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean validMovesLeft(){
        boolean valid=false;

        for(int i=0; i<121;i++){
        if(isItNear(tiles[i])&&!tiles[i].getIsitBlocked()){
            valid = true;
        }
        }
        return valid;
    }
    public void moveCat() {

        if (difficulty == 4) {
            moveByCatInput();
        } else {
            moveCatWithCPU();
        }
    }


    public void moveByCatInput(){
        boolean notvalid= true;
        do {
            //get the user input for the cat move with a button
            //convert button to integer 0-120 assign it to i
            int i;
            if (!tiles[i].getIsitBlocked() && isItNear(tiles[i])) {
                catTile=i;
                notvalid = false;
            }
        }while(notvalid);
    }


    public void moveCatWithCPU(){

        //ai here

    }

    public void dtwAssignment() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11 - 2 * i; j++) {
                if(tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].setDistanceToWin(i);

                if(tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].setDistanceToWin(i);

                if(tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].setDistanceToWin(i);

                if(tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].getIsitBlocked())
                    tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].setDistanceToWin(i);
                if (i == 0) {
                    if(tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(1 + i, 1 + i + j)].setRoutes(i);

                    if(tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(11 - i, 1 + i + j)].setRoutes(i);

                    if(tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].getIsitBlocked())
                        tiles[Tile.getTileWithCoordinates(1 + i + j, 1 + i)].setRoutes(i);

                    if(tiles[Tile.getTileWithCoordinates(1 + i + j, 11 - i)].getIsitBlocked())
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

        public void adjacentDtwAdjustment () {

        }
        public void setCatTile ( int i){
            catTile = i;
        }

        public int getCatTile () {
            return catTile;
        }
    }
