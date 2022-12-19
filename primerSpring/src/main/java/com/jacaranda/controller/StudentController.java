package com.jacaranda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.model.Student;
import com.jacaranda.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService repositorio;
	
	@GetMapping("ListStudent")					
	public String listStudent(Model model) {
		model.addAttribute("lista",repositorio.getStudents());
		return "listStudents";
	}
	
	/*-----------------------------------------------*/

	
	@GetMapping("ListStudent/Del")
	public String delStudent(Model model, 
			@RequestParam(name="name") String name,
			@RequestParam(name="surname") String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		
		
		model.addAttribute("student",estudiante);
		return "delStudent";
	}
	
	@PostMapping("ListStudent/Del/Submit")
	public String delStudentSubmit(@ModelAttribute("student") Student newStudent) {
		
		repositorio.removeStudents(newStudent);
		return "redirect:/ListStudent";
	}

	/*-----------------------------------------------*/

	
	@GetMapping("ListStudent/Mod")
	public String modStudent(Model model) {
		return "modStudent";
	}
	
	
	/*-----------------------------------------------*/
	
	@GetMapping("ListStudent/Add")
	public String addStudent(Model model) {
		Student student = new Student();
		
		model.addAttribute("student",student);
		return "addStudent";
	}
	
	@PostMapping("ListStudent/Add/Submit")
	public String addStudentSubmit(@ModelAttribute("student") Student newStudent) {
		
		repositorio.addStudents(newStudent);
		return "redirect:/ListStudent";
	}
	
	/*-----------------------------------------------*/
	
}
