package com.mlog.util.command;

import java.util.Arrays;

public class CommandManger {

	public static String doCommand(String... cmd) {
		if (cmd.length <= 0) {
			return null;
		}

		String type = cmd[0];
		Command command = null;

		switch (type) {
		case Command.JJS:
			command = new JJSCommand();

			break;
		default:
			break;
		}

		String jsonStr = "";
		if (command != null) {
			jsonStr = command.execute(Arrays.copyOfRange(cmd, 1, cmd.length));
		}

		if (jsonStr != null) {
			System.out.print(jsonStr);
		}
		
		return jsonStr;
	}
	
}
