package Core;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RecursiveDriver {
    public static void main(String args[]) {
        //Initializing fibonacci table:
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        FibBrain.fibTable[1] = 1;
        FibBrain.fibTable[2] = 1;



        //User input development past code.
       /*
        System.out.println("Enter number for fib calculations: ");
        int n = reader.nextInt();
        FibBrain.fib(n);
        FibBrain.tableFib(n);
        */

        System.out.println("Beginning fib calculations...");



        //System.out.println("Fibonacci results:\n");
        //System.out.println("==================\n");


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Warner-FibResults.txt"));
            writer.write("Fibonnaci Results:\n");
            writer.write("================\n");
                for (int i = 1; i <= 30; i++) {


                //Standard fib call:
                //System.out.println("fib(" + i + ") = " + FibBrain.fib(i));
                //System.out.println("Call count: " + FibBrain.fibCount);
                writer.write("fib(" + i + ") = " + FibBrain.fib(i) + "\n");
                writer.write("Call count: " + FibBrain.fibCount + "\n");

                //Table fib call:
                FibBrain.tableFib(i);
                //System.out.println("Call count w/o table: " + FibBrain.tableFibCount);
                //System.out.println("Table accesses: " + FibBrain.tableAccesses+ "\n");
                writer.write("Call count w/o table: " + FibBrain.tableFibCount + "\n");
                writer.write("Table accesses: " + FibBrain.tableAccesses+ "\n");
                writer.write("\n");
                FibBrain.fibTable = new Integer[32];
                FibBrain.fibTable[1] = 1;
                FibBrain.fibTable[2] = 1;

                //Resetting counters:
                FibBrain.tableFibCount = 0;
                FibBrain.fibCount = 0;
                FibBrain.tableAccesses = 0;







            }
            writer.close();



        } catch (IOException x) {
            System.out.println("Could not write to fib file. ");
        }


        System.out.println("Fib calculations complete.");





        //User input development past code.
       /*
        System.out.println("Enter x for ack calculations: ");
        int x = reader.nextInt();
        System.out.println("Enter y for ack calculations: ");
        int y = reader.nextInt();

        AckBrain.ack(x,y);
        AckBrain.tableAck(x,y);
        */

       System.out.println("\nBeginning ack calculations...");


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Warner-AckResults.txt"));
            writer.write("Ackerman results:\n");
            writer.write("=================\n");
            for (int x = 0; x <= 4; x++){
                for (int y = 0; y <= 15; y++) {

                    try {
                        //System.out.println("Trying values.");
                        //System.out.print("ack(" + x + "," + y + ") = ");
                        //System.out.println(AckBrain.tableAck(x,y));
                        AckBrain.ack(x,y);
                        //System.out.println("Calls without table: " + AckBrain.ackCount);
                        //System.out.println("Calls with table: " + AckBrain.ackTableCount);
                        //System.out.println("Table accesses: " + AckBrain.ackTableAccesses);
                        //System.out.println("Table exceeded: " + AckBrain.tableExceed);
                        //System.out.println("Largest Y value: " + AckBrain.largestY);
                        writer.write("ack(" + x + "," + y + ") = ");
                        writer.write(AckBrain.tableAck(x,y) + "\n");
                        writer.write("Calls without table: " + AckBrain.ackCount + "\n");
                        writer.write("Calls with table: " + AckBrain.ackTableCount+ "\n");
                        writer.write("Table accesses: " + AckBrain.ackTableAccesses+ "\n");
                        writer.write("Table exceeded: " + AckBrain.tableExceed+ "\n");
                        writer.write("Largest Y value: " + AckBrain.largestY+ "\n");
                        writer.write("\n");



                    } catch (StackOverflowError q) {

                        for (int i = y; i <= 15; i++) {
                            writer.write("ack(" + x + "," + i + ") = stack overflow.\n");
                        }

                        if (x+1 < 5) {
                            x++;
                            y=-1;
                        } else {
                            break;
                        }
                        writer.write("\n");
                    }





                    //System.out.println("\n");
                    AckBrain.ackTable = new Integer[101][101];
                    AckBrain.ackTableCount = 0;
                    AckBrain.ackTableAccesses = 0;
                    AckBrain.ackCount = 0;
                    AckBrain.largestY = 0;
                    AckBrain.tableExceed = 0;
                }
            }
            writer.close();

        } catch (IOException x) {
            System.out.println("Could not write to ack file.");
        }


        System.out.println("Ack calculations complete.");





    }

}




