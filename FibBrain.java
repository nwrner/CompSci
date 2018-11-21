package Core;

public class FibBrain {

    public static Integer[] fibTable = new Integer[32];
    public static int fibCount = 0;
    public static int tableFibCount = 0;
    public static int tableAccesses = 0;

    public static int fib(int n) {
        //Nonoptimized fib STUB

        fibCount++;
        if (n == 1 || n == 2)
            return 1;
        // recursive call
        return fib(n-1) + fib(n-2);
    }

    public static int tableFib(int n) {
        //Optimized fib STUB

        tableFibCount++;
        if (fibTable[n] != null) {
            tableAccesses+=2;

            return fibTable[n];
        } else {
            fibTable[n] = tableFib(n-1) + tableFib(n-2);
            tableAccesses+=2;
            return fibTable[n];
        }
    }



}

