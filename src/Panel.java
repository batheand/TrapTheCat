package src;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable{

        final int originalTileSize = 14;
    final int scale = 4;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 16;
    final int width = tileSize * maxScreenCol;
    final int height = tileSize * maxScreenRow;


    Thread thread;

    public Panel() {
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(thread != null) {
            //update
            update();
            //draw
            repaint();
        }
    }

    public void update() {
    }

    public void paintComponent(Graphics g, Tile[] cell, Cat cat) {

        super.paintComponent(g);

        Graphics g2D = (Graphics2D) g;

        g2D.setColor(Color.yellow);

        for(int i=0; i<6; i++){
            for(int j=0; j<11; j++)
                g2D.fillOval(100+65*j,100+130*i,tileSize,tileSize);

        }

        for(int i=0; i<5; i++){
            for(int j=0; j<11; j++)
                g2D.fillOval(75+65*j,165+130*i,tileSize,tileSize);

        }


        g2D.dispose();

        g2D.setColor(Color.yellow.darker());

        for(int i=0; i<121;i++){
            if(cell[i].getIsitBlocked()){
                if(cell[i].getY()%2==1){
                    g2D.fillOval(100+65*cell[i].getX()-1,100+130*cell[i].getY()-1,tileSize,tileSize);
                }
                else{
                    g2D.fillOval(75+65*cell[i].getX()-1,165+130*cell[i].getY()-1,tileSize,tileSize);

                }

            }

        }
        g2D.dispose();

        g2D.setColor(Color.red);

        if(cell[cat.getCatTile()].getY()%2==1){
            g2D.fillOval(100+65*cell[cat.getCatTile()].getX()-1,100+130*cell[cat.getCatTile()].getY()-1,tileSize,tileSize);
        }

        else{
            g2D.fillOval(75+65*cell[cat.getCatTile()].getX()-1,165+130*cell[cat.getCatTile()].getY()-1,tileSize,tileSize);
        }

        g2D.dispose();


    }
}



