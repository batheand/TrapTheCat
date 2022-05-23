package src;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel{

        final int originalTileSize = 14;
    final int scale = 4;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 16;
    final int width = tileSize * maxScreenCol;
    final int height = tileSize * maxScreenRow;

    Tile[] cell;
    Cat cat;
    public void receiveGameState(Tile[] cell, Cat cat){
    this.cell=cell;
    this.cat=cat;

    }

    public Panel() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);

    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.yellow);

        for(int i=0; i<6; i++){
            for(int j=0; j<11; j++) {
                g.fillOval(100 + 65 * j, 100 + 130 * i, tileSize, tileSize);
            }
        }

        for(int i=0; i<5; i++){
            for(int j=0; j<11; j++)
                g.fillOval(75+65*j,165+130*i,tileSize,tileSize);

        }

        g.setColor(Color.black);

        for(int i=0; i<121;i++){
            if(cell[i].getIsitBlocked()){
                if(cell[i].getY()%2==1){

                    g.fillOval(100+65*(cell[i].getX()-1),100+65*(cell[i].getY()-1),tileSize,tileSize);
                //add only half the time
                }
                else{
                    g.fillOval(75+65*(cell[i].getX()-1),165+65*(cell[i].getY()-2),tileSize,tileSize);

                }

            }

        }


        g.setColor(Color.red);

        if(cell[cat.getCatTile()].getY()%2==1){
            g.fillOval(100+65*(cell[cat.getCatTile()].getX()-1),100+65*(cell[cat.getCatTile()].getY()-1),tileSize,tileSize);
        }

        else{
            g.fillOval(75+65*(cell[cat.getCatTile()].getX()-1),165+65*(cell[cat.getCatTile()].getY()-2),tileSize,tileSize);
        }


}}




