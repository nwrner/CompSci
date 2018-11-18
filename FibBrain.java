package Core;

public class FibBrain {

    public static Integer[] fibTable = new Integer[32];
    public static int tableCount = 0;

    public static int fib(int n) {
        if (n == 1 || n == 2)
            return 1;
        // recursive call
        return fib(n-1) + fib(n-2);
    }

    public static int tableFib(int n) {
        tableCount++;
        if (fibTable[n] != null) {
            return fibTable[n];
        } else {
            fibTable[n] = tableFib(n-1) + tableFib(n-2);
            return fibTable[n];
        }
    }
}

