package tasks;

import java.util.Arrays;

public class HistoricalPrices {

    public static void main(String[] args) {
        int[][] testArray =  {{4, 1, 2, 3},   //6   +4-1+3
        {1, 2, 3, 3, 2, 1, 5}, //7  +3 -1 +5
        {1, 2, 3, 1, 5, 1}, //7  +3 -1 +5
        {1000000000,1,2, 2, 1000000000, 1, 1000000000},
        {1000}, //1000  +1000
        {1, 2, 1, 2, 1, 2}, //4  +2 -1 +2 -1 +2
        {1, 1, 1, 1, 1, 1}, //1  +1
        {4, 1, 2, 3, 2}, //6  +4 -1 +3
        {4, 1, 2, 3, 3}, //6  +4 -1 +3
        {4, 1, 2, 3, 4}}; //7  +4 -1 +4

        for (int i = 0; i < testArray.length; i++) {
            System.out.println("Array --> " + Arrays.toString(testArray[i])
                    + " ; Result --> " + solution(testArray[i]));
        }
    }

    public static int solution(int[] pricesArray) {
        long result = 0;
        boolean weHaveActive = true;
        for (int i = 0; i < pricesArray.length-1; i++) {
            if (weHaveActive && pricesArray[i+1]<pricesArray[i]) {
                result+=pricesArray[i];
                weHaveActive = false;
            } else if (!weHaveActive && pricesArray[i+1]>pricesArray[i]) {
                result-=pricesArray[i];
                weHaveActive = true;
            }
        }
        if (weHaveActive) result+=pricesArray[pricesArray.length-1];
        return (int) (result%1000000000);
    }
}

