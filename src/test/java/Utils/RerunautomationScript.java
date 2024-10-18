package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunautomationScript implements IRetryAnalyzer {
   private int retrycount=0;
   private static final int maxcount=2;
	@Override
	public boolean retry(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
      if(retrycount<maxcount) {
    	  retrycount++;
    	  return true;
      }
		return false;
	}

}
