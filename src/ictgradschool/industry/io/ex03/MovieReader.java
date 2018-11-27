package ictgradschool.industry.io.ex03;

import ictgradschool.Keyboard;

import java.io.*;

/**
 * Created by anhyd on 20/03/2017.
 */
public class MovieReader {

    public void start() {


        // Get a file name from the user
        System.out.print("Enter a file name: ");
        String fileName = Keyboard.readInput();

        // Load the movie data
        Movie[] films = loadMovies(fileName);

        // Do some stuff with the data to check that its working
        printMoviesArray(films);
        Movie mostRecentMovie = getMostRecentMovie(films);
        Movie longestMovie = getLongestMovie(films);
        printResults(mostRecentMovie, longestMovie);
        System.out.println();
        printDirector("Searching for Sugar Man", films);
        printDirector("Liberal Arts", films);
        printDirector("The Intouchables", films);

    }

    /**
     * Reads movies from a file.
     *
     * @param fileName
     * @return
     */
    protected Movie[] loadMovies(String fileName) {

        // TODO Implement this method
        try(DataInputStream read = new DataInputStream(new FileInputStream(new File(fileName+".txt")))){

        }catch (FileNotFoundException e){
            System.out.println("fnferr"+e);
        }catch (IOException e){
            System.out.println("ioerr"+e);
        }



        System.out.println("Movies loaded successfully from " + fileName + "!");
        return null;

    }

    private void printMoviesArray(Movie[] films) {
        System.out.println("Movie Collection");
        System.out.println("================");
        // Step 2.  Complete the printMoviesArray() method
        for(int i = 0; i<films.length; i++){
            System.out.println(films[i].toString());
        }
    }
    private Movie getMostRecentMovie(Movie[] films) {
        // Step 3.  Complete the getMostRecentMovie() method.
        Movie temp=null;
        for(int i = 1; i<films.length; i++){
            if(films[i].isMoreRecentThan(films[i-1])){
                temp = films[i];
            }
        }
        return temp;
    }
    private Movie getLongestMovie(Movie[] films) {
        // Step 4.  Complete the getLongest() method.
        Movie temp=null;
        for(int i = 1; i<films.length; i++){
            if(films[i].isLongerThan(films[i-1])){
                temp = films[i];
            }
        }
        return temp;
    }
    private void printResults(Movie mostRecent, Movie longest) {
        System.out.println();
        System.out.println("The most recent movie is: " + mostRecent.toString());
        System.out.println("The longest movie is: " + longest.toString());
    }
    private void printDirector(String movieName, Movie[] movies) {
        // Step 5. Complete the printDirector() method
        for(int i = 0; i<movies.length; i++){
            if(movieName.equals(movies[i].getName())){
                System.out.println(movieName + " was directed by " + movies[i].getDirector());
                return;
            }
        }
        System.out.println(movieName + " is not in the collection.");
    }

    public static void main(String[] args) {
        new MovieReader().start();
    }
}
