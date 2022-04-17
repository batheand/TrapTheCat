import javax.swing.*;

public class Map extends JComponent {
    private boolean[] [] isBLocked = new boolean[8][8];
    public void initializeBlocked() {
        for(int i=0; i<=8; i++) {
            for(int n = 0; n<=8; n++) {
                isBLocked[i] [n]=false;
            }
        }
    }
    public boolean isItBlocked(int y, int x) {
        boolean [] [] isBlockedTemp = getIsBLocked();
        boolean isItBlocked = isBlockedTemp[x][y];
        return isItBlocked;
    }
    public void blockTheTile(int y, int x) {
        boolean [] [] tempIsBlocked = getIsBLocked();
        tempIsBlocked [x] [y] = true;
        setIsBLocked(tempIsBlocked);
    }
    JComponent buttons = new JButton();

    public boolean[][] getIsBLocked() {
        return isBLocked;
    }
    public void setIsBLocked(boolean[][] isBLocked) {
        this.isBLocked = isBLocked;
    }
}
