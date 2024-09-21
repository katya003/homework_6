package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

public class TextBoxPageObjectTests extends TestBase {
    String userName = "Kate Mar";
    String userEmail = "kate@kate.ru";
    String currentAddress = "Moscow, Russia";
    String permanentAddress = "Kazan, Russia";

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void registrationTextBoxWithPageObjectsTest(){
        textBoxPage.openPage()
                .removeBanner()
                .setFullName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();
        textBoxPage
                .checkResult("Name:", userName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);
    }

}

