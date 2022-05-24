package src;

public class Tile{

    private int routes;
    private int distanceToWin;

    private int score;
    private boolean isitBlocked;
    private final int x, y;


    public Tile(int coordianteX, int coordinateY){
        isitBlocked = false;
        x=coordianteX;
        y=coordinateY;

    }




    public static int getTileWithCoordinates(int x, int y){
        return x-1+ (y-1)*11;
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

    public void setDistanceToWin(int distanceToWin) {
        this.distanceToWin = distanceToWin;
    }

    public void setRoutes(int routes) {
        this.routes = routes;
    }

    public int getDistanceToWin() {
        return distanceToWin;
    }

    public int getRoutes() {
        return routes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


