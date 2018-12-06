package DB;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Database {

    public static void main (String args[]) {

        DatabaseBST centralDB = new DatabaseBST();


        centralDB.filler();
        centralDB.populateDatabase(DatabaseBST.root);


        boolean done = false;
        try {
            while (!done) {
                Scanner reader = new Scanner(System.in);
                System.out.println("\n====== The *AMAZING* Car Database System ====== ");
                System.out.println("0) Print database report");
                System.out.println("1) Find all cars with certain make");
                System.out.println("2) Find all cars with certain model");
                System.out.println("3) Find all cars with certain year");
                System.out.println("4) Find all cars with certain color");
                System.out.println("5) Full license plate search");
                System.out.println("6) Partial license plate search");
                System.out.println("7) Specified make and color search");
                System.out.println("8) Specified color and partial license search");
                System.out.println("9) Cars in a specified date range");
                System.out.println("===============================================\n");
                System.out.print("What would you like to do?: ");
                int choice = reader.nextInt();


                //Finding matching makes.
                if (choice == 0) {
                    //System.out.println("DB contains: " + centralDB.findNumberOfCars(DatabaseBST.root));
                    //DatabaseBST.printTree(DatabaseBST.root);
                }
                if (choice == 1) {
                    System.out.print("What make are we searching for?: ");
                    String makeQuery = reader.next();
                    System.out.println("======================");
                    System.out.println("Requested query: All " + makeQuery + "s.");
                    System.out.println("======================\n");
                    centralDB.findMatchingMake(makeQuery, DatabaseBST.root);
                }

                if (choice == 2) {
                    System.out.print("What model are we searching for?: ");
                    String modelQuery = reader.next();
                    System.out.println("======================");
                    System.out.println("Requested query: All " + modelQuery + "s.");
                    System.out.println("======================\n");
                    System.out.println("Models found: " + centralDB.findMatchingModel(modelQuery, DatabaseBST.root));
                }

                if (choice == 3) {
                    System.out.print("What year are we searching for?: ");
                    int yearQuery = reader.nextInt();
                    System.out.println("======================");
                    System.out.println("Requested query: All " + yearQuery + "s.");
                    System.out.println("======================\n");
                    System.out.println("Models found: " + centralDB.findMatchingYear(yearQuery, DatabaseBST.root));

                }

                if (choice == 4) {
                    System.out.print("What color are we searching for?: ");
                    String colorQuery = reader.next();
                    System.out.println("======================");
                    System.out.println("Requested query: All " + colorQuery + " cars.");
                    System.out.println("======================\n");
                    System.out.println("Models found: " + centralDB.findMatchingColor(colorQuery, DatabaseBST.root));
                }

                if (choice == 5) {
                    System.out.print("What license are we searching for?: ");
                    reader.nextLine();
                    String licenseQuery = reader.nextLine();
                    //Removing all special characters/whitespace
                    licenseQuery = licenseQuery.replaceAll("\\s+","");
                    //System.out.println(licenseQuery);
                    for (int i = 0; i < licenseQuery.length(); i++) {
                        if (!Character.isDigit(licenseQuery.charAt(i)) && !Character.isAlphabetic(licenseQuery.charAt(i))) {
                            licenseQuery = licenseQuery.replace(String.valueOf(licenseQuery.charAt(i)), "");
                        }


                    }




                    System.out.println("======================");
                    System.out.println("Requested query: All " + licenseQuery + " cars.");
                    System.out.println("======================\n");
                    if (!centralDB.findMatchingLicense(licenseQuery, DatabaseBST.root)) {
                        System.out.println("Liscense not found in database.");
                    }

                }

                if (choice == 6) {
                    System.out.print("What partial license are we searching for?: ");
                    reader.nextLine();
                    String licenseQuery = reader.nextLine();
                    //Removing all special characters/whitespace
                    licenseQuery = licenseQuery.replaceAll("\\s+","");
                    //System.out.println(licenseQuery);
                    for (int i = 0; i < licenseQuery.length(); i++) {
                        if (!Character.isDigit(licenseQuery.charAt(i)) && !Character.isAlphabetic(licenseQuery.charAt(i))) {
                            licenseQuery = licenseQuery.replace(String.valueOf(licenseQuery.charAt(i)), "");
                        }


                    }




                    System.out.println("======================");
                    System.out.println("Requested query: All " + licenseQuery.toLowerCase() + " cars.");
                    System.out.println("======================\n");
                    if (!centralDB.findMatchingPartialLicense(licenseQuery.toLowerCase(), DatabaseBST.root)) {
                        System.out.println("License not found in database.");
                    }

                }

                if (choice == 7) {
                    System.out.print("What make are we looking for?: ");
                    String make = reader.next();
                    System.out.print("What color are we looking for?: ");
                    String color = reader.next();
                    System.out.println("======================");
                    System.out.println("Requested query: All " + make + " cars that are " + color);
                    System.out.println("======================\n");
                    centralDB.findMakeandColor(color,make, DatabaseBST.root);
                }
                
                if (choice == 8) {
                    System.out.print("What color are we looking for?: ");
                    String color = reader.next();
                    System.out.print("What partial license do we have to work with?: ");
                    String partialLicense = reader.next();

                    partialLicense = partialLicense.replaceAll("\\s+","");
                    //System.out.println(partialLicense);

                    System.out.println("======================");
                    System.out.println("Requested query: All cars that are " + color + " and that have " + partialLicense.toLowerCase() + " in the license plate.");
                    System.out.println("======================\n");

                    for (int i = 0; i < partialLicense.length(); i++) {
                        if (!Character.isDigit(partialLicense.charAt(i)) && !Character.isAlphabetic(partialLicense.charAt(i))) {
                            partialLicense = partialLicense.replace(String.valueOf(partialLicense.charAt(i)), "");
                        }


                    }

                    centralDB.findColorandPartialLicesne(color, partialLicense.toLowerCase(), DatabaseBST.root);
                }

                if (choice == 9) {
                    System.out.print("Where does your range begin?: ");
                    int startingYear = reader.nextInt();
                    System.out.print("Where does your range end?: ");
                    int endingYear = reader.nextInt();

                    if (startingYear > endingYear) {
                        System.out.println("Cannot check for invalid date ranges.");
                    } else {
                        centralDB.findCarsInYearSet(startingYear, endingYear, DatabaseBST.root);
                    }
                }




            }
        } catch (InputMismatchException oops) {
            System.out.println("Oops! Can only take numbers. Pleae try again.\n");

        }
}






}
