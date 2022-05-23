package ch.fhnw.algd1.mergesort;

public class MergesortSimple {
	public void mergesort(int[] a) {
		// TODO implement header method to start recursive sorting
		sort(a, 0, a.length);

	}

	private void sort(int[] a, int beg, int end) {
		// TODO implement recursive sorting with merge sort strategy
		if ((end - beg) > 1) {
			int m = (beg + end) >>> 1;
			sort(a, beg, m);
			sort(a, m, end);
			merge(a, beg, m, end);
		}

	}

	// Merges sequence a[beg...m-1] with a[m...end-1] into a[beg...end-1]
	private void merge(int[] a, int beg, int m, int end) {
		int[] b = new int[end - beg];
		// TODO copy elements from a[beg...m-1] and a[m...end-1] to b[0...]
		int i=0, j=beg, k=m;
		while (j != m || k != end) {
			if (k == end || j < m && a[j] <= a[k]) {
				b[i++] = a[j++];
			} else {
				b[i++] = a[k++];
			}
		}
		// TODO copy all elements from b[0...] to a[beg...]
		while (i > 0) {
			i--;
			a[beg+i] = b[i];
		}
	}
}
