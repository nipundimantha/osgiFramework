package com.technician.service.publisher;


import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TechnicianServiceImpl implements TechnicianService{
	ArrayList<CertifiedUpgrade>upgrades = new ArrayList<CertifiedUpgrade>();
	ArrayList<String>upgradeNextFix = new ArrayList<String>();
	ArrayList<String>duration = new ArrayList<String>();
	ArrayList<String>dailySummary = new ArrayList<String>();
	ArrayList<String>test = new ArrayList<String>();
	
	int count = 0;

	@Override
	public void upgradeNextFix(String name, String nextFix, String dur) {
		 upgrades.add(new CertifiedUpgrade(name, dur, nextFix));
	}

	@Override
	public void nextFixTest(String tName) {
		test.add(tName);
	}

	@Override
	public void viewHistory() {
		
		System.out.println("================================View Daily Summary=================================");
		System.out.println("Customers for the day : ");
		
		for(int i = 0; i <= (dailySummary.size() - 1); i++) {
			System.out.println(dailySummary.get(i));
			count = dailySummary.size();
			
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Total number of customers : " + count);
		System.out.println();
		System.out.println("===================================================================================");

	}

	@Override
	public void printUpgradeList(String customerName, String page, String tecName) {
		
		try {
			File file = new File("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\upgrade.txt");
			
			FileWriter fileWriter = new FileWriter("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\upgrade.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================Upgrade Prescription============================");
			printWriter.println();
			printWriter.println("Packaged by : MR. "+tecName);
			printWriter.println("Customer Name : "+ customerName + "                                 " + page);
			printWriter.println();
			printWriter.println();
			printWriter.println("Upgrade                nextFix        Duration"  );

			for(int i = 0; i<= upgrades.size()- 1; i++ ) {
				printWriter.println(upgrades.get(i).getName() + "                      " + upgrades.get(i).getNextFix() + "              " + upgrades.get(i).getDuration());
			}
			printWriter.println("");
			printWriter.println("============================================================================");
			printWriter.close();
			
			
		}catch (IOException e) {
			System.out.println("An error occured");
		}
		
		System.out.println("Package print successfully");
		System.out.println();
		
	}

	@Override
	public void printTestPrescription(String pname, String page, String dname) {
		try {
		FileWriter fileWriter = new FileWriter("F:\\sliit\\y3 s1\\new\\SA\\labs\\generated reports\\Test.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println("===========================Test Prescription============================");
		printWriter.println();
		printWriter.println("Packaged by: Mr. "+dname);
		printWriter.println("Customer Name : "+ pname + "                                  "+ page);
		printWriter.println();
		
		
		for (int i = 0; i <= test.size()-1; i++) {
			printWriter.println(test.get(i));
			
		}
		
		printWriter.println("");
		printWriter.println("========================================================================");
		printWriter.close();
		
		}catch (IOException e) {
			System.out.println("An error has occured");
		}
		
		System.out.println("Package print successfully");
		System.out.println();
	}

	@Override
	public void viewNextFixPoint(String customerName, String page, String tecName) {
		System.out.println("===========================Upgrade Prescription============================");
		System.out.println();
		System.out.println("Packaged by : Mr. "+tecName);
		System.out.println("Customer Name : "+ customerName + "                                 "+ page);
		System.out.println();
		System.out.println("Upgrade                nextFix        Duration");
		for(int i = 0; i<= upgrades.size()- 1; i++ ) {
			System.out.println(upgrades.get(i).getName() + "                      " + upgrades.get(i).getNextFix() + "             " + upgrades.get(i).getDuration());
		}
		System.out.println();
		System.out.println("============================================================================");
		
	}

	@Override
	public void viewUpgradedTest(String customerName, String page, String tecName) {
		System.out.println("===========================Test Prescription============================");
		System.out.println();
		System.out.println("Packaged by: Mr. "+tecName);
		System.out.println("Customer Name : "+ customerName + "                                " + page);
		System.out.println();
		
		for(int i = 0; i<= test.size()-1; i++ ) {
			
			System.out.println(test.get(i));
		}
		
		System.out.println();
		System.out.println("========================================================================");

	}

	@Override
	public void clearUpgradeNextFix() {
		upgrades.clear();
	}

	@Override
	public void clearUpgradeTestNextFix() {
		test.clear();
		
	}

	@Override
	public void keepCustomerSummary(String customerName) {
		if(!dailySummary.isEmpty()) {
			int last = dailySummary.size() - 1;
			String previous = dailySummary.get(last);
			
			if(!previous.equals(customerName)) {
				dailySummary.add(customerName);
			}
			
		}
		
		else {
			dailySummary.add(customerName);
		}
			
	}

}
