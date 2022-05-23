package src;


public class Map {
    public Tile[] tiles = new Tile[121];

    public Map() {   //constructs map and blocks 12 random tiles
        for(int i=0, y=1,x=1; i<11*11; i++,x++,y++) {
            if((x%12)==0){
                x+=1;
            }
            tiles[i] = new Tile(x%12,y / 11 + ((y % 11 == 0) ? 0 : 1));
        }

        for(int i=0; i<12; i++){
            double random = Math.random()*121;
            if(!((int)random==60)) {
                tiles[(int) random].setIsitBlocked(true);
                }
            else {
                i--;
            }
            }



    }
    public Tile[] adjacent(Tile cell){
        int i=0;
        if(!tiles[Tile.getTileWithCoordinates(cell.getX(), cell.getY()-1)].getIsitBlocked()){
            i++;
        }
        if(!tiles[Tile.getTileWithCoordinates(cell.getX(), cell.getY()+1)].getIsitBlocked()){
            i++;
        }
        if(!tiles[Tile.getTileWithCoordinates(cell.getX()-1, cell.getY())].getIsitBlocked()){
            i++;
        }
        if(!tiles[Tile.getTileWithCoordinates(cell.getX()+1, cell.getY())].getIsitBlocked()){
            i++;
        }
        if(cell.getY()%2==0){
            if(!tiles[Tile.getTileWithCoordinates(cell.getX()-1, cell.getY()+1)].getIsitBlocked()){
                i++;
            }
            if(!tiles[Tile.getTileWithCoordinates(cell.getX()-1, cell.getY()-1)].getIsitBlocked()){
                i++;
            }
        }
        if(cell.getY()%2==1){
            if(!tiles[Tile.getTileWithCoordinates(cell.getX()+1, cell.getY()+1)].getIsitBlocked()){
                i++;
            }
            if(!tiles[Tile.getTileWithCoordinates(cell.getX()+1, cell.getY()-1)].getIsitBlocked()){
                i++;
            }
        }
        Tile[] adjacent = new Tile[i];
        if (i != 0) {

            i = 0;
            if (!tiles[Tile.getTileWithCoordinates(cell.getX(), cell.getY() - 1)].getIsitBlocked()) {
                adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX(), cell.getY() - 1)];
                i++;
            }
            if (!tiles[Tile.getTileWithCoordinates(cell.getX(), cell.getY() + 1)].getIsitBlocked()) {
                adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX(), cell.getY() + 1)];
                i++;
            }
            if (!tiles[Tile.getTileWithCoordinates(cell.getX() - 1, cell.getY())].getIsitBlocked()) {
                adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX() - 1, cell.getY())];
                i++;
            }
            if (!tiles[Tile.getTileWithCoordinates(cell.getX() + 1, cell.getY())].getIsitBlocked()) {
                adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX() + 1, cell.getY())];
                i++;
            }
            if (cell.getY() % 2 == 0) {
                if (!tiles[Tile.getTileWithCoordinates(cell.getX() - 1, cell.getY() + 1)].getIsitBlocked()) {
                    adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX() - 1, cell.getY() + 1)];
                    i++;
                }
                if (!tiles[Tile.getTileWithCoordinates(cell.getX() - 1, cell.getY() - 1)].getIsitBlocked()) {
                    adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX() - 1, cell.getY() - 1)];
                }
            }
            if (cell.getY() % 2 == 1) {
                if (!tiles[Tile.getTileWithCoordinates(cell.getX() + 1, cell.getY() + 1)].getIsitBlocked()) {
                    adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX() + 1, cell.getY() + 1)];
                    i++;
                }
                if (!tiles[Tile.getTileWithCoordinates(cell.getX() + 1, cell.getY() - 1)].getIsitBlocked()) {
                    adjacent[i] = tiles[Tile.getTileWithCoordinates(cell.getX() + 1, cell.getY() - 1)];
                }
            }

        }
        return adjacent;


    }


}
