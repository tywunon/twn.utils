package twn.lang;

public class Tuple {
	public static class Tuple1<T1> {

		public final T1 item1;
		
		public static <T1> Tuple1<T1> Create(T1 i1){
			return new Tuple1<T1>(i1);
		}
		
		private Tuple1(T1 i1)
		{
			item1 = i1;
		}
	}
	
	public static class Tuple2<T1, T2> {

		public final T1 item1;
		public final T2 item2;
		
		public static <T1, T2> Tuple2<T1, T2> Create(T1 i1, T2 i2){
			return new Tuple2<T1, T2>(i1, i2);
		}
		
		private Tuple2(T1 i1, T2 i2)
		{
			item1 = i1;
			item2 = i2;
		}
	}
	
	public static class Tuple3<T1, T2, T3> {

		public final T1 item1;
		public final T2 item2;
		public final T3 item3;
		
		public static <T1, T2, T3> Tuple3<T1, T2, T3> Create(T1 i1, T2 i2, T3 i3){
			return new Tuple3<T1, T2, T3>(i1, i2, i3);
		}
		
		private Tuple3(T1 i1, T2 i2, T3 i3)
		{
			item1 = i1;
			item2 = i2;
			item3 = i3;
		}
	}
	
	public static class Tuple4<T1, T2, T3, T4> {

		public final T1 item1;
		public final T2 item2;
		public final T3 item3;
		public final T4 item4;
		
		public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> Create(T1 i1, T2 i2, T3 i3, T4 i4){
			return new Tuple4<T1, T2, T3, T4>(i1, i2, i3, i4);
		}
		
		private Tuple4(T1 i1, T2 i2, T3 i3, T4 i4)
		{
			item1 = i1;
			item2 = i2;
			item3 = i3;
			item4 = i4;
		}
	}
	
	public static class Tuple5<T1, T2, T3, T4, T5> {

		public final T1 item1;
		public final T2 item2;
		public final T3 item3;
		public final T4 item4;
		public final T5 item5;
		
		public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> Create(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5){
			return new Tuple5<T1, T2, T3, T4, T5>(i1, i2, i3, i4, i5);
		}
		
		private Tuple5(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5)
		{
			item1 = i1;
			item2 = i2;
			item3 = i3;
			item4 = i4;
			item5 = i5;
		}
	}
	
	public static class Tuple6<T1, T2, T3, T4, T5, T6> {

		public final T1 item1;
		public final T2 item2;
		public final T3 item3;
		public final T4 item4;
		public final T5 item5;
		public final T6 item6;
		
		public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> Create(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6) {
			return new Tuple6<T1, T2, T3, T4, T5, T6>(i1, i2, i3, i4, i5, i6);
		}
		
		private Tuple6(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6)
		{
			item1 = i1;
			item2 = i2;
			item3 = i3;
			item4 = i4;
			item5 = i5;
			item6 = i6;
		}
	}
	
	public static class Tuple7<T1, T2, T3, T4, T5, T6, T7> {

		public final T1 item1;
		public final T2 item2;
		public final T3 item3;
		public final T4 item4;
		public final T5 item5;
		public final T6 item6;
		public final T7 item7;
		
		public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> Create(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7) {
			return new Tuple7<T1, T2, T3, T4, T5, T6, T7>(i1, i2, i3, i4, i5, i6, i7);
		}
		
		private Tuple7(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7)
		{
			item1 = i1;
			item2 = i2;
			item3 = i3;
			item4 = i4;
			item5 = i5;
			item6 = i6;
			item7 = i7;
		}
	}
	
	public static class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> {

		public final T1 item1;
		public final T2 item2;
		public final T3 item3;
		public final T4 item4;
		public final T5 item5;
		public final T6 item6;
		public final T7 item7;
		public final T8 item8;
		
		public static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> Create(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7, T8 i8) {
			return new Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(i1, i2, i3, i4, i5, i6, i7, i8);
		}
		
		private Tuple8(T1 i1, T2 i2, T3 i3, T4 i4, T5 i5, T6 i6, T7 i7, T8 i8)
		{
			item1 = i1;
			item2 = i2;
			item3 = i3;
			item4 = i4;
			item5 = i5;
			item6 = i6;
			item7 = i7;
			item8 = i8;
		}
	}
}
