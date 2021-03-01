package imdb.app.base;

import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestNGListener extends BaseTest implements ITestListener {

    @Override
    public void onStart(ITestContext iTestContext) {
        //read parameters from XML file
        testData = iTestContext.getCurrentXmlTest().getAllParameters();
    }
}

