package com.mystore.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static final ExtentReports sparkReports = new ExtentReports();

    public static ExtentReports createInstance(String fileName) {    	
    	   	
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);       
        
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setReportName(fileName);  
       


        sparkReports.attachReporter(htmlReporter);
        sparkReports.setSystemInfo("Tester Name", "Bharath Kumar");
        sparkReports.setSystemInfo("Organization", " ");        
        
        return sparkReports;
    }


}
