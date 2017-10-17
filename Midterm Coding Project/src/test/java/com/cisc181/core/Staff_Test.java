package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.eNums.eTitle;
import com.cisc181.Exception.*;

public class Staff_Test {

	static ArrayList<Staff> Staff = new ArrayList<Staff>();
	
	@BeforeClass
	public static void setup() {
		//add staff members
		Staff Joe = new Staff(eTitle.MR);
		Joe.setSalary(150000);
		Staff Jane = new Staff(eTitle.MRS);
		Jane.setSalary(50000);
		Staff Bob = new Staff(eTitle.MR);
		Bob.setSalary(70000);
		Staff Ashley = new Staff(eTitle.MS);
		Ashley.setSalary(105000);
		Staff Max = new Staff(eTitle.MR);
		Max.setSalary(55000);
		
		Staff.add(Joe);
		Staff.add(Jane);
		Staff.add(Bob);
		Staff.add(Ashley);
		Staff.add(Max);
	}
	
	@Test
	public void testStaff() {
		double aSalary = 0;
		for(Staff s: Staff) {
			aSalary += s.getSalary();
		}
		
		aSalary /= Staff.size();
		assertTrue(aSalary == 86000);
		assertFalse(aSalary == 100000);
	}	
	
	@Test(expected = PersonException.class)
	public void Test_DOB() throws PersonException {
		
		Calendar dob = Calendar.getInstance();
		dob.set(1854,10,28);
		Date DOB = dob.getTime();
		Staff Bill = new Staff(eTitle.MR);
		Bill.setDOB(DOB);
	}
	
	@Test(expected = PersonException.class)
	public void Test_Phone() throws PersonException {
			
		Staff Bill = new Staff(eTitle.MR);
		Bill.setPhone("6-78");
	}
}
