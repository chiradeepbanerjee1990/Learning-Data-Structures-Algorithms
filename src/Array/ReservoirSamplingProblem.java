package Array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 *
 * Reservoir sampling problem overview
   Our task is to design an algorithm that's capable of selecting k items from an array!
  The problem is that the n size of the array is unknown (or infinitely large)!
 */
public class ReservoirSamplingProblem {

    static void selectKItems(int stream[], int n, int howManyNumbers)
    {
        int i;   // index for elements in stream[]

        // reservoir[] is the output array. Initialize it with
        // first howManyNumbers elements from stream[]. Basically its done to fill up the array from 0 to howManyNumbers position
        // from Stream
        int reservoir[] = new int[howManyNumbers];
        for (i = 0; i < howManyNumbers; i++)
            reservoir[i] = stream[i];

        Random r = new Random();

        System.out.println("Value of I:::"+i);
        // Iterate from the (howManyNumbers+1)th element to nth element as we have already inserted first howManyNumbers elements.
        // "i" will start from i+1 index. So need to reinitialize
        for (; i < n; i++)
        {
            // Pick a random index from 0 to i to make variation.
            int j = r.nextInt(i)+1;
            System.out.print("\nRandom Number:::"+j);

            // If the randomly  picked index is smaller than howManyNumbers,
            // then replace the element present at the index
            // with new element from stream. So, that first added loop elements will be replaced
            if(j < howManyNumbers) {
                reservoir[j] = stream[i];
                System.out.print("    Stored Number:::" + reservoir[j]+ "  Value of i::"+i);
            }
        }

        System.out.println("\nFollowing are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }

    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 4;
        selectKItems(stream, n, k);
    }
}
