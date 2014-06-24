package twn.sort.util;

import java.util.List;

public class SortLib {
	public static <T> void swap(List<T> sequence, int a, int b)
	{
		if(a < sequence.size() && b < sequence.size()){
			sequence.set(a, sequence.set(b, sequence.get(a)));
		}
	}
	
	public static <T> List<T> invertList(List<T> sequence){
		for(int i=0; i<sequence.size(); i++){
			T temp = sequence.get(i);
			sequence.remove(i);
			sequence.add(0, temp);
		}
		return sequence;
	}
}
