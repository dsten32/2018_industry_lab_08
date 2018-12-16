package ictgradschool.industry.io.EX05;

import ictgradschool.industry.io.ex02.MyReader;

import java.util.Scanner;

public class GameMain {
    String playerGuess,playerCode, computerGuess,computerCode,bullPlural,cowPlural;
    int cow,bull,num_guesses=0;
    Scanner sc = new Scanner(System.in);

    private void start() {
        playerCode="";
        computerCode=compCode();

        GameReader gr = new GameReader();
        gr.start();

        playerCode = playerEntry("Please enter your secret code:\n");

        while (num_guesses<7) {
            playerGuess=playerEntry("--- \nYou Guess:");

            test(playerGuess, computerCode);

            System.out.println("Result: " + bull + " " + bullPlural + " and " + cow + " " + cowPlural);
            System.out.println("\nsshhhh, this is what the computer's code is... "+computerCode);

            if(checkWin()){
                System.out.print("You win! :)");
                return;
            }

            System.out.println();
            computerGuess=compCode();
            test(computerGuess,playerCode);
            System.out.println("Computer Guess: "+computerGuess);
            System.out.println("Result: " + bull + " " + bullPlural + " and " + cow + " " + cowPlural);

            if(checkWin()){
                System.out.print("Computer wins! :P");
                return;
            }
            num_guesses++;
        }
        System.out.print("\nYou're out of guesses, bye.");
    }

    private void test(String guess, String code){
        cow=0;
        bull=0;
        String temp=code;
        for(int i=0;i<guess.length();i++) {
            if(guess.charAt(i)==temp.charAt(i)){
                bull++;
            }
            if (temp.contains(Character.toString(guess.charAt(i)))){
                cow++;
                temp=temp.replace(Character.toString(guess.charAt(i)),"^");
            }
        }
        cow-=bull;

        if(bull==1){
            bullPlural="Bull";
        } else {
            bullPlural="Bulls";
        }
        if(cow==1){
            cowPlural="cow";
        } else {
            cowPlural="cows";
        }
    }

    //get the player entry, covers the players secret code as well as guesses.
    private String playerEntry(String entryText){
        String entry="";
        while (entry.length()<=3||entry.length()>=5) {
            try {
                System.out.print(entryText);
                entry = sc.next();
                Integer.parseInt(String.valueOf(entry));
                checkEntry(entry);
            } catch (NumberFormatException e) {
                System.out.println("nope, not a num");
            } catch (InvalidEntryException e) {
                System.out.println("ugh, wrong number of digits..");
            }
        }
        return entry;
    }


    private void checkEntry(String guess) throws InvalidEntryException{
        if (guess.length()<4 || guess.length()>4){
            throw new InvalidEntryException();
        }
    }

    //did this round win?
    private boolean checkWin(){
        return (bull==4);
    }

    //generate the computer's secret code.
    private String compCode(){
        char a ='0',b='0',c='0',d='0';

        while (a==b||a==c ||a==d||b==c||b==d||c==d){
            a =((char)((Math.random()*10)+48));
            b =((char)((Math.random()*10)+48));
            c =((char)((Math.random()*10)+48));
            d =((char)((Math.random()*10)+48));
        }

        String code = ""+a+b+c+d;

        return code;
    }


    public static void main(String[] args){
        GameMain gm = new GameMain();
        gm.start();
    }


}
