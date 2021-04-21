package com.checkpoint.service.publisher;

public interface CheckpointService {

	public void displayReport();
	public void selectReportType(String labservicetype);
	public void reportPrint(String customerName, String vehicleNumber, String vehicleType, String technicianName, String tecName);
	public void checkpointReportHistory(String customerName);
	public void viewCheckpointReport(String customerName, String vehicleNumber, String vehicleType, String technicianName, String tecName);
	public void viewCheckpointReportHistory();
	public void cleardata();
	
	
}
