package ictgradschool.industry.io.EX05;

import ictgradschool.Keyboard;

import java.io.*;

public class GameReader {
    String g1, g2, g3, g4, g5, g6, g7;

    public void start() {

        // TODOne Prompt the user for a file name, then read and print out all the text in that file.
        // TODOne Use a BufferedReader.

        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        try(BufferedReader reader = new BufferedReader(new FileReader(new File(fileName+".txt")))){

            String line = null;

            while ((line= reader.readLine())!=null){
//                System.out.println(line);
            }

        } catch (FileNotFoundException e){
            System.out.println("FnF err "+e);
        } catch (IOException e){
            System.out.println("IO err "+e);
        }

    }

    public static void main(String[] args) {
        new GameReader().start();
    }
}
