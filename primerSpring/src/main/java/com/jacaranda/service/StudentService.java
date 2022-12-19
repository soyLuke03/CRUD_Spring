package com.jacaranda.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.model.Student;

@Service
public class StudentService {
	
	private List<Student> lista;

	public StudentService() {
		lista = new ArrayList<Student>();
		
		lista.add(new Student("Inma","Olias",25));
		lista.add(new Student("Jose","Adolfo",41));
		lista.add(new Student("Fran","Oliver",23));
		lista.add(new Student("Gonzalo","Gonzalez",15));
	}

	public boolean removeStudents(Student o) {
		return lista.remove(o);
	}
	
	public boolean addStudents(Student o) {
		return lista.add(o);
	}
	
	public Student getStudent(String nombre, String apellido) {
		Boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> iterator = this.lista.iterator();
		while (iterator.hasNext() && !encontrado) {
			resultado = iterator.next();
			if( resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				encontrado = true;
			}
		}
		
		if (encontrado == true) {
			return resultado;
		}else {
			return null;
		}
	}
	
	
	public Student updateStudent(String nombre, String apellido, int edad) {
		Boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> iterator = this.lista.iterator();
		while (iterator.hasNext() && !encontrado) {
			resultado = iterator.next();
			if( resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				resultado.setAge(edad);
				encontrado = true;
			}
		}
		
		if (encontrado == true) {
			return resultado;
		}else {
			return null;
		}
	}

	
	
	public List<Student> getStudents() {
		return lista;
	}

	public void setLista(List<Student> lista) {
		this.lista = lista;
	}

	
	
	
	
}
