package com.jacaranda.model;

import java.util.Objects;

public class Calculator {

	private Double number1;
	private Double number2;
	
	private String operation;

	public Calculator(Double number1, Double number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}
	
	public Calculator() {
		// TODO Auto-generated constructor stub
	}

	public Calculator(Double number1, Double number2, String operation) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}
	
	public Double operar() {
		Double resultado = -1.0;
		
		switch (operation) {
		case "+": 
			resultado = number1+number2;	
			break;
		
		case "-": 
			resultado = number1-number2;	
			break;
		
		case "/": 
			resultado = number1/number2;	
			break;
		
		case "*": 
			resultado = number1*number2;	
			break;
		
		default:
			break;
		}
		
		return resultado;
		
	}


	
	
	
	
	@Override
	public String toString() {
		return "Calculator [number1=" + number1 + ", number2=" + number2 + ", operation=" + operation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(number1, number2, operation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		return Objects.equals(number1, other.number1) && Objects.equals(number2, other.number2)
				&& Objects.equals(operation, other.operation);
	}

	public Double getNumber1() {
		return number1;
	}

	public void setNumber1(Double number1) {
		this.number1 = number1;
	}

	public Double getNumber2() {
		return number2;
	}

	public void setNumber2(Double number2) {
		this.number2 = number2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	

	
	
	
}
