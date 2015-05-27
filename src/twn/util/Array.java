package twn.util;

public final class Array {
	public final static <From, To> To[] arryToArry(Class<To> toType, From[] fromArray, Converter<From, To> converter) {
		@SuppressWarnings("unchecked")
		To[] toArray = (To[]) java.lang.reflect.Array.newInstance(toType, fromArray.length);
		for(int i=0; i<fromArray.length; i++)
		{
			toArray[i] = converter.convert(fromArray[i]);
		}
		return toArray;
	}
	
	public final static Boolean[] convertPrimToWrapper(boolean[] values) {
		Boolean[] result = new Boolean[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Character[] convertPrimToWrapper(char[] values) {
		Character[] result = new Character[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Byte[] convertPrimToWrapper(byte[] values) {
		Byte[] result = new Byte[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Short[] convertPrimToWrapper(short[] values) {
		Short[] result = new Short[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Integer[] convertPrimToWrapper(int[] values) {
		Integer[] result = new Integer[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Long[] convertPrimToWrapper(long[] values) {
		Long[] result = new Long[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Float[] convertPrimToWrapper(float[] values) {
		Float[] result = new Float[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static Double[] convertPrimToWrapper(double[] values) {
		Double[] result = new Double[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static boolean[] convertWrapperToPrim(Boolean[] values) {
		boolean[] result = new boolean[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static char[] convertWrapperToPrim(Character[] values) {
		char[] result = new char[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static byte[] convertWrapperToPrim(Byte[] values) {
		byte[] result = new byte[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static short[] convertWrapperToPrim(Short[] values) {
		short[] result = new short[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static int[] convertWrapperToPrim(Integer[] values) {
		int[] result = new int[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static long[] convertWrapperToPrim(Long[] values) {
		long[] result = new long[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static float[] convertWrapperToPrim(Float[] values) {
		float[] result = new float[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	public final static double[] convertWrapperToPrim(Double[] values) {
		double[] result = new double[values.length];
		for(int i=0; i<values.length;i++) {
			result[i] = values[i];
		}
		return result;
	}
	
	@FunctionalInterface
	public static interface Converter<From, To> {
		To convert(From value);
	}
}
