package ictgradschool.industry.io.ex01;

import java.io.*;

public class ExerciseOne {

    public void start() {

        printNumEsWithFileReader();

        printNumEsWithBufferedReader();

    }

    private void printNumEsWithFileReader() {

        int numE = 0;
        int total = 0;

        // TODOne Read input2.txt and print the total number of characters, and the number of e and E characters.
        // TODOne Use a FileReader.
        int num =0;

        try(FileReader fR = new FileReader("input2.txt")) {

            while((num=fR.read())!=-1){
                if((char)num=='E'||(char)num=='e'){
                    numE++;
                    total++;
                } else {
                    total++;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("FnF exc. "+e);
        } catch (IOException e){
            System.out.println("IO exc. "+e);
        }

        System.out.println("Number of e/E's: " + numE + " out of " + total);
    }

    private void printNumEsWithBufferedReader() {

        int numE = 0;
        int total = 0;

        // TODOne Read input2.txt and print the total number of characters, and the number of e and E characters.
        // TODOne Use a BufferedReader.
        File theFile = new File("input2.txt");
        try(BufferedReader bF= new BufferedReader(new FileReader(theFile))){
            String line = null;
            while((line=bF.readLine())!=null){
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i)=='e'||line.charAt(i)=='E'){
                        numE++;
                        total++;
                    } else {
                        total++;
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("FnF err: "+e);
        } catch (IOException e){
            System.out.println("IO err: "+e);
        }

        System.out.println("Number of e/E's: " + numE + " out of " + total);
    }

    public static void main(String[] args) {
        new ExerciseOne().start();
    }

}
