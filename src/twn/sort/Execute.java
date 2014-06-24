package twn.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import twn.sort.Sort.Algorithm;
import twn.sort.Sort.Mode;

public class Execute {
	public static void main(String[] args) {		
		List<Comps> list = new ArrayList<Comps>();
		Random rnd = new Random();
		for(int i=0;i<10000;i++){
			list.add(new Comps(rnd.nextInt(20)));
		}
		System.out.println(list);
		System.out.println(Sort.sort(list, new CompsComperator(), Algorithm.QuickSort, Mode.ASC));
	}
	
	public static class Comps{

		public int val;
		public Comps(int i) {
			this.val = i;
		}
		
		@Override
		public String toString() {
			return val+"";
		}
		
	}
	
	public static class CompsComperator implements Comparator<Comps>{

		@Override
		public int compare(Comps o1, Comps o2) {
			return o2.val - o1.val;
		}
		
	}
}
