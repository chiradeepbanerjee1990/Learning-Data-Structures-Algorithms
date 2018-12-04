package Data_Structure.Array;

import java.util.*;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 */

/**
 * The Program aims to get the Best Shortest path for a Reverse FizzBuzz Input
 * Sample Input: "fizz", "buzz", "fizzbuzz"
 * Output should be: 9,10,15 - Lowest path distance 6
 */
public class FizzBuzzReverseBestPath {
    int fizzArr[], buzzArr[], fizzBuzzArr[];
    int outputArr[];
    static String myFizzBuzz[];
    boolean trueSet;
    int howManyFizz = 0, howManyBuzz = 0, howManyFizzBuzz = 0;


    public static void main(String args[]) {
        myFizzBuzz = new String[]{"fizz", "buzz", "fizzbuzz", "fizz"};
        new FizzBuzzReverseBestPath().getReverseFizzBuzz(myFizzBuzz);

    }

    int recursionVal = 0;

    private int[] getReverseFizzBuzz(String inputArr[]) {
        trueSet = true;
        ArrayList<Integer> myList = new ArrayList<>(inputArr.length);

        for (int i = 0; i < inputArr.length; i++) {
            if (inputArr[i] == "fizz")
                howManyFizz++;
            if (inputArr[i] == "buzz")
                howManyBuzz++;
            if (inputArr[i] == "fizzbuzz")
                howManyFizzBuzz++;
        }

        //Create Three diff arrays
        //15,30,45...fizzBuzz series.
        fizzArr = new int[100000];
        buzzArr = new int[100000];
        fizzBuzzArr = new int[100000];
        int index = 0;
        for (int j = 3; j < 100000; j++) {
            int value = j;
            if (value % 5 != 0 && value % 3 == 0 && value % 15 != 0) {
                fizzArr[index] = value;
                index++;
            }
        }
        index = 0;
        for (int j = 5; j < 100000; j++) {
            int value = j;
            if (value % 5 == 0 && value % 3 != 0 && value % 15 != 0) {
                buzzArr[index] = value;
                index++;
            }
        }
        index = 0;
        for (int j = 15; j < 100000; j++) {
            int value = j;
            if (value % 5 == 0 && value % 3 == 0 && value % 15 == 0) {
                fizzBuzzArr[index] = value;
                index++;
            }
        }

        callRecursively(inputArr, myList,  0, 0, 0);
        return outputArr;
    }

    private void callRecursively(String inputArr[], ArrayList<Integer> myList, int fizzArrIndex,
                                 int buzzArrIndex, int fizzbuzzArrIndex) {
        try {
            Set<Integer> myUniqueSet;
            myList = new ArrayList<>();
            for (int i = 0; i < inputArr.length; i++) {
                if (inputArr[i] == "fizz") {
                    myList.add(fizzArr[fizzArrIndex]);
                    fizzArrIndex++;
                } else if (inputArr[i] == "buzz") {
                    myList.add(buzzArr[buzzArrIndex]);
                    buzzArrIndex++;
                } else if (inputArr[i] == "fizzbuzz") {
                    myList.add(fizzBuzzArr[fizzbuzzArrIndex]);
                    fizzbuzzArrIndex++;
                }
            }

            //Between list elements any other element is there ?
            ArrayList<Integer> checkAnyOtherElements = new ArrayList<>();
            for (int i = 0; i < myList.size(); i++) {
                checkAnyOtherElements.add(myList.get(i));
            }
            Collections.sort(checkAnyOtherElements);
            int counter = 0;
            if (inputArr.length == 3 ) {
                for (int i = checkAnyOtherElements.get(0);
                     i < checkAnyOtherElements.get(checkAnyOtherElements.size() - 1); i++) {

                    //For fizz check
                    if (i % 3 == 0 && i % 5 != 0 && i % 15 != 0) {
                        counter++;
                        trueSet = true;
                    }

                    //For buzz check
                    if (i % 3 != 0 && i % 5 == 0 && i % 15 != 0) {
                        counter++;
                        trueSet = true;

                    }
                    //For fizzbuzz check
                    if (i % 3 == 0 && i % 5 == 0 && i % 15 == 0) {
                        counter++;
                        trueSet = true;

                    }
                }
            } else {
                for (int i = checkAnyOtherElements.get(0);
                     i <= checkAnyOtherElements.get(checkAnyOtherElements.size() - 1); i++) {

                    //For fizz check
                    if (i % 3 == 0 && i % 5 != 0 && i % 15 != 0) {
                        counter++;
                        trueSet = true;
                    }

                    //For buzz check
                    if (i % 3 != 0 && i % 5 == 0 && i % 15 != 0) {
                        counter++;
                        trueSet = true;

                    }
                    //For fizzbuzz check
                    if (i % 3 == 0 && i % 5 == 0 && i % 15 == 0) {
                        counter++;
                        trueSet = true;

                    }
                }
            }

            //Check
            if (counter > myList.size()) {
                trueSet = false;
            }

            recursionVal++;
            if (trueSet == false) {
                fizzArrIndex = fizzArrIndex - howManyFizz;
                buzzArrIndex = buzzArrIndex - howManyBuzz;
                fizzbuzzArrIndex = fizzbuzzArrIndex - howManyFizzBuzz;
                if (fizzArr[fizzArrIndex + 1] > buzzArr[buzzArrIndex]) {
                    fizzArrIndex = fizzArrIndex + 1;
                }
                if (fizzArr[fizzArrIndex + 1] < buzzArr[buzzArrIndex]) {
                    fizzArrIndex = fizzArrIndex + 1;
                }

                if (fizzArr[fizzArrIndex] > buzzArr[buzzArrIndex]) {
                    buzzArrIndex = buzzArrIndex + 1;

                }
                if (fizzArr[fizzArrIndex] > fizzBuzzArr[fizzbuzzArrIndex]
                        && buzzArr[buzzArrIndex] > fizzBuzzArr[fizzbuzzArrIndex]) {
                    fizzbuzzArrIndex = fizzbuzzArrIndex + 1;
                }
                callRecursively(inputArr, myList, 100000, fizzArrIndex, buzzArrIndex, fizzbuzzArrIndex);
            } else {
                //Only for this particular iteration
                myUniqueSet = new HashSet<>(myList);
                Collections.sort(new ArrayList<Comparable>(myUniqueSet));
                HashMap<ArrayList<Integer>, Integer> myMap = new HashMap<>();
                myMap.put(new ArrayList<Integer>(myUniqueSet),
                        Collections.max(myList) - Collections.min(myList));

                Iterator it = myMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    System.out.println("Shortest Path::" + pair.getKey() + " Route Value: " + pair.getValue());
                }
            }

        } catch (StackOverflowError e) {
            System.out.print("===Did not found===");
        }


    }


    private int[] decideShortestFizzBuzz(String inputArr[], int length) {
        int returnArr[] = new int[length];
        int fizzIndex = 0, buzzIndex = 0, fizzBuzzIndex = 0;
        for (int i = 0; i < length; i++) {

            if (inputArr[i] == "fizz") {
                returnArr[i] = fizzArr[fizzIndex];
                fizzIndex++;
            }
            if (inputArr[i] == "buzz") {
                returnArr[i] = buzzArr[buzzIndex];
                buzzIndex++;
            }
            if (inputArr[i] == "fizzbuzz") {
                returnArr[i] = fizzBuzzArr[fizzBuzzIndex];
                fizzBuzzIndex++;
            }
        }


        return returnArr;
    }


}
