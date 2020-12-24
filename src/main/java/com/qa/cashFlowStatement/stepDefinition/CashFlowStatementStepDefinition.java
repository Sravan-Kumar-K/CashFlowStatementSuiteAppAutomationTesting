package com.qa.cashFlowStatement.stepDefinition;

import java.text.ParseException;
import java.util.Map;

import com.aventstack.extentreports.ExtentTest;
import com.qa.cashFlowStatement.pages.AuthenticationPage;
import com.qa.cashFlowStatement.pages.CashFlowStatementPage;
import com.qa.cashFlowStatement.pages.HomePage;
import com.qa.cashFlowStatement.pages.LoginPage;
import com.qa.cashFlowStatement.util.ExcelDataToDataTable;
import com.qa.cashFlowStatement.util.TestBase;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CashFlowStatementStepDefinition extends TestBase{
	
	cucumber.api.Scenario scenario;
	LoginPage loginPage;
	AuthenticationPage authPage;
	HomePage homePage;
	CashFlowStatementPage cfPage;
	
	@Before
	public void login(cucumber.api.Scenario scenario){
	    this.scenario = scenario;
		ExtentTest loginfo = null;
		try {
			test = extent.createTest(scenario.getName());
			loginfo = test.createNode("Login Test");
			
			TestBase.init();
			loginPage = new LoginPage();
			authPage = loginPage.login();
			homePage = authPage.Authentication();
			homePage.changeRole(prop.getProperty("roleText"), prop.getProperty("roleType"));
			
			loginfo.pass("Login Successful in Netsuite");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, scenario.getName());
		}
	}
	
	@After
	public void closeBrowser() {
		driver.close();
	}
	
	@Given("^User is on Cash Flow Statement page$")
	public void user_is_on_Cash_Flow_Statement_page() {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("User is on Cash Flow Statement page");
			cfPage = homePage.clickOnCashFlowStatementLink();
			loginfo.pass("Navigated to Cash flow statement page");
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, scenario.getName());
		}
	}
	
	@Then("^Verify From date & To date field validations$")
	public void verify_From_date_To_date_field_validations() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verify From date field validations");
			cfPage.verifyFromDateFieldValidations(loginfo);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, scenario.getName());
		}
		ExtentTest loginfo2 = null;
		try {
			loginfo2 = test.createNode("Verify To date field validations");
			cfPage.verifyToDateFieldValidations(loginfo2);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo2, e, scenario.getName());
		}
	}
	
	@Then("^Verify Current balance field value & Cash flow sublist using excel data at \"([^\"]*)\"$")
	public void verify_Current_balance_field_value_Cash_flow_sublist_using_excel_data_at(@Transform(ExcelDataToDataTable.class) DataTable cashFlowData) throws InterruptedException {
		ExtentTest loginfo = null;
		ExtentTest loginfo1 = null;
		try {
			loginfo = test.createNode("Verification of Current balance field value, Cash flow sublist data, Final balance field value");
			for(Map<String,String> data: cashFlowData.asMaps(String.class, String.class)) {
				String toDate = data.get("To Date");
				String currency = data.get("Currency");
				String cashAccounts = data.get("Cash Accounts");
				loginfo1 = loginfo.createNode("Test Data >>> To Date: "+toDate+", Currency: "+currency+", Cash Accounts: "+cashAccounts);
				cfPage.verifyCurrentBalanceFieldValue(toDate, currency, cashAccounts, loginfo1);
				cfPage.verifyCashFlowSublist(toDate, currency, cashAccounts, loginfo1);
				cfPage.verifyBalanceFieldValues(loginfo1);
				cfPage.verifyFinalBalance(loginfo1);
				homePage.clickOnCashFlowStatementLink();
			}
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo1, e, scenario.getName());
		}
	}
	
	@Then("^Edit the Balance field & verify the alert$")
	public void edit_the_Balance_field_verify_the_alert() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verification of alert message while editing Balance field");
			cfPage.editBalanceFieldVerifyAlert(loginfo);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, scenario.getName());
		}
	}
	
	@Then("^Verify Weekly forecast & download excel file$")
	public void verify_Weekly_forecast() throws InterruptedException, ParseException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verification of Weekly forecast with due amounts");
			homePage.clickOnCashFlowStatementLink();
			cfPage.verifyWeeklyForecast(loginfo);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, scenario.getName());
		}
		ExtentTest loginfo1 = null;
		try {
			loginfo1 = test.createNode("Verification of downloading the excel file");
			cfPage.downloadExcelFile(loginfo1);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo1, e, scenario.getName());
		}
	}
	
	@Then("^Verify Cash flow sublist$")
	public void verify_Cash_flow_sublist() throws InterruptedException {
		ExtentTest loginfo = null;
		try {
			loginfo = test.createNode("Verification of displayed results in the cash flow sublist when no.of transactions are greater than 50");
			cfPage.verifyCfs(loginfo);
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, loginfo, e, scenario.getName());
		}
	}
}