package test.java.Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testngRun extends BaseTest {
	@Test(priority = 1)
	public void testSuccessfulLogin() throws InterruptedException {

		driver.get("https://qa-takehome.dtxplus.com/"); // Replace with actual login URL

		QAEngineerAssessment loginPage = new QAEngineerAssessment(driver);
		loginPage.loginwithValidData("dtxplus", "dtxplus");
	}

	@Test(priority = 2)
	public void PatientDashboard() {
		QAEngineerAssessment dash = new QAEngineerAssessment(driver);
		dash.DashBoard();
	}

	@Test(priority = 3)
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
