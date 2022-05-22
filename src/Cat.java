package src;

public class Cat extends Map {

    private int difficulty;

    public Cat(){}
    public Cat(int diff){
        difficulty=diff;
            }

    private int catLocationX;
    private int catLocationY;

    public void initializeCatLocation(){
        catLocationX = 6;
        catLocationY = 6;
    }

    public boolean isItNear(Tile cell) {
        int currX = getCatLocationX(), currY = getCatLocationY();
        boolean isNear;
        isNear= ((cell.getY() > (currY - 2)) && (cell.getY() < (currY + 2))) && ((cell.getX() > (currX - 2)) && (cell.getX() < (currX + 2)));
        return isNear;
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
                setCatLocation(tiles[i].getY(), tiles[i].getX());
                notvalid = false;
            }
        }while(notvalid);
    }


    public void moveCatWithCPU(){

        //ai here

    }
    public void setCatLocation(int y, int x) {
        setCatLocationY(y);
        setCatLocationX(x);
    }
    public int getCatLocationX() {
        return catLocationX;
    }

    public int getCatLocationY() {
        return catLocationY;
    }

    public void setCatLocationX(int catLocationX) {
        this.catLocationX = catLocationX;
    }

    public void setCatLocationY(int catLocationY) {
        this.catLocationY = catLocationY;
    }

}
