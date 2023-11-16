package basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormPage;
import testbase.TestBase;

import java.io.File;

public class FormTest extends TestBase {

    @Test
    @Tag("basic")
    void fillTheForm() {
        openWebsite("http://www.seleniumui.moderntester.pl/form.php");

        FormPage formPage = new FormPage(driver);
        File sampleFile = new File("src/test/resources/sampleFile.txt");

        formPage.putFirstName("John")
                .putLastName("Smith")
                .putAge("24")
                .selectSexOption(1)
                .selectExperienceOption(2)
                .selectProfessionOption(1)
                .selectContinentOption("europe")
                .selectCommandOption(0)
                .uploadFile(sampleFile)
                .clickSignInBtn();

        Assertions.assertThat(formPage.getSuccessText().isDisplayed()).isTrue();
    }
}
