package suchen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for binary search variants.
 *
 * @author Christoph Stamm
 * @version 18.3.2020
 */

class BinaereSucheTests {
	final byte part = 100;

	byte[] a0, a1, a2, a3, a4, a8, a9, a2Mia;
	
	@BeforeEach
	void setUp() throws Exception {
		a0 = new byte[0];
		a1 = new byte[] {5};
		a2 = new byte[] {4,5};
		a3 = new byte[] {4,5,6};
		a4 = new byte[] {4,5,5,6};
		a8 = new byte[] {4,5,5,5,5,5,5,6};
		a9 = new byte[] {4,5,5,5,5,5,5,5,6};
		a2Mia = new byte[2_000_000_000];
		int pos = 0;
		for(int i = 1; i <= part; i++) 
			for(int j = 0; j < a2Mia.length/part; j++) a2Mia[pos++] = (byte)i;
	}

	@Test
	void testBinarySearch() {
		assertFalse(BinaereSuche.binarySearch(a0, (byte)5));
		
		assertFalse(BinaereSuche.binarySearch(a1, (byte)4));
		assertTrue(BinaereSuche.binarySearch(a1, (byte)5));
		assertFalse(BinaereSuche.binarySearch(a1, (byte)6));
		
		assertFalse(BinaereSuche.binarySearch(a2, (byte)3));
		assertTrue(BinaereSuche.binarySearch(a2, (byte)4));
		assertTrue(BinaereSuche.binarySearch(a2, (byte)5));
		assertFalse(BinaereSuche.binarySearch(a2, (byte)6));

		assertFalse(BinaereSuche.binarySearch(a3, (byte)3));
		assertTrue(BinaereSuche.binarySearch(a3, (byte)4));
		assertTrue(BinaereSuche.binarySearch(a3, (byte)5));
		assertTrue(BinaereSuche.binarySearch(a3, (byte)6));
		assertFalse(BinaereSuche.binarySearch(a3, (byte)7));

		assertFalse(BinaereSuche.binarySearch(a4, (byte)3));
		assertTrue(BinaereSuche.binarySearch(a4, (byte)4));
		assertTrue(BinaereSuche.binarySearch(a4, (byte)5));
		assertTrue(BinaereSuche.binarySearch(a4, (byte)6));
		assertFalse(BinaereSuche.binarySearch(a4, (byte)7));

		assertFalse(BinaereSuche.binarySearch(a8, (byte)3));
		assertTrue(BinaereSuche.binarySearch(a8, (byte)4));
		assertTrue(BinaereSuche.binarySearch(a8, (byte)5));
		assertTrue(BinaereSuche.binarySearch(a8, (byte)6));
		assertFalse(BinaereSuche.binarySearch(a8, (byte)7));

		assertFalse(BinaereSuche.binarySearch(a9, (byte)3));
		assertTrue(BinaereSuche.binarySearch(a9, (byte)4));
		assertTrue(BinaereSuche.binarySearch(a9, (byte)5));
		assertTrue(BinaereSuche.binarySearch(a9, (byte)6));
		assertFalse(BinaereSuche.binarySearch(a9, (byte)7));

		assertFalse(BinaereSuche.binarySearch(a2Mia, (byte)0));
		assertTrue(BinaereSuche.binarySearch(a2Mia, (byte)1));
		assertTrue(BinaereSuche.binarySearch(a2Mia, part));
		assertFalse(BinaereSuche.binarySearch(a2Mia, (byte)(part + 1)));
	}

	@Test
	void testFindFirst() {
		assertEquals(BinaereSuche.findFirst(a0, (byte)5), -1);
		
		assertEquals(BinaereSuche.findFirst(a1, (byte)4), -1);
		assertEquals(BinaereSuche.findFirst(a1, (byte)5), 0);
		assertEquals(BinaereSuche.findFirst(a1, (byte)6), -1);
		
		assertEquals(BinaereSuche.findFirst(a2, (byte)3), -1);
		assertEquals(BinaereSuche.findFirst(a2, (byte)4), 0);
		assertEquals(BinaereSuche.findFirst(a2, (byte)5), 1);
		assertEquals(BinaereSuche.findFirst(a2, (byte)6), -1);
		
		assertEquals(BinaereSuche.findFirst(a3, (byte)3), -1);
		assertEquals(BinaereSuche.findFirst(a3, (byte)4), 0);
		assertEquals(BinaereSuche.findFirst(a3, (byte)5), 1);
		assertEquals(BinaereSuche.findFirst(a3, (byte)6), 2);
		assertEquals(BinaereSuche.findFirst(a3, (byte)7), -1);
		
		assertEquals(BinaereSuche.findFirst(a4, (byte)3), -1);
		assertEquals(BinaereSuche.findFirst(a4, (byte)4), 0);
		assertEquals(BinaereSuche.findFirst(a4, (byte)5), 1);
		assertEquals(BinaereSuche.findFirst(a4, (byte)6), 3);
		assertEquals(BinaereSuche.findFirst(a4, (byte)7), -1);
		
		assertEquals(BinaereSuche.findFirst(a8, (byte)3), -1);
		assertEquals(BinaereSuche.findFirst(a8, (byte)4), 0);
		assertEquals(BinaereSuche.findFirst(a8, (byte)5), 1);
		assertEquals(BinaereSuche.findFirst(a8, (byte)6), 7);
		assertEquals(BinaereSuche.findFirst(a8, (byte)7), -1);
		
		assertEquals(BinaereSuche.findFirst(a9, (byte)3), -1);
		assertEquals(BinaereSuche.findFirst(a9, (byte)4), 0);
		assertEquals(BinaereSuche.findFirst(a9, (byte)5), 1);
		assertEquals(BinaereSuche.findFirst(a9, (byte)6), 8);
		assertEquals(BinaereSuche.findFirst(a9, (byte)7), -1);

		assertEquals(BinaereSuche.findFirst(a2Mia, (byte)0), -1);
		assertEquals(BinaereSuche.findFirst(a2Mia, (byte)1), 0);
		assertEquals(BinaereSuche.findFirst(a2Mia, part), a2Mia.length/part*(part - 1));
		assertEquals(BinaereSuche.findFirst(a2Mia, (byte)(part + 1)), -1);
	}

	@Test
	void testFindLast() {
		assertEquals(BinaereSuche.findLast(a0, (byte)5), -1);
		
		assertEquals(BinaereSuche.findLast(a1, (byte)4), -1);
		assertEquals(BinaereSuche.findLast(a1, (byte)5), 0);
		assertEquals(BinaereSuche.findLast(a1, (byte)6), -1);
		
		assertEquals(BinaereSuche.findLast(a2, (byte)3), -1);
		assertEquals(BinaereSuche.findLast(a2, (byte)4), 0);
		assertEquals(BinaereSuche.findLast(a2, (byte)5), 1);
		assertEquals(BinaereSuche.findLast(a2, (byte)6), -1);
		
		assertEquals(BinaereSuche.findLast(a3, (byte)3), -1);
		assertEquals(BinaereSuche.findLast(a3, (byte)4), 0);
		assertEquals(BinaereSuche.findLast(a3, (byte)5), 1);
		assertEquals(BinaereSuche.findLast(a3, (byte)6), 2);
		assertEquals(BinaereSuche.findLast(a3, (byte)7), -1);
		
		assertEquals(BinaereSuche.findLast(a4, (byte)3), -1);
		assertEquals(BinaereSuche.findLast(a4, (byte)4), 0);
		assertEquals(BinaereSuche.findLast(a4, (byte)5), 2);
		assertEquals(BinaereSuche.findLast(a4, (byte)6), 3);
		assertEquals(BinaereSuche.findLast(a4, (byte)7), -1);
		
		assertEquals(BinaereSuche.findLast(a8, (byte)3), -1);
		assertEquals(BinaereSuche.findLast(a8, (byte)4), 0);
		assertEquals(BinaereSuche.findLast(a8, (byte)5), 6);
		assertEquals(BinaereSuche.findLast(a8, (byte)6), 7);
		assertEquals(BinaereSuche.findLast(a8, (byte)7), -1);
		
		assertEquals(BinaereSuche.findLast(a9, (byte)3), -1);
		assertEquals(BinaereSuche.findLast(a9, (byte)4), 0);
		assertEquals(BinaereSuche.findLast(a9, (byte)5), 7);
		assertEquals(BinaereSuche.findLast(a9, (byte)6), 8);
		assertEquals(BinaereSuche.findLast(a9, (byte)7), -1);

		assertEquals(BinaereSuche.findLast(a2Mia, (byte)0), -1);
		assertEquals(BinaereSuche.findLast(a2Mia, (byte)1), a2Mia.length/part - 1);
		assertEquals(BinaereSuche.findLast(a2Mia, part), a2Mia.length - 1);
		assertEquals(BinaereSuche.findLast(a2Mia, (byte)(part + 1)), -1);
	}
}
