package Tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BrowserChannel;
import org.junit.AfterClass;
import org.junit.BeforeClass;

abstract public class BaseTest {
    private Browser browser;

    protected Page page;
    private BrowserContext context;


    @BeforeClass
    public void setUp(){
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome"));

        context = browser.newContext();

        page = context.newPage();
    }

    @AfterClass
    public void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }
}
