package _05_Sortieren; 

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
     * Gibt true zurück, falls das Array aufsteigend sortiert ist.
     * Aufwand: linear in der Länge des Arrays
     * @return true, falls das Array aufsteigend geordnet ist, ansonsten false.
     */
    public boolean isSorted() {
    	// TODO
    	return false;
    }
    
    /**
     * Ordnet alle Werte des Arrays in aufsteigender Reihenfolge.
     * Aufwand: quadratisch in der Länge des Arrays: O(n^2)
     * Methode: Sortieren durch direktes Auswählen.
     */
    public void selectionSort() {
    	// TODO
    }

    /**
     * Ordnet alle Werte des Arrays in aufsteigender Reihenfolge.
     * Aufwand: quadratisch in der Länge des Arrays: O(n^2)
     * Methode: Sortieren durch direktes Einfügen.
     */
    public void insertionSort() {
    	// TODO
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
