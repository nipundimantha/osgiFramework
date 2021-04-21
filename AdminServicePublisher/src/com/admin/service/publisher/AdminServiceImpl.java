package com.admin.service.publisher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

	List<String> newCustomer = new ArrayList<>();
	ArrayList<Customer>customers = new ArrayList<Customer>();

	int selectedTechnician ;
	int customerIndex = 1;
	int ID=0;

	@Override
	//DISPALY TECHNICIAN LIST
	public int getTechList() {
		Scanner customerScanner = new Scanner(System.in);
		int i = 5;
		
		System.out.println("\t1.General Technician  - Mr.B.G.N.Rathnasena");
		System.out.println("\t2.Hybrid Technician  - Mr.Chandima Amarasena");
		System.out.println("\t3.Electrical Technician - Mr.H.K.De S.Kularatne ");
		System.out.println("\t4.Assistant Technician - Mr.WAS De Silva");
		
		for (String doc : newCustomer) {
			System.out.println("\t"+i + "." + doc);
			i++;
		}
		System.out.print("\n\tEnter Technician's index number : ");
		selectedTechnician = customerScanner.nextInt();
		return selectedTechnician;
		
	}

	@Override
	//ADDING TECHNICIANS TO THE LIST
	public void addTechnician() {
		Scanner addCustomerScanner = new Scanner(System.in);
		
		System.out.println("\t\t----Enter no to exit----");
		do {
			System.out.print("\tEnter Technician name :");
			newCustomer.add(addCustomerScanner.next());
			System.out.println("\n \t Technician added successfully!!!\n");
		
		}while(newCustomer.equals("no"));
		
	}

	@Override
	//DISPLAY MAIN OPTIONS
	public void dispalyOption() {
		System.out.println("\t1. Customer registration ");
		System.out.println("\t2. Add Technicians ");
		System.out.println("\t3. Technician hiring");
		System.out.println("\t4. Customer History");
		System.out.println("\t0. Exit \n");
		
	}

	@Override
	//REGISTER CUSTOMER
	public void registerCustomer(String name, int telephone, String address, String vehicalNumber,String vehicalType) {

		System.out.println("\n\t----- new customer details -----");
		System.out.println("  \tAuto Miraj Service station Administration  ");
		System.out.println("\n \t \t CUSTOMER DETAILS :");
		customers.add(new Customer(ID, name, telephone, address, vehicalType, vehicalNumber));
		ID = ID +1;
		
		System.out.println("\tCustomer Name      :- " + name);
		System.out.println("\tCustomer Telephone :- "+telephone);
		System.out.println("\tCustomer Address   :- "+address);
		System.out.println("\tVehicle Type     	 :- " + vehicalType);
		System.out.println("\tVehicle Number     :- " + vehicalNumber);
		
		System.out.println("\n \t Customer Added Successfully!!!\n");
		
	}

	@Override
	//CALCULATE BALANCE
	public double calculateHire(int type, double paymant, double tecCharge) {
		double balance = 0;
		if (type == 1) {
			balance = paymant -tecCharge;
			
		}
		if (type == 2) {
			balance = paymant -tecCharge;
			
		}
		if (type == 3) {
			balance = paymant -tecCharge;
			
		}
		
			return balance; 
	}

	@Override
	
	public void printChargingBill(int customerIndex, String customerName,String tecName,double hire,double bal) {
		try {
			
			FileWriter fileWriter = new FileWriter("D:\\channelingbill.txt");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("\n\t====================================================");
			printWriter.println("\t -Hiring Details-");
			printWriter.println("customer no : " + customerIndex);
			printWriter.println("customer name :" + customerName);
			printWriter.println("Technician name : " + tecName );
			printWriter.println("time and Venue : " + timestamp);
			printWriter.println("Total charge :" + hire);
			printWriter.println("balance :" + bal );
			printWriter.println("\t====================================================\n");
			printWriter.close();
			
			
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("\tAn error occured");
		}
		
	}
	
	@Override
	//CREATING BILL INFORMATION
	public void createTechHireDetails(int type, String customerName,String tecName,double tecCharge, double amount,int customerIndex) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println("\t========================================");
		System.out.println("\t\t -Hiring Details-");
		System.out.println("\tcustomer no : " + customerIndex);
		System.out.println("\tcustomer name :" + customerName);
		System.out.println("\tTechnician name : " +tecName );
		System.out.println("\tPaid");
		System.out.println("\ttime and Venue : " + timestamp);
		System.out.println("\tTotal charge :" + tecCharge);
		System.out.println("\tbalance      :" + this.calculateHire(type,amount,tecCharge));
		System.out.println("\t========================================");
		
		
	}

	@Override
	//GET ALL REGISTERED CUSTOMERS AND DISPLAY
	public void allCustomers(double tot) {
		System.out.println("\n\t==============Patient History================");
		System.out.println("\t Customer Name \t\t\t Address");
		for(int i=0 ; i < customers.size();i++) {
			
			System.out.println("\t" +(i+1)+" "+customers.get(i).getName()+"   \t\t\t"+customers.get(i).getAddress());
			
		}
		
		System.out.println("\n\tTotal income : " + tot);
		
		
	}

}
