package com.admin.service.subscriber;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.admin.service.publisher.AdminService;
import com.admin.service.publisher.AdminServiceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;
	
	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
	Activator.context = bundleContext;
		
		ServiceReference<AdminService> serviceReference = context.getServiceReference(AdminService.class);
		AdminService service = (AdminService) context.getService(serviceReference);
		
		
		//DEFINE VARIABLES 
		AdminService adminService = new AdminServiceImpl(); 
		Scanner myScanner = new Scanner(System.in);	
		
		int selectedTec ;
		int customerIndex = 1;
		int loop = 1;
		double totIncome = 0;
		
		System.out.println(" Admin Service Subscriber Start");
		System.out.println("\n\t============= Welcome to Auto Miraj Service Station ==============");
		int i = 0;
		//MAIN SYSTEM START
		do {
			//ACCESS CONTROLL
			System.out.print("\n\tPlease Enter UserName : ");
			String un = myScanner.next();
			
			System.out.print("\tPlease Enter Password : ");
			String pwd = myScanner.next();
		
		//CHECK USERNAME AND PASSWORD	
		if((un.equals("admin") || un.equals("ADMIN") )&& (pwd.equals("admin") || pwd.equals("ADMIN"))) {
			
			//START ADMINISTRATION SYSTEM
			System.out.println("\n \t \t Welcome to Administration !!!");
			do {
				
			System.out.println("\n \t Choose option : ");
			service.dispalyOption();
			System.out.print("\t option : ");
			int option = myScanner.nextInt();
			
			double bal = 0;
			
			//OPTION 1 -> CUSTOMER REGISTRATION
			if(option == 1 ) {
				System.out.print("\n\tPlease enter customer name : ");
				String customerName = myScanner.next();
				
				System.out.print("\tPlease enter customer Telephone : ");
				int customerMSISDN = myScanner.nextInt();
				
				System.out.print("\tPlease enter customer address : ");
				String customerAddress = myScanner.next();
				
				System.out.print("\tPlease enter customer vehicle Number : ");
				String customerVehicleNumber = myScanner.next();
				
				System.out.print("\tPlease enter customer vehicle Type : ");
				String customerVehicleType = myScanner.next();
	
				service.registerCustomer(customerName, customerMSISDN, customerAddress, customerVehicleNumber,customerVehicleType);
		
			}
				
			//OPTION 2 -> ADD TECHNICIAN TO THE LIST
			else if (option == 2) {
				service.addTechnician();
				
			}
			
			//OPTION 3 -> HIRE A TECHNICIAN
			else if(option == 3) {
				Scanner cash = new Scanner(System.in);
				System.out.print("\n \tPlease enter customer name : ");
				String customerName = myScanner.next();
				System.out.println("\tPlease select Technician : \n");
				selectedTec = service.getTechList();
				
				if(selectedTec == 1) {
					
					System.out.println("\n\t==== Selected Technician Charges ====");
					System.out.println("\tMr.B.G.N.Rathnasena   =  1000.00");
					System.out.println("\tHiring fee        =   300.00");
				
					System.out.println("\tTotal       	 =  1300.00");
					
					totIncome = totIncome + 1300;
					System.out.print("\n\tEnter Paymant :");
					double amount = cash.nextDouble();
					
					service.createTechHireDetails(1,customerName," Dr.B.G.N.Rathnasena",1300,amount,customerIndex);
					
					System.out.print("\tDo you want to print the bill (y/n) ?? ");
					String selection = myScanner.next();
					
					if(selection.equals("y") ||selection.equals("Y") ) {
						service.printChargingBill(customerIndex, customerName," Dr.B.G.N.Rathnasena",1300,bal);
						System.out.println("\n \tprinted successully");
					}
					
				}
				else if(selectedTec == 2) {
							System.out.println("\n\t==== Selected Technician Charges ====");
							System.out.println("\tMr.Chandima Amarasena =  1700.00");
							System.out.println("\tHiring fee        =   300.00");
							
							System.out.println("\tTotal       	  =  2000.00");
							totIncome = totIncome + 2000;
			
					System.out.print("\n \tEnter Paymant :");
					double amount = cash.nextDouble();
							
					service.createTechHireDetails(1,customerName,"Mr.Chandima Amarasena",2000,amount,customerIndex);
			
					System.out.print("\n \tDo you want to print the bill (y/n) ?? ");
					String selection = myScanner.next();
					
					if(selection.equals("y")) {
						service.printChargingBill(customerIndex, customerName,"Mr.Chandima Amarasena",2000,bal);
						System.out.println("\n \t printed successully");
					}
					
				}
				else if(selectedTec == 3) {
					
							System.out.println("\n\t==== Selected Technician Charges ====");
							System.out.println("\tDr.H.K.De S.Kularatne =  1500.00");
							System.out.println("\tHiring fee        =   300.00");
							                    
							System.out.println("\tTotal 		 =  1800.00");
							totIncome = totIncome + 1800;
						
			
					System.out.print("\n \t Enter Paymant :");
					double amount = cash.nextDouble();
					
					service.createTechHireDetails(1,customerName,"Mr.H.K.De S.Kularatne",1800,amount,customerIndex);
					
					System.out.print("\n \t Do you want to print the bill (y/n) ?? ");
					String selection = myScanner.next();
					
					if(selection.equals("y")) {
						service.printChargingBill(customerIndex, customerName,"Mr.H.K.De S.Kularatne",1800,bal);
						System.out.println("\n \tprinted successully");
					}
					
				}
				else if(selectedTec == 4) {
							System.out.println("\n \t==== Selected Technician Charges ====");
							System.out.println("\t Mr.WAS De Silva       =  1500.00");
							System.out.println("\t Hiring fee        =   300.00");
							
							System.out.println("\tTotal       	      =  1800.00");
							totIncome = totIncome + 1800;
							

					System.out.print("\n \tEnter Paymant :");
					double amount = cash.nextDouble();
					
					service.createTechHireDetails(1,customerName,"Mr.WAS De Silva",1800,amount,customerIndex);
					
					System.out.print("\tDo you want to print the bill  (y/n) ?? ");
					String selection = myScanner.next();
					
					if(selection.equals("y") || selection.equals("Y")) {
						service.printChargingBill(customerIndex, customerName,"Mr.WAS De Silva",1800,bal);
						System.out.println("\n \tprinted successully");
					}
					
				}
			
				customerIndex++;
			}
			
			//OPTION 4 -> CUSTOMER REGISTRATION HISTORY 
			else if (option == 4) {
				service.allCustomers(totIncome);
			}
			
			//OPTION 0 -> EXIT
			else if(option == 0) {
				loop = -1;
			}
			
			// GO BACK TO ADMINISTRATION SYSTEM AGAIN
			System.out.print("\n \tGo back ?? (y or n)  : ");
			String optionContinue = myScanner.next();
			  
				if(optionContinue.equals("y") || optionContinue.equals("Y") ) {
				  i = -1;
				}
				else if(optionContinue.equals("n") || optionContinue.equals("N") ) {
				  System.out.println("\t Good Bye !!!");
					i = 1;
					loop = -1;
				}
			  
				else {
				  System.out.println("\t please enter valid letter");
				}
			
			  	} while(i<0);	//ADMINISTRATION SYSTEM ENDS
		 
		}
		else {
			System.out.println("\n\tAcces Denied!!");
			System.out.print("\tDo you want try again  (-1.Exit , 1.Go Back) ??  ");
			loop = myScanner.nextInt();
		}
		
		} while(loop > 0);//MAIN SYSTEM ENDS
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Admin Service Subscriber Stop");
	}

}
