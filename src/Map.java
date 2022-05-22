package src;

import javax.swing.*;

public class Map extends JComponent {
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


    JComponent buttons = new JButton();


}
