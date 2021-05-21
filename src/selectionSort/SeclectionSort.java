package selectionSort;

public class SeclectionSort {

    public static void main(String[] args) {
        
        int[] array = new int[10];

        System.out.println("Array length: " +array.length);

        for(int i=0; i<array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        printArray(array);

        int[] array1 = array.clone();
        selctionSort(array1);

        printArray(array1);

        System.out.println("check");

    }

    public static void selctionSort(int[] array) {

        for( int i=0; i<array.length-1; i++) {

            int min = i;
            for ( int j=i+1; j<array.length; j++) {

                if ( array[j] <= array[min]) {
                    min = j;
                }

            }
            int buffer = array[min];
            array[min] = array[i];
            array[i] = buffer;
           
        }

    }

    public static void printArray(int[] array) {

        for(int i=0; i<array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}
