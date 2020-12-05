/*
 * 		RecursiveBinarySearchTest.java
 *   Copyright (C) 2020  Adrián E. Córdoba [software.asia@gmail.com]
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * 		RecursiveBinarySearchTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Dec 5, 2020
 */
package ar.com.adriancordoba.test.console.algorithms.arraysearch.recursivebinarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Recursive binary search algorithm test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class RecursiveBinarySearchTest {
	private static final int ARRAY_SIZE = 10;
	private static final int VALUES_LIMIT = 1000;

	/**
	 * Generate an array with random values, and search a key in it.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[ARRAY_SIZE];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * VALUES_LIMIT);
		Arrays.sort(array);

		System.out.println("RECURSIVE BINARY SEARCH");
		System.out.println("Generated and sorted array:");
		printArray(array);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Input the element to search: ");
		int searchKey = Integer.parseInt(scanner.nextLine());
		scanner.close();

		int position = recursiveBinarySearch(array, 0, array.length - 1, searchKey);
		if (position != -1)
			System.out.println("Element \'" + searchKey + "\' is at position " + position + ".");
		else
			System.out.println("Element \'" + searchKey + "\' not found.");
	}

	/**
	 * Binary search algorithm.
	 * @param array The array where to search.
	 * @param firstIndex First index to search.
	 * @param lastIndex Last index to search,
	 * @param searchKey Key value to search.
	 * @return The index where key value was found; -1 if key value wasn't
	 *         found.
	 */
	private static int recursiveBinarySearch(int[] array, int firstIndex, int lastIndex, int searchKey) {
		int index = -1;
		if (firstIndex <= lastIndex) {
			int midIndex = (firstIndex + lastIndex) / 2;
			if (array[midIndex] == searchKey)
				index = midIndex;
			else {
				if (searchKey < array[midIndex])
					index = recursiveBinarySearch(array, firstIndex, midIndex - 1, searchKey);
				else
					index = recursiveBinarySearch(array, midIndex + 1, lastIndex, searchKey);
			}
		}
		return index;
	}

	/**
	 * Print an array.
	 * @param array Array to print.
	 */
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.format("%5d", array[i]);
		System.out.println();
	}
}
