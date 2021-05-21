package suchen;

/**
 * binary search
 */
public class BinarySearch1 {

    public static void main(String[] args) {

        System.out.println("Log before");
        
        byte[] a = new byte[10];

        for (int i=0; i<a.length; i++) {
            a[i] = (byte) (i);
        }
        
        byte value = 3;
        int result = binarySearch(a, value);

        System.out.println(result);

        System.out.println("Log after");

    }
    
    public static int binarySearch(byte[] a, byte value) {  // byte um einen overflow zu verhindern

        int first = -1;
        int last = a.length;

        while (first + 1 != last) {
            int m = (first + last) >>> 1; 
            if (a[m] < value) {
                first = m;
            } else if (a[m] > value) {
                last = m;
            } else {
                return m;
            }
        }
        return -1;
    }

}
