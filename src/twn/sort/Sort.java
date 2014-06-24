package twn.sort;

import java.util.Comparator;
import java.util.List;

import twn.sort.algorithm.*;


public class Sort {
	public static enum Algorithm{
		BubbleSort, 
		MergeSort, 
		QuickSort, 
		SimpleSort,
	}
	
	public static enum Mode{
		ASC, DESC
	}

	public static <T> List<T> sort(List<T> sequence, Comparator<T> comperator, Algorithm algorithm, Mode mode){
		switch (algorithm) {
		case MergeSort:
			sequence = MergeSort.sort(sequence, comperator, mode);
			break;
		case BubbleSort:
			sequence = BubbleSort.sort(sequence, comperator, mode);
			break;
		case QuickSort:
			sequence = QuickSort.sort(sequence, comperator, mode);
			break;
		case SimpleSort:
			sequence = SimpleSort.sort(sequence, comperator, mode);
		}
		return sequence;
	}
	
	
	public static <T> void swap(List<T> sequence, int indexA, int indexB){
		T A = sequence.get(indexA);
		T B = sequence.get(indexB);
		
		sequence.set(indexA, B);
		sequence.set(indexB, A);
	}
	
	
	public static <T> void insert(List<T> sequence, int destIndex, int srcIndex){
		T temp = sequence.get(srcIndex);
		sequence.remove(srcIndex);
		sequence.add(destIndex, temp);		
	}
}
