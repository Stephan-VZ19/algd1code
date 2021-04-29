package suchen;

/**
 * Boolean binary search
 */
public class BinarySearch1 {

    public static void main(String[] args) {

        System.out.println("Test");
        
        

    }
    
    public static boolean binarySearch(byte[] a, byte value) {

        int first = -1;
        int last = a.length;

        while (first <= last) {
            int m = (first + last) >>> 1; 
            if (a[m] < value) {
            first = m + 1;
            } else if (a[m] == value) {
            return true;
            } else {
            last = m - 1;
            }
        }






        return false;
    }

}
