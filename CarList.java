package DB;


public class CarList {


    public CarListNode root = new CarListNode();

    public void newCar(String model, String year, String color, String liscence, CarListNode actingNode) {
        if (root.model == null) {
            //System.out.println("Assigning root.");
            root.model = model;
            root.year = year;
            root.color = color;
            root.preLiscence = liscence;
        } else {
            if (actingNode.next == null) {
                actingNode.next = new CarListNode();
                actingNode.next.model = model;
                actingNode.next.year = year;
                actingNode.next.color = color;
                actingNode.next.preLiscence = liscence;
            } else {
                newCar(model, year, color, liscence, actingNode.next);
            }
        }



    }


    public void printList() {
        //System.out.println("Database report, code written by Nick Warner.");

        CarListNode acting = root;
        int carCount = 0 ;


        acting = root;
        while (acting != null) {
            System.out.println(acting.model);
            System.out.println("------------");
            System.out.println(acting.year);
            System.out.println(acting.color);
            System.out.println(acting.preLiscence);
            System.out.println("\n");
            carCount++;
            acting=acting.next;
        }
    }


    public int findNumberOfCars() {
        CarListNode acting = root;
        int carCount=0;

        acting = root;
        while (acting != null) {
            carCount++;
            acting=acting.next;
        }

        return carCount;

    }


    public int findModel (String query, CarListNode actingNode) {
        CarListNode acting = root;
        int matchCount = 0;
        while (acting != null) {
            if (acting.model.compareTo(query)==0) {
                System.out.println(acting.model);
                System.out.println("------------");
                System.out.println(acting.year);
                System.out.println(acting.color);
                System.out.println(acting.preLiscence+"\n");
                matchCount++;
            }



            acting = acting.next;

        }

        return matchCount;

    }

    public int findYear (String query) {
        CarListNode acting = root;
        int matchCount = 0;
        while (acting != null) {


            if (acting.year.compareTo(query)==0) {
                System.out.println(acting.model);
                System.out.println("------------");
                System.out.println(acting.year);
                System.out.println(acting.color);
                System.out.println(acting.preLiscence+"\n");
                matchCount++;
            }




            acting = acting.next;

        }

        return matchCount;


    }

    public int findColor (String query) {
        CarListNode acting = root;
        int matchCount = 0;
        while (acting != null) {


            if (acting.color.compareTo(query)==0) {
                System.out.println(acting.model);
                System.out.println("------------");
                System.out.println(acting.year);
                System.out.println(acting.color);
                System.out.println(acting.preLiscence+"\n");
                matchCount++;
            }




            acting = acting.next;

        }

        return matchCount;


    }

    public boolean findLicense (String query) {
        CarListNode acting = root;
        boolean found = false;
        while (acting != null) {

            //System.out.println(acting.preLiscence + " compared to " + query + ": " + acting.preLiscence.compareTo(query));

            for (int i = 0; i < acting.preLiscence.length(); i++) {
                if (!Character.isDigit(acting.preLiscence.charAt(i)) && !Character.isAlphabetic(acting.preLiscence.charAt(i))) {
                    acting.preLiscence = acting.preLiscence.replace(String.valueOf(acting.preLiscence.charAt(i)), "");
                }

            }

            if (acting.preLiscence.compareTo(query)==0) {
                System.out.println(acting.model);
                System.out.println("------------");
                System.out.println(acting.year);
                System.out.println(acting.color);
                System.out.println(acting.preLiscence+"\n");
                found = true;
            }




            acting = acting.next;

        }

        return found;



    }


    public boolean findPartialLicense (String query) {
        CarListNode acting = root;
        boolean found = false;
        while (acting != null) {

            //System.out.println(acting.preLiscence + " compared to " + query + ": " + acting.preLiscence.compareTo(query));

            for (int i = 0; i < acting.preLiscence.length(); i++) {
                if (!Character.isDigit(acting.preLiscence.charAt(i)) && !Character.isAlphabetic(acting.preLiscence.charAt(i))) {
                    acting.preLiscence = acting.preLiscence.replace(String.valueOf(acting.preLiscence.charAt(i)), "");
                }

            }

            if (acting.preLiscence.toLowerCase().contains(query)) {
                System.out.println(acting.model);
                System.out.println("------------");
                System.out.println(acting.year);
                System.out.println(acting.color);
                System.out.println(acting.preLiscence+"\n");
                found = true;
            }




            acting = acting.next;

        }

        return found;



    }


    public void findCarInYearSet(int startingYear, int endingYear) {
        CarListNode acting = root;
        while (acting != null) {

            //System.out.println(acting.preLiscence + " compared to " + query + ": " + acting.preLiscence.compareTo(query));



            if (Integer.parseInt(acting.year) >= startingYear && Integer.parseInt(acting.year) <= endingYear) {
                System.out.println(acting.model);
                System.out.println("------------");
                System.out.println(acting.year);
                System.out.println(acting.color);
                System.out.println(acting.preLiscence+"\n");
            }




            acting = acting.next;

        }

    }
    public static class CarListNode {
        String make, model, color, preLiscence, postLiscence, year;
        CarListNode next;
    }
}
