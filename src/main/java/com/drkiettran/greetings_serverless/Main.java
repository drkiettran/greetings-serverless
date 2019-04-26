package com.drkiettran.greetings_serverless;

import java.net.UnknownHostException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Main implements RequestHandler<HandlerRequest, HandlerResponse> {

	@Override
	public HandlerResponse handleRequest(HandlerRequest input, Context context) {
		context.getLogger().log("Hello " + input.getName());
		String greetings = "";
		try {
			greetings = new Greetings().hello(input.getName());
		} catch (UnknownHostException e) {
			context.getLogger().log(e.getMessage());
		}
		context.getLogger().log("returning: " + greetings);
		return new HandlerResponse(greetings);
	}

}
