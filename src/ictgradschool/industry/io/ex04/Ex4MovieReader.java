package ictgradschool.industry.io.ex04;

import ictgradschool.industry.io.ex03.Movie;
import ictgradschool.industry.io.ex03.MovieReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anhyd on 20/03/2017.
 */
public class Ex4MovieReader extends MovieReader {

    @Override
    protected Movie[] loadMovies(String fileName) {

        // TODO Implement this with a Scanner
        try(Scanner read = new Scanner(new File(fileName+".txt"))) {
            read.useDelimiter(",");

            byte count = read.nextByte();
            Movie[] films = new Movie[count];
            while (read.hasNextLine()){

            }
            for (int i = 0; i < films.length; i++) {
                byte[] bytes = new byte[read.readByte()];
                read.read(bytes);
                String name = "";
                for (byte bt : bytes) {
                    name += (char) bt;
                }
                bytes = new byte[read.readByte()];
                read.read(bytes);
                String year = "";
                for (byte bt : bytes) {
                    year += (char) bt;
                }
                bytes = new byte[read.readByte()];
                read.read(bytes);
                String length = "";
                for (byte bt : bytes) {
                    length += (char) bt;
                }
                bytes = new byte[read.readByte()];
                read.read(bytes);
                String director = "";
                for (byte bt : bytes) {
                    director += (char) bt;
                }

                films[i]= new Movie(name, Integer.parseInt(year), Integer.parseInt(length), director);
            }
            return films;

        }catch (FileNotFoundException e){
            System.out.println("fnferr"+e);
        }catch (IOException e){
            System.out.println("ioerr"+e);
        }



        System.out.println("Movies loaded successfully from " + fileName + "!");
        return null;
    }

    public static void main(String[] args) {
        new Ex4MovieReader().start();
    }
}
