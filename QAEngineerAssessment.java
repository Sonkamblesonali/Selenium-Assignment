package test.java.Testng;

import java.text.DateFormatSymbols;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class QAEngineerAssessment {

	WebDriver driver;
	@FindBy(id = "username")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//*[@id='login-form']/button")
	WebElement LoginButton;

	@FindBy(id = "add-patient-btn")
	WebElement AddPatientbtn;

	@FindBy(id = "mrn")
	WebElement MRN;

	@FindBy(id = "firstName")
	WebElement FirstName;

	@FindBy(id = "lastName")
	WebElement LastName;

	@FindBy(id = "dob")
	WebElement DOB;

	@FindBy(id = "discharge")
	WebElement DischargeDate;

	@FindBy(id = "phone")
	WebElement phonenumber;

	@FindBy(id = "language")
	WebElement Language;

	@FindBy(id = "timezone")
	WebElement timezone;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement Submitbtn;

	@FindBy(xpath = "//*[@id=\"language\"]/option[2]")
	WebElement Spanish;

	@FindBy(xpath = "//*[@id=\"timezone\"]/option[2]")
	WebElement PST;

	public QAEngineerAssessment(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializes all @FindBy
	}

	public void loginwithValidData(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		LoginButton.click();
		System.out.println("Step1: Login as Using Valid credentials");
		WebElement loginText = driver.findElement(By.xpath("//*[@id=\"patients-table\"]/thead/tr/th[1]"));
		Assert.assertTrue(loginText.isDisplayed(), "User is logged in Successfully");
		System.out.println("User is logged in Successfully ");
		System.out.println("***************************************************************************");

	}

	public void DashBoard() {
		AddPatientbtn.click();
		System.out.println("Step 2: User redirected to Dashboard Page");
		WebElement MRN = driver.findElement(By.xpath("//h2[text()='Login']"));
		// Assert the login text is visible
		Assert.assertTrue(MRN.isDisplayed(), "patient table is visibile ");
		System.out.println("patient table  is visible ");
		System.out.println("***************************************************************************");

	}

	public void AddPatientForm(String dynamicMRN, String date, String desireDateandTime) {
		System.out.println("Step 3:Patient Form submitted");
		MRN.sendKeys(dynamicMRN);
		FirstName.sendKeys("NewUser");
		LastName.sendKeys("UserLastName");
		String[] dateParts = date.split("-");
		String day = dateParts[0];
		String month = dateParts[1];
		String year = dateParts[2];

		DOB.click();
		while (true) {
			String currentMonth = driver.findElement(By.className("calendar-month")).getText();
			String currentYear = driver.findElement(By.className("calendar-year")).getText();

			if (currentMonth.equalsIgnoreCase(getMonthName(month)) && currentYear.equals(year)) {
				break;
			} else {
				driver.findElement(By.xpath("//button[@class='calendar-next']")).click();
			}
		
		}


		WebElement dayElement = driver.findElement(By.xpath("//td[normalize-space()='" + Integer.parseInt(day) + "']"));
		dayElement.click();
		String[] dateTimeParts = desireDateandTime.split(" ");
		if (dateTimeParts.length == 2) {
			String time = dateTimeParts[1]; // HH:mm
			String[] timeParts = time.split(":");
			String hour = timeParts[0];
			String minute = timeParts[1];

			driver.findElement(By.id("timePicker")).click();

			driver.findElement(By.xpath("//li[text()='" + hour + "']")).click();

			driver.findElement(By.xpath("//li[text()='" + minute + "']")).click();
		}
		phonenumber.click();
		phonenumber.sendKeys("9876543210");
		Language.click();
		Select languageSelect = new Select(Language);
		languageSelect.selectByVisibleText("Spanish");
		timezone.click();
		Select timezoneSelect = new Select(timezone);
		timezoneSelect.selectByVisibleText("PST");
		Submitbtn.click();
		boolean isMRNFound = driver.getPageSource().contains(dynamicMRN);
		Assert.assertTrue(isMRNFound, "Patient with MRN: " + dynamicMRN + " not found!");
		System.out.println("User should submit the Add Patient Form");
		System.out.println("***************************************************************************");


	}

	private String getMonthName(String monthNumber) {
		int monthInt = Integer.parseInt(monthNumber);
		return new DateFormatSymbols().getMonths()[monthInt - 1];
		
	}
}
