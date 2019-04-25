package com.drkiettran.greetings_serverless;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Greetings implements RequestHandler<Map<String, Object>, Object> {

	public Object handleRequest(Map<String, Object> input, Context context) {
		context.getLogger().log("input: " + input.get("name") + "\n");
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"message\":\"hello ");
		sb.append(input.get("name"));
		sb.append("\"}");
//		String greeting = "{ \"message\": \"Hello " + input.get("name") + "\" }";
		return sb.toString();
	}

}
