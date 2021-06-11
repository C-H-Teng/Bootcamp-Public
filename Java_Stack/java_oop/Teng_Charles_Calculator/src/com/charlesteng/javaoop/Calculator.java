package com.charlesteng.javaoop;

public class Calculator {
	private double operandOne;
	private String operation;
	private double operandTwo;
	private double results;


	// constructors
	public Calculator() {
		this(0,"+",0);
	}

	public Calculator(double operandOne, String operation, double operandTwo) {
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
	}


	// methods
	public double performOperation() {
		if(this.operation == "+") {
			this.results = this.operandOne + this.operandTwo;
			return results;
		} else if(this.operation == "-") {
			this.results = this.operandOne - this.operandTwo;
			return results;
		} else {
			System.out.println(this.operation + " is not a valid operation.");
			return results;
		}
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public double getResults() {
		return results;
	}
}
