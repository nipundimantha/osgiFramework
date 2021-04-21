package com.checkpoint.service.subscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.checkpoint.service.publisher.CheckpointService;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		ServiceReference<CheckpointService>serviceRefrence = context.getServiceReference(CheckpointService.class);
		CheckpointService service = (CheckpointService) context.getService(serviceRefrence);
		
		String tecName, password,customerName, technicianName, vehicleNumber, vehicleType;
		int LabserviceType =0 ,patientAge =0, command = 0, printCommand, ContinueCommand;
		
		Scanner myscanner = new Scanner(System.in);
		
		try {
			

		System.out.println("========= Welcome to Auto Miraj Checkpoint Service =========");
		System.out.println("");
		System.out.println("Please Log in to the Checkpoint");
		int correct;
		do {
			System.out.print("Please enter Checkpoint technician Name : ");
			tecName = myscanner.next();
			
			System.out.print("Please enter password : ");
			password = myscanner.next();
			
			if(tecName.equals("tec") && password.equals("tec")) {
				System.out.println("");
				System.out.println("Login Successfull");
				System.out.println("");
				correct = 1;
				
			}	
				else {
					System.out.println("Please enter  the correct credentials");
					System.out.println();
					correct = 0;
					
				}
			
			}while(correct != 1);
			
				System.out.print("Please enter your Name : ");
				tecName = myscanner.next();
				
				System.out.println("===========================Welcome MLT. "+ tecName + " =============================== ");
				
				do {
					System.out.println("Choose your Checkpoint Service number:");
					System.out.println("      1 - Test Medical Report. ");
					System.out.println("      2 - View Test List. ");
					System.out.println("      3 - View Customer's Report history. ");
					System.out.println("Enter Checkpoint Service Number: ");
					LabserviceType = myscanner.nextInt();
					
					if(LabserviceType == 1) {
						System.out.print("Enter the name of the customer : ");
						customerName = myscanner.next();
						
						System.out.print("Enter the Vehicle Number : ");
						vehicleNumber = myscanner.next();
						
						System.out.print("Enter the Vehicle Type : ");
						vehicleType = myscanner.next();
						
						System.out.print("Enter the name of the Technician : ");
						technicianName = myscanner.next();
						
						System.out.println("");
						
						service.checkpointReportHistory(customerName);
					
						System.out.println("===========================Welcome to Auto Miraj Checkpoint===========================");
						System.out.println();
					
						service.displayReport();
					
						do {
							//System.out.println("enter test: ");
							//LabtestType = myscanner.nextInt();
						
							System.out.println("Enter Checkpoint Test Type : ");
							int testtype = myscanner.nextInt();
							
								if(testtype == 1){
									
									//service.LabTestHistory("Tires & Wheels Grooming");
									service.selectReportType("Tires & Wheels Grooming");
								}else if(testtype == 2) {
									
									//service.LabTestHistory("Exterior Waxing");
									service.selectReportType("\r\n" + 
											"Exterior Waxing");
								}else if(testtype == 3) {
									
									//service.LabTestHistory("Windscreen Treatment");
									service.selectReportType("Windscreen Treatment");
								}else if(testtype == 4){
									
									//service.LabTestHistory("Undercarriage Degreasing");
									service.selectReportType("Undercarriage Degreasing");
								}else if(testtype == 5) {
									
								//	service.LabTestHistory("Vehicle Inspection");
									service.selectReportType("Vehicle Inspection");
								}else if(testtype == 6) {
									
								//	service.LabTestHistory("Engine Decreasing");
									service.selectReportType("Engine Degreasing");
								}else if (testtype == 7) {
									
								//	service.LabTestHistory("Interior Detailing");
									service.selectReportType("Interior Detailing");
								}else if (testtype == 8) {
									
									//service.LabTestHistory("Exterior Detailing");
									service.selectReportType("Exterior Detailing");
								}else if (testtype == 9) {
									
								//	service.LabTestHistory("Wash & Vacuum");
									service.selectReportType("Wash & Vacuum");
								}else if(testtype == 10){
									
								//	service.LabTestHistory("Tyre & Spare Parts");
									service.selectReportType("Tyre & Spare Parts");
								}else{
									
									System.out.println(" Please Contact MLT for any other Checkpoint Reports");
								}
						
						System.out.println("Do  you want to add Another Checkpoint service..? ");
						System.out.println("   Press 1 to continue");
						System.out.println("   Press 0 to exit from Auto Miraj Checkpoint");
						command = myscanner.nextInt();
						
						}while(command == 1);
						
						System.out.println("Do you want to View the Checkpoint Report? ");
						System.out.println("   1 - yes");
						System.out.println("   0 - no");
						int ViewCommand = myscanner.nextInt();
						
						if(ViewCommand == 1) {
						
							service.viewCheckpointReport( customerName, vehicleNumber, vehicleType, technicianName, tecName);
						
						}
						
						System.out.println("Do you want to print the Checkpoint Report? ");
						System.out.println("   1 - yes");
						System.out.println("   0 - no");
						printCommand = myscanner.nextInt();
						
						if(printCommand== 1) {
							service.reportPrint(customerName, vehicleNumber, vehicleType, technicianName, tecName);
						}
						
						service.cleardata();
						
					}else if(LabserviceType == 2) {
						System.out.println("====Auto Miraj Checkpoint Test List====");
						System.out.println();
						service.displayReport();
						
					}else if(LabserviceType == 3) {
						System.out.println("=====Welcome to Checkpoint Report Summary====");
						System.out.println();
						service.viewCheckpointReportHistory();
					}
					
					else {
						System.out.println(" Press a valid Command");
					}
				
					System.out.println("Do you want to switch to another service?");
					System.out.println("   Press 1 to continue");
					System.out.println("   Press 0 to exit from Checkpoint Service");
					ContinueCommand = myscanner.nextInt();
					
				} while(ContinueCommand == 1);
				
		} catch (Exception e) {
			System.out.println("Error: " + e);
			
		} finally {
			System.out.println("Thank you for using checkpoint Consultation Service");
			System.out.println("Good Bye!....");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println();
		System.out.println("===========================Auto Miraj Service Stoped===========================");
	}
}
