package com.store.service.publisher;

public interface StoreService {

	public void displayOption();
	public void getUpgradeList();
	public void getOptions(int type);
	public void purchesUpgrades(String upgrade,String nextFix,int price,int qty);
	public void createBill();
	public void calculateBill();
	public void myHistory();
	public void createPdf();
	public void addCustomers(String name);
	public void manageUserBill(int cash);
	public void addUpgradeToMyInventory(String upgradeEquip);
	public void printHistory();
}
