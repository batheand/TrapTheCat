package src;

public class Cat extends Map {
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
    public void MoveTheCat(Tile cell) {
        boolean inBounds = (cell.getX()>=0&&cell.getX()<=8)&&(cell.getY()>=0&&cell.getY()<=8);
        boolean isAvailable = cell.getIsitBlocked();
        boolean isNear = isItNear(cell);
        isAvailable = !isAvailable;
        if(inBounds&&isAvailable&&isNear){
            setCatLocation(cell.getY(), cell.getX());
        }
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
