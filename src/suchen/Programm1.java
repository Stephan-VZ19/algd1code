package suchen;

/**
 * Wächtersuche mit der Arraylänge plus 1
 */
public class Programm1 {

    public static void main(String[] args) {
        
        final int count = 10;

        int[] array = new int[count];
        for ( int i=0; i<array.length; i++) {
            array[i] = (int) (100 * Math.random());
        }

        int value = 54;

        int i=0;
        boolean found = false;
        
        int[] a2 = new int[count+1];
        a2[a2.length-1] = value;
        for( int j=0; j<array.length; j++) {
            a2[j] = array[j];
        }

        while(a2[i] != value) i++;
        found = (i < a2.length-1);

        System.out.println("Value found: " + found);
        System.out.println("At index: " + i);

    }
    
}
