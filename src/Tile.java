package src;

public class Tile {

    private boolean isitBlocked;
    private final int x, y;

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
