package Array;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 */

/**
 * Reverse an array without using extra memory
 */
public class ReverseArray {

    public static void main(String[] args){
        int[] givenArray = new int[5];
        int[] reverseArray = new int[5];
        for(int i=0;i<5;i++)
            givenArray[i]=i+1;

        //easiest way to reverse an array
        for(int i=0,j=4;i<5;i++){
            reverseArray[i]=givenArray[j];
            j--;
        }
        for(int i=0;i<5;i++)
        System.out.println(reverseArray[i]);


        // Without using extra memory
        /**
         * Start two index from start = 0 and end = 4
         * decrement end by -1 and increment start by +1 and swap two variables
         */

        for(int i=0,j=4;i<5;i++){
            if(i==j)
                break;
            int temp = givenArray[j];
            givenArray[j]= givenArray[i];
            givenArray[i] = temp;
            j--;
        }

        for(int i=0;i<5;i++)
            System.out.println(givenArray[i]);
    }
}
