package kolmogorow;

public class String2 {

    public static void calculateString(int length) {
        int maxCount = 0;
        int control = 1;
        int fibonacci1 = 0;
        int fibonacci2 = 1;
        
        do {
            if (control > 0) {
                for(int i=0; i<fibonacci1+fibonacci2; i++) {
                    System.out.print(1);
                    maxCount++;
                }
                int t = fibonacci1;
                fibonacci1 = fibonacci2;
                fibonacci2 = t + fibonacci2;
                control *= -1;
            } else {
                for(int i=0; i<fibonacci1+fibonacci2; i++) {
                    System.out.print(0);
                    maxCount++;
                }
                int t = fibonacci1;
                fibonacci1 = fibonacci2;
                fibonacci2 = t + fibonacci2;
                control *= -1;            
            }
        } while (maxCount < length);
    }

    public static void main(String[] args) {
        
        calculateString(60);

    }
    
}
