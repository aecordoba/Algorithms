/*
 * 		RecursiveMergeSortTest.java
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
 * 		RecursiveMergeSortTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Feb 9, 2021
 */
package ar.com.adriancordoba.test.console.algorithms.arraysort.recursivemergesort;

import ar.com.adriancordoba.test.console.algorithms.common.Utilities;

/**
 * Recursive merge sort algorithm test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class RecursiveMergeSortTest {
	private static final int ARRAY_SIZE = 10;
	private static final int VALUES_LIMIT = 1000;

	private enum Order {
		DESCENDING, ASCENDING
	}

	private static Order sortOrder = Order.DESCENDING;

	/**
	 * Gets an array with random values, and sort it.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = Utilities.generateArray(ARRAY_SIZE, VALUES_LIMIT);

		System.out.println("RECURSIVE MERGE SORT");
		System.out.println("Generated array:");
		Utilities.printArray(array);

		recursiveMergeSort(array, 0, array.length - 1);

		System.out.println(sortOrder + " sorted array:");
		Utilities.printArray(array);
	}

	/**
	 * Recursive merge sort algorithm.
	 * @param array The array to sort.
	 * @param low Low index in the array.
	 * @param high High index in the array.
	 */
	private static void recursiveMergeSort(int[] array, int low, int high) {
		if (high > low) {
			int middle = (low + high) / 2;
			recursiveMergeSort(array, low, middle);
			recursiveMergeSort(array, middle + 1, high);
			switch (sortOrder) {
				case ASCENDING:
					ascendingMerge(array, low, middle, high);
					break;
				case DESCENDING:
					descendingMerge(array, low, middle, high);
					break;
			}

		} else
			return;
	}

	/**
	 * Merge two sub-arrays into one ascending sorted array.
	 * @param array The array to sort.
	 * @param low The low index in the array.
	 * @param middle The middle index in the array, to split in two sub-arrays.
	 * @param high The high index in the array.
	 */
	private static void ascendingMerge(int[] array, int low, int middle, int high) {
		int[] leftArray = new int[middle - low + 1];
		int leftIndex = 0;
		int[] rightArray = new int[high - middle];
		int rightIndex = 0;

		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[middle + 1 + i];

		for (int i = low; i <= high; i++) {
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if (leftArray[leftIndex] < rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < leftArray.length) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < rightArray.length) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}

	/**
	 * Merge two sub-arrays into one descending sorted array.
	 * @param array The array to sort.
	 * @param low The low index in the array.
	 * @param middle The middle index in the array, to split in two sub-arrays.
	 * @param high The high index in the array.
	 */
	private static void descendingMerge(int[] array, int low, int middle, int high) {
		int[] leftArray = new int[middle - low + 1];
		int leftIndex = 0;
		int[] rightArray = new int[high - middle];
		int rightIndex = 0;

		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[low + i];
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[middle + 1 + i];

		for (int i = low; i <= high; i++) {
			if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
				if (leftArray[leftIndex] > rightArray[rightIndex]) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			} else if (leftIndex < leftArray.length) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			} else if (rightIndex < rightArray.length) {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}
}
