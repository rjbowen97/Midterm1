package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

import exceptions.PersonException;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}

	@Test
	public void averageTest() throws PersonException {
		ArrayList<Staff> staffListTest = new ArrayList<Staff>();
		staffListTest.add(new Staff("Richard", "James", "Bowen", new Date(), "2632 Standardbred", "(717)-867-5309",
				"rjbowen@udel.edu", "9:00 pm", 2, 120000, new Date(), eTitle.PRINCIPAL));
		staffListTest.add(new Staff("Richard", "James", "Bowen", new Date(), "2632 Standardbred", "(717)-867-5309",
				"rjbowen@udel.edu", "9:00 pm", 2, 9600, new Date(), eTitle.PRINCIPAL));
		staffListTest.add(new Staff("Richard", "James", "Bowen", new Date(), "2632 Standardbred", "(717)-867-5309",
				"rjbowen@udel.edu", "9:00 pm", 2, 48000, new Date(), eTitle.PRINCIPAL));
		staffListTest.add(new Staff("Richard", "James", "Bowen", new Date(), "2632 Standardbred", "(717)-867-5309",
				"rjbowen@udel.edu", "9:00 pm", 2, 12000, new Date(), eTitle.PRINCIPAL));
		staffListTest.add(new Staff("Richard", "James", "Bowen", new Date(), "2632 Standardbred", "(717)-867-5309",
				"rjbowen@udel.edu", "9:00 pm", 2, 80000, new Date(), eTitle.PRINCIPAL));

		double averageSalaryTest = 0;
		for (Staff staff : staffListTest) {
			averageSalaryTest += staff.getSalary();
		}

		averageSalaryTest /= 5;
		assertEquals(averageSalaryTest, 53920, 0);
	}

	@Test(expected = PersonException.class)
	@SuppressWarnings("deprecation")
	public void phoneTest() throws PersonException {
		new Staff("Richard", "James", "Bowen", new Date(0, 0, 0, 0, 0), "2632 Standardbred", "(717)-867-5309",
				"rjbowen@udel.edu", "9:00 pm", 2, 120000, new Date(), eTitle.PRINCIPAL);
	}

	@Test(expected = PersonException.class)
	public void Test() throws PersonException {
		new Staff("Richard", "James", "Bowen", new Date(), "2632 Standardbred", "(717)8675309",
				"rjbowen@udel.edu", "9:00 pm", 2, 120000, new Date(), eTitle.PRINCIPAL);
	}

}
