Feature: Tasks F7.6 - F7.10

  
  
  @JIRA-PLAN-124 @JIRA-PLAN-126 @JIRA-PLAN-131
  Scenario: F7.8 : Settings : Tasks : PlanIT > view Tasks record > detail : View Task record
    # As A User
    # I want to access a task in Planit
    # So I can view the individual task's details
    * Logon to PlanIT
    * Go to Operations menu - Tasks
    * See Task records in view
    Given Resource Task are viewable
    When Viewing a Task Record
    Then Task Record is displayed on screen

  @JIRA-PLAN-124 @JIRA-PLAN-126 @JIRA-PLAN-127 @JIRA-PLAN-132
  Scenario Outline: F7.9 : Settings : Tasks : PlanIT > create Task : Create a Task (<hiptest-uid>)
    # As A User
    # I want to create a task in PlanIT, specifying all Task variables
    * Logon to PlanIT
    * Go to Operations menu - Tasks
    * Select +Add
    Given Task fields are editable
    Then Fill task fields with "<task_code>" "<task_name>" "<time_unit>" "<t_duration>" "<t_status>" "<resource_name1>" "<t_quantity1>"
   
    Then new Task is created
    * Logon to PlanIT

    Examples:
      | task_code | task_name | time_unit | t_duration | t_status | resource_name1 | t_quantity1 | hiptest-uid |
      | autotask | tasty | Minutes | 20 | Active | Workstation 23 | 55 |  |

  