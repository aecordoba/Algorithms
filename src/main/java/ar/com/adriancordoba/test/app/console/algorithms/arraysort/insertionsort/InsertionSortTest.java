/*
 * 		InsertionSortTest.java
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
 * 		InsertionSortTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Dec 5, 2020
 */
package ar.com.adriancordoba.test.app.console.algorithms.arraysort.insertionsort;

import ar.com.adriancordoba.test.app.console.algorithms.common.SortOrder;
import ar.com.adriancordoba.test.app.console.algorithms.common.Utilities;

/**
 * Insertion sort algorithm test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class InsertionSortTest {
	private static final int ARRAY_SIZE = 10;
	private static final int VALUES_LIMIT = 1000;

	private static SortOrder sortOrder;

	/**
	 * Gets an array with random values, and sort it.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utilities.generateArray(ARRAY_SIZE, VALUES_LIMIT);

		System.out.println("INSERTION SORT");
		System.out.println("Generated array:");
		Utilities.printArray(array);

		sortOrder = Utilities.getSortOrder();
		switch (sortOrder) {
			case ASC:
				ascendingInsertionSort(array);
				break;
			case DES:
				descendingInsertionSort(array);
				break;
		}

		System.out.println(sortOrder.getDescription() + " sorted array:");
		Utilities.printArray(array);
	}

	/**
	 * Ascending insertion sort algorithm. O(n²)
	 * @param array Array to sort.
	 */
	private static void ascendingInsertionSort(int[] array) {
		for (int index1 = 1; index1 < array.length; index1++) {
			int key = array[index1];
			int index2 = index1 - 1;
			while (index2 >= 0 && array[index2] > key) {
				array[index2 + 1] = array[index2];
				index2--;
			}
			array[index2 + 1] = key;
		}
	}

	/**
	 * Descending insertion sort algorithm. O(n²)
	 * @param array Array to sort.
	 */
	private static void descendingInsertionSort(int[] array) {
		for (int index1 = 1; index1 < array.length; index1++) {
			int key = array[index1];
			int index2 = index1 - 1;
			while (index2 >= 0 && array[index2] < key) {
				array[index2 + 1] = array[index2];
				index2--;
			}
			array[index2 + 1] = key;
		}
	}
}
