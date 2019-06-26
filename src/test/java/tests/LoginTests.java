package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import pages.HomePage;
import utilities.Browser;
import utilities.Verifications;


@RunWith(Parameterized.class)
public class LoginTests {

	@Before
	public void setup() {
	Browser.openBrowser();
	HomePage.openPage();
	}
	
	@After
	public void tearDown() {
	Browser.quit();
	System.out.println("\n");
	}
	
	private String username;
	private String password;
	
	@Parameters
	public static Collection<String[]> testData() throws IOException {
		return getTestData("D:\\CMS_3_1\\QAAutomation\\automation-task\\src\\main\\resources\\properties\\test.data");
	}
	
	public LoginTests(String username, String password) {
			this.username = username;
			this.password = password;
			}
	
	public static Collection<String[]> getTestData(String fileName)
			throws IOException {
			List<String[]> records = new ArrayList<String[]>();
			String record;
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
			}
			file.close();
			return records;
	}

	@Test
	public void negativeLoginTest() throws Exception {
		HomePage.openLoginForm();
		Verifications.verifySignInFormIsPresent("Sign In Form isn't Loaded");
		//Set username
		HomePage.usernameInput(username);	
		//Set password
		HomePage.passwordInput(password);
		HomePage.signInButtonClick();
		Verifications.verifyNegativeLogin("The message is Wrong!/Not Present!", "Wrong user or password.");
		
	}
	

}
