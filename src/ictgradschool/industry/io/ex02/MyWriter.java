package ictgradschool.industry.io.ex02;

import ictgradschool.Keyboard;

import java.io.*;

/**
 * A simple program which should allow the user to type any number of text lines. The program will then
 * write them out to a file.
 */
public class MyWriter {

    public void start() {

        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        // TODOne Open a file for writing, using a PrintWriter.
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File(fileName+".txt"),true))) {

            while (true) {

                System.out.print("Type a line of text, or just press ENTER to quit: ");
                String text = Keyboard.readInput();

                if (text.isEmpty()) {
                    break;
                }

                // TODOne Write the user's line of text to a file.
                writer.println(text);
            }

            System.out.println("Done!");

        } catch (IOException e){
            System.out.println("oops, err "+e);
        }
    }

    public static void main(String[] args) {

        new MyWriter().start();

    }
}
