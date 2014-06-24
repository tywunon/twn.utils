package twn.test;

import static org.junit.Assert.*;

import org.junit.Test;

import twn.lang.Clazz;

public class ClazzTest {

	@Test
	public void testGetAllFields() {
		assertEquals(3, Clazz.getAllFields(TestClass.class).size());
	}

	@Test
	public void testHasField() {
		assertTrue(Clazz.hasField(TestClass.class, "i"));
		assertTrue(Clazz.hasField(TestClass.class, "o"));
		assertTrue(Clazz.hasField(TestClass.class, "s"));
		
		assertFalse(Clazz.hasField(TestClass.class, "j"));
		assertFalse(Clazz.hasField(TestClass.class, "h"));
		assertFalse(Clazz.hasField(TestClass.class, "sad"));
		assertFalse(Clazz.hasField(TestClass.class, "gfhj"));
	}
	
	private static class TestClass {
		@SuppressWarnings("unused")
		public int i;
		@SuppressWarnings("unused")
		public String s;
		@SuppressWarnings("unused")
		public Object o;
	}
}
