public class Test {

    @org.testng.annotations.Test(testName = "Verify Headers")
    public void testHomePageHeaders() throws Exception {

        WebDriverUtil.getDriver().get(Config.getConfig("url"));
        HomePage homePage = new HomePage(WebDriverUtil.getDriver());
        homePage.verifyHeaderLinks();

    }

    @org.testng.annotations.Test(testName = "Verify Footers")
    public void testHomePageFooters() throws Exception {

        WebDriverUtil.getDriver().get(Config.getConfig("url"));
        HomePage homePage = new HomePage(WebDriverUtil.getDriver());
        homePage.verifyFooterLinks();

    }
}
