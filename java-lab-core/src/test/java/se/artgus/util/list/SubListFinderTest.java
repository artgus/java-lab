package se.artgus.util.list;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubListFinderTest {
	
	private ListMatcher sut = new SubListFinder();

	@Test
	public void findsFirstSublistInMiddle() {
		
		List<String> listA = Arrays.asList("ab", "cd", "efg", "hi", "ab");
		List<String> listB = Arrays.asList("cd", "efg", "hi");
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", 1, actual);
	}

	@Test
	public void findsFirstSublistAtBeginning() {
		
		List<String> listA = Arrays.asList("ab", "cd", "efg", "hi", "ab");
		List<String> listB = Arrays.asList("ab", "cd");
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", 0, actual);
	}

	@Test
	public void findsFirstSublistAtEnd() {
		
		List<Character> listA = Arrays.asList('A', 'E', 'G', 'C', 'C', 'B');
		List<Character> listB = Arrays.asList('C', 'B');
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", 4, actual);
	}

	@Test
	public void findsFirstSublistWhenMoreExist() {
		
		List<Integer> listA = Arrays.asList(1, 3, 4, 5, 3, 2, 7, 4, 5, 3, 8);
		List<Integer> listB = Arrays.asList(4, 5, 3);
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", 2, actual);
	}

	@Test
	public void firstSublistNotFound() {
		
		List<Integer> listA = Arrays.asList(1, 3, 4, 5, 3, 2, 7, 4, 5, 3, 8);
		List<Integer> listB = Arrays.asList(8, 2);
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", -1, actual);
	}

	@Test
	public void firstNotFoundWhenSublistIsEmpty() {
		
		List<Integer> listA = Arrays.asList(1, 3, 4, 5, 3, 2, 7, 4, 5, 3, 8);
		List<Integer> listB = new ArrayList<>();
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", -1, actual);
	}

	@Test
	public void firstNotFoundWheListIsEmpty() {

		List<Integer> listB = new ArrayList<>();
		List<Integer> listA = Arrays.asList(1, 3, 4, 5);
		
		int actual = sut.findFirst(listA, listB);
		
		assertEquals("sublist index", -1, actual);
	}
}
