package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter/*Lombok crea los getters y setters...*/
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="instructor")
public class Instructor extends BaseEntity{

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Embedded
	private Address address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id", referencedColumnName="id")
	private InstructorDetail instructorDetail;
	
	@OneToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn (name = "instructor_id")
	List <Course> courses = new ArrayList<>();
	
	@ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="instructor_project", joinColumns=@JoinColumn(name="instructor_id"), 
			inverseJoinColumns=@JoinColumn(name="project_id"))
	private Set<Project> projects = new HashSet<>();

	public Instructor(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}
