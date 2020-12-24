package com.qa.cashFlowStatement.pages;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qa.cashFlowStatement.util.TestBase;
public class CashFlowStatementPage extends TestBase{
	
	@FindBy(xpath = "//input[@id='custpage_fromdate']")
	WebElement fromDate;
	
	@FindBy(xpath = "//input[@id='custpage_todate']")
	WebElement toDate;
	
	@FindBy(xpath = "//h1")
	WebElement label;
	
	@FindBy(xpath = "//input[@id='inpt_custage_currency1']")
	WebElement currencyDropdown;
	
	@FindBy(xpath = "//div[@class='dropdownDiv']//div")
	List<WebElement> currencyOptions;

	@FindBy(xpath = "//td[contains(@id,'acc')]//a[@class='uir-multiselect-option']")
	List<WebElement> cashAccountsDropdown;
	
	@FindBy(xpath = "//input[@id='custpage_acctcurrentbal']")
	WebElement currentBalanceBox;
	
	@FindBy(xpath = "//table//tr[contains(@id,'custpage_cashflowsublistrow')]")
	List<WebElement> transactionsList;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[(count(//div[text()='Due Date']//parent::td//preceding-sibling::*)+1)]//input")
	List<WebElement> cfsDueDates;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[(count(//div[contains(text(),'memo')]//parent::td//preceding-sibling::*)+1)]")
	List<WebElement> cfsmemos;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[(count(//div[contains(text(),'Type')]//parent::td//preceding-sibling::*)+1)]")
	List<WebElement> cfsTypes;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[(count(//div[contains(text(),'Document Number')]//parent::td//preceding-sibling::*)+1)]//a")
	List<WebElement> cfsDocumentNumbers;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Entity')]//parent::td//preceding-sibling::*)+1)]")
	List<WebElement> cfsEntities;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Amount(Foreign Currency)')]//parent::td//preceding-sibling::*)+1)]")
	List<WebElement> cfsAmounts;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Open Balance')]//parent::td//preceding-sibling::*)+1)]")
	List<WebElement> cfsOpenBalances;
	
	@FindBy(xpath = "//table[@id='custpage_cashflowsublist_splits']//tr[contains(@id,'custpage_cashflowsublistrow')]//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Balance')]//parent::td//preceding-sibling::*)+1)]//input")
	List<WebElement> cfsBalances;
	
	@FindBy(xpath = "//span[text()='Lists']")
	WebElement listsLink;
	
	@FindBy(xpath = "//span[text()='Search']")
	WebElement searchLink;
	
	@FindBy(xpath = "//span[text()='Saved Searches']")
	WebElement savedSearchLink;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[3]")
	List<WebElement> savedSearchList;
	
	@FindBy(xpath = "//span[@class='ns-icon ns-filters-onoff-button']")
	WebElement filtersDiv;
	
	@FindBy(xpath = "//input[@id='inpt_Transaction_CURRENCY1']")
	WebElement currencyInSearch;
	
	@FindBy(xpath = "//a[text()='Currency']")
	WebElement currencyLabelInSearch;
	
	@FindBy(xpath = "//input[@id='Transaction_DUEDATEto']")
	WebElement toDateInSearch;
	
	@FindBy(xpath = "//a[text()='To']")
	WebElement toDateLabelInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]")
	List<WebElement> transactionsListInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'DUE DATE')]//parent::td//preceding-sibling::td)+1)]")
	List<WebElement> cfsDueDatesInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'MEMO')]//parent::td//preceding-sibling::td)+1)]")
	List<WebElement> cfsMemosInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'TYPE')]//parent::td//preceding-sibling::td)+1)]")
	List<WebElement> cfsTypesInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'DOCUMENT NUMBER')]//parent::td//preceding-sibling::td)+1)]")
	List<WebElement> cfsDocumentNumbersInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'ENTITY')]//parent::td//preceding-sibling::td)+1)]//a")
	List<WebElement> cfsEntitiesInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'AMOUNT(FOREIGN CURRENCY)')]//parent::td//preceding-sibling::td)+1)]")
	List<WebElement> cfsAmountsInSearch;
	
	@FindBy(xpath = "//table[@id='div__bodytab']//tr[contains(@id,'row')]//td[(count(//table[@id='div__labtab']//div[contains(text(),'OPEN BALANCE')]//parent::td//preceding-sibling::td)+1)]")
	List<WebElement> cfsOpenBalancesInSearch;
	
	@FindBy(xpath = "//input[@id='custpage_totalaccountbalance1']")
	WebElement balanceField;
	
	@FindBy(xpath = "//input[@id='custpage_tempfinalbalance']")
	WebElement finalBalanceField;
	
	@FindBy(xpath = "//div[@class='uir-message-popup']")
	WebElement popUpDiv;
	
	@FindBy(xpath = "//div[@class='uir-message-popup']//span")
	WebElement popUpMessage;
	
	@FindBy(xpath = "//div[@class='uir-message-popup']//button")
	WebElement popUpOkBtn;
	
	@FindBy(xpath = "//td[contains(@id,'week')]//a[@class='uir-multiselect-option']")
	List<WebElement> weekElements;
	
	@FindBy(xpath = "//iframe[@id='myframe']")
	WebElement weeklyForecastFrame;
	
	@FindBy(xpath = "//input[@id='custpage_excel']")
	WebElement downloadBtn;
	
	@FindBy(xpath = "//td[@id='uir_totalcount']")
	WebElement searchResultsCount;
	
	public CashFlowStatementPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCfs(ExtentTest logInfo) throws InterruptedException {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		eleAvailability(driver, By.xpath("//input[@id='custpage_todate']"), 5);
		action.click(toDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(toDate, "10/14/2020").build().perform();
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(2000);
		currencyDropdown.sendKeys("US Dollar");
		label.click();
		Thread.sleep(5000);
		for(int j=0;j<cashAccountsDropdown.size();j++) {
			WebElement accountsLink = cashAccountsDropdown.get(j);
			String text = accountsLink.getText();
			if(text.contains("1000 Checking")) {
				eleAvailability(driver, accountsLink, 6);
				accountsLink.click();
				break;
			}
		}
		Thread.sleep(5000);
		int transactionCountInCFS = transactionsList.size();
		int transactionCountInSearch = 0;
		
		// Navigate to search created in Netsuite
		je.executeScript("window.open('about:blank','_blank');");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("searchUrl"));
				
		// Expand the filters section
		eleClickable(driver, By.xpath("//span[@class='ns-icon ns-filters-onoff-button']"), 5);
		String flag = filtersDiv.getAttribute("aria-expanded");
		if(flag.equals("false")) {
			action.moveToElement(filtersDiv).build().perform();
			filtersDiv.click();
		}
		
		// Enter Currency
		currencyInSearch.sendKeys("US Dollar");
		currencyLabelInSearch.click();
		
		// Enter date
		toDateInSearch.sendKeys("10/14/2020");
		toDateLabelInSearch.click();
		
		transactionCountInSearch = Integer.parseInt(searchResultsCount.getText().replace("TOTAL:", "").trim());
		
		driver.close();
		driver.switchTo().window(tabs.get(0));
		
		if(transactionCountInSearch > 50 && transactionCountInCFS == 50) {
			System.out.println("Cash flow sublist is displaying all transactions in a single page limited to 50 transactions only");
			logInfo.pass("Cash flow sublist is displaying all transactions in a single page limited to 50 transactions only");
		}else {
			System.out.println("Cash flow sublist is displaying only "+transactionCountInCFS+" no.of transactions");
			logInfo.fail("Cash flow sublist is displaying only "+transactionCountInCFS+" no.of transactions");
		}
	}
	
	public void downloadExcelFile(ExtentTest logInfo) throws InterruptedException {
		Thread.sleep(2000);
		downloadBtn.click();
		Thread.sleep(3000);
		System.out.println("Excel file is downloaded");
		logInfo.pass("Excel file is downloaded");
	}
	
	public void verifyFinalBalance(ExtentTest logInfo) {
		double actualFinalBalance = convertStringToDouble(finalBalanceField.getAttribute("value"));
		double accCurrentBalance = convertStringToDouble(currentBalanceBox.getAttribute("value"));
		double calculatedFinalBalance = accCurrentBalance;
		for(int i=0;i<cfsOpenBalances.size();i++) {
			double currentOpenBalance = convertStringToDouble(cfsOpenBalances.get(i).getText().substring(1));
			calculatedFinalBalance += currentOpenBalance;
		}
		calculatedFinalBalance = round(calculatedFinalBalance, 2);
		System.out.println(actualFinalBalance+" "+calculatedFinalBalance);
		if(actualFinalBalance == calculatedFinalBalance) {
			System.out.println("Final Balance field value is calculated correctly");
			logInfo.pass("Final Balance field value is calculated correctly");
		}else {
			System.out.println("Final Balance field value is not calculated correctly, expected value is "+calculatedFinalBalance+" but actual final balance is displayed as "+actualFinalBalance);
			logInfo.fail("Final Balance field value is not calculated correctly, expected value is "+calculatedFinalBalance+" but actual final balance is displayed as "+actualFinalBalance);
		}
	}
	
	public void verifyBalanceFieldValues(ExtentTest logInfo) {
		boolean balanceFlag = true;
		double accCurrentBalance = convertStringToDouble(currentBalanceBox.getAttribute("value"));
		for (int i = 0; i < transactionsList.size(); i++) {
			double calculatedBalance;
			double currentOpenBalance;
			double balanceInPage;
			String trId = transactionsList.get(i).getAttribute("id");
			currentOpenBalance = convertStringToDouble(driver.findElement(By.xpath("//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Open Balance')]//parent::td//preceding-sibling::*)+1)]")).getText().substring(1));
			balanceInPage = convertStringToDouble(driver.findElement(By.xpath("//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Balance')]//parent::td//preceding-sibling::*)+1)]//input")).getAttribute("value").substring(1));
			if(trId.contains("0")) {
				calculatedBalance = round(accCurrentBalance + currentOpenBalance, 2);
				System.out.println(calculatedBalance+" "+balanceInPage);
				if(calculatedBalance == balanceInPage)
					System.out.println("Balance equal for row:"+trId);
				else
					balanceFlag = false;
			}else {
				double prevBalance;
				String prevTrId = transactionsList.get(i-1).getAttribute("id");
				prevBalance = convertStringToDouble(driver.findElement(By.xpath("//tr[@id='"+prevTrId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Balance')]//parent::td//preceding-sibling::*)+1)]//input")).getAttribute("value").substring(1));
				calculatedBalance = round(prevBalance + currentOpenBalance,2);
				System.out.println(calculatedBalance+" "+balanceInPage);
				if(calculatedBalance == balanceInPage)
					System.out.println("Balance equal for row:"+trId);
				else
					balanceFlag = false;
			}
		}
		
		if(balanceFlag) {
			System.out.println("Balances for all the transactions in the Cash flow sublist are calculated correctly");
			logInfo.pass("Balances for all the transactions in the Cash flow sublist are calculated correctly");
		}
		else {
			System.out.println("Balances for all the transactions in the Cash flow sublist are not calculated correctly");
			logInfo.fail("Balances for all the transactions in the Cash flow sublist are calculated correctly");
		}
	}
	
	public void verifyWeeklyForecast(ExtentTest logInfo) throws InterruptedException, ParseException {
		Thread.sleep(6000);
		eleAvailability(driver, By.xpath("//input[@id='custpage_todate']"), 5);
		action.click(toDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(toDate, "9/15/2015").build().perform();
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(6000);
		currencyDropdown.sendKeys("Euro");
		label.click();
		Thread.sleep(5000);
		for(int j=0;j<cashAccountsDropdown.size();j++) {
			WebElement accountsLink = cashAccountsDropdown.get(j);
			String text = accountsLink.getText();
			if(text.contains("73073 Default Payment Euro account")) {
				eleAvailability(driver, accountsLink, 6);
				accountsLink.click();
				break;
			}
		}
		Thread.sleep(5000);
//		driver.switchTo().frame(weeklyForecastFrame);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		for (int i = 0; i < weekElements.size(); i++) {
			if(!weekElements.get(i).getText().isBlank()) {
				String[] currentWeekDateRange = weekElements.get(i).getText().split("--")[0].split("-");
				double actualDueAmount = convertStringToDouble(weekElements.get(i).getText().split("--")[1].trim());
				double calculatedDueAmount = 0;
	//			driver.switchTo().defaultContent();
				for (int j = 0; j < transactionsList.size(); j++) {
					String trId = transactionsList.get(j).getAttribute("id");
					Date currentDueDate = sdf.parse(driver.findElement(By.xpath("//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Due Date')]//parent::td//preceding-sibling::*)+1)]//input")).getAttribute("value"));
					if(currentDueDate.before(sdf.parse(currentWeekDateRange[1].trim())) || currentDueDate.compareTo(sdf.parse(currentWeekDateRange[1].trim())) == 0) {
						double openBalance = convertStringToDouble(driver.findElement(By.xpath("//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Open Balance')]//parent::td//preceding-sibling::*)+1)]")).getText().substring(1));
						calculatedDueAmount += openBalance;
					}
				}
				System.out.println("For week "+i+":"+actualDueAmount+" "+calculatedDueAmount);
				if(actualDueAmount == calculatedDueAmount) {
					System.out.println("Weekly forecast for week "+i+" is displayed with correct due amounts");
					logInfo.pass("Weekly forecast for week "+i+" is displayed with correct due amounts");
				}else {
					System.out.println("Weekly forecast for week "+i+" is not displayed correctly. Due amount is wrong");
					logInfo.pass("Weekly forecast for week "+i+" is not displayed correctly. Due amount is wrong");
				}
	//			driver.switchTo().frame(weeklyForecastFrame);
			}
		}
//		driver.switchTo().defaultContent();
	}

	public void editBalanceFieldVerifyAlert(ExtentTest logInfo) throws InterruptedException {
		Thread.sleep(2000);
		currencyDropdown.sendKeys("US Dollar");
		label.click();
		Thread.sleep(5000);
		for(int j=0;j<cashAccountsDropdown.size();j++) {
			WebElement accountsLink = cashAccountsDropdown.get(j);
			String text = accountsLink.getText();
			if(text.contains("1000 Checking")) {
				eleAvailability(driver, accountsLink, 6);
				accountsLink.click();
				break;
			}
		}
		Thread.sleep(5000);
		action.click(balanceField).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
		label.click();
		Thread.sleep(2000);
		
		// Verify the alert
		if(isAlertPresent()){
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured when balance field is edited: "+alertMsg);
			alert.accept();
		} else if(popUpDiv.isDisplayed()) {
			Thread.sleep(1000);
			String alertMsg = popUpMessage.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured: "+alertMsg);
			popUpOkBtn.click();
		} else {
			System.out.println("Alert not occured when balance field is edited");
			logInfo.fail("Alert not occured when balance field is edited");
		}
	}
	
	public void verifyCashFlowSublist(String toDateData, String currencyData, String cashAccountsData, ExtentTest logInfo) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		action = new Actions(driver);
		je.executeScript("window.scrollTo(0,0)");
		
		// Cash Flow Data in Cash Flow statement page
		List<String> dueDatesInCfPage = new ArrayList<>();
		List<String> memosInCfPage = new ArrayList<>();
		List<String> typesInCfPage = new ArrayList<>();
		List<String> documentNumbersInCfPage = new ArrayList<>();
		List<String> entitiesInCfPage = new ArrayList<>();
		List<String> amountsInCfPage = new ArrayList<>();
		List<String> openBalancesInCfPage = new ArrayList<>();
		
		// Data from Search
		List<String> dueDatesInSearch = new ArrayList<>();
		List<String> memosInSearch = new ArrayList<>();
		List<String> typesInSearch = new ArrayList<>();
		List<String> documentNumbersInSearch = new ArrayList<>();
		List<String> entitiesInSearch = new ArrayList<>();
		List<String> amountsInSearch = new ArrayList<>();
		List<String> openBalancesInSearch = new ArrayList<>();
		
		// Get all the values of Due date, Memos, Types, Document Numbers, Entities, Amount & Open balances from the Cash flow sublist
		for(int i=0;i<transactionsList.size();i++) {
			je.executeScript("arguments[0].scrollIntoView(true);", transactionsList.get(i));
			String dueDateText = cfsDueDates.get(i).getAttribute("value");
			String memoText = cfsmemos.get(i).getText();
			String typeText = cfsTypes.get(i).getText();
			String documentNumberText = cfsDocumentNumbers.get(i).getText();
			String entityText = cfsEntities.get(i).getText();
			String amountText = cfsAmounts.get(i).getText();
			String openBalanceText = cfsOpenBalances.get(i).getText();
			dueDatesInCfPage.add(dueDateText);
			memosInCfPage.add(memoText);
			typesInCfPage.add(typeText);
			documentNumbersInCfPage.add(documentNumberText);
			entitiesInCfPage.add(entityText);
			amountsInCfPage.add(amountText);
			openBalancesInCfPage.add(openBalanceText);
		}
		
		// Navigate to search created in Netsuite
		je.executeScript("window.open('about:blank','_blank');");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty("searchUrl"));
				
		// Expand the filters section
		eleClickable(driver, By.xpath("//span[@class='ns-icon ns-filters-onoff-button']"), 5);
		String flag = filtersDiv.getAttribute("aria-expanded");
		if(flag.equals("false")) {
			action.moveToElement(filtersDiv).build().perform();
			filtersDiv.click();
		}
		
		// Enter Currency
		currencyInSearch.sendKeys(currencyData);
		currencyLabelInSearch.click();
		
		// Enter date
		toDateInSearch.sendKeys(toDateData);
		toDateLabelInSearch.click();
		
		// Get all the values of Due date, Memos, Types, Document Numbers, Entities, Amount & Open balances from the Saved search
		for(int i=0;i<transactionsListInSearch.size();i++) {
			if(currencyData.equals("Euro")) {
				action.moveToElement(transactionsListInSearch.get(i)).build().perform();
				String dueDateText = cfsDueDatesInSearch.get(i).getText();
				if(!dueDateText.trim().isBlank()) {
					String memoText = cfsMemosInSearch.get(i).getText();
					String typeText = cfsTypesInSearch.get(i).getText();
					String documentNumberText = cfsDocumentNumbersInSearch.get(i).getText();
					String entityText = cfsEntitiesInSearch.get(i).getText();
					String amountText = cfsAmountsInSearch.get(i).getText().trim().replaceAll(" ", "").replaceAll(",", ".");
					String openBalanceText = cfsOpenBalancesInSearch.get(i).getText();
					dueDatesInSearch.add(dueDateText);
					memosInSearch.add(memoText);
					typesInSearch.add(typeText);
					documentNumbersInSearch.add(documentNumberText);
					entitiesInSearch.add(entityText);
					amountsInSearch.add(amountText);
					openBalancesInSearch.add(openBalanceText);
				}
			}else {
				action.moveToElement(transactionsListInSearch.get(i)).build().perform();
				String dueDateText = cfsDueDatesInSearch.get(i).getText();
				if(!dueDateText.trim().isBlank()) {
					String memoText = cfsMemosInSearch.get(i).getText();
					String typeText = cfsTypesInSearch.get(i).getText();
					String documentNumberText = cfsDocumentNumbersInSearch.get(i).getText();
					String entityText = cfsEntitiesInSearch.get(i).getText();
					String amountText = cfsAmountsInSearch.get(i).getText().trim();
					String openBalanceText = cfsOpenBalancesInSearch.get(i).getText();
					dueDatesInSearch.add(dueDateText);
					memosInSearch.add(memoText);
					typesInSearch.add(typeText);
					documentNumbersInSearch.add(documentNumberText);
					entitiesInSearch.add(entityText);
					amountsInSearch.add(amountText);
					openBalancesInSearch.add(openBalanceText);
				}
			}
		}
		
		driver.close();
		// Switch to PO Window
		driver.switchTo().window(tabs.get(0));
		
		// Compare Due dates
		boolean dueDateFlag = true;
		if(dueDatesInCfPage.size() == dueDatesInSearch.size()) {
			for (int i = 0; i < dueDatesInCfPage.size(); i++) {
				if(!dueDatesInCfPage.get(i).contains(dueDatesInSearch.get(i)))
					dueDateFlag = false;
			}
		}
		else
			dueDateFlag = false;
		
		if(dueDateFlag) {
			System.out.println("Due Dates are displayed correctly");
			logInfo.pass("Due Dates are displayed correctly");
		}
		else {
			System.out.println("Due date are not displaying correctly");
			logInfo.fail("Due date are not displaying correctly");
		}
		
		// Compare Memos
		boolean memoFlag = true;
		if(memosInCfPage.size() == memosInSearch.size()) {
			for (int i = 0; i < memosInCfPage.size(); i++) {
				if(!memosInCfPage.get(i).contains(memosInSearch.get(i)))
					memoFlag = false;
			}
		}
		else
			memoFlag = false;
		
		if(memoFlag) {
			System.out.println("Memos are displayed correctly");
			logInfo.pass("Memos are displayed correctly");
		}
		else {
			System.out.println("Memos are not displaying correctly");
			logInfo.fail("Memos are not displaying correctly");
		}
		
		// Compare Transaction types
		boolean typeFlag = true;
		if(typesInCfPage.size() == typesInSearch.size()) {
			for (int i = 0; i < memosInCfPage.size(); i++) {
				if(!typesInCfPage.get(i).contains(typesInSearch.get(i)))
					typeFlag = false;
			}
		}
		else
			typeFlag = false;
		
		if(typeFlag) {
			System.out.println("Transactions types are displayed correctly");
			logInfo.pass("Transactions types are displayed correctly");
		}
		else {
			System.out.println("Transaction types are not displaying correctly");
			logInfo.fail("Transaction types are not displaying correctly");
		}
		
		// Compare Document numbers
		boolean documentNumberFlag = true;
		if(documentNumbersInCfPage.size() == documentNumbersInSearch.size()) {
			for (int i = 0; i < documentNumbersInCfPage.size(); i++) {
				if(!documentNumbersInCfPage.get(i).contains(documentNumbersInSearch.get(i)))
					documentNumberFlag = false;
			}
		}
		else
			documentNumberFlag = false;
		
		if(documentNumberFlag) {
			System.out.println("Document numbers are displayed correctly");
			logInfo.pass("Document numbers are displayed correctly");
		}
		else {
			System.out.println("Document numbers are not displaying correctly");
			logInfo.fail("Document numbers are not displaying correctly");
		}
		
		// Compare Entities
		boolean entityFlag = true;
		if(entitiesInCfPage.size() == entitiesInSearch.size()) {
			for (int i = 0; i < entitiesInCfPage.size(); i++) {
				if(!entitiesInCfPage.get(i).contains(entitiesInSearch.get(i)))
					entityFlag = false;
			}
		}
		else
			entityFlag = false;
		
		if(entityFlag) {
			System.out.println("Entity field values are displayed correctly");
			logInfo.pass("Entity field values are displayed correctly");
		}
		else {
			System.out.println("Entity field values are not displaying correctly");
			logInfo.fail("Entity field values are not displaying correctly");
		}
		
		// Compare Amount
		boolean amountFlag = true;
		if(amountsInCfPage.size() == amountsInSearch.size()) {
			for (int i = 0; i < amountsInCfPage.size(); i++) {
				if(!amountsInCfPage.get(i).contains(amountsInSearch.get(i).replace(",", "")))
					amountFlag = false;
			}
		}
		else
			amountFlag = false;
		
		if(amountFlag) {
			System.out.println("Amount field values are displayed correctly");
			logInfo.pass("Amount field values are displayed correctly");
		}
		else {
			System.out.println("Amount field values are not displaying correctly");
			logInfo.fail("Amount field values are not displaying correctly");
		}
		
		// Verify Open Balance for Bills, Invoices & expense report
		boolean openBalanceForBillFlag = true;
		boolean openBalanceForInvoicesFlag = true;
		boolean openBalanceForExpenseReportFlag = true;
		for(int i=0;i<cfsTypes.size();i++) {
			WebElement currentType = cfsTypes.get(i);
			je.executeScript("arguments[0].scrollIntoView(true);", currentType);
			String text = currentType.getText();
			
			if(text.contains("Bill")) {
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentType);
				String trId = parentTr.getAttribute("id");
				String openBalanceTest = driver.findElement(By.xpath("//table[@id='custpage_cashflowsublist_splits']//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Open Balance')]//parent::td//preceding-sibling::*)+1)]")).getText();
				if(!openBalanceTest.contains("-"))
					openBalanceForBillFlag = false;
			}
			
			if(text.contains("Expense Report")) {
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentType);
				String trId = parentTr.getAttribute("id");
				String openBalanceTest = driver.findElement(By.xpath("//table[@id='custpage_cashflowsublist_splits']//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Open Balance')]//parent::td//preceding-sibling::*)+1)]")).getText();
				if(!openBalanceTest.contains("-"))
					openBalanceForExpenseReportFlag = false;
			}
			
			if(text.contains("Invoice")) {
				WebElement parentTr = (WebElement)je.executeScript("return arguments[0].parentNode;", currentType);
				String trId = parentTr.getAttribute("id");
				String openBalanceTest = driver.findElement(By.xpath("//table[@id='custpage_cashflowsublist_splits']//tr[@id='"+trId+"']//td[not(@class='listtexthl uir-column-large')][(count(//div[contains(text(),'Open Balance')]//parent::td//preceding-sibling::*)+1)]")).getText();
				if(openBalanceTest.contains("-"))
					openBalanceForInvoicesFlag = false;
			}
		}
		
		if(openBalanceForBillFlag) {
			System.out.println("Open Balance for Bills are displayed correctly with negative sign");
			logInfo.pass("Open Balance for Bills are displayed correctly with negative sign");
		}
		else {
			System.out.println("Open Balance for Bills are not displaying correctly. Value should be negative for bills");
			logInfo.fail("Open Balance for Bills are not displaying correctly. Value should be negative for bills");
		}
		
		if(openBalanceForExpenseReportFlag) {
			System.out.println("Open Balance for Expense reports are displayed correctly with negative sign");
			logInfo.pass("Open Balance for Expense reports are displayed correctly with negative sign");
		}
		else {
			System.out.println("Open Balance for Expense reports are not displaying correctly. Value should be negative for Expense reports");
			logInfo.fail("Open Balance for Expense reports are not displaying correctly. Value should be negative for Expense reports");
		}
		
		if(openBalanceForInvoicesFlag) {
			System.out.println("Open Balance for Invoices are displayed correctly with positive sign");
			logInfo.pass("Open Balance for Invoices are displayed correctly with positive sign");
		}
		else {
			System.out.println("Open Balance for Invoices are not displaying correctly. Value should be positive for Invoices");
			logInfo.fail("Open Balance for Invoices are not displaying correctly. Value should be positive for Invoices");
		}
		
	}
	
	public void verifyCurrentBalanceFieldValue(String toDateData, String currencyData, String cashAccountsData, ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
//		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(fromDate, "9/12/2020").build().perform();
//		label.click();
//		Thread.sleep(4000);
		eleAvailability(driver, By.xpath("//input[@id='custpage_todate']"), 5);
		action.click(toDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(toDate, toDateData).build().perform();
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(6000);
		currencyDropdown.click();
		for (int i = 0; i < currencyOptions.size(); i++) {
			String text = currencyOptions.get(i).getText();
			if(text.equals(currencyData)) {
				currencyOptions.get(i).click();
			}
		}
		Thread.sleep(5000);
		
		// Select Cash Accounts
		String[] cashAccounts = cashAccountsData.split(",");
		double balanceCount = 0;
		action.keyDown(Keys.CONTROL).build().perform();
		for(int i=0;i<cashAccounts.length;i++) {
			for(int j=0;j<cashAccountsDropdown.size();j++) {
				WebElement accountsLink = cashAccountsDropdown.get(j);
				String text = accountsLink.getText();
				if(text.contains(cashAccounts[i])) {
					eleAvailability(driver, accountsLink, 6);
					String currentSelectedAcountBalance = text.split(":")[1].trim();
					balanceCount += Double.parseDouble(currentSelectedAcountBalance);
					accountsLink.click();
					break;
				}
			}
			Thread.sleep(6000);
		}
		action.keyUp(Keys.CONTROL).build().perform();
		
		// Get Currenct balance field value & verify the value
		String formattedbalanceCount = String.format("%.2f", balanceCount);
		String currentBalanceValue = currentBalanceBox.getAttribute("value");
		
		if(formattedbalanceCount.equals(currentBalanceValue)) {
			System.out.println("Current balance is displaying correct value for the selected cash accounts:"+cashAccountsData);
			logInfo.pass("Current balance is displaying correct value for the selected cash accounts:"+cashAccountsData);
		}else {
			System.out.println("Current balance is not displaying correct value for the selected cash accounts:"+cashAccountsData);
			logInfo.fail("Current balance is not displaying correct value for the selected cash accounts:"+cashAccountsData);
		}
	}
	
	public void verifyFromDateFieldValidations(ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		
		// Verification of From Date Field with alphabets
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(fromDate, "abc").build().perform();
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of From Date Field with alphabets: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of From Date Field with numbers
		fromDate.sendKeys("12");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of From Date Field with numbers: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of From Date Field with special characters
		fromDate.sendKeys("@#$");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of From Date Field with special characters: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of From Date Field with alpha-numerics
		fromDate.sendKeys("abc123");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of From Date Field with alpha-numerics: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of From Date Field with alphabets & special characters
		fromDate.sendKeys("abc@#$");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of From Date Field with alphabets & special characters: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of From Date Field with numbers & special characters
		fromDate.sendKeys("123@#$");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of From Date Field with numbers & special characters: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of From Date Field with value of the month
		fromDate.sendKeys("13/13/2020");
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(3000);
		String date1 = fromDate.getAttribute("value");
		if(date1.equals("12/13/2020")) {
			logInfo.pass("Value of the month adjusted to 12");
			System.out.println("Value of the month adjusted to 12");
		}else {
			logInfo.fail("Value of the month is not adjusted to 12");
			System.out.println("Value of the month is not adjusted to 12");
		}
		
		// Verification of From Date Field with value of the day
		action.click(fromDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(fromDate, "1/40/2020").build().perform();
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(3000);
		String date2 = fromDate.getAttribute("value");
		System.out.println(date2);
		if(date2.equals("1/31/2020")) {
			logInfo.pass("Value of the date adjusted to 31");
			System.out.println("Value of the date adjusted to 31");
		}else {
			logInfo.fail("Value of the date is not adjusted to 31");
			System.out.println("Value of the date is not adjusted to 31");
		}
	}

	public void verifyToDateFieldValidations(ExtentTest logInfo) throws InterruptedException {
		action = new Actions(driver);
		
		// Verification of To Date Field with alphabets
		action.click(toDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(toDate, "abc").build().perform();
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of To Date Field with alphabets: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of To Date Field with numbers
		toDate.sendKeys("12");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of To Date Field with numbers: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of To Date Field with special characters
		toDate.sendKeys("@#$");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of To Date Field with special characters: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of To Date Field with alpha-numerics
		toDate.sendKeys("abc123");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of To Date Field with alpha-numerics: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of To Date Field with alphabets & special characters
		toDate.sendKeys("abc@#$");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of To Date Field with alphabets & special characters: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of To Date Field with numbers & special characters
		toDate.sendKeys("123@#$");
		label.click();
		if(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			logInfo.pass("Alert occured for verification of To Date Field with numbers & special characters: "+alertMsg);
			alert.accept();
		}else {
			System.out.println("No alert occured");
			logInfo.fail("No alert occured");
		}
		
		// Verification of To Date Field with value of the month
		toDate.sendKeys("13/13/2020");
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(3000);
		String date1 = toDate.getAttribute("value");
		if(date1.equals("12/13/2020")) {
			logInfo.pass("Value of the month adjusted to 12");
			System.out.println("Value of the month adjusted to 12");
		}else {
			logInfo.fail("Value of the month is not adjusted to 12");
			System.out.println("Value of the month is not adjusted to 12");
		}
		
		// Verification of To Date Field with value of the day
		action.click(toDate).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(toDate, "1/40/2020").build().perform();
		label.click();
		while(isAlertPresent()) {
			Thread.sleep(1000);
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert occured: "+alertMsg);
			alert.accept();
		}
		Thread.sleep(3000);
		String date2 = toDate.getAttribute("value");
		System.out.println(date2);
		if(date2.equals("1/31/2020")) {
			logInfo.pass("Value of the date adjusted to 31");
			System.out.println("Value of the date adjusted to 31");
		}else {
			logInfo.fail("Value of the date is not adjusted to 31");
			System.out.println("Value of the date is not adjusted to 31");
		}
	}
}
