package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;

public class Student_Test {
		//create empty array lists
		static ArrayList<Course> Courses = new ArrayList<Course>();
		static ArrayList<Semester> Semesters = new ArrayList<Semester>();
		static ArrayList<Section> Sections = new ArrayList<Section>();
		static ArrayList<Student> Students = new ArrayList<Student>();
		static ArrayList<Enrollment> ClassMembers = new ArrayList<Enrollment>();
	
	@BeforeClass
	public static void setUp() throws Exception{
				
		//add courses
		Course CISC106 = new Course(UUID.randomUUID());
		Courses.add(CISC106);
		Course CHEM111 = new Course(UUID.randomUUID());
		Courses.add(CHEM111);
		Course MATH305 = new Course(UUID.randomUUID());
		Courses.add(MATH305);
		
		//add semesters
		Semester FallSemester = new Semester(UUID.randomUUID());
		Semesters.add(FallSemester);
		Semester SpringSemester = new Semester(UUID.randomUUID());
		Semesters.add(SpringSemester);
		
		//add sections
		for(Course c : Courses) {
			for(Semester s : Semesters) {
				Sections.add(new Section(c.getCourseID(),s.getSemesterID()));
			}
		}
		
		//add students
		Calendar cal1 = Calendar.getInstance();
		cal1.set(1995,1,16); 
		Date dob = cal1.getTime();
		
		Students.add(new Student("John","A","Doe",dob,eMajor.CHEM, "0","000-000-0000","jdoe1"));
		Students.add(new Student("Bob","B","Doe",dob,eMajor.COMPSI, "1","100-000-0000","bdoe"));
		Students.add(new Student("Jess","C","Doe",dob,eMajor.NURSING, "2","200-000-0000","jdoe2"));
		Students.add(new Student("Mike","D","Doe",dob,eMajor.CHEM, "3","300-000-0000","mdoe1"));
		Students.add(new Student("Sarah","E","Doe",dob,eMajor.BUSINESS, "4","400-000-0000","sdoe"));
		Students.add(new Student("Rachel","F","Doe",dob,eMajor.BUSINESS, "5","500-000-0000","rdoe"));
		Students.add(new Student("Matt","G","Doe",dob,eMajor.COMPSI, "6","600-000-0000","mdoe2"));
		Students.add(new Student("Alex","H","Doe",dob,eMajor.NURSING, "7","700-000-0000","adoe"));
		Students.add(new Student("Emily","I","Doe",dob,eMajor.CHEM, "8","800-000-0000","edoe"));
		Students.add(new Student("Liz","J","Doe",dob,eMajor.BUSINESS, "9","900-000-0000","ldoe"));
		
		//enroll students
		double d = 4.0;
		for(Student a : Students) {
			for(Section b : Sections) {
				Enrollment e = new Enrollment(a.getStudentID(),b.getSectionID());
				e.setGrade(d);
				ClassMembers.add(e);
				d -= 0.05;
			}
		}
		
	}

	@Test
	public void testStudent() {
		
		List<Double> l1 = new ArrayList<Double>();
		List<Double> l2 = Arrays.asList(3.875,3.575,3.275,2.975,2.675,2.375,2.075,1.775,1.475,1.175);
		for(Student s : Students) {
			double GPA = 0.0;
			for(Enrollment e : ClassMembers) {
				if(e.getStudentID() == s.getStudentID()) {
					GPA += e.getGrade()/6;	
				}
			}
			l1.add(GPA);
		}
		for(int i = 0; i < 10;i++) {
			assertEquals(l1.get(i), l2.get(i),0.0001);
		}
	}
	@Test
	public void testClass() {
		
		List<Double> l1 = new ArrayList<Double>();
		List<Double> l2 = new ArrayList<Double>();
		for(Section s : Sections) {
			double GPA = 0.0;
			for(Enrollment e : ClassMembers) {
				if(e.getSectionID() == s.getSectionID()) {
					GPA += e.getGrade()/10;	
				}
			}
			l1.add(GPA);
		}
		for(int i = 0;i<5;i+=2) {
			l2.add((l1.get(i)+l1.get(i+1))/2);
		}
		for(Course c : Courses) {
			c.setGradePoints((int)Math.round(l2.get(0)/4*100));
			l2.remove(0);
		}
		assertEquals(Courses.get(0).getGradePoints(),66);
		assertEquals(Courses.get(1).getGradePoints(),63);
		assertEquals(Courses.get(2).getGradePoints(),61);
	}
}