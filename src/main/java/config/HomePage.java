package config;

public class HomePage extends BasePage{
    @Override
    public void openPage() {
        DriverUtils.driver.get(Configuration.ENVIRONMENT);
    }
}
