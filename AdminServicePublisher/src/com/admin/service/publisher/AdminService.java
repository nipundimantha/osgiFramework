package com.admin.service.publisher;

public interface AdminService {
	public void registerCustomer(String name, int telephone, String address, String vehicalNumber, String vehicalType);
	public void allCustomers(double tot);
	public int  getTechList();
	public void addTechnician();
	public void dispalyOption();
	public void createTechHireDetails(int type ,String customerName,String tecName, double tecCharge, double amount,int customerIndex);
	public double calculateHire(int type, double paymant,double tecCharge);
	
	public void printChargingBill(int customerIndex, String customerName,String tecName, double hire,double bal);
	
}
