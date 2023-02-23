package eus.birt.dam.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name="tuition")
public class Tuition extends BaseEntity{
	
	@Column (name="fee")
	private Double fee;
	
	@OneToOne
	@JoinColumn(name="student_id", referencedColumnName="id")
	private Student student;

	public Tuition(Double fee) {
		super();
		this.fee = fee;
	}

	
}
