package com.mlog.util.command;

public interface Command {

	String DEC = "DEC";
	String ENC = "ENC";

	String JJS = "JJS";

	public String execute(String... args);
}
