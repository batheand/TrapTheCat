package src;

public class Main {
    public static void main(String[] args){
        boolean goAgain;
        Game ggwp = new Game();

        do {

            int choice = ggwp.startMenu();

            ggwp.PlayGame(choice);

            goAgain = ggwp.gameOver();

        }while(goAgain);

        System.exit(0);


    }}

