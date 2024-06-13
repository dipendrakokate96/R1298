package Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseStudy.Base;
import UtilityStudy.Utility;

public class listener extends Base implements ITestListener 
{
   public void onTestFailure(ITestResult result) 
   {
	   String TcName1 = result.getName();
	   try {
		takeScreenShot(TcName1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void onTestSuccess(ITestResult result) 
   {
		System.out.println("passed Tc name is "+result.getName());
 }
}
