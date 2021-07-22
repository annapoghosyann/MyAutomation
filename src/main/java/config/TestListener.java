package config;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST START");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST SUCCES");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FINISH");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIP");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
