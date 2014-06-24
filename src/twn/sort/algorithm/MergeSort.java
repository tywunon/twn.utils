package twn.sort.algorithm;
import java.util.*;

import twn.sort.Sort;
import twn.sort.Sort.Mode;


public class MergeSort {
	public static <T> List<T> sort(List<T> sequence, Comparator<T> comparator, Mode mode){
		return mergeSort(sequence, comparator, mode);
	}
	
	private static <T> List<T> mergeSort(List<T> sequence, Comparator<T> comparator, Mode mode){
		int firstLast = 0;
		int secondLast = 0;
		while(firstLast < sequence.size()-1){
			firstLast = findSortedListInList(sequence, comparator, 0, mode);
			secondLast = findSortedListInList(sequence, comparator, firstLast+1, mode);
			merge(sequence, comparator, firstLast, secondLast, mode);
		}
		return sequence;
	}
	
	private static <T> int findSortedListInList(List<T> sequence, Comparator<T> comparator, int firstIndex, Mode mode){
		int i=firstIndex;
		switch (mode) {
			case ASC:
				while ((i+1) < sequence.size() && comparator.compare(sequence.get(i), sequence.get(i+1)) >= 0) {
					i++;
				}
				break;
			case DESC:
				while ((i+1) < sequence.size() && comparator.compare(sequence.get(i), sequence.get(i+1)) <= 0) {
					i++;
				}
				break;
			default:
				return i;
		}
		return i;
	}
	
	private static <T> void merge(List<T> sequence, Comparator<T> comparator, int firstLast, int secondLast, Mode mode){
		int i = 0;
		int j = firstLast+1;
		while(i<=firstLast && j<=secondLast && i<j){
			switch (mode) {
				case ASC:
					if(j<sequence.size() && comparator.compare(sequence.get(i), sequence.get(j)) < 0){
						Sort.insert(sequence, i, j);
						j++;
					}else{
						i++;
					}
					break;
				case DESC:
					if(j<sequence.size() && comparator.compare(sequence.get(i), sequence.get(j)) > 0){
						Sort.insert(sequence, i, j);
						j++;
					}else{
						i++;
					}
					break;
				default:
					break;
			}
		}
	}
}
