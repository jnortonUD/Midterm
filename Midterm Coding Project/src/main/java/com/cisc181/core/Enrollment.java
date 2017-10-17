package com.cisc181.core;

import java.util.UUID;

public class Enrollment {

	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	
	public UUID getSectionID() {
		return this.SectionID;
	}
	public void setSectionID(UUID SectionID) {
		this.SectionID = SectionID;
	}
	public UUID getStudentID() {
		return this.StudentID;
	}
	public void setStudentID(UUID StudentID) {
		this.StudentID = StudentID;
	}
	public UUID getEnrollmentID() {
		return this.EnrollmentID;
	}
	public double getGrade() {
		return this.Grade;
	}
	public void setGrade(double Grade) {
		this.Grade = Grade;
	}
	private Enrollment() {
	
	}
	public Enrollment(UUID StudentID, UUID SectionID){
		super();
		this.StudentID = StudentID;
		this.SectionID = SectionID;
		this.EnrollmentID = UUID.randomUUID();
	}
}
