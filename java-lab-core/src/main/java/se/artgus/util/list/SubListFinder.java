package se.artgus.util.list;

import java.util.List;

public class SubListFinder implements ListMatcher {

	public <T> int findFirst(List<T> listA, List<T> listB) {

		if (listB.isEmpty()) {
			return -1;
		}
		
		for (int i = 0; i < listA.size(); i++) {
			T value1 = listA.get(i);
			if (value1.equals(listB.get(0))) {
				if (subListFound(listA, listB, i)) {
					return i;
				}
			}
		}
			
		return -1;
	}
	
	private <T> boolean subListFound(List<T> listA, List<T> listB, int index1) {

		if (listA.size()-index1 >= listB.size()) {
			for (int i = 0; i < listB.size(); i++) {
				if (listA.get(index1++).equals(listB.get(i))) {
					if (i == (listB.size()-1)) { // last pos i list2 -> lists matched
						return true;
					}
				}
			}
		}
		return false;
	}

	public <T> int[] findAll(List<T> listA, List<T> listB) {
		throw new RuntimeException("Not implemented yet.");
	}

}
