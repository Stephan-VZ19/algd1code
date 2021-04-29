package suchen;

/**
 * Wächtersuche mit gleicher Array Länge
 */
public class Programm2 {

    public static void main(String[] args) {
        
        final int count = 10000;

        int[] array = new int[count];
        for ( int i=0; i<array.length; i++) {
            array[i] = (int) (100 * Math.random());
        }

        int value = 53;

        int i=0;
        boolean found = false;
        if (value != array[array.length-1]) {
            array[array.length-1] = value;
        } else {
            found = true;
            i = array.length-1;
        }
        if (!found) {
            while ( array[i] != value) i++;
            found = (i < array.length-1);
        }

        System.out.println("Value found: " + found);
        System.out.println("At index: " + i);
    }

}