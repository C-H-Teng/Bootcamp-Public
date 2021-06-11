package com.charlesteng.javaoop;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calc1 = new Calculator(10.5,"+",5.2);
		Calculator calc2 = new Calculator(15.8,"-",9.3);


		System.out.println(calc1.getOperandOne() + calc1.getOperation() + calc1.getOperandTwo() + "=");
		System.out.println(calc1.performOperation());

		System.out.println(calc2.getOperandOne() + calc2.getOperation() + calc2.getOperandTwo() + "=");
		System.out.println(calc2.performOperation());
	}

}
