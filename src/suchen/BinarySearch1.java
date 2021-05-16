package suchen;

/**
 * binary search
 */
public class BinarySearch1 {

    public static void main(String[] args) {

        System.out.println("Log before");
        
        byte[] a = new byte[] {10};

        for (int i=0; i<a.length; i++) {
            a[i] = (byte) (i);
        }
        
        byte value = 7;
        int result = binarySearch(a, value);

        System.out.println(result);

        System.out.println("Log after");

    }
    
    public static int binarySearch(byte[] a, byte value) {

        int first = 0;
        int last = a.length-1;

        while (first <= last) {
            int m = (first + last) >>> 1; 
            if (a[m] < value) {
                first = m + 1;
            } else if (a[m] == value) {
                return m;
            } else {
            last = m - 1;
            }
        }
        return -1;
    }

}
