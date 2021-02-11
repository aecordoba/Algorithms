/*
 * 		SortOrder.java
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
 * 		SortOrder.java
 *  Adrián E. Córdoba [software.asia@gmail.com]		Feb 11, 2021
 */
package ar.com.adriancordoba.test.console.algorithms.common;

/**
 * Define the two sort orders.
 * @author Adrián E. Córdoba [software.asia@gmail.com]
 */
public enum SortOrder {
	ASC("Ascending"), DES("Descending");

	private String description;

	private SortOrder(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
