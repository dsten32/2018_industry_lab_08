package ictgradschool.io.ex04;

import ictgradschool.io.ex03.Movie;
import ictgradschool.io.ex03.MovieReader;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by anhyd on 20/03/2017.
 */
public class Ex4MovieReader extends MovieReader {

    @Override
    protected Movie[] loadMovies(String fileName) {

        // TODOne Implement this with a Scanner
        try(Scanner read = new Scanner(new File(fileName+".txt"))) {
            String movieName;
            int movieYear;
            int movieLength;
            String movieDirector;

            read.useDelimiter(",");

            int count = Integer.parseInt(read.next());
            read.nextLine();
            Movie[] films = new Movie[count];
            while (read.hasNextLine()){
            for (int i = 0; i < films.length; i++) {
                String newline = read.nextLine();
                String[] movieData=newline.split(",");
                movieName=movieData[0];
                movieYear=Integer.parseInt(movieData[1]);
                movieLength=Integer.parseInt(movieData[2]);
                movieDirector=movieData[3];
                films[i]= new Movie(movieName, movieYear, movieLength, movieDirector);
            }
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
