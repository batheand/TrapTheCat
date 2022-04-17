public class Cat extends Map{
    private int catLocationX;
    private int catLocationY;
    public void initializeCatLocation() {
        int x = (int) (Math.random()*2) , y = (int) (Math.random()*2);
        x = x+3;
        y = y+3;
        setCatLocationX(x);
        setCatLocationY(y);

    }
    public boolean isItNear(int y, int x) {
        int currX = getCatLocationX(), currY = getCatLocationY();
        boolean isNear;
        if (((y<=(currY-2))||(y>=(currY+2)))||((x<=(currX-2))||(x>=(currX+2)))) {
            isNear=false;
        }else{
            isNear=true;
        }
        return isNear;
    }
    public void MoveTheCat(int y, int x) {
        boolean inBounds = (x>=0&&x<=8)&&(y>=0&&y<=8);
        boolean isAvailable = isItBlocked(y,x);
        boolean isNear = isItNear(y,x);
        isAvailable = !isAvailable;
        if(inBounds&&isAvailable&&isNear){
            setCatLocation(y,x);
        } else {
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
