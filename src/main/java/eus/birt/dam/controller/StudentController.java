package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
   	private StudentRepository studentRepository;
    
    @GetMapping({"/students", "/"})
    public String getStudents(Model model){

        model.addAttribute("students", studentRepository.findAll());

        return "students/list";	
    }
 
}
