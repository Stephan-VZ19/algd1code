package kolmogorow;

public class String3 {
    
    public static void calculateString(int length) {
        int maxCount = 0;
        int number = 1;
        String n1 = "1";
        String t1 = "0";   // buffer String
        
        do {
            System.out.print(n1);
            if (number%2 == 0) {
                n1 = t1;
                number++;
            } else {
                number <<= 1; 
                String t = n1;
                n1 = t + "0";
                t1 = t + "1";
                maxCount++;
            }
        } while (maxCount < length);
    }

    public static void main(String[] args) {
        
        calculateString(60);

    }

}
