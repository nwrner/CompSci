package Core;

import java.util.Arrays;

public class RecursiveDriver {
    public static void main (String args[]) {
        FibBrain.fibTable[1] = 1;
        FibBrain.fibTable[2] = 1;

        for (int i = 1; i <= 30; i++) {
            FibBrain.tableFib(i);
            System.out.println("Call count: " + FibBrain.tableCount);
            FibBrain.fibTable = new Integer[32];
            FibBrain.fibTable[1] = 1;
            FibBrain.fibTable[2] = 1;

            FibBrain.tableCount = 0;


        }





        System.out.println(Arrays.toString(FibBrain.fibTable));

    }
}
