package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class FormPage {

    WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(css = "#inputLastName3")
    private WebElement lastNameInput;
    @FindBy(css = "#inputEmail3")
    private WebElement emailInput;

    @FindBy(css = "[name='gridRadiosSex']")
    private List<WebElement> sexCheckBoxes;

    @FindBy(css = "#inputAge3")
    private WebElement ageInput;

    @FindBy(css = "[name='gridRadiosExperience']")
    private List<WebElement> experienceCheckBoxes;

    @FindBy(css = "[name='gridCheckboxProfession']")
    private List<WebElement> professionCheckBoxes;

    @FindBy(css = "#selectContinents")
    private WebElement continentSelect;

    @FindBy(css = "#selectSeleniumCommands")
    private WebElement commandSelect;

    @FindBy(css = "#chooseFile")
    private WebElement fileBrowserBtn;

    @FindBy(css = "#additionalInformations")
    private WebElement additionalInfoInput;

    @FindBy(xpath = "//*[text()='Sign in']")
    private WebElement signInBtn;


    public FormPage putFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage putLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage putAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
        return this;
    }


    public FormPage selectSexOption(int optionIndex) {
        sexCheckBoxes.get(optionIndex).click();
        return this;
    }

    public FormPage selectExperienceOption(int optionIndex) {
        experienceCheckBoxes.get(optionIndex).click();
        return this;
    }

    public FormPage selectProfessionOption(int optionIndex) {
        professionCheckBoxes.get(optionIndex).click();
        return this;
    }

    public FormPage selectContinentOption(String continentValue) {
        Select continentSelectOptions = new Select(continentSelect);
        continentSelectOptions.selectByValue(continentValue);
        return this;
    }

    public FormPage selectCommandOption(int optionIndex) {
        Select commandSelectOptions = new Select(commandSelect);
        commandSelectOptions.selectByIndex(optionIndex);
        return this;
    }


    public FormPage uploadFile(File file) {
        fileBrowserBtn.sendKeys(file.getAbsolutePath());
        return this;
    }


    public void clickSignInBtn() {
        signInBtn.click();
    }

    public WebElement getSuccessText() {
        return driver.findElement(By.cssSelector("#validator-message"));

    }
}
