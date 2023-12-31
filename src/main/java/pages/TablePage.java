package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class TablePage {
    WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> tableRows;


    public List<TableRowComponent> getRows() {
        return tableRows.stream().map(TableRowComponent::new).collect(Collectors.toList());
    }


    public List<TableRowComponent> getPeaksMeetingConditions(String countryCondition, int heightCondition) {
        return getRows().stream()
                .filter(r -> (r.getHeight() > heightCondition) && (r.getState().contains(countryCondition)))
                .collect(Collectors.toList());
    }


    public void printPeaks(List<TableRowComponent> selectedPeaks) {
        System.out.println(selectedPeaks.toString().replace("[", "").replace("]", ""));
    }
}





