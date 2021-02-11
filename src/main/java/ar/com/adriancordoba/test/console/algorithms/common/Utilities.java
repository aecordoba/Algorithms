/*
 * 		Utilities.java
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
 * 		Utilities.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Feb 9, 2021
 */
package ar.com.adriancordoba.test.console.algorithms.common;

import java.util.Scanner;

/**
 * Define the utilities methods for algorithms.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class Utilities {
	/**
	 * Generate an array of random integers.
	 * @param size Array size.
	 * @param limit Value limit for elements.
	 * @return
	 */
	public static int[] generateArray(int size, int limit) {
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * limit);
		return array;
	}

	/**
	 * Gets the sort order from the user.
	 * @return The sort order.
	 */
	public static SortOrder getSortOrder() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the sort order ('ASC' or 'DES'): ");
		String order = scanner.nextLine();
		while (!order.equals("ASC") && !order.equals("DES")) {
			System.out.print("Enter a valid sort order ('ASC' or 'DES'): ");
			order = scanner.nextLine();
		}
		scanner.close();
		System.out.println();
		return SortOrder.valueOf(order);
	}

	/**
	 * Gets the search key from the user.
	 * @return The search key.
	 */
	public static int getSearchKey() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the element to search: ");
		int searchKey = Integer.parseInt(scanner.nextLine());
		scanner.close();
		System.out.println();
		return searchKey;
	}

	/**
	 * Print an array.
	 * @param array Array to print.
	 */
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++)
			System.out.format("%5d", array[i]);
		System.out.println();
	}
}
