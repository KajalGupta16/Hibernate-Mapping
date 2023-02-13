package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Aadhar;
import com.jsp.dto.Pan;
import com.jsp.dto.Person;

public class PersonDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("kajal");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Person testSave(Person person, Aadhar aadhar, Pan pan) {

		entityTransaction.begin();
		entityManager.persist(aadhar);
		entityManager.persist(pan);
		entityManager.persist(person);
		entityTransaction.commit();

		return person;
	}

	public Person updateById(Person person) {
		Person p = entityManager.find(Person.class, person.getId());
		Aadhar a = entityManager.find(Aadhar.class, person.getId());
		Pan pan = entityManager.find(Pan.class, person.getId());
		if (p != null) {
			p.setEmail(person.getEmail());
			p.setName(person.getName());

			a.setName(person.getName());
			pan.setName(person.getName());

			entityTransaction.begin();
			entityManager.merge(p);
			entityManager.persist(pan);
			entityManager.persist(a);
			entityTransaction.commit();
		}
		return person;
	}
	public void getById(Person person) {
		Person p1=entityManager.find(Person.class,person.getId());
		if(p1!=null) {
			System.out.println(p1.getId());
			System.out.println(p1.getName());
			System.out.println(p1.getEmail());}}
	
	public void deleteById(Person person) {
		Person p1=entityManager.find(Person.class, person.getId());
		if(p1!=null) {
			entityTransaction.begin();
			entityManager.remove(p1);
			entityTransaction.commit();
		}
	}

}
