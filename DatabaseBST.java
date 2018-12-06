package DB;

import java.io.*;
import java.util.Arrays;

public class DatabaseBST {

    public static DBTreeNode root = new DBTreeNode();
    int makesFound;
    int modelsFound = 0;
    int numberOfCars = 0;
    boolean fullLicenseFound = false;

    public void filler() {
        //root.make = "Pontiac";


    }

    public void populateDatabase(DBTreeNode actingNode) {


        File file = new File("/Users/Nick/IdeaProjects/Test/src/DB/DBTestFile.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            try {
                while ((st = br.readLine()) != null) {
                    //String[] sanitizedInput = shatterInput(st, 0, 0);
                    newNode(st, actingNode);
                }
                //printTree(root);

            } catch (IOException y) {
                System.out.println("Other file problem.");
            }
        } catch (FileNotFoundException x) {
            System.out.println("Could not open file.");
        }
    }

    public void newNode(String newEntry, DBTreeNode actingNode) {
        String[] sanitizedInput = shatterInput(newEntry, 0, 0);
        String inputMake = sanitizedInput[0];
        String inputModel = sanitizedInput[1];
        String inputYear = sanitizedInput[2];
        String inputColor = sanitizedInput[3];
        String inputLiscence = sanitizedInput[4];


        if (root.make == null) {
            //System.out.println("Empty tree, assigning new root.");
            root.make = sanitizedInput[0];
            root.list.newCar(inputModel, inputYear, inputColor, inputLiscence, actingNode.list.root);
        } else {
            //System.out.println("Current root: " + root.make);
            //System.out.println("Value of " + newEntry + " to " + actingNode.make + "= " + newEntry.compareTo(actingNode.make));
            if (inputMake.compareTo(actingNode.make) < 0) {
                //System.out.println("Alphabetically before");

                if (actingNode.left != null) {
                    newNode(newEntry, actingNode.left);
                } else {
                    //System.out.println("Making new left child.");
                    actingNode.left = new DBTreeNode();
                    actingNode.left.make = sanitizedInput[0];
                    //System.out.println(inputLiscence);
                    actingNode.left.list.newCar(inputModel, inputYear, inputColor, inputLiscence, actingNode.list.root);


                }

            } else if (inputMake.compareTo(actingNode.make) == 0) {
                actingNode.list.newCar(inputModel, inputYear, inputColor, inputLiscence, actingNode.list.root);



            } else if (inputMake.compareTo(actingNode.make) > 0) {
                //System.out.println("Alphabetically after");
                if (actingNode.right != null) {
                    newNode(newEntry, actingNode.right);
                } else {
                    //System.out.println("Making new right child.");
                    actingNode.right = new DBTreeNode();
                    actingNode.right.make = sanitizedInput[0];
                    //System.out.println(inputLiscence);
                    actingNode.right.list.newCar(inputModel, inputYear, inputColor, inputLiscence, actingNode.list.root);




                }
            }

        }

    }

    public String[] shatterInput(String input, int tableDesignation, int lastVisited) {
        input = input.replaceAll("\\s+","");
        String[] shatteredOutput = new String[5];
        for (int i = 0; i <= input.length()-1; i++) {
            //System.out.print(input.charAt(i));
            if (input.charAt(i) == ',') {
                shatteredOutput[tableDesignation] = (input.substring(lastVisited, i));
                //System.out.println(shatteredOutput[i]);
                lastVisited=i+1;
                tableDesignation++;
            }
            //Grab the license plate
            shatteredOutput[tableDesignation] = input.substring(lastVisited);
        }

        //System.out.println(Arrays.toString(shatteredOutput));
        return shatteredOutput;
    }

    public void findMatchingMake(String query, DBTreeNode actingNode) {

        if (actingNode.left != null) {
            findMatchingMake(query, actingNode.left);
        }


        if (actingNode.make.equals(query)) {
            actingNode.list.printList();

        }

        if (actingNode.right != null) {
            findMatchingMake(query, actingNode.right);
        }



    }
    public int findMatchingModel(String query, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMatchingModel(query, actingNode.left);
        }


        //TODO: Also put make above output?
        modelsFound += actingNode.list.findModel(query, actingNode.list.root);




        if (actingNode.right != null) {
            findMatchingModel(query, actingNode.right);
        }
        return modelsFound;
    }
    public int findMatchingYear(int query, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMatchingYear(query, actingNode.left);
        }


        //TODO: Also put make above output?
        modelsFound += actingNode.list.findYear(String.valueOf(query));




        if (actingNode.right != null) {
            findMatchingYear(query, actingNode.right);
        }
        return modelsFound;
    }
    public int findMatchingColor(String query, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMatchingColor(query, actingNode.left);
        }


        //TODO: Also put make above output?
        modelsFound += actingNode.list.findColor(query);




        if (actingNode.right != null) {
            findMatchingColor(query, actingNode.right);
        }
        return modelsFound;
    }

    public boolean findMatchingLicense(String query, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMatchingLicense(query, actingNode.left);
        }


        //TODO: Also put make above output?
        fullLicenseFound = actingNode.list.findLicense(query);




        if (actingNode.right != null) {
            findMatchingLicense(query, actingNode.right);
        }

        return fullLicenseFound;

    }

    public boolean findMatchingPartialLicense(String query, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMatchingPartialLicense(query, actingNode.left);
        }


        //TODO: Also put make above output?
        fullLicenseFound = actingNode.list.findPartialLicense(query);




        if (actingNode.right != null) {
            findMatchingPartialLicense(query, actingNode.right);
        }

        return fullLicenseFound;

    }

    public void findMakeandColor(String colorQuery, String makeQuery, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMakeandColor(colorQuery, makeQuery, actingNode.left);
        }


        if (actingNode.make.equals(makeQuery)) {
            actingNode.list.findColor(colorQuery);

        }

        if (actingNode.right != null) {
            findMakeandColor(colorQuery, makeQuery, actingNode.right);
        }
    }

    public void findColorandPartialLicesne(String colorQuery, String partialLicenseQuery, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findMakeandColor(colorQuery, partialLicenseQuery, actingNode.left);
        }


        if (findMatchingPartialLicense(partialLicenseQuery, root)) {
            actingNode.list.findColor(colorQuery);

        }

        if (actingNode.right != null) {
            findMakeandColor(colorQuery, partialLicenseQuery, actingNode.right);
        }
    }

    public void findCarsInYearSet(int startingYear, int endingYear, DBTreeNode actingNode) {
        if (actingNode.left != null) {
            findCarsInYearSet(startingYear, endingYear, actingNode.left);
        }


        actingNode.list.findCarInYearSet(startingYear, endingYear);

        if (actingNode.right != null) {
            findCarsInYearSet(startingYear, endingYear, actingNode.right);
        }
    }




    public static void printTree(DBTreeNode actingNode) {

        if (actingNode.left != null) {
            printTree(actingNode.left);
        }


        System.out.println("====================" + actingNode.make + "======================");
        //System.out.print("Node data: ");
        actingNode.list.printList();

        if (actingNode.right != null) {
            printTree(actingNode.right);
        }



    }



    public static class DBTreeNode {
        String make;
        DBTreeNode left,right;
        CarList list = new CarList();
    }
}
