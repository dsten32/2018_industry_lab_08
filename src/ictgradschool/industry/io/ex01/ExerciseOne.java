package ictgradschool.industry.io.ex01;

public class ExerciseOne {

    public void start() {

        printNumEsWithFileReader();

        printNumEsWithBufferedReader();

    }

    private void printNumEsWithFileReader() {

        int numE = 0;
        int total = 0;

        // TODO Read input2.txt and print the total number of characters, and the number of e and E characters.
        // TODO Use a FileReader.

        System.out.println("Number of e/E's: " + numE + " out of " + total);
    }

    private void printNumEsWithBufferedReader() {

        int numE = 0;
        int total = 0;

        // TODO Read input2.txt and print the total number of characters, and the number of e and E characters.
        // TODO Use a BufferedReader.

        System.out.println("Number of e/E's: " + numE + " out of " + total);
    }

    public static void main(String[] args) {
        new ExerciseOne().start();
    }

}
