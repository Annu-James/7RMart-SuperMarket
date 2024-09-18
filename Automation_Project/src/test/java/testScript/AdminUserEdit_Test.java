package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUser_Edit;
import pages.Login_Page;
import utilities.Excel_Utilities;

public class AdminUserEdit_Test extends Base {
	Login_Page loginPage;
	AdminUser_Edit edit;

	@Test
	@Parameters({ "User name", "Password" })
	public void verify_userCanEdit_Details(String userName, String password) throws IOException {
		// String userNameValue=Excel_Utilities.getStringData(1, 0, "Login page");
		// String passwordValue=Excel_Utilities.getStringData(1, 1, "Login page");
		loginPage = new Login_Page(driver);
		String editName = Excel_Utilities.getStringData(1, 0, "Admin User-Edit");
		String editPassword = Excel_Utilities.getStringData(1, 1, "Admin User-Edit");
		String editUserType = Excel_Utilities.getStringData(1, 2, "Admin User-Edit");
		loginPage.enterUserNameField(userName).enterPasswordField(password).clickSubmitButton();

		
		edit = loginPage.adminUserClick1().adminUserEdit().editUserName(editName).editPasswordField(editPassword)
				.editUserType(editUserType).updatingAdminUserClick();
		// AdminUser_Edit edit=new AdminUser_Edit(driver);
		/*
		 * edit.adminUserClick(); edit.adminUserEdit(); 
		 * edit.editUserName(editName); edit.editPasswordField(editPassword);
		 * edit.editUserType(editUserType); edit.updatingAdminUserClick();
		 */
		boolean updateCheck = edit.isAdminUserisUpdated();
		assertTrue(updateCheck, Constants.ERRORMESSAGE_EDITADMIN);
	}
}
