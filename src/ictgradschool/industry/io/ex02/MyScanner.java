package ictgradschool.industry.io.ex02;

import ictgradschool.Keyboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MyScanner {

    public void start() {

        // TODO Prompt the user for a file name, then read and print out all the text in that file.
        // TODO Use a Scanner.
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        try(Scanner sc=new Scanner(new File(fileName+".txt"))){
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("FnF err "+e);
        }catch (IOException e){
            System.out.println("IO err "+e);
        }

    }

    public static void main(String[] args) {
        new MyScanner().start();
    }
}
