package BigNumbers;

import java.util.Arrays;

public class standardStack {

    Integer[] stack = new Integer[0];
    Integer[] answerStack = new Integer[0];
    int carryBit = 0;


    //Constructors



    public void standard() {
        stack = new Integer[10];
        answerStack = new Integer[11];
    }

    public void custom(int x) {
        stack = new Integer[x];
        answerStack = new Integer[x+1];
    }

    //Stack operations
    public void push (int x) {
        stack[findTopOfStack(0)] = x;

    }

    public void pop () {
        stack[findTopOfStack(0)-1] = null;
    }





    //Helper methods.
    public int findTopOfStack(int lastSearchedIndex) {
        if (stack[lastSearchedIndex] == null) {
            return lastSearchedIndex;
        } else {
            return findTopOfStack(lastSearchedIndex + 1);
        }
    }

    public int callableFindTopOfStack(int lastSearchedIndex, Integer[] alpha) {
        int index = -1;
        for (int i = alpha.length-1; i >= 0; i--) {
            if (alpha[i] == null) {
                index = i;
            }
        }

        return index;
    }

    public void populateStack(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            push(Character.getNumericValue(inputNumber.charAt(i)));
        }



    }


    public boolean stackIsEmpty() {
        if (stack[0] == null) {
            return true;
        } else {
            return false;
        }
    }


    public void add(standardStack b) {

        int counter = 0;
        int topper = findTopOfStack(0);
        int answer = 0;


        while (counter!=9999) {

            System.out.println(Arrays.toString(stack));
            System.out.println(Arrays.toString(b.stack));

            if (stackIsEmpty() && b.stackIsEmpty()) {
                System.out.println("\nBoth stacks empty.");
                System.out.print("Answer: ");
                returnAnswer();
                counter=9999;
            } else {
                if (!stackIsEmpty() && !b.stackIsEmpty()) {
                    System.out.println("Adding " + stack[findTopOfStack(0) - 1] + ", " + b.stack[b.findTopOfStack(0) - 1] + ", " + carryBit);
                    answer = stack[findTopOfStack(0) - 1] + b.stack[b.findTopOfStack(0) - 1] + carryBit;
                    if (answer > 9) {
                        carryBit = Character.getNumericValue(String.valueOf(answer).charAt(0));
                        answerStack[callableFindTopOfStack(0, answerStack)] = Character.getNumericValue(String.valueOf(answer).charAt(1));
                        pop();
                        b.pop();
                    } else {
                        answerStack[callableFindTopOfStack(0, answerStack)] = answer;
                        carryBit = 0;
                        pop();
                        b.pop();

                    }


                    //A has values left, b doesnt.
                } else if (stackIsEmpty() && !b.stackIsEmpty()) {
                    System.out.println("A empty, B full");
                    answer = b.stack[b.findTopOfStack(0) - 1] + carryBit;
                    if (answer > 9) {
                        carryBit = Character.getNumericValue(String.valueOf(answer).charAt(0));
                        answerStack[callableFindTopOfStack(0, answerStack)] = Character.getNumericValue(String.valueOf(answer).charAt(1));
                        b.pop();
                    } else {
                        answerStack[callableFindTopOfStack(0, answerStack)] = answer;
                        carryBit = 0;
                        b.pop();

                    }



                } else if (!stackIsEmpty() && b.stackIsEmpty()) {
                    System.out.println("B empty, A full");
                    System.out.println("Trouble condition");
                    answer = stack[findTopOfStack(0) - 1] + carryBit;

                    if (answer > 9) {
                        carryBit = Character.getNumericValue(String.valueOf(answer).charAt(0));
                        answerStack[callableFindTopOfStack(0, answerStack)] = Character.getNumericValue(String.valueOf(answer).charAt(1));
                        pop();
                    } else {
                        answerStack[callableFindTopOfStack(0, answerStack)] = answer;
                        pop();
                        carryBit = 0;

                    }
                }

                System.out.println("[" + carryBit + "]");
                System.out.println(Arrays.toString(answerStack));
                System.out.println("==================\n");
            }
        }



    }






    public void returnAnswer() {
        if (carryBit != 0) {
            System.out.print(carryBit + "");
        }
        for (int i = callableFindTopOfStack(0, answerStack)-1; i >= 0; i--) {
            System.out.print(answerStack[i]);
        }
    }




}

