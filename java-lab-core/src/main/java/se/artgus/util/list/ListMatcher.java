package se.artgus.util.list;

import java.util.List;

public interface ListMatcher {

	<T> int findFirst(List<T> listA, List<T> listB);
	<T> int[] findAll(List<T> listA, List<T> listB);
}
