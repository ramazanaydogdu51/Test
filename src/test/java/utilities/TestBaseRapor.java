package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class TestBaseRapor {
    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;
    protected static ExtentHtmlReporter extentHtmlReporter;
    @BeforeTest(alwaysRun = true)
    public void setUpTest() {
        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/target/Rapor/rapor"+date+".html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Enviroment","Test");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Ramazan");
        extentHtmlReporter.config().setDocumentTitle("Pozitif Login Test");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}
