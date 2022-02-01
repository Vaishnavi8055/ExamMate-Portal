package com.exam.portal.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organisers")
public class Organiser implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(nullable=false,unique=true,length=50)
	private String email;
	
	@Column(nullable=false,length=50)
	private String name;
	
	@Column(nullable=false,length=250)
	private String password;
	
	
	/*
	 * organiser Id is the foreign key in the exam paper
	 */
	@OneToMany(mappedBy="organisers")
	private List<Exam> exams= new ArrayList<Exam>();


	public List<Exam> getExams() {
		return exams;
	}
}