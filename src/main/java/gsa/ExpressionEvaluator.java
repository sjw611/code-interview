package gsa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionEvaluator {

	private static final String TOKEN_SEPARATOR_PATTERN = "\\s+";
	private static final String TOKEN_SEPARATOR = " ";

	private static final String LEFT_PAREN = "(";
	private static final String RIGHT_PAREN = ")";

	private static final Pattern OPERAND_PATTERN = Pattern.compile("\\d+");

	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

		String expression = "1 + 3 * 4 + 7 * ( 1 + 3 )";

		try {
			System.out.println(scriptEngine.eval(expression));
		} catch (ScriptException e) {
			throw new IllegalStateException(e);
		}

		String postfixExpression = infixToPostfix(expression);
		System.out.println(postfixExpression);

		System.out.println(postfixEvaluator(postfixExpression));
	}

	public static String infixToPostfix(String infixExpression) {
		Objects.requireNonNull(infixExpression);
		StringBuilder postfixExpressionBuilder = new StringBuilder();

		String[] tokens = infixExpression.split(TOKEN_SEPARATOR_PATTERN);

		Deque<String> stack = new ArrayDeque<>();

		for (String token : tokens) {
			if (isOperand(token)) {
				postfixExpressionBuilder.append(token).append(TOKEN_SEPARATOR);
			}
			if (LEFT_PAREN.equals(token)) {
				stack.push(LEFT_PAREN);
			}
			if (RIGHT_PAREN.equals(token)) {
				while (!stack.isEmpty() && !LEFT_PAREN.equals(stack.peek())) {
					postfixExpressionBuilder.append(stack.pop()).append(TOKEN_SEPARATOR);
				}
				if (LEFT_PAREN.equals(stack.peek())) {
					stack.pop();
				}
			}
			if (isOperator(token)) {
				Operation operation = Operation.fromSymbol(token);

				while (!stack.isEmpty()) {
					if (LEFT_PAREN.equals(stack.peek())) {
						break;
					} else {
						Operation operationOnTop = Operation.fromSymbol(stack.peek());
						if (OperationPrecedence.INSTANCE.compare(operation, operationOnTop) > 0) {
							break;
						} else {
							postfixExpressionBuilder.append(stack.pop()).append(TOKEN_SEPARATOR);
						}
					}
				}

				stack.push(token);
			}
		}

		while (!stack.isEmpty()) {
			postfixExpressionBuilder.append(stack.pop()).append(TOKEN_SEPARATOR);
		}

		return postfixExpressionBuilder.toString();
	}

	public static enum OperationPrecedence implements Comparator<Operation> {

		INSTANCE;

		@Override
		public int compare(Operation left, Operation right) {
			Objects.requireNonNull(left);
			Objects.requireNonNull(right);

			return Integer.compare(left.precedence, right.precedence);
		}

	}

	public static double postfixEvaluator(String postfixExpression) {
		Objects.requireNonNull(postfixExpression);

		String[] tokens = postfixExpression.split(TOKEN_SEPARATOR_PATTERN);

		Deque<String> stack = new ArrayDeque<>();

		for (String token : tokens) {
			if (isOperator(token)) {
				String rightToken = stack.pop();
				String leftToken = stack.pop();

				Operation operation = Operation.fromSymbol(token);
				double leftOperand = Double.valueOf(leftToken);
				double rightOperand = Double.valueOf(rightToken);

				double result = operation.operator.apply(leftOperand, rightOperand);

				stack.push(String.valueOf(result));
			} else {
				stack.push(token);
			}
		}

		return Double.valueOf(stack.poll());
	}

	private static boolean isOperator(String token) {
		return Operation.symbols().contains(token);
	}

	private static boolean isOperand(String token) {
		return OPERAND_PATTERN.matcher(token).matches();
	}

	public static enum Operation {

		PLUS("+", (a, b) -> a + b, 1), MINUS("-", (a, b) -> a - b, 1), MULTIPLY("*", (a, b) -> a * b, 2), DIVIDE("/",
				(a, b) -> a / b, 2);

		private final String symbol;
		private final BinaryOperator<Double> operator;
		private final int precedence;

		private static final Map<String, Operation> symbolLookupMap = Arrays.stream(Operation.values())
				.collect(Collectors.toMap(a -> a.symbol, Function.identity()));

		private Operation(String symbol, BinaryOperator<Double> bop, int precedence) {
			this.symbol = Objects.requireNonNull(symbol);
			this.operator = Objects.requireNonNull(bop);
			this.precedence = precedence;
		}

		public static Set<String> symbols() {
			return Collections.unmodifiableSet(symbolLookupMap.keySet());
		}

		public static Operation fromSymbol(String symbol) {
			if (!symbols().contains(symbol)) {
				throw new IllegalArgumentException("Unsupported operator " + symbol);
			}
			return symbolLookupMap.get(symbol);
		}
	}
}
