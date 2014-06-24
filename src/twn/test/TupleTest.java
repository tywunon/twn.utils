package twn.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import twn.util.Tuple.*;

public class TupleTest {
	Object o1;
	String o2;
	Integer o3;
	Double o4;
	Float o5;
	Byte o6;
	Character o7;
	Long o8;
	
	@Before
	public void init(){
		o1 = new Object();
		o2 = new String();
		o3 = new Integer(0);
		o4 = new Double(0.0);
		o5 = new Float(0.0f);
		o6 = new Byte((byte)0);
		o7 = new Character((char)0);
		o8 = new Long(0);
	}
	
	@Test
	public void Tuple1Test() {
		Tuple1<Object> tpl = Tuple1.Create(o1);
		assertEquals(o1, tpl.item1);
	}
	
	@Test
	public void Tuple2Test() {
		Tuple2<Object, String> tpl = Tuple2.Create(o1, o2);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
	}
	
	@Test
	public void Tuple3Test() {
		Tuple3<Object, String, Integer> tpl = Tuple3.Create(o1, o2, o3);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		assertNotEquals(o1, tpl.item3);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
		assertNotEquals(o2, tpl.item3);
		
		assertNotEquals(o3, tpl.item1);
		assertNotEquals(o3, tpl.item2);
		assertEquals(o3, tpl.item3);
	}
	
	@Test
	public void Tuple4Test() {
		Tuple4<Object, String, Integer, Double> tpl = Tuple4.Create(o1, o2, o3, o4);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		assertNotEquals(o1, tpl.item3);
		assertNotEquals(o1, tpl.item4);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
		assertNotEquals(o2, tpl.item3);
		assertNotEquals(o2, tpl.item4);
		
		assertNotEquals(o3, tpl.item1);
		assertNotEquals(o3, tpl.item2);
		assertEquals(o3, tpl.item3);
		assertNotEquals(o3, tpl.item4);
		
		assertNotEquals(o4, tpl.item1);
		assertNotEquals(o4, tpl.item2);
		assertNotEquals(o4, tpl.item3);
		assertEquals(o4, tpl.item4);
	}
	
	@Test
	public void Tuple5Test() {
		Tuple5<Object, String, Integer, Double, Float> tpl = Tuple5.Create(o1, o2, o3, o4, o5);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		assertNotEquals(o1, tpl.item3);
		assertNotEquals(o1, tpl.item4);
		assertNotEquals(o1, tpl.item5);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
		assertNotEquals(o2, tpl.item3);
		assertNotEquals(o2, tpl.item4);
		assertNotEquals(o2, tpl.item5);
		
		assertNotEquals(o3, tpl.item1);
		assertNotEquals(o3, tpl.item2);
		assertEquals(o3, tpl.item3);
		assertNotEquals(o3, tpl.item4);
		assertNotEquals(o3, tpl.item5);
		
		assertNotEquals(o4, tpl.item1);
		assertNotEquals(o4, tpl.item2);
		assertNotEquals(o4, tpl.item3);
		assertEquals(o4, tpl.item4);
		assertNotEquals(o4, tpl.item5);
		
		assertNotEquals(o5, tpl.item1);
		assertNotEquals(o5, tpl.item2);
		assertNotEquals(o5, tpl.item3);
		assertNotEquals(o5, tpl.item4);
		assertEquals(o5, tpl.item5);
	}
	
	@Test
	public void Tuple6Test() {
		Tuple6<Object, String, Integer, Double, Float, Byte> tpl = Tuple6.Create(o1, o2, o3, o4, o5, o6);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		assertNotEquals(o1, tpl.item3);
		assertNotEquals(o1, tpl.item4);
		assertNotEquals(o1, tpl.item5);
		assertNotEquals(o1, tpl.item6);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
		assertNotEquals(o2, tpl.item3);
		assertNotEquals(o2, tpl.item4);
		assertNotEquals(o2, tpl.item5);
		assertNotEquals(o2, tpl.item6);
		
		assertNotEquals(o3, tpl.item1);
		assertNotEquals(o3, tpl.item2);
		assertEquals(o3, tpl.item3);
		assertNotEquals(o3, tpl.item4);
		assertNotEquals(o3, tpl.item5);
		assertNotEquals(o3, tpl.item6);
		
		assertNotEquals(o4, tpl.item1);
		assertNotEquals(o4, tpl.item2);
		assertNotEquals(o4, tpl.item3);
		assertEquals(o4, tpl.item4);
		assertNotEquals(o4, tpl.item5);
		assertNotEquals(o4, tpl.item6);
		
		assertNotEquals(o5, tpl.item1);
		assertNotEquals(o5, tpl.item2);
		assertNotEquals(o5, tpl.item3);
		assertNotEquals(o5, tpl.item4);
		assertEquals(o5, tpl.item5);
		assertNotEquals(o5, tpl.item6);
		
		assertNotEquals(o6, tpl.item1);
		assertNotEquals(o6, tpl.item2);
		assertNotEquals(o6, tpl.item3);
		assertNotEquals(o6, tpl.item4);
		assertNotEquals(o6, tpl.item5);
		assertEquals(o6, tpl.item6);
	}
	
	@Test
	public void Tuple7Test() {
		Tuple7<Object, String, Integer, Double, Float, Byte, Character> tpl = Tuple7.Create(o1, o2, o3, o4, o5, o6, o7);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		assertNotEquals(o1, tpl.item3);
		assertNotEquals(o1, tpl.item4);
		assertNotEquals(o1, tpl.item5);
		assertNotEquals(o1, tpl.item6);
		assertNotEquals(o1, tpl.item7);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
		assertNotEquals(o2, tpl.item3);
		assertNotEquals(o2, tpl.item4);
		assertNotEquals(o2, tpl.item5);
		assertNotEquals(o2, tpl.item6);
		assertNotEquals(o2, tpl.item7);
		
		assertNotEquals(o3, tpl.item1);
		assertNotEquals(o3, tpl.item2);
		assertEquals(o3, tpl.item3);
		assertNotEquals(o3, tpl.item4);
		assertNotEquals(o3, tpl.item5);
		assertNotEquals(o3, tpl.item6);
		assertNotEquals(o3, tpl.item7);
		
		assertNotEquals(o4, tpl.item1);
		assertNotEquals(o4, tpl.item2);
		assertNotEquals(o4, tpl.item3);
		assertEquals(o4, tpl.item4);
		assertNotEquals(o4, tpl.item5);
		assertNotEquals(o4, tpl.item6);
		assertNotEquals(o4, tpl.item7);
		
		assertNotEquals(o5, tpl.item1);
		assertNotEquals(o5, tpl.item2);
		assertNotEquals(o5, tpl.item3);
		assertNotEquals(o5, tpl.item4);
		assertEquals(o5, tpl.item5);
		assertNotEquals(o5, tpl.item6);
		assertNotEquals(o5, tpl.item7);
		
		assertNotEquals(o6, tpl.item1);
		assertNotEquals(o6, tpl.item2);
		assertNotEquals(o6, tpl.item3);
		assertNotEquals(o6, tpl.item4);
		assertNotEquals(o6, tpl.item5);
		assertEquals(o6, tpl.item6);
		assertNotEquals(o6, tpl.item7);
		
		assertNotEquals(o7, tpl.item1);
		assertNotEquals(o7, tpl.item2);
		assertNotEquals(o7, tpl.item3);
		assertNotEquals(o7, tpl.item4);
		assertNotEquals(o7, tpl.item5);
		assertNotEquals(o7, tpl.item6);
		assertEquals(o7, tpl.item7);
	}
	
	@Test
	public void Tuple8Test() {
		Tuple8<Object, String, Integer, Double, Float, Byte, Character, Long> tpl = Tuple8.Create(o1, o2, o3, o4, o5, o6, o7, o8);
		assertEquals(o1, tpl.item1);
		assertNotEquals(o1, tpl.item2);
		assertNotEquals(o1, tpl.item3);
		assertNotEquals(o1, tpl.item4);
		assertNotEquals(o1, tpl.item5);
		assertNotEquals(o1, tpl.item6);
		assertNotEquals(o1, tpl.item7);
		assertNotEquals(o1, tpl.item8);
		
		assertNotEquals(o2, tpl.item1);
		assertEquals(o2, tpl.item2);
		assertNotEquals(o2, tpl.item3);
		assertNotEquals(o2, tpl.item4);
		assertNotEquals(o2, tpl.item5);
		assertNotEquals(o2, tpl.item6);
		assertNotEquals(o2, tpl.item7);
		assertNotEquals(o2, tpl.item8);
		
		assertNotEquals(o3, tpl.item1);
		assertNotEquals(o3, tpl.item2);
		assertEquals(o3, tpl.item3);
		assertNotEquals(o3, tpl.item4);
		assertNotEquals(o3, tpl.item5);
		assertNotEquals(o3, tpl.item6);
		assertNotEquals(o3, tpl.item7);
		assertNotEquals(o3, tpl.item8);
		
		assertNotEquals(o4, tpl.item1);
		assertNotEquals(o4, tpl.item2);
		assertNotEquals(o4, tpl.item3);
		assertEquals(o4, tpl.item4);
		assertNotEquals(o4, tpl.item5);
		assertNotEquals(o4, tpl.item6);
		assertNotEquals(o4, tpl.item7);
		assertNotEquals(o4, tpl.item8);
		
		assertNotEquals(o5, tpl.item1);
		assertNotEquals(o5, tpl.item2);
		assertNotEquals(o5, tpl.item3);
		assertNotEquals(o5, tpl.item4);
		assertEquals(o5, tpl.item5);
		assertNotEquals(o5, tpl.item6);
		assertNotEquals(o5, tpl.item7);
		assertNotEquals(o5, tpl.item8);
		
		assertNotEquals(o6, tpl.item1);
		assertNotEquals(o6, tpl.item2);
		assertNotEquals(o6, tpl.item3);
		assertNotEquals(o6, tpl.item4);
		assertNotEquals(o6, tpl.item5);
		assertEquals(o6, tpl.item6);
		assertNotEquals(o6, tpl.item7);
		assertNotEquals(o6, tpl.item8);
		
		assertNotEquals(o7, tpl.item1);
		assertNotEquals(o7, tpl.item2);
		assertNotEquals(o7, tpl.item3);
		assertNotEquals(o7, tpl.item4);
		assertNotEquals(o7, tpl.item5);
		assertNotEquals(o7, tpl.item6);
		assertEquals(o7, tpl.item7);
		assertNotEquals(o7, tpl.item8);
		
		assertNotEquals(o8, tpl.item1);
		assertNotEquals(o8, tpl.item2);
		assertNotEquals(o8, tpl.item3);
		assertNotEquals(o8, tpl.item4);
		assertNotEquals(o8, tpl.item5);
		assertNotEquals(o8, tpl.item6);
		assertNotEquals(o8, tpl.item7);
		assertEquals(o8, tpl.item8);
	}
}
