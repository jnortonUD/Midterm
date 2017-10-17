package com.cisc181.Exception;

import java.util.Date;

import com.cisc181.core.Person;

public class PersonException extends Exception{

	private Person p;
	
	public PersonException(Person p) {
		super();
		this.p = p;
	}
	
	public Person getP() {
		return p;
	}
}
