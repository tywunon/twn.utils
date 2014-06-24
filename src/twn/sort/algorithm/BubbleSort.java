package twn.sort.algorithm;

import java.util.Comparator;
import java.util.List;

import twn.sort.Sort;
import twn.sort.Sort.Mode;


public class BubbleSort {
	public static <T> List<T> sort(List<T> sequence, Comparator<T> comparator, Mode mode){
		return bubbleSort(sequence, comparator, mode);
	}
	
	private static <T> List<T> bubbleSort(List<T> sequence, Comparator<T> comparator, Mode mode){
			switch (mode) {
			case ASC:
				for(int i=0; i<sequence.size(); i++){
					for(int j=i+1;j<sequence.size();j++){
						if(comparator.compare(sequence.get(i), sequence.get(j)) < 0){
							Sort.swap(sequence, i, j);
						}
					}
				}
				break;
			case DESC:
				for(int i=0; i<sequence.size(); i++){
					for(int j=i+1;j<sequence.size();j++){
						if(comparator.compare(sequence.get(i), sequence.get(j)) > 0){
							Sort.swap(sequence, i, j);
						}
					}
				}
				break;
			}
		return sequence;
	}
}
