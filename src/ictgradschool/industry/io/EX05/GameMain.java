package ictgradschool.industry.io.EX05;

import java.util.Scanner;

public class GameMain {
    int playerCode, computerCode;


    private void start() {
        Scanner sc = new Scanner(System.in);

        playerCode=0;
        while (playerCode==0 || playerCode<999 || playerCode>9999) {
            try {
                System.out.println("Please enter your secret code:");
                playerCode = Integer.parseInt(sc.next());
                checkEntry(playerCode);
            } catch (NumberFormatException e) {
                System.out.println("nope, not a num");
            } catch (InvalidEntryException e){
                System.out.println("ugh, wrong number of digits..");
            }
        }

        System.out.println("---");
        System.out.println("You Guess: "+playerCode);


        System.out.println("Result: ");



    }

private void checkEntry(int guess) throws InvalidEntryException{

if (guess<999 || guess>9999){
    throw new InvalidEntryException("wrong num of characters...");
}
}

    public static void main(String[] args){
        GameMain gm = new GameMain();
        gm.start();
    }


}
