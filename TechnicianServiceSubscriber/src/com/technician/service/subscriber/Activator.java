package com.technician.service.subscriber;

import java.io.IOException;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.technician.service.publisher.TechnicianService;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReferenceTec;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		Scanner scanner = new Scanner(System.in);
		String username, password;
		int status = 1,option = 0,statUp,statPrint;
		int correct = 1;
		String customerName = "",page = "",tecName = "", upgradeName,nextFix,fixDuration,testName;
		try {
		System.out.println("=========welcome to Technician Consultation Service========");
		
		Activator.context = bundleContext;
		serviceReferenceTec = bundleContext.getServiceReference(TechnicianService.class.getName());
		TechnicianService tecService = (TechnicianService)bundleContext.getService(serviceReferenceTec);
		
		do {
		System.out.print("Please enter username : ");
		username = scanner.next();
		System.out.println();
		
		System.out.print("Please enter password :");
		password = scanner.next();
		System.out.println();
		
		if(username.equals("tec") && password.equals("tec")) {
			System.out.println("Login Successfull");
			System.out.println();
			correct = 1;
			
		}	
			else {
				System.out.println("Please enter  the correct credentials");
				System.out.println();
				correct = 0;
				
			}
		
		}while(correct != 1);
		
			System.out.println("Please enter your name : ");
			tecName = scanner.next();
			
			System.out.println("===========================Welcome Mr.. "+ tecName + " =============================== ");
			
			do {
				System.out.println("Choose your preference by typing the relavent number:");
				System.out.println("      1 - Package upgrade. ");
				System.out.println("      2 - Packaging tests. ");
				System.out.println("      3 - View daily history. ");
				option = scanner.nextInt();
				
				if(option == 1 || option == 2) {
					System.out.println("Enter the name of the customer:");
					customerName = scanner.next();
					
					System.out.println("Enter the age of the customer:");
					page = scanner.next();
					
					tecService.keepCustomerSummary(customerName);
				}
				
				if(option == 1) {
					System.out.println("====Welcome to P upgrade====");
					System.out.println();
					
				do {
			
					System.out.println("Enter Name of the upgrade : ");
					upgradeName = scanner.next();
					
					System.out.println("Enter nextFix of the upgrade : ");
					nextFix = scanner.next();
					
					System.out.println("Enter duration of the upgrade : ");
					fixDuration = scanner.next();
					
					tecService.upgradeNextFix(upgradeName,nextFix,fixDuration);
					System.out.println("Do  you want to continue with packaging upgrade? ");
					System.out.println("   Press 1 to continue");
					System.out.println("   Press 0 to exit from packaging Upgrade");
					statUp = scanner.nextInt();
					
					}while(statUp == 1);
					
					tecService.viewNextFixPoint(customerName,page,tecName);
					
					System.out.println("Do you want to print the packaging? ");
					System.out.println("   1 - yes");
					System.out.println("   2 - no");
					statPrint = scanner.nextInt();
					
					if(statPrint == 1) {
						tecService.printUpgradeList(customerName,page,tecName);
						
					}
					
					tecService.clearUpgradeNextFix();
					
				}
				
				else if(option == 2) {
					System.out.println("====Welcome to packaging test====");
					System.out.println();
					
					do {
						System.out.println("Enter Name of the test : ");
						testName = scanner.next();
						
						tecService.nextFixTest(testName);
						System.out.println("Do  you want to continue with packaging test? ");
						System.out.println("   Press 1 to continue");
						System.out.println("   Press 0 to exit from upgrade test");
						statUp = scanner.nextInt();
						
						}while(statUp == 1);
					
						tecService.viewUpgradedTest(customerName, page,tecName);
						
						System.out.println("Do you want to print the test package? ");
						System.out.println("   1 - yes");
						System.out.println("   2 - no");
						statPrint = scanner.nextInt();
						
						if(statPrint == 1) {
							tecService.printTestPrescription(customerName,page,tecName);
							
						}
						
						tecService.clearUpgradeTestNextFix();
						
					}
				
				else if(option == 3) {
					System.out.println("=====Welcome to View daily Summary====");
					System.out.println();
					tecService.viewHistory();
					
				}
				
				else {
					System.out.println(" Press a valid number");
				}
			
				System.out.println("Do you want to switch to another service?");
				System.out.println("   Press 1 to continue");
				System.out.println("   Press 0 to exit from Technician Consultation Service");
				status = scanner.nextInt();
				
			}while(status == 1);
		
		} catch (Exception e) {
			System.out.println("Error: " + e);
			
		} finally {
//			scanner.close();
			System.out.println("Thank you for using Technician Consultation Service");
			System.out.println("Good Bye!....");
			
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Technician hiring service stop");
	}

}
