package com.mlog.util.command;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class JJSCommand implements Command {

	public String execute(String... args) {
		String result = null;

		String var = args[0];
		String src = args[1];

		PrintStream originalPrintStream = System.out;

		try {
			String script = "";
			src = convert(src);

			if (var != null && var.length() > 0) {
				script = var + "\n" + src;
			} else {
				script = src;
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			System.setOut(new PrintStream(baos));  // redirect standard out to print stream.

			ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript"); // create script engine. it take a little bit long time...
			scriptEngine.eval(script);

			result = baos.toString();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.setOut(originalPrintStream);
		}

		return result;
	}

	private String convert(String plain) {
		String converted = plain;
		String regex = "execution.setVariable\\((.*?)\\)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(plain);		
		
		while (matcher.find()) {
			String key = matcher.group(0);
			String val = matcher.group(1);

			String[] t = val.split(",");
			if (t.length != 2) {
				continue;
			}

			val = "var " + t[0].trim().replace("'", "") + "=" + t[1].trim();
			converted = converted.replace(key, val);
		}

		return converted;
	}
}
