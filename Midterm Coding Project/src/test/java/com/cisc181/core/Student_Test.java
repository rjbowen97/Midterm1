package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

import exceptions.PersonException;

public class Student_Test {

	static ArrayList<Course> courseListTest = new ArrayList<Course>();
	static ArrayList<Semester> semesterListTest = new ArrayList<Semester>();
	static ArrayList<Section> sectionListTest = new ArrayList<Section>();
	static ArrayList<Student> studentListTest = new ArrayList<Student>();
	static ArrayList<Enrollment> enrollListTest = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws PersonException {
		// add new courses to the test list of courses
		courseListTest.add(new Course());
		courseListTest.add(new Course());
		courseListTest.add(new Course());

		// set credit hours
		courseListTest.get(0).setCreditHours(2);
		courseListTest.get(1).setCreditHours(1);
		courseListTest.get(2).setCreditHours(4);

		// set grade points for the given course
		courseListTest.get(0).setGradePoint(8);
		courseListTest.get(1).setGradePoint(4);
		courseListTest.get(2).setGradePoint(16);

		// add new semesters to the semester test list
		semesterListTest.add(new Semester());
		semesterListTest.add(new Semester());

		// create a new list of sections
		for (int courseListIndex = 0; courseListIndex < 3; courseListIndex++) {
			for (int semesterListIndex = 0; semesterListIndex < 2; semesterListIndex++) {
				sectionListTest.add(new Section(semesterListTest.get(semesterListIndex).getSemesterID(),
						courseListTest.get(courseListIndex).getCourseID()));
			}
		}
		// add students to a list for testing
		for (int studentListIndex = 0; studentListIndex < 10; studentListIndex++) {
			studentListTest.add(new Student("Richard", "James", "Bowen", new Date(), eMajor.BUSINESS,
					"2632 standardbred", "(717)-471-7535", "rjbowen@udel.edu"));
		}

		// enroll 10 students into six classes each
		for (int enrollSectionIndex = 0; enrollSectionIndex < 6; enrollSectionIndex++) {
			for (int enrollStudentListIndex = 0; enrollStudentListIndex < 10; enrollStudentListIndex++) {
				enrollListTest.add(new Enrollment(studentListTest.get(enrollStudentListIndex).getStudentID(),
						sectionListTest.get(enrollSectionIndex).getSectionID()));
			}
		}

		// assigns each student a grade for each section (10 students in 6
		// sections
		for (int gradedSection = 0; gradedSection < 60; gradedSection += 10) {
			enrollListTest.get(gradedSection).setGrade(95.0);
			enrollListTest.get(gradedSection + 1).setGrade(75.0);
			enrollListTest.get(gradedSection + 2).setGrade(98.4);
			enrollListTest.get(gradedSection + 3).setGrade(16.7);
			enrollListTest.get(gradedSection + 4).setGrade(84.0);
			enrollListTest.get(gradedSection + 5).setGrade(76.0);
			enrollListTest.get(gradedSection + 6).setGrade(83.3);
			enrollListTest.get(gradedSection + 7).setGrade(100.0);
			enrollListTest.get(gradedSection + 8).setGrade(76.0);
			enrollListTest.get(gradedSection + 9).setGrade(50.0);
		}
	}

	@Test
	public void sectionZeroTest() {

		double totalGrade = 0;
		for (int averageStartIndex = 0; averageStartIndex < 10; averageStartIndex++) {
			totalGrade += enrollListTest.get(averageStartIndex).getGrade();
		}

		assertEquals(totalGrade / 10, 75.44, 0);

		// get grade of student zero in section zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(0).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.8, 0);

		// get grade of student one in section zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(1).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.0, 0);

		// get grade of student zero in section zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(
				((enrollListTest.get(2).getGrade() / 100))
						* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()),
				3.936, 0.01);

		// get grade of student one in section zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(
				((enrollListTest.get(3).getGrade() / 100))
						* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()),
				0.668, 0.001);

		// get grade of student zero in section zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(4).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.36, 0);

		// get grade of student one in section zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(5).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.04, 0);

		// get grade of student zero in section zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(6).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.332, 0);

		// get grade of student one in section zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(7).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 4.0, 0);

		// get grade of student zero in section zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(8).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.04, 0);

		// get grade of student one in section zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(9).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 2.0, 0);
	}

	@Test
	public void sectionOneTest() {

		double totalGrade = 0;
		for (int averageStartIndex = 10; averageStartIndex < 20; averageStartIndex++) {
			totalGrade += enrollListTest.get(averageStartIndex).getGrade();
		}

		assertEquals(totalGrade / 10, 75.44, 0);

		// get grade of student zero in section one
		// get gradepoints of class 1
		// get credit hours of course 1
		assertEquals(((enrollListTest.get(10).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.8, 0);

		// get grade of student one in section one
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(11).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.0, 0);

	}

	@Test
	public void sectionTwoTest() {

		double totalGrade = 0;
		for (int averageStartIndex = 20; averageStartIndex < 30; averageStartIndex++) {
			totalGrade += enrollListTest.get(averageStartIndex).getGrade();
		}

		assertEquals(totalGrade / 10, 75.44, 0);

		// get grade of student zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(20).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.8, 0);

		// get grade of student zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(21).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.0, 0);
	}

	@Test
	public void sectionThreeTest() {

		double totalGrade = 0;
		for (int averageStartIndex = 30; averageStartIndex < 40; averageStartIndex++) {
			totalGrade += enrollListTest.get(averageStartIndex).getGrade();
		}

		assertEquals(totalGrade / 10, 75.44, 0);

		// get grade of student zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(30).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.8, 0);

		// get grade of student zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(31).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.0, 0);

	}

	@Test
	public void sectionFourTest() {

		double totalGrade = 0;
		for (int averageStartIndex = 40; averageStartIndex < 50; averageStartIndex++) {
			totalGrade += enrollListTest.get(averageStartIndex).getGrade();
		}

		assertEquals(totalGrade / 10, 75.44, 0);

		// get grade of student zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(40).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.8, 0);

		// get grade of student zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(41).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.0, 0);

	}

	@Test
	public void sectionFiveTest() {

		double totalGrade = 0;
		for (int averageStartIndex = 50; averageStartIndex < 60; averageStartIndex++) {
			totalGrade += enrollListTest.get(averageStartIndex).getGrade();
		}

		assertEquals(totalGrade / 10, 75.44, 0);

		// get grade of student zero
		// get gradepoints of class zero
		// get credit hours of course zero
		assertEquals(((enrollListTest.get(50).getGrade() / 100))
				* (courseListTest.get(0).getGradePoint() / courseListTest.get(0).getCreditHours()), 3.8, 0);

		// get grade of student zero
		// get gradepoints of class One
		// get credit hours of course One
		assertEquals(((enrollListTest.get(51).getGrade() / 100))
				* (courseListTest.get(1).getGradePoint() / courseListTest.get(1).getCreditHours()), 3.0, 0);

	}

	@Test
	public void majorChangeTest() {
		studentListTest.get(0).seteMajor(eMajor.BUSINESS);
	}

}