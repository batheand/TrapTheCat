package src;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        boolean goAgain;
        Game ggwp = new Game();

        JFrame screen = new JFrame();

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("Cat Trap");




        do {

            int choice = ggwp.startMenu();

            ggwp.PlayGame(choice, screen);

            goAgain = ggwp.gameOver();

        }while(goAgain);

        System.exit(0);


    }}

