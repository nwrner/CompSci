package Core;

public class AckBrain {

    public static Integer[][] ackTable = new Integer[5][101];
    public static int tableExceed = 0;
    public static int ackCount = 0;
    public static int ackTableCount = 0;
    public static int largestY = 0;
    public static int ackTableAccesses = 0;
    public static int tablelargestY = 0;



    public static int ack(int x, int y) {
        //Non-optimizied ackerman STUB
        ackCount++;
        if ( y > largestY) {
            largestY = y;
        }
        if (x == 0) {
            return y + 1;
        } else if (x > 0 && y == 0) {
            return ack(x - 1, 1);
        } else {
            return ack(x - 1, ack(x, y - 1));
        }

    }



    public static int tableAck(int m, int n) {
        // Optimized ackerman STUB
        ackTableCount++;

        if ( n > tablelargestY) {
            tablelargestY = n;
        }

        if (n > 100) {
            tableExceed++;
            if (m == 0) {
                return n + 1;
            } else if (m > 0 && n == 0) {
                return tableAck(m - 1, 1);
            } else {
                return tableAck(m - 1, tableAck(m, n - 1));
            }
        }


        if (ackTable[m][n] != null) {
            ackTableAccesses+=2;
            return ackTable[m][n];
        }

        if (m == 0) {
            ackTableAccesses+=2;
            ackTable[m][n] = n + 1;
            return n + 1;

        } else if (m > 0 && n == 0) {
            ackTableAccesses+=2;
            ackTable[m][n] = tableAck(m - 1, 1);
            return ackTable[m][n];

        } else {
            ackTableAccesses+=2;
            ackTable[m][n] = tableAck(m - 1, tableAck(m, n - 1));
            return ackTable[m][n];
        }
    }
}






