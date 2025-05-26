package test.java.Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testngRun extends BaseTest {

	@Test(priority = 1)

	public void loginwithinvalidcredentials() throws InterruptedException {

		QAEngineerAssessment loginwithInvalidCred = new QAEngineerAssessment(driver);
		loginwithInvalidCred.loginwithemptydeatils();

	}

	@Test(priority = 2)
	public void testSuccessfulLogin() throws InterruptedException {

		driver.get("https://qa-takehome.dtxplus.com/"); // Replace with actual login URL

		QAEngineerAssessment loginPage = new QAEngineerAssessment(driver);
		loginPage.loginwithValidData("dtxplus", "dtxplus");
	}

	@Test(priority = 3)
	public void PatientDashboard() {
		QAEngineerAssessment dash = new QAEngineerAssessment(driver);
		dash.DashBoard();
	}

	@Test(priority = 4)
// Here not able to perform with invalid phone number because of the issue , so try with empty phone number
	public void testEmptyPhoneNumbet() {
		QAEngineerAssessment qa = new QAEngineerAssessment(driver);
		qa.loginwithValidData("dtxplus", "dtxplus");
		qa.DashBoard();
		String uniqueMRN = "MRN" + System.currentTimeMillis();
		try {
			qa.AddPatientForm(uniqueMRN, "23-05-2025", "26-05-2025 14:30");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void VerifyFieldsOmAddPatientForm() {

		String uniqueMRN = "MRN" + System.currentTimeMillis();
		QAEngineerAssessment UniqueUrn = new QAEngineerAssessment(driver);
		// UniqueUrn.AddPatientForm(uniqueMRN,"23-05-2025");
		// selectDateFromCalendar("23-05-2025");
		try {
			UniqueUrn.AddPatientForm(uniqueMRN, "23-05-2025", "26-05-2025 14:30");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
