package ictgradschool.industry.io.EX05;

import ictgradschool.Keyboard;

import java.io.*;

/**
 * A simple program which should allow the user to type any number of text lines. The program will then
 * write them out to a file.
 */
public class GameWriter {

    public void start(String textIn) {
        String textOut = textIn;
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();
        System.out.print("Enter a file path: ");
        String filePath = Keyboard.readInput();

        // TODOne Open a file for writing, using a PrintWriter.
//        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName+".txt"),true))) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath+"/"+fileName+".txt"),true))) {

            writer.write(textOut);

//            writer.println(textOut);

//                System.out.print("Type a line of text, or just press ENTER to quit: ");




                // TODOne Write the user's line of text to a file.



            System.out.println("Done!");

        } catch (IOException e){
            System.out.println("oops, err "+e);
        }
    }

    public static void main(String[] args) {

        new GameWriter().start("default");

    }
}
