package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class TableRowComponent {
    WebDriver driver;

    public TableRowComponent(WebElement parent) {
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
        this.driver = driver;
    }

    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(xpath = "./td[1]")
    private WebElement peak;

    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;
    @FindBy(xpath = "./td[3]")
    private WebElement state;

    @FindBy(xpath = "./td[4]")
    private WebElement height;


    public int getHeight() {
        return Integer.parseInt(height.getText());
    }

    public String getPeakName() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String getState() {
        return state.getText();
    }

    public String getRank() {
        return rank.getText();
    }


    @Override
    public String toString() {
        return "Peak: " + getPeakName() + ", " + "Rank: " + getRank() + ", " + "Mountain range: " + getMountainRange() + "\n";

    }
}
