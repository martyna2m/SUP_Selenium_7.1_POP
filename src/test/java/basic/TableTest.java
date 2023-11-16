package basic;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TablePage;
import testbase.TestBase;

public class TableTest extends TestBase {

    @Test
    @Tag("basic")
    void printPeaksMeetingConditions() {
        openWebsite("http://www.seleniumui.moderntester.pl/table.php");

        TablePage tablePage = new TablePage(driver);

        String countryCondition = "Switzerland";
        int heightCondition = 4000;

        tablePage.printPeaks((tablePage.getPeaksMeetingConditions(countryCondition, heightCondition)));

    }
}
