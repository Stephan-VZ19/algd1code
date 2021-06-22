package kolmogorow;

public class String1 {

    public static void calculateString(int length) {
        int maxCount = 0;
        int control = 1;
        int zeroCount = 1;
        
        do {
            if (control > 0) {
                System.out.print(1);
                maxCount++;
            } else {
                for (int j=0; j<zeroCount; j++) {
                    System.out.print(0);
                    maxCount++;
                }
                zeroCount++;              
            }
            control *= -1;
        } while (maxCount < length);
    }

    public static void main(String[] args) {
        
        calculateString(60);

    }
}