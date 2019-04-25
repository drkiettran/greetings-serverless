package com.drkiettran.greetings_serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Main implements RequestHandler<HandlerRequest, HandlerResponse> {

	@Override
	public HandlerResponse handleRequest(HandlerRequest input, Context context) {
		context.getLogger().log("Hello " + input.getName());
		return new HandlerResponse("Hello " + input.getName());
	}

}
