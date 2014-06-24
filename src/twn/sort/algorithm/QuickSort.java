package twn.sort.algorithm;

import java.util.Comparator;
import java.util.List;

import twn.sort.Sort.Mode;
import twn.sort.util.SortLib;

public class QuickSort {
	public static <T> List<T> sort(List<T> sequence, Comparator<T> comparator, Mode mode){
		switch (mode) {
		case ASC:
			sequence = SortLib.invertList(quicksort(sequence, comparator, 0, sequence.size()-1));
			break;
		case DESC:
			sequence = quicksort(sequence, comparator, 0, sequence.size()-1);
			break;
		default:
			break;
		}
			
		return sequence;
	}
	
	private static <T> List<T> quicksort(List<T> sequence, Comparator<T> comparator, int left, int right){
		if(left < right) {
			int split = split(sequence, comparator, left, right);
			quicksort(sequence, comparator, left, split-1);
			quicksort(sequence, comparator, split+1, right);
		}
		return sequence;
	}
	
	private static <T> int split(List<T> sequence, Comparator<T> comparator, int left, int right)
	{
		int i = left;
		int j = right-1;
		T pivot = sequence.get(right);
		do{
			while(comparator.compare(sequence.get(i), pivot) <= 0 && i < right){
				i++;
			}
			
			while(comparator.compare(sequence.get(j), pivot) >= 0 && j > left){
				j--;
			}
			
			if(i < j)
				SortLib.swap(sequence, i, j);
		}while(i < j);
		
		if(comparator.compare(sequence.get(i), pivot) > 0)
			SortLib.swap(sequence, i, right);
		
		return i;
	}
}
