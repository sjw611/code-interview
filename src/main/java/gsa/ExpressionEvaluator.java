package gsa;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpressionEvaluator {
	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");

		String expression = "1+3*4+7*(1+3)";

		try {
			System.out.println(scriptEngine.eval(expression));
		} catch (ScriptException e) {
			throw new IllegalStateException(e);
		}
	}
}
