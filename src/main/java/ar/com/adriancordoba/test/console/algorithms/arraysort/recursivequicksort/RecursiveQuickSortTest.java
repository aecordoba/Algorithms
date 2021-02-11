/*
 * 		RecursiveQuickSortTest.java
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
 * 		RecursiveQuickSortTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Dec 5, 2020
 */
package ar.com.adriancordoba.test.console.algorithms.arraysort.recursivequicksort;

import ar.com.adriancordoba.test.console.algorithms.common.Utilities;

/**
 * Recursive quick sort algorithm test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class RecursiveQuickSortTest {
	private static final int ARRAY_SIZE = 10;
	private static final int VALUES_LIMIT = 1000;

	private enum Order {
		DESCENDING, ASCENDING
	}

	private static Order sortOrder = Order.ASCENDING;

	/**
	 * Gets an array with random values, and sort it.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utilities.generateArray(ARRAY_SIZE, VALUES_LIMIT);

		System.out.println("RECURSIVE QUICK SORT");
		System.out.println("Generated array:");
		Utilities.printArray(array);

		recursiveQuickSort(array, 0, array.length - 1);

		System.out.println(sortOrder + " sorted array:");
		Utilities.printArray(array);
	}

	/**
	 * Recursive quick sort algorithm.
	 * @param array Array to sort.
	 * @param start Index to the start position.
	 * @param end Index to the end position.
	 */
	private static void recursiveQuickSort(int[] array, int start, int end) {
		if (start < end) {
			int partitionIndex = 0;
			switch (sortOrder) {
				case ASCENDING:
					partitionIndex = ascendingArrayPartitioner(array, start, end);
					break;
				case DESCENDING:
					partitionIndex = descendingArrayPartitioner(array, start, end);
					break;
			}
			recursiveQuickSort(array, start, partitionIndex - 1);
			recursiveQuickSort(array, partitionIndex + 1, end);
		}
	}

	/**
	 * Splits an array into two parts for ascending order.
	 * @param array Array to partition.
	 * @param start Index to the start position.
	 * @param end Index to the end position.
	 * @return Index to the partition.
	 */
	private static int ascendingArrayPartitioner(int[] array, int start, int end) {
		int partitionIndex = start;
		while (start < end) {
			if (array[start] <= array[end]) {
				swapElements(array, partitionIndex, start);
				partitionIndex++;
			}
			start++;
		}
		swapElements(array, partitionIndex, end);
		return partitionIndex;
	}

	/**
	 * Splits an array into two parts for descending order.
	 * @param array Array to partition.
	 * @param start Index to the start position.
	 * @param end Index to the end position.
	 * @return Index to the partition.
	 */
	private static int descendingArrayPartitioner(int[] array, int start, int end) {
		int partitionIndex = start;
		while (start < end) {
			if (array[start] >= array[end]) {
				swapElements(array, partitionIndex, start);
				partitionIndex++;
			}
			start++;
		}
		swapElements(array, partitionIndex, end);
		return partitionIndex;
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
}
