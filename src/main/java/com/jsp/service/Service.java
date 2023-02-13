package com.jsp.service;

import com.jsp.dao.PersonDao;
import com.jsp.dto.Aadhar;
import com.jsp.dto.Pan;
import com.jsp.dto.Person;

public class Service {

	PersonDao personDao = new PersonDao();

	public void testSave(Person person, Aadhar aadhar, Pan pan) {
		personDao.testSave(person, aadhar, pan);
	}

	public void updateById(Person person) {
		personDao.updateById(person);

	}

	public void getById(Person person) {
		personDao.getById(person);
	}

	public void deleteById(Person person) {
		personDao.deleteById(person);
	}

}
