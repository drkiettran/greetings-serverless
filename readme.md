# Serverless with AWS Lambda
This sample application demonstrates how to program a serverless
application using AWS Lambda service.

## Build application:
``` bash
mvn clean package
```

## Create a Lambda function

- Login to aws
- Go to AWS Lambda landing page.
- Click on Create function.
- Select (by default) Author from scratch.
- Name the function as 'cisc-525-04-greetings' without the ticks '.
- Select Java 8 as Runtime
- Click on Choose or create an execution role.
- Select Create a new role from AWS policy templates
- Name the role as 'cisc-525-04-role' without the ticks.
- Select Simple microservice permissions as a Policy template.
- Click on Create function button at the bottom right. 

## Upload the function code:

- Select the lambda function
- At the landing page of the cisc-525-04-greetings function, scroll down to the Function code section
- Select Upload a .zip or .jar file as th Code entry type (default).
- Click Upload button below that.
- Navigate to the target folder of your greetings-serverless project.
- Choose greetings_lambda.jar file.
- Click on Open button.
- Select Java 8 as Runtime (default).
- Enter this 'com.drkiettran.greetings_serverless.Main::handleRequest' without the ticks into the Handler text box.

- ==> Click on the Save button on the top-left corner (Must do this).

## Test the lambda function

- Select the lambda function
- Select Configure test events from the drowndown box on the left of the Test button.
- Use the Hello World template.
- Name the event as 'SimpleTest' without the ticks.
- Enter the following text in the text box area below the Event name input box:

``` json
{
  "name": "testing name",
  "message": "testing message"
}

```

- Click Create button on the bottom right corner.
- On the landing page of the cisc-525-04-greetings function, click on the Test button on the top left corner.
- You should see the following output in the Details of the Execution result section:

```
{
  "message": "Hello, 'testing name' from xxx.xx.xx.xx/x@xx.xx.xx.xx"
}
```
 
## Create a API gateway resource

- On the landing page of the cisc-525-04-greetings lambda function, expand the Designer (default).
- Select API Gateway option on the left panel.
- Select Create a new API in the API text box.
- Select Open Security policy.
- Click on the Add button on the bottom-right of the screen.
- You should see 'unsaved changes' with the following information:

```
API: $CREATE
API name: cisc-525-04-greetings-API
Enable metrics and error logging: No
Security: NONE
Stage: default
```

- ==> Click on the Save button on the top-left corner (Must do this).

- Return to the AWS console.
- Go to the API Gateway landing page.
- Select the 'cisc-525-04-greetings-API'.
- Select /cisc-525-04-greetings under the Resources column (middle).
- Click on the Action dropdown list.
- Select Create Method.
- Select PUT on the dropdown box.
- Click on the check botton next to the x button.
- Enter this 'cisc-525-04-greetings' as Lambda Function (second line from the botton).
- Click on the Save button on the right-bottom.
- Click on OK button on the warning popup window.

## Testing the Lambda function through API gateway.

- Select the PUT method on the Resource column.
- Click on the TEST link (lightning bold beneath).

- Enter the following in the Headers text area:

```
Content-type: application/json
Accept: application/json
```

- Enter the following into the Request Body text area:

```
{
  "name": "testing name",
  "message": "testing message"
}
```


- Click on the Test button (lightning bold) on the bottom.
- You should see a return of 200 Status and the following text:

```
{
  "message": "Hello, 'testing name' from xxx.xx.xx.xx/x@xx.xx.xx.xx"
}
```

## Deploying API

Return to the AWS console.
- Go to the API Gateway landing page.
- Select the 'cisc-525-04-greetings-API'.
- Select /cisc-525-04-greetings under the Resources column (middle).
- Click on the Action dropdown list.
- Select Deploy API.
- Select 'default' from the dropdown menu.
- Click on Deploy button.
 
