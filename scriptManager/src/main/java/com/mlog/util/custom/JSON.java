package com.mlog.util.custom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON {

	public static String stringfy(Object json) {
		String jsonStr = null;
		if (json == null) {
			return null;
		}

		Gson gson = new GsonBuilder().create();
		jsonStr = gson.toJson(json);

		return jsonStr;
	}
}
