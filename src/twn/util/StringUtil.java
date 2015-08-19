package twn.util;

public class StringUtil {
	public static boolean parseBooleanDef(String string, boolean _default){
		try {
			return Boolean.parseBoolean(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
	
	public static byte parseByteDef(String string, byte _default){
		try {
			return Byte.parseByte(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
	
	public static short parseShortDef(String string, short _default){
		try {
			return Short.parseShort(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
	
	public static int parseIntDef(String string, int _default){
		try {
			return Integer.parseInt(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
	
	public static long parseLongDef(String string, long _default){
		try {
			return Long.parseLong(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
	
	public static float parseFloatDef(String string, float _default){
		try {
			return Float.parseFloat(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
	
	public static double parseDoubleDef(String string, double _default){
		try {
			return Double.parseDouble(string);
		} catch(NumberFormatException ex) {
			return _default;
		}
	}
}
