package Array;

import java.util.Arrays;

/**
 * Created by Chiradeep Banerjee
 * Email : chiradeep.banerjee72@gmail.com.
 */
public class AnagramCheck {

    boolean isAnagram(String firstWord, String secondWord){
        boolean isAna = false;
        char frst[] = firstWord.toCharArray();
        char scnd[] = secondWord.toCharArray();
        Arrays.sort(frst);
        Arrays.sort(scnd);
        for(int i=0;i<frst.length;i++){
            if(frst[i]==scnd[i]){
                isAna = true;
                continue;
            }
            else
                break;
        }
        return isAna;


    }

    public static void main(String args[]){
        System.out.print(new AnagramCheck().isAnagram("abcd","dcba"));
    }
}
