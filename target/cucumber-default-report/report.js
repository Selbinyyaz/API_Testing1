$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/APIWorkFflow.feature");
formatter.feature({
  "name": "Syntax HRMS API End to End Worklow",
  "description": "  Description: This feature tests and verifies Syntax HRMS Web Services \n  The workflow consistes of the following sequential calls",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@workflow"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "A JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.TokenGenerationSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Creating an employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@workflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to create an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.a_request_is_prepared_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a Post call is made to create an employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.a_Post_call_is_made_to_create_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for creating an employee is 201",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.the_status_code_for_creating_an_employee_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee is created and response contains key \"Message\" and value \"Entry Created\"",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.the_employee_is_created_and_response_contains_key_and_value(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the employee ID \"Employee[0].employee_id\" is stored as a global variable to be used for other calls",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.the_employee_ID_is_stored_as_a_global_variable_to_be_used_for_other_calls(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "A JWT is generated",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.TokenGenerationSteps.a_JWT_is_generated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Retrieving created employee",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@workflow"
    }
  ]
});
formatter.step({
  "name": "a request is prepared to retrieve the created employee",
  "keyword": "Given "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.a_request_is_prepared_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a Get call is made to retrieve the created employee",
  "keyword": "When "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.a_Get_call_is_made_to_retrieve_the_created_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the status code for retrieving the created employee is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.the_status_code_for_retrieving_the_created_employee_is(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved employee ID \"employee[0].employee_id\" matches the globally stored employee ID",
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.the_retrieved_employee_ID_matches_the_globally_stored_employee_ID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the retrieved data at \"employee\" matches the data used to create an employee with employee ID \"employee[0].employee_id\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "com.hrms.API.steps.practice.WorkflowAllSteps.the_retrieved_data_at_matches_the_data_used_to_create_an_employee_with_employee_ID(java.lang.String,java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
});