package com.spring_project.proyect.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter @Column(name = "id")
	private Long id;
	
	@Getter @Setter @Column(name = "name")
	private String name;
	
	@Getter @Setter @Column(name = "surname")
	private String surname;
	
	@Getter @Setter @Column(name = "email")
	private String email;
	
	@Getter @Setter @Column(name = "phone")
	private String phone;
	
	@Getter @Setter @Column(name = "password")
	private String password;

}
