/** File: LabCh09FileIOLab3.java
    
    ### Complete
    Name: Nick Warner
    Section: CS 1050
    Lab #: 9.3
    
	 Read a file of numbers, calculate sums and averages
	 
	 Input	A file that has rows of input with a name and double numbers
            for gross pay, savings rate and IRA investment rate, one set 
            per line
	 
	 Process	Read the data values, calculate savings and IRA investment amounts,
            and sum them
	 
	 Output	A file with the original data values, one line for each input line as
            shown in the assignment specification. After the detail lines are
            displayed, leave a blank line then add lines with appropriate
            messages for:
            1. the number of input lines read
            2. the number of valid input lines read (all three input numbers are 
               greater than 0)
            3. the averages of the gross pay, savings amount and IRA investment
               amount, one to a line
            
    Note 	Without your added code, the program will display the number
		      of lines in the input file.

*/

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;  // Access the Scanner class
import java.io.*;          // Access PrintWriter and related classes




public class LabCh09FileIOLab3 {

   public static void main(String[] args) throws IOException {
   
      // Declare variables
   
      final String INPUT_FILE  = "/Users/Nick/IdeaProjects/Test/src/com/example/LabCh09FileIO_Input3.txt";
      final String OUTPUT_FILE = "/Users/Nick/IdeaProjects/Test/src/com/example/LabCh09FileIO_Output3.txt";
      int spacer = 0;
      
      int numInputLines = 0;     // Number of lines in the input file
      int numValidLines = 0;     // Number of valid lines in the input file
      String lastName = "";      // Input file's last name
      double grossPay = 0.0;     // Input file's gross pay
      double savingsRate = 0.0;  // Input file's savings rate
      double iraRate = 0.0;      // Input file's IRA investment rate
      double sumGrossPay = 0.0;  // Sum of all valid gross pay amounts
      double sumSavings = 0.0;   // Sum of all valid savings amounts
      double sumIra = 0.0;       // Sum of all valid IRA investment amounts

      
      Scanner input  = new Scanner(new File(INPUT_FILE));
      //PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE));
      
      System.out.println("Reading  file " + INPUT_FILE  + "\r\n" +
                         "Creating file " + OUTPUT_FILE + "\r\n");

      explainProgram();
      outputLabels();
      /*
      output.printf("%20s", "Name");
      output.printf("%1s", "");
      output.printf("%20s", "Gross Pay");
      output.printf("%1s", "");
      output.printf("%20s", "Savings Rate");
      output.printf("%1s", "");
      output.printf("%20s", "IRA Rate");
      output.printf("%1s", "");
      output.printf("%20s\n", "IRA Amount");
      output.printf("%20s", "========");
      output.printf("%1s", "");
      output.printf("%20s", "========");
      output.printf("%1s", "");
      output.printf("%20s", "========");
      output.printf("%1s", "");
      output.printf("%20s", "========");
      output.printf("%1s", "");
      output.printf("%20s\n", "========");
      */


      while (input.hasNext()) {

         numInputLines++;
         lastName = input.next();
         grossPay = input.nextDouble();
         savingsRate = input.nextDouble();
         iraRate = input.nextDouble();
	

        double savingsAmount = (grossPay*savingsRate)/100;
          //double savingsAmount = calcAmount(grossPay, savingsRate);
		double iraAmount = grossPay*(iraRate/100);
		spacer = 20-lastName.length();

			if (savingsRate > 0 && grossPay > 0 && iraRate > 0) {
			    int flag = 0;
				//If so:
					//    (a) Calculate savings and IRA investment amounts
					//    (b) Add those amounts and gross pay to running totals (sums)
					//    (c) Write the spec'd information to the output file
					//    (d) Write the same information to the console
					//		   (use System.out.println). This is called "Echoing the input"
                numValidLines++;
                sumGrossPay+=grossPay;
                sumSavings+=savingsAmount;
                sumIra+=iraAmount;

			    outputDetailLine(lastName, grossPay, savingsRate, savingsAmount, iraRate, iraAmount, spacer, flag);
                outputDataIf(lastName, spacer, grossPay, savingsRate, savingsAmount, iraAmount, iraRate);



                /*
                output.print(lastName);
                output.printf("%"+spacer+"s", grossPay);
                output.printf("%20s", savingsRate);
                output.printf("%20.2f", savingsAmount);
                output.printf("%20.2f", iraAmount);
                output.printf("%20s", iraRate);


                System.out.println("");
                output.println("");
                */

		// 3. If not:
				//    (a) Write just the three input values in the correct columns
				//    (b) Write the same information to the console
		} else {
			int flag = 1;
			outputDetailLine(lastName, grossPay, savingsRate, savingsAmount, iraRate, iraAmount, spacer, flag);
            outputDataElse(lastName, spacer, grossPay, savingsRate, iraRate);

            /*
			output.print(lastName);
			output.printf("%"+spacer+"s", grossPay);
			output.printf("%20s", savingsRate);
			output.printf("%20s", iraRate);
			System.out.println("");
			output.println("");
            */


		  } // End while
	   }

	    //output.close();
	    input.close();
    	outputSummary(sumGrossPay, sumSavings, sumIra, numValidLines);

	    System.exit(0);

   } // End main

    public static void explainProgram() {
       System.out.println("This program performs the same functions as LabCh09FileIO_Lab3 but with methods.");
       System.out.println(" ");

    }

    public static double calcAmount ( double grossPay, double rate) {
       return ((grossPay*rate)/100);

    }

    public static void outputDetailLine(String lastName, double grossPay,
                                        double savingsRate, double savingsAmount, double iraRate, double iraAmount, int spacer, int flag) {
        if (flag == 0) {
            System.out.print(lastName);
            System.out.printf("%" + spacer + ".2f", grossPay);
            System.out.printf("%15s", savingsRate);
            System.out.printf("%15.2f", savingsAmount);
            System.out.printf("%15.1f", iraRate);
            System.out.printf("%15.2f", iraAmount);
        } else {
            System.out.print(lastName);
            System.out.printf("%"+spacer+".2f", grossPay);
            System.out.printf("%15s", savingsRate);
            System.out.printf("%15.1f", iraRate);
        }
    }

    public static double calcAverage(double sum, int count) {
       return (sum/count);
    }

    public static String outputSummary(double sumGrossPay, double sumSavings, double sumIra, int numValidLines) {
        System.out.print("Average Gross Pay: ");
        System.out.printf("%.2f\n", calcAverage(sumGrossPay, numValidLines));
        System.out.print("Average Savings: ");
        System.out.printf("%.2f\n", calcAverage(sumSavings, numValidLines));
        System.out.print("Average IRA Amount: ");
        System.out.printf("%.2f\n", calcAverage(sumIra, numValidLines));
        return "";
    }

    public static String outputLabels() {
        final String OUTPUT_FILE = "/Users/Nick/IdeaProjects/Test/src/com/example/LabCh09FileIO_Output3.txt";
        try {
            PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE), true);

            output.printf("%20s", "Name");
            output.printf("%1s", "");
            output.printf("%20s", "Gross Pay");
            output.printf("%1s", "");
            output.printf("%20s", "Savings Rate");
            output.printf("%1s", "");
            output.printf("%20s", "IRA Rate");
            output.printf("%1s", "");
            output.printf("%20s\n", "IRA Amount");
            output.printf("%20s", "========");
            output.printf("%1s", "");
            output.printf("%20s", "========");
            output.printf("%1s", "");
            output.printf("%20s", "========");
            output.printf("%1s", "");
            output.printf("%20s", "========");
            output.printf("%1s", "");
            output.printf("%20s\n", "========");
            System.out.println("");
            output.println("");
            output.close();
        } catch (IOException exception) {

        }
        return "";
    }

    public static String outputDataIf(String lastName, int spacer, double grossPay, double savingsRate, double savingsAmount, double iraAmount, double iraRate) {

        try {
            final String OUTPUT_FILE = "/Users/Nick/IdeaProjects/Test/src/com/example/LabCh09FileIO_Output3.txt";
            PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE), true);
            output.print(lastName);
            output.printf("%"+spacer+"s", grossPay);
            output.printf("%20s", savingsRate);
            output.printf("%20.2f", savingsAmount);
            output.printf("%20.2f", iraAmount);
            output.printf("%20s", iraRate);


            System.out.println("");
            output.println("");
            output.close();

        } catch (IOException exception) {

        }
        return "";
    }

    public static String outputDataElse(String lastName, int spacer, double grossPay, double savingsRate, double iraRate) {

        try {
            final String OUTPUT_FILE = "/Users/Nick/IdeaProjects/Test/src/com/example/LabCh09FileIO_Output3.txt";
            PrintWriter output = new PrintWriter(new FileWriter(OUTPUT_FILE), true);
            output.print(lastName);
            output.printf("%"+spacer+"s", grossPay);
            output.printf("%20s", savingsRate);
            output.printf("%20s", iraRate);
            System.out.println("");
            output.println("");
            output.close();

        } catch (IOException exception) {

        }
        return "";
    }


} // End class
