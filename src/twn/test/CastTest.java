package twn.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twn.util.Cast;

public class CastTest {
	
	Object o;
	String s;
	Integer i;
	
	@Before
	public void init()
	{
		o = new Object();
		s = "";
		i = 0;
	}
	
	@Test
	public void subtype(){
		assertNull("Cast into Subtype", Cast.as(o, Integer.class));
	}
	
	@Test
	public void superType(){
		assertNotNull("Cast into Supertype", Cast.as(s, Object.class));		
	}
	
	@Test
	public void sameType(){
		assertNotNull("Cast into same Type", Cast.as(o, Object.class));
	}
	
	@Test
	public void otherType(){
		assertNull("Cast into other Type", Cast.as(i, String.class));
	}
	
	@Test
	public void nullCast(){
		assertNull("Cast null", Cast.as(null, Object.class));
	}
	
	@After
	public void finalize(){
		o = null;
		s = null;
		i = null;
	}
}
