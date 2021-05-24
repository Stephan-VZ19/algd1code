package sortieren_05; 

public class SortingTests {
    static enum Order { Random, Increasing, Decreasing };
    
    static void test(int size, Order order) {
        long time;
        SortPackage sp = new SortPackage(size);
        double[] data = null;
        
        switch(order) {
        case Random:
            System.out.println("\nzuf�llige Folge von " + size + " ganzen Zahlen");
            sp.randomOrder();
            break;
        case Increasing:
            System.out.println("\naufsteigende Folge von " + size + " ganzen Zahlen");
            sp.increasingOrder(); 
            break;
        case Decreasing:
            System.out.println("\nabsteigende Folge von " + size + " ganzen Zahlen");
            sp.decreasingOrder();
            break;
        }
        data = sp.getData();
        
        // SelectionSort
        sp.setData(data.clone());
        time = sp.sort(SortPackage.Method.SelectionSort);
        System.out.println("Sortieren durch Ausw�hlen dauert: " + time + " ms, sortiert: " + sp.isSorted());

        // InsertionSort
        sp.setData(data.clone());
        time = sp.sort(SortPackage.Method.InsertionSort);
        System.out.println("Sortieren durch Einf�gen dauert: " + time + " ms, sortiert: " + sp.isSorted());

        // JDK Sort
        sp.setData(data.clone());
        time = sp.sort(SortPackage.Method.JDKSort);
        System.out.println("Sortieren mit JDK dauert: " + time + " ms, sortiert: " + sp.isSorted());
        
    }
    
    public static void main(String[] args) {
        test(10000, Order.Random);
        test(10000, Order.Decreasing);
        test(10000, Order.Increasing);
        System.out.println();
    }

}
