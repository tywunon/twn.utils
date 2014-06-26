package twn.test;

import org.junit.Test;

import static org.junit.Assert.*;
import twn.lang.Property;
import twn.lang.SetOnce;

public class UtilTest {

	boolean expectEvent;
	
	@Test
	public void testProperty() {

		Property<String> string = new Property<String>();
		assertEquals("null without initValue", null, string.get());
		string = new Property<>("Hello");
		assertEquals("InitValue?", "Hello", string.get());
		expectEvent = false;
		string.propertyChanged.subscribe((sender, args) -> assertTrue(expectEvent));
		string.set("Hello");
		assertEquals("still InitValue?", "Hello", string.get());
		expectEvent = true;
		string.set("Test");
		assertEquals("New Value", "Test", string.get());
	}
	
	@Test
	public void testSetOnce() {
		SetOnce<String> string = new SetOnce<>();
		assertEquals("null without initValue", null, string.value());
		assertTrue("is Unset", !string.isSet());
		string.setValue("Hello");
		assertEquals("expect set Value", "Hello", string.value());
		assertTrue("is Set", string.isSet());
		string = new SetOnce<>("Hello");
		assertEquals("expect initValue", "Hello", string.value());
		assertTrue("is Set", string.isSet());
	}

}
