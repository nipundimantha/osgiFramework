package com.store.service.publisher;

public class Upgrade {
	int id;
	String equipedName;
	String nextFix;
	int price;
	int count;
	int total;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getEquipedName() {
		return equipedName;
	}

	public void setEquipedName(String equipedName) {
		this.equipedName = equipedName;
	}

	public String getNextFix() {
		return nextFix;
	}

	public void setNextFix(String nextFix) {
		this.nextFix = nextFix;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Upgrade(int id, String equipedName, String nextFix, int price, int count, int total) {
		super();
		this.id = id;
		this.equipedName = equipedName;
		this.nextFix = nextFix;
		this.price = price;
		this.count = count;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Upgrade [id=" + id + ", equipedName=" + equipedName + ", nextFix=" + nextFix + ", price=" + price
				+ ", count=" + count + ", total=" + total + "]";
	}

	
	
}
