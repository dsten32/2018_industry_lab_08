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
                String newline = read.nextLine();
                String[] movieData=newline.split(",");
                String movieName=movieData[0];
                int movieYear=Integer.parseInt(movieData[1]);
                int movieLength=Integer.parseInt(movieData[2]);
                String movieDirector=movieData[3];
                for (int i = 0; i < films.length; i++) {
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
