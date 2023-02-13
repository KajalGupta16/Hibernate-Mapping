package com.jsp.controller;


import com.jsp.dto.Aadhar;
import com.jsp.dto.Pan;
import com.jsp.dto.Person;
import com.jsp.service.Service;

public class TestClass {
	public static void main(String[] args) {
		Pan pan = new Pan();
		pan.setName("kajal");

		Aadhar aadhar = new Aadhar();
		aadhar.setName("kajal");

		Person person = new Person();
		person.setEmail("kajal@gmail.com");
		person.setName("kajal");
		person.setAadhar(aadhar);
		person.setPan(pan);

		// to save

		Service service = new Service();
		service.testSave(person, aadhar, pan);

		// to update

		person.setId(2);
		service.updateById(person);

		// to get by Id

		person.setId(1);
		service.getById(person);

		// to get

		person.setId(2);
		service.deleteById(person);

	}
}
