package com.cisc181.core;

import java.util.UUID;

public class Section {

	private UUID CourseID;
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;
	
	public UUID getCourseID(){
		return this.CourseID;
	}
	public void setCourseID(UUID CourseID) {
		this.CourseID = CourseID;
	}
	public UUID getSemesterID(){
		return this.SemesterID;
	}
	public void setSemesterID(UUID SemesterID){
		this.SemesterID = SemesterID;
	}
	public UUID getSectionID() {
		return this.SectionID;
	}
	public int getRoomID() {
		return this.RoomID;
	}
	public void setRoomID(int RoomID) {
		this.RoomID = RoomID;
	}
	public Section(UUID CourseID, UUID SemesterID) {
		super();
		this.CourseID = CourseID;
		this.SemesterID = SemesterID;
		this.SectionID = UUID.randomUUID();
	}
}
