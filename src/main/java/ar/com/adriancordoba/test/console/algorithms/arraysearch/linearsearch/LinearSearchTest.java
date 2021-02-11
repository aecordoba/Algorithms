/*
 * 		LinearSearchTest.java
 *   Copyright (C) 2021  Adrián E. Córdoba [software.asia@gmail.com]
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
 * 		LinearSearchTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Feb 11, 2021
 */
package ar.com.adriancordoba.test.console.algorithms.arraysearch.linearsearch;

import java.util.Arrays;

import ar.com.adriancordoba.test.console.algorithms.common.Utilities;

/**
 * Linear search algorithm test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class LinearSearchTest {
	private static final int ARRAY_SIZE = 10;
	private static final int VALUES_LIMIT = 1000;

	/**
	 * Gets an array with random values, and search a key in it.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utilities.generateArray(ARRAY_SIZE, VALUES_LIMIT);
		Arrays.sort(array);

		System.out.println("LINEAR SEARCH");
		System.out.println("Generated and sorted array:");
		Utilities.printArray(array);

		int searchKey = Utilities.getSearchKey();
		int position = linearSearch(array, searchKey);

		if (position != -1)
			System.out.println("Element \'" + searchKey + "\' is at position " + position + ".");
		else
			System.out.println("Element \'" + searchKey + "\' not found.");
	}

	/**
	 * Linear search algorithm. O(n)
	 * @param array The array where to search.
	 * @param searchKey The search key.
	 * @return The position where the search key was found. -1 if search key wasn't found.
	 */
	private static int linearSearch(int[] array, int searchKey) {
		int position = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == searchKey) {
				position = i;
				break;
			}
		}
		return position;
	}
}
