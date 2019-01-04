/**
 * 
 */
package testSuites;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

/**
 * @author QAAUTOTEST
 *
 */
public class ReportLister implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start99999999999999999999999" );
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passsed *****************: "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed : "+result.getName());
		//result.

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
