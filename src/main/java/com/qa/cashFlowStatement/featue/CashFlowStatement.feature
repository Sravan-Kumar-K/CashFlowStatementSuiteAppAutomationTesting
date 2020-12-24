Feature: Automation Testing on Cash Flow Statement Suite App

Scenario: Test scenario for From date & To date field validations
Given User is on Cash Flow Statement page
Then Verify From date & To date field validations

Scenario: Verification of Current balance field & Cash flow sublist
Given User is on Cash Flow Statement page
Then Verify Current balance field value & Cash flow sublist using excel data at "C:\Users\Sravan Kumar\Desktop\Cash Flow Statement Data.xlsx,Cash Flow Sublist"
Then Edit the Balance field & verify the alert
Then Verify Weekly forecast & download excel file

Scenario: Verification of Cash flow sublist when no.of transactions are greater than fifty
Given User is on Cash Flow Statement page
Then Verify Cash flow sublist