package ictgradschool.industry.io.EX05;

import ictgradschool.industry.io.ex02.MyReader;

import java.util.List;
import java.util.Scanner;

public class GameMain {
    String playerGuess,playerCode, computerGuess,computerCode,bullPlural,cowPlural,toText;
    int cow,bull,num_guesses=0;
    Scanner sc = new Scanner(System.in);
    List<String> guessList;

    private void start() {
        playerCode="";
        computerCode=compCode();

        System.out.print("do you want to enter guesses from a file..? (y/n)");

        String filit=sc.next();
        if(filit.equals("y") || filit.equals("Y")){
            GameReader gr = new GameReader();
            guessList=gr.start();
//            System.out.print(guessList);
        }

        playerCode = playerEntry("Please enter your secret code:\n");
        toText+="Please enter your secret code:\n"+playerCode;

        while (num_guesses<7) {

            if(guessList!=null && guessList.size()>num_guesses) {
                    playerGuess = guessList.get(num_guesses);
                    System.out.print("---\nYou Guess: " + playerGuess+"\n");
                toText+="---\nYou Guess: " + playerGuess+"\n";
            } else{
                playerGuess = playerEntry("---\nYou Guess:");
                toText+="---\nYou Guess: " + playerGuess+"\n";
            }

            test(playerGuess, computerCode);

            System.out.print("Result: " + bull + " " + bullPlural + " and " + cow + " " + cowPlural+"\n");
            toText+="Result: " + bull + " " + bullPlural + " and " + cow + " " + cowPlural+"\n";
            System.out.print("\nsshhhh, this is what the computer's code is... "+computerCode+"\n");

            if(checkWin()){
                System.out.print("You win! :)");
                toText+="You win! :)";
                return;
            }

            System.out.print("\n");
            toText+="\n";
            computerGuess=compCode();
            test(computerGuess,playerCode);
            System.out.print("Computer Guess: "+computerGuess+"\n");
            toText+="Computer Guess: "+computerGuess+"\n";
            System.out.print("Result: " + bull + " " + bullPlural + " and " + cow + " " + cowPlural+"\n");
            toText+="Result: " + bull + " " + bullPlural + " and " + cow + " " + cowPlural+"\n";

            if(checkWin()){
                System.out.print("Computer wins! :P");
                toText+="Computer wins! :P";
                return;
            }
            num_guesses++;
        }
        System.out.print("\nYou're out of guesses, bye.");
        toText+="\nYou're out of guesses, bye.";
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
                System.out.print("nope, not a num\n");
            } catch (InvalidEntryException e) {
                System.out.print("ugh, wrong number of digits..\n");
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
