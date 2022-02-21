package biggestInt;

public class BiggestInt {

    public static void main(String[] args) {

        System.out.println("The biggest Int Number is: "+ findNumber());

    }

    public static int findNumber() {
        int x = 1;
        while (x > 0 && !((Integer.MIN_VALUE & x) > 0) ) {
            if (x++ >0) {
                x <<= 1;
                x += 1;
            }
        }
        return x;
    }

}
