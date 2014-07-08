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
	
	boolean willSetExpected;
	boolean didSetExpected;
	boolean willSetCalled;
	boolean didSetCalled;
	
	@Test
	public void testWillDidSet() {
		Property<String> string;
		
		willSetExpected = false;
		didSetExpected = false;
		willSetCalled = false;
		didSetCalled = false;
		string = new Property<String>("initString");
		string.set("settet");
		assertTrue("willSet not called?", !willSetCalled);
		assertTrue("didSet not called?", !didSetCalled);
		
		willSetExpected = true;
		didSetExpected = true;
		willSetCalled = false;
		didSetCalled = false;
		string = new Property<String>("initString");
		string.willSet = this::willSetHandleTrue;
		string.didSet = this::didSetHandle;
		string.set("settet");
		assertTrue("willSet called?", willSetCalled);
		assertTrue("didSet called?", didSetCalled);
		assertEquals("was settet?", "settet", string.get());
		
		willSetExpected = true;
		didSetExpected = false;
		willSetCalled = false;
		didSetCalled = false;
		string = new Property<String>("initString");
		string.willSet = this::willSetHandleFalse;
		string.set("settet");
		assertTrue("willSet called?", willSetCalled);
		assertTrue("didSet not called?", !didSetCalled);
		assertEquals("was not settet?", "initString", string.get());
	}
	
	public boolean willSetHandleTrue(String oldVal, String newVal){
		assertTrue(willSetExpected);
		assertEquals("initString", oldVal);
		assertEquals("settet", newVal);
		willSetCalled = true;
		return true;
	}
	
	public boolean willSetHandleFalse(String oldVal, String newVal){
		assertTrue(willSetExpected);
		assertEquals("initString", oldVal);
		assertEquals("settet", newVal);
		willSetCalled = true;
		return false;
	}
	
	public void didSetHandle(String oldVal, String newVal){
		assertTrue(didSetExpected);
		assertEquals("initString", oldVal);
		assertEquals("settet", newVal);
		willSetExpected = true;
		didSetCalled = true;
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
