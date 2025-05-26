//QA Engineer 
The tests are written in **Java**, use the **TestNG** testing framework, and are executed through **Eclipse IDE**.

 -**Programming Language:** Java  
- **Testing Framework:** TestNG  
- **Automation Tool:** Selenium WebDriver  
- **IDE:** Eclipse  
- **Build Tool:** Maven   
- **Browser Support:** Google Chrome 

Project Structure

src/
└── test/
└── java/
└── testng
└── BaseTest.java 
└── QAEngineerAssessment.java
└── testngRun.java

Clone the Repository
Run the following command in your terminal or Git Bash:

bash
Copy
Edit
git clone https://github.com/Sonkamblesonali/Selenium-Assignment
Import the Project in Eclipse

Open Eclipse IDE

Go to File → Import

Select Existing Maven Projects (I used Maven Project)

Browse to the cloned project folder and finish the import

Run the TestNG Tests

In the src/test/java directory, open testngRun.java 

Right-click on the file → Run As → TestNG Test


BaseTest.java
Sets up and closes the Chrome browser before and after tests run, so every test starts fresh.

QAEngineerAssessment.java
Contains methods to interact with the app — login, open dashboard, and fill out the Add Patient form.

testngRun.java
Runs the test cases in order:

Login test — verifies user can log in with valid credentials.

Dashboard test — checks the patient dashboard loads correctly.

Add Patient test — verifies that adding a new patient with valid data works and the patient appears in the system.









