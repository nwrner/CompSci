package BigNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class StackDriver {

    public static void main (String args[]) {
        //Setting up user input and RNG.
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();

        //Building a new stack and setting it to standard size.
        standardStack stackA = new standardStack();
        standardStack stackB = new standardStack();


        stackA.custom(26);
        stackB.custom(26);


        stackA.populateStack("6464663202334290850984309");
        stackB.populateStack("2390842039439875938741834");


        stackA.add(stackB);



        //stackA.returnAnswer();















        /*

        // Asking the user for the path of the test file and assigning it.
        System.out.print("Enter FULL path of input file: ");
        String filePath = reader.next(); //
        reader.close();


        //Preparing the file.
        File file = new File(filePath);


        //Trying to read it.
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            System.out.println("Test file author = " + br.readLine() + "\n");


            while (br.readLine() != null) {
                for (int i = 0; i < 2; i++) {
                    System.out.println("Test conditions: " + br.readLine());
                    System.out.println("Operand A: " + br.readLine());
                    System.out.println("Operand B: " + br.readLine() + "\n");
                }
                //System.out.println("\n");

            }
        } catch (IOException x) { //Catching any failure to read.
            System.out.println("Could not read from file. Is your path correct and the FULL path?");
        }

        */









    }
}
