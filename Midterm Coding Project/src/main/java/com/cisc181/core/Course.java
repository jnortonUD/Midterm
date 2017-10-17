package com.cisc181.core;

import java.util.UUID;

public class Course {

	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	
	public Course(UUID CourseID){
		super();
		this.CourseID = CourseID;
	}
	public UUID getCourseID(){
		return this.CourseID;
	}
	public void setCourseID(UUID CourseID) {
		this.CourseID = CourseID;
	}
	public String getCourseName(){
		return this.CourseName;
	}
	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}
	public int getGradePoints() {
		return this.GradePoints;
	}
	public void setGradePoints(int GradePoints) {
		this.GradePoints = GradePoints;
	}
}
