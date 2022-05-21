public class Tile {

    private boolean isitBlocked;
    private int x, y;

    public Tile(){


    }
    public Tile(int coordianteX, int coordinateY){
        isitBlocked = false;
        x=coordianteX;
        y=coordinateY;
    }

    public void setIsitBlocked(boolean isitBlocked) {
        this.isitBlocked = isitBlocked;
    }

    public boolean getIsitBlocked(){
        return isitBlocked;
    }
public int getX(){
        return x;
}
public int getY(){
        return y;
}
}
