package com.mlog.util.main;

import com.mlog.util.command.CommandManger;

public class ProcessMain {

	public static void main(String[] args) throws Exception {
		args = new String[3];
		args[0] = "JJS";
		args[1] = "var a=1; var b=2";
		args[2] = "execution.setVariable('A','A'); execution.setVariable('B', 'B'); print('Hello world:' + a + '/' + b); print('Hello world:' + A + '/' + B);";

		CommandManger.doCommand(args);
	}
}
