package com.drkiettran.greetings_serverless;

import java.net.UnknownHostException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Main implements RequestHandler<HandlerRequest, HandlerResponse> {

	public HandlerResponse handleRequest(HandlerRequest input, Context context) {
		context.getLogger().log("\nfunction-name: " + context.getFunctionName());
		context.getLogger().log("\nname: " + input.getName());
		context.getLogger().log("\nmessage: " + input.getMessage());

		String greetings = "";
		
		try {
			greetings = new Greetings().hello(input.getName());
		} catch (UnknownHostException e) {
			context.getLogger().log(e.getMessage());
		}

		context.getLogger().log("\nreturning: " + greetings);
		context.getLogger().log("\n\n");
		
		return new HandlerResponse(greetings);
	}

}
