package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {
    String firstName = "Kate";
    String lastName = "Mar";
    String userEmail = "kate@kate.ru";
    String gender = "Male";
    String userNumber = "8933333333";
    String dayOfBirth = "03";
    String monthOfBirth = "March";
    String yearOfBirth = "1992";
    String subjectsOne = "History";
    String hobbiesOne = "Sports";
    String pictureName = "test.jpg";
    String address = "test";
    String state = "NCR";
    String city = "Delhi";

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationWithPageObjectsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjectsOne)
                .setHobby(hobbiesOne)
                .uploadPicture(pictureName)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subjectsOne)
                .checkResult("Hobbies", hobbiesOne)
                .checkResult("Picture", pictureName)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    public void registrationWithPageObjectsRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    public void registrationWithPageObjectsNegativeTest() {
        registrationPage.openPage()
                .removeBanner()
                .clickSubmit();

        registrationPage.checkNegativeResult();
    }
}
