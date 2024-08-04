package org.example;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class FunctionalCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Введите функцию (например, x + y): ");
		String function = scanner.nextLine();
		
		System.out.print("Введите значение x: ");
		int x = scanner.nextInt();
		
		System.out.print("Введите значение y: ");
		int y = scanner.nextInt();
		
		try {
			double result = evaluateFunction(function, x, y);
			System.out.println("Result: " + result);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		scanner.close();
	}
	
	public static double evaluateFunction(String function, double x, double y) throws ScriptException {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		
		engine.put("x", x);
		engine.put("y", y);
		
		Object result = engine.eval(function);
		
		// Преобразуем результат в double
		return ((Number) result).doubleValue();
	}
}
