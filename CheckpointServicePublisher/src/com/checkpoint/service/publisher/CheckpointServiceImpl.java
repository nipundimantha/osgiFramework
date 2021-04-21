package com.checkpoint.service.publisher;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CheckpointServiceImpl implements CheckpointService {
	
	ArrayList<Checkpoint> checkpointName = new ArrayList<Checkpoint>(); 
	ArrayList<Double> checkpointResult = new ArrayList<Double>();
	ArrayList<String> checkpointHistory = new ArrayList<String>();
	ArrayList<String> checkpointTestHistory = new ArrayList<String>();
	
	@Override
	public void displayReport() {
		
		System.out.println("====== Service Reports ======");
		System.out.println("--1. Tires & Wheels Grooming");
		System.out.println("--2. Exterior Waxing");
		System.out.println("--3. Exterior Waxing");
		System.out.println("--4. Undercarriage Degreasing");
		System.out.println("--5. Vehicle Inspection");
		System.out.println("--6. Engine Degreasing");
		System.out.println("--7. Interior Detailing");
		System.out.println("--8. Exterior Detailing");
		System.out.println("--9. Wash & Vacuum");
		System.out.println("--10. Tyre & Spare Parts");
		
	}

	@Override
	public void selectReportType(String labservicetype) {
		
	checkpointName.add( new Checkpoint (labservicetype));
	checkpointTestHistory.add(labservicetype);
	
	double max = 10; 
    double min = 1; 
    double range = max - min + 1; 

    // generate random numbers within 1 to 10 
    for (int i = 0; i < 10; i++) { 
        double rand = (Math.random() * range) + min; 
        checkpointResult.add(rand);
    	}

	}		
	
	@Override
	public void checkpointReportHistory(String customerName) {
		// TODO Auto-generated method stub
		if(!checkpointHistory.isEmpty()){
			int last = checkpointHistory.size() - 1;
			String previous = checkpointHistory.get(last);
		
			if(!previous.equals(customerName)) {
				checkpointHistory.add(customerName);
			}
		}else{
			checkpointHistory.add(customerName);	
		}	
	}
	
	@Override
	public void reportPrint(String customerName, String vehicleNumber, String vehicleType, String technicianName, String tecName) {
		
		try {
			File file = new File("C:\\Users\\Hp\\Desktop\\LabReport.txt");
			
			FileWriter fileWriter = new FileWriter("C:\\Users\\Hp\\Desktop\\LabReport.txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("===========================Checkpoint Report============================");
			printWriter.println("Order Investigation by : Mr. " + technicianName);
			printWriter.println("Vehicle Type : " + vehicleType + "                                 Vehicle Number: "+ vehicleNumber);
			printWriter.println("Customer Name : " + customerName);
			for(int i = 0; i<= checkpointName.size()- 1; i++ ) {
				printWriter.println(checkpointName.get(i).getLabtestType() + "                				Test Result :" + checkpointResult.get(i));
			}
			printWriter.println("");
			printWriter.println("============================================================================");
			printWriter.close();
			
		}catch (IOException e) {
			
			System.out.println("An error occured");
		}
    }

	@Override
	public void viewCheckpointReport(String customerName, String vehicleNumber, String vehicleType, String technicianName, String tecName){

		System.out.println("=================================Checkpoint Report=================================");
		System.out.println("");
		System.out.println("Requested by : Mr. " + technicianName);
		System.out.println("Vehicle Type : " + vehicleType +"                                 Vehicle Number: "+ vehicleNumber);
		System.out.println("Customer Name : " + customerName);
		System.out.println("");
		for(int i = 0; i<= checkpointName.size()- 1; i++ ) {
			System.out.println(checkpointName.get(i).getLabtestType() + "                                        test Result: "+ checkpointResult.get(i));
		}
		System.out.println("");
		System.out.println("============================================================================");
		
	}

	@Override
	public void cleardata() {
	
		checkpointResult.clear();
		checkpointName.clear();
		
	}

	@Override
	public void viewCheckpointReportHistory() {
		
		int customerCount = 0, Tcount = 0;
		
		System.out.println("================================View Checkpoint Report Summary=================================");
		System.out.println("Customer Names for the day : ");
		
		for(int i = 0; i <= (checkpointHistory.size() - 1); i++) {
			System.out.println(i+1+"."+checkpointHistory.get(i));
				
			 customerCount = checkpointHistory.size();
			 Tcount = checkpointTestHistory.size();
			 	 
		}
		for(int x = 0 ; x<= (checkpointTestHistory.size() -1) ;x++) {
							System.out.println("              - " + checkpointTestHistory.get(x) );
						}
		System.out.println("");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Total number of customers : "+ customerCount+"           Total number of customers : "+Tcount );
		System.out.println();
		System.out.println("===================================================================================");
		
		
		
	}
	
	}


