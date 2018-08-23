

import java.util.Scanner;



public class Radix {

    public static void main(String argsp[]) {
        explainProgram();
        calculateValue();

    }

    public static void explainProgram() {
        System.out.println("================= Code Explanation =====================");
        System.out.println("This program converts user entered number into base 10.");
        System.out.println("The first of two inputs is the radix (base) the user wants to use, ");
        System.out.println("and the second is the actual number. ");
    }

    public static void calculateValue() {
        System.out.println("\n============= User Input ==============");
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter radix: ");
        int userRadix = reader.nextInt();
        System.out.print("Enter number: ");
        int userNumber = reader.nextInt();
        reader.close();


        int number = String.valueOf(userNumber).length();
        int[] positions = new int[number];

        for (int i = 0; i < String.valueOf(userNumber).length(); i++) {
            positions[i] = Character.getNumericValue(String.valueOf(userNumber).charAt(i));
        }
        int loopCount = 0;
        int cache = 0;
        for (int i = positions.length - 1; i > -1; i--) {
            cache += positions[i] * (Math.pow(userRadix, loopCount));
            loopCount++;
        }
        System.out.println(cache);
    }


}
