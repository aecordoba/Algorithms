/*
 * 		SelectionSortTest.java
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
 * 		SelectionSortTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Dec 3, 2020
 */
package ar.com.adriancordoba.test.console.algorithms.arraysort.selectionsort;

/**
 * Selection sort algorithm test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class SelectionSortTest {
	private static final int ARRAY_SIZE = 10;
	private static final int VALUES_LIMIT = 1000;

	private enum Order {
		DESCENDING, ASCENDING
	}

	private static Order sortOrder = Order.DESCENDING;

	/**
	 * Generate an array with random values, and sort it.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[ARRAY_SIZE];

		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * VALUES_LIMIT);

		System.out.println("SELECTION SORT");
		System.out.println("Generated array:");
		printArray(array);

		switch (sortOrder) {
			case ASCENDING:
				ascendingSelectionSort(array);
				break;
			case DESCENDING:
				descendingSelectionSort(array);
				break;
		}

		System.out.println(sortOrder + " sorted array:");
		printArray(array);
	}

	/**
	 * Ascending selection sort algorithm.
	 * @param array Array to sort.
	 */
	private static void ascendingSelectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i])
					swapElements(array, i, j);
			}
		}
	}

	/**
	 * Descending selection sort algorithm.
	 * @param array Array to sort.
	 */
	private static void descendingSelectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[i])
					swapElements(array, i, j);
			}
		}
	}

	/**
	 * Swap two array elements.
	 * @param array The array.
	 * @param index1 Index to the first element to swap.
	 * @param index2 Index to the second element to swap.
	 */
	private static void swapElements(int[] array, int index1, int index2) {
		int aux = array[index1];
		array[index1] = array[index2];
		array[index2] = aux;
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
