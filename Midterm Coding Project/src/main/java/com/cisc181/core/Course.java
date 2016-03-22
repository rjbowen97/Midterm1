package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course
{
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor major;
	private double creditHours;
	
	public double getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(double creditHours) {
		this.creditHours = creditHours;
	}

	public UUID getCourseID() {
		return CourseID;
	}

	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public int getGradePoint() {
		return GradePoints;
	}

	public void setGradePoint(int gradePoint) {
		GradePoints = gradePoint;
	}

	public eMajor getMajor() {
		return major;
	}

	public void setMajor(eMajor major) {
		this.major = major;
	}
	
	Course()
	{
		
	}
}
