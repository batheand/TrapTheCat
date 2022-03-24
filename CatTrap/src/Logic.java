public class Logic {
    //thinking of a 8*8 map
    // *** ** ***
    private int catLocationX;
    private int catLocationY;
    private boolean[] [] isBLocked = new boolean[8][8];

    public void initializeBlocked() {
        for(int i=0; i<=8; i++) {
            for(int n = 0; n<=8; n++) {
                isBLocked[i] [n]=false;
            }
        }
    }
    public void InitializeCatLocation() {
        int x = (int) (Math.random()*2) , y = (int) (Math.random()*2);
        x = x+3;
        y = y+3;
        setCatLocationX(x);
        setCatLocationY(y);
    }
    public boolean isItBlocked(int y, int x) {
        boolean [] [] isBlockedTemp = getIsBLocked();
        boolean isItBlocked = isBlockedTemp[x][y];
        return isItBlocked;
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
    public void blockTheTile(int y, int x) {
        boolean [] [] tempIsBlocked = getIsBLocked();
        tempIsBlocked [x] [y] = true;
        setIsBLocked(tempIsBlocked);
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
    public boolean[][] getIsBLocked() {
        return isBLocked;
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

    public void setIsBLocked(boolean[][] isBLocked) {
        this.isBLocked = isBLocked;
    }

}
