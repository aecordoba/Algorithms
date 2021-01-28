/*
 * 		RecursiveFibonacciSeriesGeneratorTest.java
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
 * 		RecursiveFibonacciSeriesGeneratorTest.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Jan 28, 2021
 */
package ar.com.adriancordoba.test.console.algorithms.fibonacciseries.recursivefibonaccinumbergenerator;

/**
 * Recursive Fibonacci series generator test.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public class RecursiveFibonacciSeriesGeneratorTest {
	private static final int NUMBER_LIMIT = 40;

	/**
	 * Generate an array with the Fibonacci series.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] fibonacciSeries = new int[NUMBER_LIMIT];
		for(int i = 0; i < fibonacciSeries.length; i++)
			fibonacciSeries[i] = recursiveFibonocciNumberGenerator(i);
		printFibonacciSeries(fibonacciSeries);
	}

	/**
	 * Recursive Fibonacci number generator.
	 * @param number Order of Fibonacci series.
	 * @return The Fibonacci number.
	 */
	private static int recursiveFibonocciNumberGenerator(int number) {
		int fibonacciNumber = 0;
		if (number <= 1)
			fibonacciNumber = number;
		else
			fibonacciNumber = recursiveFibonocciNumberGenerator(number - 1) + recursiveFibonocciNumberGenerator(number - 2);
		return fibonacciNumber;
	}

	/**
	 * Print the Fibonacci series.
	 * @param fibonacciSeries Fibonacci Series array.
	 */
	private static void printFibonacciSeries(int[] fibonacciSeries) {
		System.out.format("%5s %10s\n","ORDER", "FIBONACCI");
		for (int i = 0; i < fibonacciSeries.length; i++)
			System.out.format("%5d %10d\n",i, fibonacciSeries[i]);
		System.out.println();
	}
}
