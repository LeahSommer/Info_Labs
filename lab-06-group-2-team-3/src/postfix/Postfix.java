package postfix;

import stack.LinkedListStack;
import stack.Underflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Postfix {

	static int precedence(String c){
		switch (c){
			case "+":
			case "-":
				return 1;
			case "*":
			case "/":
				return 2;
			case "^":
				return 3;
		}
		return -1;
	}

	public String infixToPostfix(String expression){
		ArrayList<String> sequence = new ArrayList<>(Arrays.asList(expression.split(" ")));
		String result = "";
		LinkedListStack<String> stack = new LinkedListStack<>();
		try {
			for (String c : sequence) {
				if (precedence(c) > 0) {
					while (!stack.isEmpty() && precedence(stack.top()) >= precedence(c)) {
						result += stack.pop() + " ";
					}
					stack.push(c);
				} else if (c.equals(")")) {
					String x = stack.pop();
					while (!x.equals("(")) {
						result += x + " ";
						x = stack.pop();
					}
				} else if (c.equals("(")) {
					stack.push(c);
				} else {
					result += c + " ";
				}
			}
			for (int i = 0; i < stack.size(); i++) {
				if (i == 0) {
					result += stack.pop();
				} else {
					result += " " + stack.pop();
				}
			}
		} catch (Underflow u) {
			System.out.println("INVALID EXPRESSION");
			return null;
		}

		// REmove space at the end
		return result.replaceAll("\\s+$", "");
	}

	public static void main(String[] args) {
		Postfix p = new Postfix();
		Scanner scanner = new Scanner(System.in);
		while (true){
			String s = scanner.nextLine();
			System.out.println(s);
			if (s.equals("quit")) break;
			String postfix = p.infixToPostfix(s);
			Double result = p.evaluate(postfix);
			System.out.println(s + " -> " + postfix + " => " + result);
		}
		System.out.println("Bye...");
		scanner.close();
	}

	public double evaluate(String postfix) {
		LinkedListStack<Double> stack = new LinkedListStack<>();
		ArrayList<String> sequence = new ArrayList<>(Arrays.asList(postfix.split(" ")));
		System.out.println(sequence.toString());
		Double result = 0.0;
		for (String letter : sequence) {
			try {
				// Check if letter is operand
				if (letter.equals("*") || letter.equals("+") || letter.equals("-") || letter.equals("/") || letter.equals("^")) {
					Double val2 = stack.pop();
					Double val1 = stack.pop();
					switch (letter) {
						case "*":
							result = val1*val2;
							break;
						case "+":
							result = val1+val2;
							break;
						case "-":
							result = val1-val2;
							break;
						case "/":
							result = val1/val2;
							break;
						case "^":
							result = Math.pow(val1, val2);
							break;
					}
					System.out.println("DOING: " + val1 + letter + val2);
					stack.push(result);
				} else {
					stack.push(Double.valueOf(letter));
					System.out.println(stack.toString());
				}
			} catch (Underflow u) {
				System.out.println("INVALID STATMENT");
				return -1;
			}
		}

		System.out.println("RESULT = " + result);

		return result;
	}

}
