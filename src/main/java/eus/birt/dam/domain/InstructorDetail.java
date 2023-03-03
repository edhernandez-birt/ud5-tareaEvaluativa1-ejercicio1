package eus.birt.dam.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="instructor_detail")
public class InstructorDetail extends BaseEntity{

	@Column(name="blog")
	private String blog;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="instructorDetail")  //Mapped by no es con tabla, es con "objeto"
	private Instructor instructor;
}
