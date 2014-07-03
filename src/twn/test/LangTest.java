package twn.test;

import org.junit.Test;

import static org.junit.Assert.*;
import twn.lang.Property;
import twn.lang.Property.PropertyContainer;
import twn.lang.Property.PropertyContainerChangedArgs;
import twn.lang.SetOnce;

public class LangTest {

	boolean expectEvent;
	boolean eventRecieved;
	
	@Test
	public void testPropertyGetSet() {
		expectEvent = false;
		Property<String> string = new Property<String>();
		assertEquals("null without initValue", null, string.get());
		string = new Property<>("Hello");
		assertEquals("InitValue?", "Hello", string.get());
		string.propertyChanged.subscribe((sender, args) -> assertTrue(expectEvent));
		string.set("Hello");
		assertEquals("still InitValue?", "Hello", string.get());
		expectEvent = true;
		string.set("Test");
		assertEquals("New Value", "Test", string.get());
	}
	
	@Test
	public void testPropertyChanged() {
		expectEvent = false;
		eventRecieved = false;
		TestPropertyContainer tpc = new TestPropertyContainer();
		tpc.containerChanged.subscribe(this::handleContainerChanged);
		expectEvent = true;
		tpc.string.set("settet");
		assertTrue(eventRecieved);
		
	}
	
	public void handleContainerChanged(Object sender, PropertyContainerChangedArgs args) {
		eventRecieved = true; 
		assertTrue(expectEvent);
		assertEquals("init", args.oldValue); 
		assertEquals("settet", args.newValue); 
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
	
	private static class TestPropertyContainer extends PropertyContainer {
		public final Property<String> string;
		
		public TestPropertyContainer() {
			string = new Property<String>("init");
			initPropertys();
		}
	}
}
