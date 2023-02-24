package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Address;
import eus.birt.dam.domain.Course;
import eus.birt.dam.domain.Instructor;
import eus.birt.dam.domain.InstructorDetail;
import eus.birt.dam.domain.Project;
import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.Tuition;
import eus.birt.dam.domain.University;
import eus.birt.dam.repository.CourseRepository;
import eus.birt.dam.repository.InstructorDetailRepository;
import eus.birt.dam.repository.InstructorRepository;
import eus.birt.dam.repository.ProjectRepository;
import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.TuitionRepository;
import eus.birt.dam.repository.UniversityRepository;
import jakarta.transaction.Transactional;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TuitionRepository tuitionRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private InstructorDetailRepository instructorDetailsRepository;
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional //Metodo con única transaccion, evita: object references an unsaved transient instance
	@Override
	public void run(String... arg0) throws Exception {
		Student student1 = new Student("Jill", "Admin","as@s");
		Address address1 = new Address("Araba Kalea", "4","Gasteiz", "01100");
		Tuition tuition1 = new Tuition(4000.0);
		University university1 = new University("EHU");
		Course course1 = new Course("Acceso a datos",4);
		
		student1.setAddress(address1);
		student1.getPhones().add("687452145");
		student1.getPhones().add("687452146");
		student1.setBirthdate(LocalDate.parse("1989-04-04"));
		university1.setAddress(address1);
		
		student1.setTuition(tuition1);
		tuition1.setStudent(student1);
		
		student1.setUniversity(university1);
		university1.getStudents().add(student1);
		
		course1.getStudents().add(student1);
		student1.getCourses().add(course1);
		
//      Termina la tarea de aprendizaje 3 tal y como lo hemos hecho en la tarea evaluativa de la UD4, pero en este caso usando, Spring Boot y Spring MVC. Utiliza los recursos que nos ofrece el Spring. El resultado final debe contemplar el esquema entero en su globalidad. No vale únicamente con crear las tres entidades pendientes. Utiliza BootStrapData para introducir datos.(3 puntos)
//		Una vez preparadas las lases necesarias (modelos y repositorios JPA), podemos hacer lo que se pide:
		
//      Crea un nuevo objeto Instructor y guárdalo en la BD. La asociación entre Instructor y Curso será: @OneToMany bidireccional. 
//		Crea un nuevo instructor y añádele un curso ya creado.
        Instructor instructor1 = new Instructor("Beñat","Madina","bm@birt.eus");
        Address addressInstructor1 = new Address("Araba Kalea", "4","Gasteiz", "01100");
        instructor1.setAddress(addressInstructor1);
        instructor1.getCourses().add(course1);
        course1.setInstructor(instructor1);
        
//      Crea un nuevo objeto Instructor pero esta vez junto con el objeto Instructor_detail y guárdalo en la BD. 
//      La asociación entre Instructor e InstructorDetail será: @OneToOne bidireccional.
        
        InstructorDetail instructorDetail1 = new InstructorDetail();
        instructorDetail1.setBlog("La pesca en Euskadi");
        instructorDetail1.setHobby("Pesca");
        
        Instructor instructor2 = new Instructor ("Nora","San Saturnino","nora@birt.eus");
        instructor2.setAddress(addressInstructor1);
        instructor2.setInstructorDetail(instructorDetail1);
        instructorDetail1.setInstructor(instructor2);
        
//      Crea un nuevo objeto Project y guárdalo en la BD. 
//      La asociación entre Instructor y Project será: @ManyToMany bidireccional.

        Project project1 = new Project();
        project1.setName("ETHAZI");
        project1.setField("Educacion");
        project1.setBudget(17495.90);
        project1.getInstructors().add(instructor2);
        instructor2.getProjects().add(project1);
		
		courseRepository.save(course1);	
		universityRepository.save(university1);
		studentRepository.save(student1);
		tuitionRepository.save(tuition1);
		
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorDetailsRepository.save(instructorDetail1);
        
        projectRepository.save(project1);
		
		System.out.println("Started in Bootstrap");
        System.out.println("Number of Students: " + studentRepository.count());
        
			
	}
	
}