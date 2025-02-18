
package com.qa.listners;

import java.util.Objects;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import org.testng.ITestResult;

import com.qa.DriverUtilities.DriverManagerUtility;
import com.qa.reportutil.ExtentLogger;
import com.qa.reportutil.ExtentReport;



/**
 * @author Ketan Tiwari
 *
 */
public class CustomListeners implements ITestListener,ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.extentinitializer();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.reportflush();
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtentReport.createtest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + "Passed Sucessfully", false);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (Objects.nonNull(DriverManagerUtility.getDriver())) {
			ExtentLogger.fail(result.getMethod().getMethodName() + "failed.", true);
			ExtentLogger.fail(result.getThrowable().toString(), true);
		}
		else {
			ExtentLogger.skip(result.getMethod().getMethodName(), false);
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName(), false);

	}





}
