package ictgradschool.industry.io.ex04;

import ictgradschool.industry.io.ex03.Movie;
import ictgradschool.industry.io.ex03.MovieWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by anhyd on 20/03/2017.
 */
public class Ex4MovieWriter extends MovieWriter {

    @Override
    protected void saveMovies(String fileName, Movie[] films) {

        // TODOne Implement this with a PrintWriter
        try (PrintWriter print=new PrintWriter(new FileWriter(fileName+".txt"))){



            for (int i = 0; i < films.length; i++) {
                StringBuffer movieInfo=new StringBuffer("");

                movieInfo.append(films[i].getName());
                movieInfo.append(",");
                movieInfo.append(films[i].getYear());
                movieInfo.append(",");
                movieInfo.append(films[i].getLengthInMinutes());
                movieInfo.append(",");
                movieInfo.append(films[i].getDirector());
                movieInfo.append("\n");
                print.write(movieInfo.toString());
            }

        }catch (FileNotFoundException e){
            System.out.println("FnF err "+e);
        } catch (IOException e){
            System.out.println("IO err "+e);
        }

    }

    public static void main(String[] args) {
        new Ex4MovieWriter().start();
    }

}
