package twn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import twn.lang.Array;

public class ArrayTest {
	@Test
	public void testArryToArry() {
		String[] expected = new String[]{"1", "2", "4", "5", "6", "8", "9"};
		Integer[] inArry = new Integer[] {1,2,4,5,6,8,9};
		String[] outArry = Array.arryToArry(String.class, inArry, (obj) -> obj.toString());
		assertArrayEquals(expected, outArry);
	}
}
