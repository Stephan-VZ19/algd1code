package backtracking;

public class Fibonacci {

    public static void main(String[] args) {

        calculateFibonacciIterative(15);
        
    }

    public static void calculateFibonacciIterative(int maxValue) {

        int value1 = 0;
        int value2 = 1;

        for (int i=0; i<maxValue; i++) {
            int t = value1;
            value1 = value2;
            value2 = t + value2;
            System.out.print(value1 + ", ");
        }
    }  
}
