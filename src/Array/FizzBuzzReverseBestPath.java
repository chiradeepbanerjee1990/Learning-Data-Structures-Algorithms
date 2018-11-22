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
    HashMap<ArrayList<Integer>, Integer> myMap;
    int outputArr[];
    static String myFizzBuzz[];


    public static void main(String args[]) {
        myFizzBuzz = new String[]{"fizz", "buzz", "fizzbuzz"};
        new FizzBuzzReverseBestPath().getReverseFizzBuzz(myFizzBuzz);

    }

    private int[] getReverseFizzBuzz(String inputArr[]) {

        int fizzbuzzCount = 0;
        myMap = new HashMap<>();
        ArrayList<Integer> myList = new ArrayList<>(inputArr.length);

        //Find the number of "fizzbuzz" in the inputArr
        int i = 0;
        do {
            if (inputArr[i] == "fizzbuzz") {
                fizzbuzzCount++;
            }
            i++;
        } while (i < inputArr.length);

        System.out.println("FizzBuzz word count::" + fizzbuzzCount);

        //Create Three diff arrays
        //15,30,45...fizzBuzz series.
        int rangeLength = fizzbuzzCount * 15;

        int fizzArrMaxLength = rangeLength / 3 - 1;
        int buzzArrMaxLength = rangeLength / 5 - 1;
        int fizzBuzzArrMaxLength = rangeLength / 15;

        fizzArr = new int[fizzArrMaxLength];
        buzzArr = new int[buzzArrMaxLength];
        fizzBuzzArr = new int[fizzBuzzArrMaxLength];
        int index = 1;
        for (int j = 0; j < fizzArrMaxLength; j++) {

            fizzArr[j] = 3 * index;
            index++;
        }
        index = 1;
        for (int j = 0; j < buzzArrMaxLength; j++) {

            buzzArr[j] = 5 * index;
            index++;
        }
        index = 1;
        for (int j = 0; j < fizzBuzzArrMaxLength; j++) {

            fizzBuzzArr[j] = 15 * index;
            index++;
        }

        callRecursively(inputArr, myList, fizzArrMaxLength, buzzArrMaxLength, fizzBuzzArrMaxLength, 1);

        return outputArr;
    }

    private void callRecursively(String inputArr[], ArrayList<Integer> myList, int fizzArrMaxLength,
                                 int buzzArrMaxLength, int fizzBuzzArrMaxLength, int globalIndex) {
        int index = globalIndex;
        myList = new ArrayList<>();
        outputArr = decideShortestFizzBuzz(inputArr, inputArr.length);
        for (int k = 0; k < outputArr.length; k++) {
            myList.add(outputArr[k]);
            System.out.println("elements Are::" + outputArr[k]);
        }

        myMap.put(myList, getMax(outputArr) - getMin(outputArr));


        if (index == 1) {
            index++;
        }
        //Here Recursive Call Happens

        int localIndex = index;
        fizzArr = new int[fizzArrMaxLength - 1];
        for (int j = 0; j < fizzArrMaxLength - 1; j++) {

            fizzArr[j] = 3 * localIndex;
            localIndex++;
        }

        if (globalIndex > 0) {
            localIndex = index;
            buzzArr = new int[buzzArrMaxLength - 1];
            for (int j = 0; j < buzzArrMaxLength - 1; j++) {

                buzzArr[j] = 5 * localIndex;
                localIndex++;
            }

            int fizzBuzzIndex = 1;
            for (int j = 0; j < fizzBuzzArrMaxLength; j++) {

                fizzBuzzArr[j] = 15 * fizzBuzzIndex;
                fizzBuzzIndex++;
            }

            if (globalIndex <= buzzArrMaxLength) {
                globalIndex++;
                callRecursively(inputArr, myList, fizzArrMaxLength, buzzArrMaxLength, fizzBuzzArrMaxLength, globalIndex);
            } else {
                Iterator it = myMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    System.out.println("Shortest Path::" + pair.getKey() + " RouteValue: " + pair.getValue());
                }
            }
        }


    }

    public static int getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static int getMin(int[] inputArray) {
        int minValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] < minValue) {
                minValue = inputArray[i];
            }
        }
        return minValue;
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
