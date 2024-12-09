package tasks;

public class HistoricalPrices {

    public static void main(String[] args) {
        int[] priceArray1 = {4, 1, 2, 3};  //6   +4-1+3
        int[] priceArray2 = {1, 2, 3, 3, 2, 1, 5}; //7  +3 -1 +5
        int[] priceArray3 = {1, 2, 3, 1, 5, 1}; //7  +3 -1 +5
        System.out.println("--> " + solution(priceArray1));


    }

    public static int solution(int[] pricesArray) {
        int result = 0;
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
        if (weHaveActive) result+=pricesArray[pricesArray.length];
        return result;
    }
}

