package eus.birt.dam.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="project")
public class Project extends BaseEntity{
	
	@Column (name= "name")
	private String name;
	
	@Column (name= "field")
	private String field;
	
	@Column (name= "budget")
	private double budget;
	
	@ManyToMany (mappedBy="projects")
	private Set<Instructor> instructors = new HashSet<>();

}
