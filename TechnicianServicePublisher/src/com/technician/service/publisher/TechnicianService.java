package com.technician.service.publisher;

import java.util.ArrayList;

public interface TechnicianService {
	
	public void upgradeNextFix(String name, String nextFix, String dur);
	public void viewNextFixPoint(String customerName,String page,String tecName);
	public void nextFixTest(String tName);
	public void viewUpgradedTest(String customerName,String page,String tecName);
	public void viewHistory();
	public void printUpgradeList(String customerName,String page, String tecName);
	public void printTestPrescription(String customerName,String page, String tecName);
	public void clearUpgradeNextFix();
	public void clearUpgradeTestNextFix();
	public void keepCustomerSummary(String customerName);
}
