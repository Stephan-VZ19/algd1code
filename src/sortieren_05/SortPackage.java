package sortieren_05; 

import java.util.Arrays;

/**
 * 
 * @author Christoph Stamm
 *
 */
public class SortPackage {
    public static enum Method { SelectionSort, InsertionSort, JDKSort }
    
    private double[] m_array;
    
    public SortPackage(int size) {
        m_array = new double[size];
    }
    
    private SortPackage(double[] data) {
        m_array = data;
    }
    
    public double[] getData() { return m_array; }
    public void setData(double[] data) { m_array = data; }
    
    public void print() {
        System.out.println(Arrays.toString(m_array));
    }
    
    public void randomOrder() {
        for (int i=0; i < m_array.length; i++) {
            m_array[i] = Math.random();
        }
    }

    public void increasingOrder() {
        randomOrder();
        sortJDK();
    }
    
    public void decreasingOrder() {
        randomOrder();
        sortJDK();
        
        // reverse order (ArrayUtils.reverse())
        for (int i=0; i < m_array.length/2; i++) {
            double tmp = m_array[i];
            m_array[i] = m_array[m_array.length - 1 - i];
            m_array[m_array.length - 1 - i] = tmp;
        }
    }
    
    /**
     * Gibt true zur�ck, falls das Array aufsteigend sortiert ist.
     * Aufwand: linear in der L�nge des Arrays
     * @return true, falls das Array aufsteigend geordnet ist, ansonsten false.
     */
    public boolean isSorted() {
        int i=1;
        while (i<m_array.length && m_array[i-1] <= m_array[i]) i++;
        return i == m_array.length;
    }
    
    /**
     * Ordnet alle Werte des Arrays in aufsteigender Reihenfolge.
     * Aufwand: quadratisch in der L�nge des Arrays: O(n^2)
     * Methode: Sortieren durch direktes Ausw�hlen.
     */
    public void selectionSort() {
    	for (int last=m_array.length-1; last>0; last--) {
            int maxPos = 0;
            double max = m_array[maxPos];
            for (int i=1; i<=last; i++) {
                if (m_array[i]>max) {
                    maxPos = i;
                    max = m_array[maxPos];
                }
            }
            m_array[maxPos] = m_array[last];
            m_array[last] = max;
        }
    }

    /**
     * Ordnet alle Werte des Arrays in aufsteigender Reihenfolge.
     * Aufwand: quadratisch in der L�nge des Arrays: O(n^2)
     * Methode: Sortieren durch direktes Einf�gen.
     */
    public void insertionSort() {
    	for (int i=1; i<m_array.length; i++) {
            double x = m_array[i];
            int j = i-1;
            while( j>=0 && m_array[j] > x) {
                m_array[j+1] = m_array[j];
                j--;
            }
            m_array[j+1] = x;
        }
    }
    
    /**
     * Ordnet alle Werte des Arrays in aufsteigender Reihenfolge.
     * Aufwand: im Durchschnitt O(n log n), im schlechtesten Fall: O(n^2)
     * Methode: Sortieralgorithmus von Java SDK (Quicksort-Variante).
     */
    public void sortJDK() {
        Arrays.sort(m_array);
    }
        
    public long sort(Method m) {
        long start = System.currentTimeMillis();
        switch(m) {
            case SelectionSort: selectionSort(); break;
            case InsertionSort: insertionSort(); break;
            case JDKSort: sortJDK(); break;
            default:
                assert false : "unhandled method";
        }
        return System.currentTimeMillis() - start;      
    }
    
   /**
     * Sortiert die gegebenen Daten mit der Methode m 
     */
    public static long sort(double[] data, Method m) {
        SortPackage sp = new SortPackage(data);
        long time = sp.sort(m);
        return time;
    }
}
