@uniqueID
Feature: Employee ID

  Background: 
    Given A JWT is generated

  Scenario: Creating an employee
    Given a request is prepared to create an employee
    When a Post call is made to create an employee
    Then user receive valid HTTP response code 201
    And the employee is created and response contains key "Message" and value "Entry Created"
    And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls

  Scenario: Retrieving created employee
    Given a request is prepared to retrieve the created employee
    When a Get call is made to retrieve the created employee
    Then user receive valid HTTP response code 200
    And the retrieved employee ID "employee[0].employee_id" matches the globally stored employee ID
    And the retrieved data at "employee" matches the data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title   | emp_status |
      | Jemal         | GulshemShat     | Ahmedova     | 1980-07-11   | Female     | Cloud Architect | Employee   |

  Scenario: Updating completely created employee
    Given a request is prepared to update the created employee
    When a Put call is made to update the created employee
    Then user receive valid HTTP response code 201
    And the employee is updated and response contains key "Message" and value "Entry updated"
    And the updated data at "employee" matches the data used to create an employee with employee ID "employee[0].employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title    | emp_status |
      | Aygul         | Sarygyz         | Akjemalova   | 1990-07-11   | Female     | Graphic Designer | Freelance  |

  Scenario: Partially updated created employee
    Given a request is prepared to partially update the created employee
    When a Patch call is made to partially update the created employee
    Then user receive valid HTTP response code 201
    And the employee is updated and response contains key "Message" and value "Entry updated"
    And user verifies partially updated employee job title at "employee[0].emp_job_title" matches the "Developer"

  Scenario: Deleted created employee by using unique employee id
    Given a request is prepared to delete the created employee
    When a Delete call is made to delete the created employee
    Then user receive valid HTTP response code 201
    Then user is deleted and response contains key "message" and value "Entry deleted"
