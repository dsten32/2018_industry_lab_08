package ictgradschool.industry.io.EX05;

import java.util.Scanner;

public class GameMain {
    String playerCode, computerCode;


    private void start() {
        Scanner sc = new Scanner(System.in);
        playerCode="";
        // generate computer code

        computerCode=compCode();

        while (playerCode.length()<=3||playerCode.length()>=5) {
            try {
                System.out.println("Please enter your secret code:");
                playerCode = sc.next();
                checkEntry(playerCode);
            } catch (NumberFormatException e) {
                System.out.println("nope, not a num");
            } catch (InvalidEntryException e){
                System.out.println("ugh, wrong number of digits..");
            }
        }

        test(playerCode,computerCode);

//        test(playerCode,computerCode,new CompareGuess());

        System.out.println("---");
        System.out.println("You Guess: "+playerCode);


//        System.out.println("Me Guess: "+computerCode);

        // add in testing for comparing player guess to computer code



        System.out.println("Result: "+"haven't figured this part out yet");



    }

    private void test(String guess, String code){
        int cow = 0,bull=0;
        for(int i=0;i<guess.length();i++) {
            for (int j = 0; j < code.length(); j++) {
                if (guess.charAt(i)==code.charAt(j)){

                }
            }
        }

    }

    private void checkEntry(String guess) throws InvalidEntryException{

        if (guess.length()<4 || guess.length()>4){
            throw new InvalidEntryException();
        }
    }

    private String compCode(){
        char a ='0',b='0',c='0',d='0';

        while (a==b||a==c ||a==d||b==c||b==d||c==d){
            a =((char)((Math.random()*10)+48));
            b =((char)((Math.random()*10)+48));
            c =((char)((Math.random()*10)+48));
            d =((char)((Math.random()*10)+48));
        }

//        char a =((char)((Math.random()*10)+48));
//        char b = ((char)((Math.random()*10)+48));
//        char c = ((char)((Math.random()*10)+48));
//        char d = ((char)((Math.random()*10)+48));
        String code = ""+a+b+c+d;
//        int code = Integer.parseInt(temp);
        return code;
    }


    public static void main(String[] args){
        GameMain gm = new GameMain();
        gm.start();
    }


}
