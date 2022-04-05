package mada;

public class SiebDesEratos {

    public static void main(String[] args) {

        int[] arr = primFinder(120);

        for (int prim : arr) {

            if (arr[prim] != 0) {
                System.out.print(arr[prim] + " ");
            }

        }

    }

    public static int[] primFinder(int s) {

        int[] primNumbers = new int[s];

        int l = primNumbers.length;

        for (int i=0; i < l; i++) {
            primNumbers[i] = i;
        }

        for (int i=2; i < Math.sqrt(s); i++) {

            for (int j=i;j < l && primNumbers[j] != 0 && i != 0; j++) {

                if (j != i && (j % i) == 0) {
                    primNumbers[j] = 0;
                }
            }
        }

        return primNumbers;
    }

}
