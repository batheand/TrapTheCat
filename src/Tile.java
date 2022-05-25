package src;

public class Tile{

    private int routes;
    private int distanceToWin;

    private int score;
    private boolean isitBlocked;
    private final int x, y;

//the constructor defaults block state of a tile to false, since every tile is initially supposed to be unblocked
    public Tile(int coordianteX, int coordinateY){
        isitBlocked = false;
        x=coordianteX;
        y=coordinateY;

    }



//static method used to convert cartesian coordinates into the index number of the main tile array,(constructed in src.Map)
    public static int getTileWithCoordinates(int x, int y){
        return x-1+ (y-1)*11;
}

//generic setter will help the ai work more optimized by pre-adjusting dtw and route values for blocked tiles(%11-%25 depending on the amount of tiles blocked)
    public void setIsitBlocked(boolean isitBlocked) {

        this.isitBlocked = isitBlocked;
        if(isitBlocked){
            distanceToWin=-10;
            routes=-10;
        }
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


